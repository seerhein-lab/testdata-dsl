package com.seitenbau.testdatadsl.dbunitdemo.groovy

import groovy.transform.ToString

class TableModel {
  String name
  
  def columns = []
  
  TableModel addColumn(TableColumn column) {
    column.table = this
    columns.add(column)
    return this
  }
  
  TableColumn ref(String columnId) {
    for (TableColumn column in columns) {
      if (column.name == columnId) {
        return column
      }
    }
    
    return null
  }
  
    def containsColumn(String name) {
      for (TableColumn c in columns) {
        if (c.name == name) {
          return true;
        }
      }
  
      return false;
    }
  
}

class TableColumn {
  
  TableModel table

  String name
  
  TableColumn ref
  
}

@ToString
class TableDataRow {
  String ref

  String type

  def values = [:]

  Object rowBuilder
  
  def hasReferences() {
    for (e in values) {
      if (e.value instanceof Var) {
        if (!e.value.isPlaceholder()) {
          return true;
        }
      }
      if (e.value instanceof Values) {
        for (e2 in e.value.values) {
          if (e.value instanceof Var) {
            if (!e.value.isPlaceholder()) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
}


abstract class AbstractTableModel
{
  static def columnId = "REF"
  
  static def placeHolder = new Var();

  def tables = [:]

  def apply(Map fixtureData) {
    TableParser parser = new TableParser()

    def parsedTables = [:]
    def variables = [:]
    
    for (e in fixtureData) {
      TableModel tableModel = tables[e.key]
      //println e.key
      
      def data = parser.parseTableClosure(e.value)
      def head = data[0]
      def columns = head.values.size()
      def columnIds = 0
      for (column in head.values) {
        assert column instanceof Var
        String name = column.name
        if (name == "REF") {
          columnIds++;
          if (columnIds == 2) {
            throw new IllegalArgumentException("Multiple ID columns in table");
          }
        } else if (!tableModel.containsColumn(name)) {
          throw new IllegalArgumentException("Column $name not part of table $e.key");
        }
      }
      def tablerows = []
      for (row in data) {
        if (row == head) {
          continue;
        }

        TableDataRow tableRow = new TableDataRow()
        tableRow.type = e.key

        if (row.values.size() != columns) {
          throw new IllegalStateException("Column widths do not match");
        }

        Var ref = placeHolder
        for (i in 0..(columns-1)) {
          def field = head.values[i].name
          if (field == columnId) {
            ref = row.values[i]
          } else {
            def value = row.values[i]
            tableRow.values[field] = value
          }
        }

        tableRow.ref = ref.name

        if (!ref.isPlaceholder()) {
          variables[ref.name] = tableRow;
        }

        tablerows.add(tableRow);
      }
      parsedTables[e.key] = tablerows
    }
    
    // now apply each table
    for (e in parsedTables) {
      this."apply_$e.key"(e.value, variables)
    }

    applyReferences(parsedTables, variables)
  }
  

  
  def invokeSetter(rowBuilder, key, parameter) {
    String setter = key.substring(0, 1).toUpperCase() + key.substring(1)
    try {
      rowBuilder."set$setter"(parameter)
    }
    catch (Exception ex) {
      // TODO NM improve: remove try/catch
    }

  }
  
  def apply_table(table, tablerows, variables) {
    for (TableDataRow row : tablerows) {
      def rowBuilder = table.insertRow()
      row.rowBuilder = rowBuilder

      for (e in row.values) {
        invokeSetter(rowBuilder, e.key, e.value)
      }
    }
  }

}
