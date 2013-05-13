package com.seitenbau.testdatadsl.dbunitdemo.sbtesting.groovy;

import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.DBUnitExamplesDataSet
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.ProfessorTable.RowBuilder_Professor
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.ProfessorTable.RowCollection_Professor
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.LehrveranstaltungTable.RowBuilder_Lehrveranstaltung
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.LehrveranstaltungTable.RowCollection_Lehrveranstaltung
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.PruefungTable.RowBuilder_Pruefung
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.PruefungTable.RowCollection_Pruefung
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.StudentTable.RowBuilder_Student
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.StudentTable.RowCollection_Student
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.BeaufsichtigtTable.RowBuilder_Beaufsichtigt
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.BeaufsichtigtTable.RowCollection_Beaufsichtigt
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.BesuchtTable.RowBuilder_Besucht
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.BesuchtTable.RowCollection_Besucht
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.IsttutorTable.RowBuilder_Isttutor
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.IsttutorTable.RowCollection_Isttutor
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.SchreibtTable.RowBuilder_Schreibt
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.SchreibtTable.RowCollection_Schreibt
import groovy.transform.ToString

//-----------------------------------
// This is a common part

@ToString
class Row {

  List values = []

  def or(arg) {
    values.add(arg)
    this
  }
}

class ColumnHeader {
  
  String name

  Class type
  
  boolean isIdentificator
  
  String javaName

}

class DatabaseReference {
}
//-----------------------------------

class ProfessorRef extends DatabaseReference {

  // TODO NM replace with IdGenerator
  static java.lang.Long nextId = 1

  private java.lang.Long id
  
  def ProfessorRef() {
  }
  
  def ProfessorRef(java.lang.Long id) {
    setId(id)
  }

  java.lang.Long getId() {
    if (id == null) {
      // TODO NM replace with IdGenerator
      id = nextId++
    }
    return id
  }

  void setId(java.lang.Long id) {
    if (isDefined() && this.id != id) {
      throw new IllegalStateException("Id already set " + id + " vs " + this.id + " [Table: professor]");
    }
    // TODO NM notify id generator that id is not available anymore
    this.id = id
  }

  boolean isDefined() {
    return this.id != null
  }
  
  String toString() {
    return "ProfessorRef[" + id + "]"
  }

  // depending on relation type with or with ellipse (...)
  List<LehrveranstaltungRef> leitetList = []

  def leitet(LehrveranstaltungRef ... refs) {
    leitetList.addAll(refs)
  }

  // depending on relation type with or with ellipse (...)
  List<PruefungRef> beaufsichtigtList = []

  def beaufsichtigt(PruefungRef ... refs) {
    beaufsichtigtList.addAll(refs)
  }

}

class LehrveranstaltungRef extends DatabaseReference {

  // TODO NM replace with IdGenerator
  static java.lang.Long nextId = 1

  private java.lang.Long id
  
  def LehrveranstaltungRef() {
  }
  
  def LehrveranstaltungRef(java.lang.Long id) {
    setId(id)
  }

  java.lang.Long getId() {
    if (id == null) {
      // TODO NM replace with IdGenerator
      id = nextId++
    }
    return id
  }

  void setId(java.lang.Long id) {
    if (isDefined() && this.id != id) {
      throw new IllegalStateException("Id already set " + id + " vs " + this.id + " [Table: lehrveranstaltung]");
    }
    // TODO NM notify id generator that id is not available anymore
    this.id = id
  }

  boolean isDefined() {
    return this.id != null
  }
  
  String toString() {
    return "LehrveranstaltungRef[" + id + "]"
  }

  List<PruefungRef> geleitetVonList = []

  // depending on relation type with or without ellipse (...)
  def geleitetVon(ProfessorRef ... refs) {
    geleitetVonList.addAll(refs)
  }

  // depending on relation type with or with ellipse (...)
  List<PruefungRef> hatPruefungList = []

  def hatPruefung(PruefungRef ... refs) {
    hatPruefungList.addAll(refs)
  }

  // depending on relation type with or with ellipse (...)
  List<StudentRef> besuchtVonList = []

  def besuchtVon(StudentRef ... refs) {
    besuchtVonList.addAll(refs)
  }

  // depending on relation type with or with ellipse (...)
  List<StudentRef> hatTutorList = []

  def hatTutor(StudentRef ... refs) {
    hatTutorList.addAll(refs)
  }

}

class PruefungRef extends DatabaseReference {

  // TODO NM replace with IdGenerator
  static java.lang.Long nextId = 1

  private java.lang.Long id
  
  def PruefungRef() {
  }
  
  def PruefungRef(java.lang.Long id) {
    setId(id)
  }

  java.lang.Long getId() {
    if (id == null) {
      // TODO NM replace with IdGenerator
      id = nextId++
    }
    return id
  }

  void setId(java.lang.Long id) {
    if (isDefined() && this.id != id) {
      throw new IllegalStateException("Id already set " + id + " vs " + this.id + " [Table: pruefung]");
    }
    // TODO NM notify id generator that id is not available anymore
    this.id = id
  }

  boolean isDefined() {
    return this.id != null
  }
  
  String toString() {
    return "PruefungRef[" + id + "]"
  }

  List<StudentRef> stoffVonList = []

  // depending on relation type with or without ellipse (...)
  def stoffVon(LehrveranstaltungRef ... refs) {
    stoffVonList.addAll(refs)
  }

  // depending on relation type with or with ellipse (...)
  List<ProfessorRef> beaufsichtigtVonList = []

  def beaufsichtigtVon(ProfessorRef ... refs) {
    beaufsichtigtVonList.addAll(refs)
  }

  // depending on relation type with or with ellipse (...)
  List<StudentRef> geschriebenVonList = []

  def geschriebenVon(StudentRef ... refs) {
    geschriebenVonList.addAll(refs)
  }

}

class StudentRef extends DatabaseReference {

  private java.lang.Long id
  
  def StudentRef(java.lang.Long id) {
    setId(id)
  }

  java.lang.Long getId() {
    if (id == null) {
      throw new IllegalStateException("No id set");      
    }
    return id
  }

  void setId(java.lang.Long id) {
    if (isDefined() && this.id != id) {
      throw new IllegalStateException("Id already set " + id + " vs " + this.id + " [Table: student]");
    }
    // TODO NM notify id generator that id is not available anymore
    this.id = id
  }

  boolean isDefined() {
    return this.id != null
  }
  
  String toString() {
    return "StudentRef[" + id + "]"
  }

  // depending on relation type with or with ellipse (...)
  List<LehrveranstaltungRef> besuchtList = []

  def besucht(LehrveranstaltungRef ... refs) {
    besuchtList.addAll(refs)
  }

  // depending on relation type with or with ellipse (...)
  List<LehrveranstaltungRef> istTutorList = []

  def istTutor(LehrveranstaltungRef ... refs) {
    istTutorList.addAll(refs)
  }

  // depending on relation type with or with ellipse (...)
  List<PruefungRef> schreibtList = []

  def schreibt(PruefungRef ... refs) {
    schreibtList.addAll(refs)
  }

}

class BeaufsichtigtRef extends DatabaseReference {
  String toString() {
    return "BeaufsichtigtRef"
  }

}

class BesuchtRef extends DatabaseReference {
  String toString() {
    return "BesuchtRef"
  }

}

class IsttutorRef extends DatabaseReference {
  String toString() {
    return "IsttutorRef"
  }

}

class SchreibtRef extends DatabaseReference {
  String toString() {
    return "SchreibtRef"
  }

}

class ProfessorTable {

  ColumnHeader REF = new ColumnHeader(name: "REF", type: ProfessorRef.class)

  ColumnHeader id = new ColumnHeader(name: "id", type: java.lang.Long, isIdentificator: true, javaName: "Id" )

  ColumnHeader name = new ColumnHeader(name: "name", type: java.lang.String, isIdentificator: false, javaName: "Name" )

  ColumnHeader vorname = new ColumnHeader(name: "vorname", type: java.lang.String, isIdentificator: false, javaName: "Vorname" )

  ColumnHeader titel = new ColumnHeader(name: "titel", type: java.lang.String, isIdentificator: false, javaName: "Titel" )

  ColumnHeader fakultaet = new ColumnHeader(name: "fakultaet", type: java.lang.String, isIdentificator: false, javaName: "Fakultaet" )

  static ThreadLocal<List> context = new ThreadLocal<List>()
  
  com.seitenbau.testdatadsl.dbunitdemo.sbtesting.ProfessorTable table

  def ProfessorTable(com.seitenbau.testdatadsl.dbunitdemo.sbtesting.ProfessorTable table) {
    this.table = table
  }

  static or(self, arg) {
    appendRow(self, arg)
  }

  static or(Integer self, Integer arg) {
    appendRow(self, arg)
  }

  static or(Boolean self, Boolean arg) {
    appendRow(self, arg)
  }

  static appendRow(value, nextValue) {
    def row = new Row(values: [value])
    context.get().add(row)
    row.or(nextValue)
  }

  def parseTable(Closure rows) {
    context.set([])
    use(ProfessorTable) {
      rows.delegate = this
      rows.resolveStrategy = Closure.DELEGATE_FIRST
      rows()
    }
    context.get()
  }
  
  boolean isHeadRow(Row row) {
    null == row.values.find { value ->
      !(value instanceof ColumnHeader)
    }
  }
  
  int getRefColumn(Row header) {
    int result = -1
    int index = 0
    header.values.each { ColumnHeader column ->
      if (column.name == "REF") result = index
      index++
    }
    return result
  }
  
  int getIdColumn(Row header) {
    int result = -1
    int index = 0
    header.values.each { ColumnHeader column ->
      if (column.isIdentificator) result = index
      index++
    }
    return result
  }

  def rows(Closure rows) {
    def tableData = parseTable(rows)
    def head = null
    int columns = 0
    int lineNr = 0
    
    int colRef = -1
    int colId = -1
    
    tableData.each { Row row ->
      lineNr++    
      if (isHeadRow(row)) {
        head = row
        colRef = getRefColumn(head)
        colId = getIdColumn(head)
        columns = row.values.size()
      }
      else {
        if (row.values.size() != columns) throwColumnsDoNotMatchException(lineNr, row)
        // rowbuilder = table_Professor.insertRow()
		
        RowBuilder_Professor rowbuilder = null 
      
        // TODO NM check if there is a row with that id already
        // check if there is an ID -> search it
        // check if there is a Ref -> check if it has an ID -> search it
        if (colId != -1) {
          def id = row.values[colId]
          try {
            rowbuilder = table.findWhere.id(id)
          }
          catch (Exception e) {
          }
        }
        if (colRef != -1) {
          def ref = row.values[colRef]
          if (ref.isDefined()) {
            try {
              // TODO NM check if there was a rowbuilder already...
              // Bad: Not possible to compare both rowbuilders :-(
              rowbuilder = table.findWhere.id(ref.id)
            }
            catch (Exception e) {
            }
          }
        }
        
        if (rowbuilder != null) {
          if (colId != -1) {
            ColumnHeader column = head.values[colId]
            def method = "get" + column.javaName
            def id = row.values[colId]
            def value = rowbuilder."$method"()
            if (id != value) throwRedefinedIdException(lineNr, row)
          }
        }        
        
        if (rowbuilder == null) {
          rowbuilder = table.insertRow()
          if (colId != -1) {
            ColumnHeader column = head.values[colId]
            def method = "set" + column.javaName
            def value = row.values[colId]
          	rowbuilder."$method"(value)
          	
          	println "Adding Professor with $value"
          	
          	if (colRef != -1) {
              def ref = row.values[colRef]
              ref.id = value
          	}
          }
        }
        //def resultRow = new ProfessorTableRow()
        for (columnIndex in 0..(columns-1)) {
          if (columnIndex == colRef || columnIndex == colId) {
            continue;
          }

          ColumnHeader column = head.values[columnIndex]
          def method = "set" + column.javaName
          def value = row.values[columnIndex]
          if (value instanceof DatabaseReference) {
            println "Setting $method ( " + value.id + " ) on " + rowbuilder
          	rowbuilder."$method"(value.id)
          } else {
            println "Setting $method ( " + value + " ) on " + rowbuilder
          	rowbuilder."$method"(value)
          }
        }
      }
    }
  }
  
  def throwColumnsDoNotMatchException(int lineNr, Row row) {
    throwException("column count does not match", lineNr, row)
  }

  def throwRedefinedIdException(int lineNr, Row row) {
    throwException("Id redefined", lineNr, row)
  }
  
  def throwException(String message, int lineNr, Row row) {
    StringBuilder builder = new StringBuilder()
    builder.append("Error in Professor, line " + lineNr + ": " + message)
    if (row.values.size() > 0 ) {
      builder.append(" [Row: ")
      row.values.each { value ->
        builder.append(value)
        builder.append(" | ")
      }
      builder.setLength(builder.length() - 3)
      builder.append("]")
    }
    throw new IllegalArgumentException(builder.toString())
  }
}

class LehrveranstaltungTable {

  ColumnHeader REF = new ColumnHeader(name: "REF", type: LehrveranstaltungRef.class)

  ColumnHeader id = new ColumnHeader(name: "id", type: java.lang.Long, isIdentificator: true, javaName: "Id" )

  ColumnHeader professor_id = new ColumnHeader(name: "professor_id", type: ProfessorRef, isIdentificator: false, javaName: "ProfessorId" )

  ColumnHeader professor = new ColumnHeader(name: "professor", type: ProfessorRef, javaName: "ProfessorId")

  ColumnHeader name = new ColumnHeader(name: "name", type: java.lang.String, isIdentificator: false, javaName: "Name" )

  ColumnHeader sws = new ColumnHeader(name: "sws", type: java.lang.Integer, isIdentificator: false, javaName: "Sws" )

  ColumnHeader ects = new ColumnHeader(name: "ects", type: java.lang.Double, isIdentificator: false, javaName: "Ects" )

  static ThreadLocal<List> context = new ThreadLocal<List>()
  
  com.seitenbau.testdatadsl.dbunitdemo.sbtesting.LehrveranstaltungTable table

  def LehrveranstaltungTable(com.seitenbau.testdatadsl.dbunitdemo.sbtesting.LehrveranstaltungTable table) {
    this.table = table
  }

  static or(self, arg) {
    appendRow(self, arg)
  }

  static or(Integer self, Integer arg) {
    appendRow(self, arg)
  }

  static or(Boolean self, Boolean arg) {
    appendRow(self, arg)
  }

  static appendRow(value, nextValue) {
    def row = new Row(values: [value])
    context.get().add(row)
    row.or(nextValue)
  }

  def parseTable(Closure rows) {
    context.set([])
    use(LehrveranstaltungTable) {
      rows.delegate = this
      rows.resolveStrategy = Closure.DELEGATE_FIRST
      rows()
    }
    context.get()
  }
  
  boolean isHeadRow(Row row) {
    null == row.values.find { value ->
      !(value instanceof ColumnHeader)
    }
  }
  
  int getRefColumn(Row header) {
    int result = -1
    int index = 0
    header.values.each { ColumnHeader column ->
      if (column.name == "REF") result = index
      index++
    }
    return result
  }
  
  int getIdColumn(Row header) {
    int result = -1
    int index = 0
    header.values.each { ColumnHeader column ->
      if (column.isIdentificator) result = index
      index++
    }
    return result
  }

  def rows(Closure rows) {
    def tableData = parseTable(rows)
    def head = null
    int columns = 0
    int lineNr = 0
    
    int colRef = -1
    int colId = -1
    
    tableData.each { Row row ->
      lineNr++    
      if (isHeadRow(row)) {
        head = row
        colRef = getRefColumn(head)
        colId = getIdColumn(head)
        columns = row.values.size()
      }
      else {
        if (row.values.size() != columns) throwColumnsDoNotMatchException(lineNr, row)
        // rowbuilder = table_Lehrveranstaltung.insertRow()
		
        RowBuilder_Lehrveranstaltung rowbuilder = null 
      
        // TODO NM check if there is a row with that id already
        // check if there is an ID -> search it
        // check if there is a Ref -> check if it has an ID -> search it
        if (colId != -1) {
          def id = row.values[colId]
          try {
            rowbuilder = table.findWhere.id(id)
          }
          catch (Exception e) {
          }
        }
        if (colRef != -1) {
          def ref = row.values[colRef]
          if (ref.isDefined()) {
            try {
              // TODO NM check if there was a rowbuilder already...
              // Bad: Not possible to compare both rowbuilders :-(
              rowbuilder = table.findWhere.id(ref.id)
            }
            catch (Exception e) {
            }
          }
        }
        
        if (rowbuilder != null) {
          if (colId != -1) {
            ColumnHeader column = head.values[colId]
            def method = "get" + column.javaName
            def id = row.values[colId]
            def value = rowbuilder."$method"()
            if (id != value) throwRedefinedIdException(lineNr, row)
          }
        }        
        
        if (rowbuilder == null) {
          rowbuilder = table.insertRow()
          if (colId != -1) {
            ColumnHeader column = head.values[colId]
            def method = "set" + column.javaName
            def value = row.values[colId]
          	rowbuilder."$method"(value)
          	
          	println "Adding Lehrveranstaltung with $value"
          	
          	if (colRef != -1) {
              def ref = row.values[colRef]
              ref.id = value
          	}
          }
        }
        //def resultRow = new LehrveranstaltungTableRow()
        for (columnIndex in 0..(columns-1)) {
          if (columnIndex == colRef || columnIndex == colId) {
            continue;
          }

          ColumnHeader column = head.values[columnIndex]
          def method = "set" + column.javaName
          def value = row.values[columnIndex]
          if (value instanceof DatabaseReference) {
            println "Setting $method ( " + value.id + " ) on " + rowbuilder
          	rowbuilder."$method"(value.id)
          } else {
            println "Setting $method ( " + value + " ) on " + rowbuilder
          	rowbuilder."$method"(value)
          }
        }
      }
    }
  }
  
  def throwColumnsDoNotMatchException(int lineNr, Row row) {
    throwException("column count does not match", lineNr, row)
  }

  def throwRedefinedIdException(int lineNr, Row row) {
    throwException("Id redefined", lineNr, row)
  }
  
  def throwException(String message, int lineNr, Row row) {
    StringBuilder builder = new StringBuilder()
    builder.append("Error in Lehrveranstaltung, line " + lineNr + ": " + message)
    if (row.values.size() > 0 ) {
      builder.append(" [Row: ")
      row.values.each { value ->
        builder.append(value)
        builder.append(" | ")
      }
      builder.setLength(builder.length() - 3)
      builder.append("]")
    }
    throw new IllegalArgumentException(builder.toString())
  }
}

class PruefungTable {

  ColumnHeader REF = new ColumnHeader(name: "REF", type: PruefungRef.class)

  ColumnHeader id = new ColumnHeader(name: "id", type: java.lang.Long, isIdentificator: true, javaName: "Id" )

  ColumnHeader lehrveranstaltung_id = new ColumnHeader(name: "lehrveranstaltung_id", type: LehrveranstaltungRef, isIdentificator: false, javaName: "LehrveranstaltungId" )

  ColumnHeader lehrveranstaltung = new ColumnHeader(name: "lehrveranstaltung", type: LehrveranstaltungRef, javaName: "LehrveranstaltungId")

  ColumnHeader typ = new ColumnHeader(name: "typ", type: java.lang.String, isIdentificator: false, javaName: "Typ" )

  ColumnHeader zeitpunkt = new ColumnHeader(name: "zeitpunkt", type: java.util.Date, isIdentificator: false, javaName: "Zeitpunkt" )

  static ThreadLocal<List> context = new ThreadLocal<List>()
  
  com.seitenbau.testdatadsl.dbunitdemo.sbtesting.PruefungTable table

  def PruefungTable(com.seitenbau.testdatadsl.dbunitdemo.sbtesting.PruefungTable table) {
    this.table = table
  }

  static or(self, arg) {
    appendRow(self, arg)
  }

  static or(Integer self, Integer arg) {
    appendRow(self, arg)
  }

  static or(Boolean self, Boolean arg) {
    appendRow(self, arg)
  }

  static appendRow(value, nextValue) {
    def row = new Row(values: [value])
    context.get().add(row)
    row.or(nextValue)
  }

  def parseTable(Closure rows) {
    context.set([])
    use(PruefungTable) {
      rows.delegate = this
      rows.resolveStrategy = Closure.DELEGATE_FIRST
      rows()
    }
    context.get()
  }
  
  boolean isHeadRow(Row row) {
    null == row.values.find { value ->
      !(value instanceof ColumnHeader)
    }
  }
  
  int getRefColumn(Row header) {
    int result = -1
    int index = 0
    header.values.each { ColumnHeader column ->
      if (column.name == "REF") result = index
      index++
    }
    return result
  }
  
  int getIdColumn(Row header) {
    int result = -1
    int index = 0
    header.values.each { ColumnHeader column ->
      if (column.isIdentificator) result = index
      index++
    }
    return result
  }

  def rows(Closure rows) {
    def tableData = parseTable(rows)
    def head = null
    int columns = 0
    int lineNr = 0
    
    int colRef = -1
    int colId = -1
    
    tableData.each { Row row ->
      lineNr++    
      if (isHeadRow(row)) {
        head = row
        colRef = getRefColumn(head)
        colId = getIdColumn(head)
        columns = row.values.size()
      }
      else {
        if (row.values.size() != columns) throwColumnsDoNotMatchException(lineNr, row)
        // rowbuilder = table_Pruefung.insertRow()
		
        RowBuilder_Pruefung rowbuilder = null 
      
        // TODO NM check if there is a row with that id already
        // check if there is an ID -> search it
        // check if there is a Ref -> check if it has an ID -> search it
        if (colId != -1) {
          def id = row.values[colId]
          try {
            rowbuilder = table.findWhere.id(id)
          }
          catch (Exception e) {
          }
        }
        if (colRef != -1) {
          def ref = row.values[colRef]
          if (ref.isDefined()) {
            try {
              // TODO NM check if there was a rowbuilder already...
              // Bad: Not possible to compare both rowbuilders :-(
              rowbuilder = table.findWhere.id(ref.id)
            }
            catch (Exception e) {
            }
          }
        }
        
        if (rowbuilder != null) {
          if (colId != -1) {
            ColumnHeader column = head.values[colId]
            def method = "get" + column.javaName
            def id = row.values[colId]
            def value = rowbuilder."$method"()
            if (id != value) throwRedefinedIdException(lineNr, row)
          }
        }        
        
        if (rowbuilder == null) {
          rowbuilder = table.insertRow()
          if (colId != -1) {
            ColumnHeader column = head.values[colId]
            def method = "set" + column.javaName
            def value = row.values[colId]
          	rowbuilder."$method"(value)
          	
          	println "Adding Pruefung with $value"
          	
          	if (colRef != -1) {
              def ref = row.values[colRef]
              ref.id = value
          	}
          }
        }
        //def resultRow = new PruefungTableRow()
        for (columnIndex in 0..(columns-1)) {
          if (columnIndex == colRef || columnIndex == colId) {
            continue;
          }

          ColumnHeader column = head.values[columnIndex]
          def method = "set" + column.javaName
          def value = row.values[columnIndex]
          if (value instanceof DatabaseReference) {
            println "Setting $method ( " + value.id + " ) on " + rowbuilder
          	rowbuilder."$method"(value.id)
          } else {
            println "Setting $method ( " + value + " ) on " + rowbuilder
          	rowbuilder."$method"(value)
          }
        }
      }
    }
  }
  
  def throwColumnsDoNotMatchException(int lineNr, Row row) {
    throwException("column count does not match", lineNr, row)
  }

  def throwRedefinedIdException(int lineNr, Row row) {
    throwException("Id redefined", lineNr, row)
  }
  
  def throwException(String message, int lineNr, Row row) {
    StringBuilder builder = new StringBuilder()
    builder.append("Error in Pruefung, line " + lineNr + ": " + message)
    if (row.values.size() > 0 ) {
      builder.append(" [Row: ")
      row.values.each { value ->
        builder.append(value)
        builder.append(" | ")
      }
      builder.setLength(builder.length() - 3)
      builder.append("]")
    }
    throw new IllegalArgumentException(builder.toString())
  }
}

class StudentTable {

  ColumnHeader REF = new ColumnHeader(name: "REF", type: StudentRef.class)

  ColumnHeader matrikelnummer = new ColumnHeader(name: "matrikelnummer", type: java.lang.Long, isIdentificator: true, javaName: "Matrikelnummer" )

  ColumnHeader name = new ColumnHeader(name: "name", type: java.lang.String, isIdentificator: false, javaName: "Name" )

  ColumnHeader vorname = new ColumnHeader(name: "vorname", type: java.lang.String, isIdentificator: false, javaName: "Vorname" )

  ColumnHeader studiengang = new ColumnHeader(name: "studiengang", type: java.lang.String, isIdentificator: false, javaName: "Studiengang" )

  ColumnHeader semester = new ColumnHeader(name: "semester", type: java.lang.Integer, isIdentificator: false, javaName: "Semester" )

  ColumnHeader immatrikuliert_seit = new ColumnHeader(name: "immatrikuliert_seit", type: java.util.Date, isIdentificator: false, javaName: "ImmatrikuliertSeit" )

  static ThreadLocal<List> context = new ThreadLocal<List>()
  
  com.seitenbau.testdatadsl.dbunitdemo.sbtesting.StudentTable table

  def StudentTable(com.seitenbau.testdatadsl.dbunitdemo.sbtesting.StudentTable table) {
    this.table = table
  }

  static or(self, arg) {
    appendRow(self, arg)
  }

  static or(Integer self, Integer arg) {
    appendRow(self, arg)
  }

  static or(Boolean self, Boolean arg) {
    appendRow(self, arg)
  }

  static appendRow(value, nextValue) {
    def row = new Row(values: [value])
    context.get().add(row)
    row.or(nextValue)
  }

  def parseTable(Closure rows) {
    context.set([])
    use(StudentTable) {
      rows.delegate = this
      rows.resolveStrategy = Closure.DELEGATE_FIRST
      rows()
    }
    context.get()
  }
  
  boolean isHeadRow(Row row) {
    null == row.values.find { value ->
      !(value instanceof ColumnHeader)
    }
  }
  
  int getRefColumn(Row header) {
    int result = -1
    int index = 0
    header.values.each { ColumnHeader column ->
      if (column.name == "REF") result = index
      index++
    }
    return result
  }
  
  int getIdColumn(Row header) {
    int result = -1
    int index = 0
    header.values.each { ColumnHeader column ->
      if (column.isIdentificator) result = index
      index++
    }
    return result
  }

  def rows(Closure rows) {
    def tableData = parseTable(rows)
    def head = null
    int columns = 0
    int lineNr = 0
    
    int colRef = -1
    int colId = -1
    
    tableData.each { Row row ->
      lineNr++    
      if (isHeadRow(row)) {
        head = row
        colRef = getRefColumn(head)
        colId = getIdColumn(head)
        columns = row.values.size()
      }
      else {
        if (row.values.size() != columns) throwColumnsDoNotMatchException(lineNr, row)
        // rowbuilder = table_Student.insertRow()
		
        RowBuilder_Student rowbuilder = null 
      
        // TODO NM check if there is a row with that id already
        // check if there is an ID -> search it
        // check if there is a Ref -> check if it has an ID -> search it
        if (colId != -1) {
          def id = row.values[colId]
          try {
            rowbuilder = table.findWhere.id(id)
          }
          catch (Exception e) {
          }
        }
        if (colRef != -1) {
          def ref = row.values[colRef]
          if (ref.isDefined()) {
            try {
              // TODO NM check if there was a rowbuilder already...
              // Bad: Not possible to compare both rowbuilders :-(
              rowbuilder = table.findWhere.id(ref.id)
            }
            catch (Exception e) {
            }
          }
        }
        
        if (rowbuilder != null) {
          if (colId != -1) {
            ColumnHeader column = head.values[colId]
            def method = "get" + column.javaName
            def id = row.values[colId]
            def value = rowbuilder."$method"()
            if (id != value) throwRedefinedIdException(lineNr, row)
          }
        }        
        
        if (rowbuilder == null) {
          rowbuilder = table.insertRow()
          if (colId != -1) {
            ColumnHeader column = head.values[colId]
            def method = "set" + column.javaName
            def value = row.values[colId]
          	rowbuilder."$method"(value)
          	
          	println "Adding Student with $value"
          	
          	if (colRef != -1) {
              def ref = row.values[colRef]
              ref.id = value
          	}
          }
        }
        //def resultRow = new StudentTableRow()
        for (columnIndex in 0..(columns-1)) {
          if (columnIndex == colRef || columnIndex == colId) {
            continue;
          }

          ColumnHeader column = head.values[columnIndex]
          def method = "set" + column.javaName
          def value = row.values[columnIndex]
          if (value instanceof DatabaseReference) {
            println "Setting $method ( " + value.id + " ) on " + rowbuilder
          	rowbuilder."$method"(value.id)
          } else {
            println "Setting $method ( " + value + " ) on " + rowbuilder
          	rowbuilder."$method"(value)
          }
        }
      }
    }
  }
  
  def throwColumnsDoNotMatchException(int lineNr, Row row) {
    throwException("column count does not match", lineNr, row)
  }

  def throwRedefinedIdException(int lineNr, Row row) {
    throwException("Id redefined", lineNr, row)
  }
  
  def throwException(String message, int lineNr, Row row) {
    StringBuilder builder = new StringBuilder()
    builder.append("Error in Student, line " + lineNr + ": " + message)
    if (row.values.size() > 0 ) {
      builder.append(" [Row: ")
      row.values.each { value ->
        builder.append(value)
        builder.append(" | ")
      }
      builder.setLength(builder.length() - 3)
      builder.append("]")
    }
    throw new IllegalArgumentException(builder.toString())
  }
}

class BeaufsichtigtTable {

  ColumnHeader REF = new ColumnHeader(name: "REF", type: BeaufsichtigtRef.class)

  ColumnHeader professor_id = new ColumnHeader(name: "professor_id", type: ProfessorRef, isIdentificator: false, javaName: "ProfessorId" )

  ColumnHeader professor = new ColumnHeader(name: "professor", type: ProfessorRef, javaName: "ProfessorId")

  ColumnHeader pruefung_id = new ColumnHeader(name: "pruefung_id", type: PruefungRef, isIdentificator: false, javaName: "PruefungId" )

  ColumnHeader pruefung = new ColumnHeader(name: "pruefung", type: PruefungRef, javaName: "PruefungId")

  static ThreadLocal<List> context = new ThreadLocal<List>()
  
  com.seitenbau.testdatadsl.dbunitdemo.sbtesting.BeaufsichtigtTable table

  def BeaufsichtigtTable(com.seitenbau.testdatadsl.dbunitdemo.sbtesting.BeaufsichtigtTable table) {
    this.table = table
  }

  static or(self, arg) {
    appendRow(self, arg)
  }

  static or(Integer self, Integer arg) {
    appendRow(self, arg)
  }

  static or(Boolean self, Boolean arg) {
    appendRow(self, arg)
  }

  static appendRow(value, nextValue) {
    def row = new Row(values: [value])
    context.get().add(row)
    row.or(nextValue)
  }

  def parseTable(Closure rows) {
    context.set([])
    use(BeaufsichtigtTable) {
      rows.delegate = this
      rows.resolveStrategy = Closure.DELEGATE_FIRST
      rows()
    }
    context.get()
  }
  
  boolean isHeadRow(Row row) {
    null == row.values.find { value ->
      !(value instanceof ColumnHeader)
    }
  }
  
  int getRefColumn(Row header) {
    int result = -1
    int index = 0
    header.values.each { ColumnHeader column ->
      if (column.name == "REF") result = index
      index++
    }
    return result
  }
  
  int getIdColumn(Row header) {
    int result = -1
    int index = 0
    header.values.each { ColumnHeader column ->
      if (column.isIdentificator) result = index
      index++
    }
    return result
  }

  def rows(Closure rows) {
    def tableData = parseTable(rows)
    def head = null
    int columns = 0
    int lineNr = 0
    
    int colRef = -1
    int colId = -1
    
    tableData.each { Row row ->
      lineNr++    
      if (isHeadRow(row)) {
        head = row
        colRef = getRefColumn(head)
        colId = getIdColumn(head)
        columns = row.values.size()
      }
      else {
        if (row.values.size() != columns) throwColumnsDoNotMatchException(lineNr, row)
        // rowbuilder = table_Beaufsichtigt.insertRow()
		
        RowBuilder_Beaufsichtigt rowbuilder = null 
      
        // TODO NM check if there is a row with that id already
        // check if there is an ID -> search it
        // check if there is a Ref -> check if it has an ID -> search it
        if (colId != -1) {
          def id = row.values[colId]
          try {
            rowbuilder = table.findWhere.id(id)
          }
          catch (Exception e) {
          }
        }
        if (colRef != -1) {
          def ref = row.values[colRef]
          if (ref.isDefined()) {
            try {
              // TODO NM check if there was a rowbuilder already...
              // Bad: Not possible to compare both rowbuilders :-(
              rowbuilder = table.findWhere.id(ref.id)
            }
            catch (Exception e) {
            }
          }
        }
        
        if (rowbuilder != null) {
          if (colId != -1) {
            ColumnHeader column = head.values[colId]
            def method = "get" + column.javaName
            def id = row.values[colId]
            def value = rowbuilder."$method"()
            if (id != value) throwRedefinedIdException(lineNr, row)
          }
        }        
        
        if (rowbuilder == null) {
          rowbuilder = table.insertRow()
          if (colId != -1) {
            ColumnHeader column = head.values[colId]
            def method = "set" + column.javaName
            def value = row.values[colId]
          	rowbuilder."$method"(value)
          	
          	println "Adding Beaufsichtigt with $value"
          	
          	if (colRef != -1) {
              def ref = row.values[colRef]
              ref.id = value
          	}
          }
        }
        //def resultRow = new BeaufsichtigtTableRow()
        for (columnIndex in 0..(columns-1)) {
          if (columnIndex == colRef || columnIndex == colId) {
            continue;
          }

          ColumnHeader column = head.values[columnIndex]
          def method = "set" + column.javaName
          def value = row.values[columnIndex]
          if (value instanceof DatabaseReference) {
            println "Setting $method ( " + value.id + " ) on " + rowbuilder
          	rowbuilder."$method"(value.id)
          } else {
            println "Setting $method ( " + value + " ) on " + rowbuilder
          	rowbuilder."$method"(value)
          }
        }
      }
    }
  }
  
  def throwColumnsDoNotMatchException(int lineNr, Row row) {
    throwException("column count does not match", lineNr, row)
  }

  def throwRedefinedIdException(int lineNr, Row row) {
    throwException("Id redefined", lineNr, row)
  }
  
  def throwException(String message, int lineNr, Row row) {
    StringBuilder builder = new StringBuilder()
    builder.append("Error in Beaufsichtigt, line " + lineNr + ": " + message)
    if (row.values.size() > 0 ) {
      builder.append(" [Row: ")
      row.values.each { value ->
        builder.append(value)
        builder.append(" | ")
      }
      builder.setLength(builder.length() - 3)
      builder.append("]")
    }
    throw new IllegalArgumentException(builder.toString())
  }
}

class BesuchtTable {

  ColumnHeader REF = new ColumnHeader(name: "REF", type: BesuchtRef.class)

  ColumnHeader student_id = new ColumnHeader(name: "student_id", type: StudentRef, isIdentificator: false, javaName: "StudentId" )

  ColumnHeader student = new ColumnHeader(name: "student", type: StudentRef, javaName: "StudentId")

  ColumnHeader lehrveranstaltung_id = new ColumnHeader(name: "lehrveranstaltung_id", type: LehrveranstaltungRef, isIdentificator: false, javaName: "LehrveranstaltungId" )

  ColumnHeader lehrveranstaltung = new ColumnHeader(name: "lehrveranstaltung", type: LehrveranstaltungRef, javaName: "LehrveranstaltungId")

  static ThreadLocal<List> context = new ThreadLocal<List>()
  
  com.seitenbau.testdatadsl.dbunitdemo.sbtesting.BesuchtTable table

  def BesuchtTable(com.seitenbau.testdatadsl.dbunitdemo.sbtesting.BesuchtTable table) {
    this.table = table
  }

  static or(self, arg) {
    appendRow(self, arg)
  }

  static or(Integer self, Integer arg) {
    appendRow(self, arg)
  }

  static or(Boolean self, Boolean arg) {
    appendRow(self, arg)
  }

  static appendRow(value, nextValue) {
    def row = new Row(values: [value])
    context.get().add(row)
    row.or(nextValue)
  }

  def parseTable(Closure rows) {
    context.set([])
    use(BesuchtTable) {
      rows.delegate = this
      rows.resolveStrategy = Closure.DELEGATE_FIRST
      rows()
    }
    context.get()
  }
  
  boolean isHeadRow(Row row) {
    null == row.values.find { value ->
      !(value instanceof ColumnHeader)
    }
  }
  
  int getRefColumn(Row header) {
    int result = -1
    int index = 0
    header.values.each { ColumnHeader column ->
      if (column.name == "REF") result = index
      index++
    }
    return result
  }
  
  int getIdColumn(Row header) {
    int result = -1
    int index = 0
    header.values.each { ColumnHeader column ->
      if (column.isIdentificator) result = index
      index++
    }
    return result
  }

  def rows(Closure rows) {
    def tableData = parseTable(rows)
    def head = null
    int columns = 0
    int lineNr = 0
    
    int colRef = -1
    int colId = -1
    
    tableData.each { Row row ->
      lineNr++    
      if (isHeadRow(row)) {
        head = row
        colRef = getRefColumn(head)
        colId = getIdColumn(head)
        columns = row.values.size()
      }
      else {
        if (row.values.size() != columns) throwColumnsDoNotMatchException(lineNr, row)
        // rowbuilder = table_Besucht.insertRow()
		
        RowBuilder_Besucht rowbuilder = null 
      
        // TODO NM check if there is a row with that id already
        // check if there is an ID -> search it
        // check if there is a Ref -> check if it has an ID -> search it
        if (colId != -1) {
          def id = row.values[colId]
          try {
            rowbuilder = table.findWhere.id(id)
          }
          catch (Exception e) {
          }
        }
        if (colRef != -1) {
          def ref = row.values[colRef]
          if (ref.isDefined()) {
            try {
              // TODO NM check if there was a rowbuilder already...
              // Bad: Not possible to compare both rowbuilders :-(
              rowbuilder = table.findWhere.id(ref.id)
            }
            catch (Exception e) {
            }
          }
        }
        
        if (rowbuilder != null) {
          if (colId != -1) {
            ColumnHeader column = head.values[colId]
            def method = "get" + column.javaName
            def id = row.values[colId]
            def value = rowbuilder."$method"()
            if (id != value) throwRedefinedIdException(lineNr, row)
          }
        }        
        
        if (rowbuilder == null) {
          rowbuilder = table.insertRow()
          if (colId != -1) {
            ColumnHeader column = head.values[colId]
            def method = "set" + column.javaName
            def value = row.values[colId]
          	rowbuilder."$method"(value)
          	
          	println "Adding Besucht with $value"
          	
          	if (colRef != -1) {
              def ref = row.values[colRef]
              ref.id = value
          	}
          }
        }
        //def resultRow = new BesuchtTableRow()
        for (columnIndex in 0..(columns-1)) {
          if (columnIndex == colRef || columnIndex == colId) {
            continue;
          }

          ColumnHeader column = head.values[columnIndex]
          def method = "set" + column.javaName
          def value = row.values[columnIndex]
          if (value instanceof DatabaseReference) {
            println "Setting $method ( " + value.id + " ) on " + rowbuilder
          	rowbuilder."$method"(value.id)
          } else {
            println "Setting $method ( " + value + " ) on " + rowbuilder
          	rowbuilder."$method"(value)
          }
        }
      }
    }
  }
  
  def throwColumnsDoNotMatchException(int lineNr, Row row) {
    throwException("column count does not match", lineNr, row)
  }

  def throwRedefinedIdException(int lineNr, Row row) {
    throwException("Id redefined", lineNr, row)
  }
  
  def throwException(String message, int lineNr, Row row) {
    StringBuilder builder = new StringBuilder()
    builder.append("Error in Besucht, line " + lineNr + ": " + message)
    if (row.values.size() > 0 ) {
      builder.append(" [Row: ")
      row.values.each { value ->
        builder.append(value)
        builder.append(" | ")
      }
      builder.setLength(builder.length() - 3)
      builder.append("]")
    }
    throw new IllegalArgumentException(builder.toString())
  }
}

class IsttutorTable {

  ColumnHeader REF = new ColumnHeader(name: "REF", type: IsttutorRef.class)

  ColumnHeader student_id = new ColumnHeader(name: "student_id", type: StudentRef, isIdentificator: false, javaName: "StudentId" )

  ColumnHeader student = new ColumnHeader(name: "student", type: StudentRef, javaName: "StudentId")

  ColumnHeader lehrveranstaltung_id = new ColumnHeader(name: "lehrveranstaltung_id", type: LehrveranstaltungRef, isIdentificator: false, javaName: "LehrveranstaltungId" )

  ColumnHeader lehrveranstaltung = new ColumnHeader(name: "lehrveranstaltung", type: LehrveranstaltungRef, javaName: "LehrveranstaltungId")

  static ThreadLocal<List> context = new ThreadLocal<List>()
  
  com.seitenbau.testdatadsl.dbunitdemo.sbtesting.IsttutorTable table

  def IsttutorTable(com.seitenbau.testdatadsl.dbunitdemo.sbtesting.IsttutorTable table) {
    this.table = table
  }

  static or(self, arg) {
    appendRow(self, arg)
  }

  static or(Integer self, Integer arg) {
    appendRow(self, arg)
  }

  static or(Boolean self, Boolean arg) {
    appendRow(self, arg)
  }

  static appendRow(value, nextValue) {
    def row = new Row(values: [value])
    context.get().add(row)
    row.or(nextValue)
  }

  def parseTable(Closure rows) {
    context.set([])
    use(IsttutorTable) {
      rows.delegate = this
      rows.resolveStrategy = Closure.DELEGATE_FIRST
      rows()
    }
    context.get()
  }
  
  boolean isHeadRow(Row row) {
    null == row.values.find { value ->
      !(value instanceof ColumnHeader)
    }
  }
  
  int getRefColumn(Row header) {
    int result = -1
    int index = 0
    header.values.each { ColumnHeader column ->
      if (column.name == "REF") result = index
      index++
    }
    return result
  }
  
  int getIdColumn(Row header) {
    int result = -1
    int index = 0
    header.values.each { ColumnHeader column ->
      if (column.isIdentificator) result = index
      index++
    }
    return result
  }

  def rows(Closure rows) {
    def tableData = parseTable(rows)
    def head = null
    int columns = 0
    int lineNr = 0
    
    int colRef = -1
    int colId = -1
    
    tableData.each { Row row ->
      lineNr++    
      if (isHeadRow(row)) {
        head = row
        colRef = getRefColumn(head)
        colId = getIdColumn(head)
        columns = row.values.size()
      }
      else {
        if (row.values.size() != columns) throwColumnsDoNotMatchException(lineNr, row)
        // rowbuilder = table_Isttutor.insertRow()
		
        RowBuilder_Isttutor rowbuilder = null 
      
        // TODO NM check if there is a row with that id already
        // check if there is an ID -> search it
        // check if there is a Ref -> check if it has an ID -> search it
        if (colId != -1) {
          def id = row.values[colId]
          try {
            rowbuilder = table.findWhere.id(id)
          }
          catch (Exception e) {
          }
        }
        if (colRef != -1) {
          def ref = row.values[colRef]
          if (ref.isDefined()) {
            try {
              // TODO NM check if there was a rowbuilder already...
              // Bad: Not possible to compare both rowbuilders :-(
              rowbuilder = table.findWhere.id(ref.id)
            }
            catch (Exception e) {
            }
          }
        }
        
        if (rowbuilder != null) {
          if (colId != -1) {
            ColumnHeader column = head.values[colId]
            def method = "get" + column.javaName
            def id = row.values[colId]
            def value = rowbuilder."$method"()
            if (id != value) throwRedefinedIdException(lineNr, row)
          }
        }        
        
        if (rowbuilder == null) {
          rowbuilder = table.insertRow()
          if (colId != -1) {
            ColumnHeader column = head.values[colId]
            def method = "set" + column.javaName
            def value = row.values[colId]
          	rowbuilder."$method"(value)
          	
          	println "Adding Isttutor with $value"
          	
          	if (colRef != -1) {
              def ref = row.values[colRef]
              ref.id = value
          	}
          }
        }
        //def resultRow = new IsttutorTableRow()
        for (columnIndex in 0..(columns-1)) {
          if (columnIndex == colRef || columnIndex == colId) {
            continue;
          }

          ColumnHeader column = head.values[columnIndex]
          def method = "set" + column.javaName
          def value = row.values[columnIndex]
          if (value instanceof DatabaseReference) {
            println "Setting $method ( " + value.id + " ) on " + rowbuilder
          	rowbuilder."$method"(value.id)
          } else {
            println "Setting $method ( " + value + " ) on " + rowbuilder
          	rowbuilder."$method"(value)
          }
        }
      }
    }
  }
  
  def throwColumnsDoNotMatchException(int lineNr, Row row) {
    throwException("column count does not match", lineNr, row)
  }

  def throwRedefinedIdException(int lineNr, Row row) {
    throwException("Id redefined", lineNr, row)
  }
  
  def throwException(String message, int lineNr, Row row) {
    StringBuilder builder = new StringBuilder()
    builder.append("Error in Isttutor, line " + lineNr + ": " + message)
    if (row.values.size() > 0 ) {
      builder.append(" [Row: ")
      row.values.each { value ->
        builder.append(value)
        builder.append(" | ")
      }
      builder.setLength(builder.length() - 3)
      builder.append("]")
    }
    throw new IllegalArgumentException(builder.toString())
  }
}

class SchreibtTable {

  ColumnHeader REF = new ColumnHeader(name: "REF", type: SchreibtRef.class)

  ColumnHeader student_id = new ColumnHeader(name: "student_id", type: StudentRef, isIdentificator: false, javaName: "StudentId" )

  ColumnHeader student = new ColumnHeader(name: "student", type: StudentRef, javaName: "StudentId")

  ColumnHeader pruefung_id = new ColumnHeader(name: "pruefung_id", type: PruefungRef, isIdentificator: false, javaName: "PruefungId" )

  ColumnHeader pruefung = new ColumnHeader(name: "pruefung", type: PruefungRef, javaName: "PruefungId")

  static ThreadLocal<List> context = new ThreadLocal<List>()
  
  com.seitenbau.testdatadsl.dbunitdemo.sbtesting.SchreibtTable table

  def SchreibtTable(com.seitenbau.testdatadsl.dbunitdemo.sbtesting.SchreibtTable table) {
    this.table = table
  }

  static or(self, arg) {
    appendRow(self, arg)
  }

  static or(Integer self, Integer arg) {
    appendRow(self, arg)
  }

  static or(Boolean self, Boolean arg) {
    appendRow(self, arg)
  }

  static appendRow(value, nextValue) {
    def row = new Row(values: [value])
    context.get().add(row)
    row.or(nextValue)
  }

  def parseTable(Closure rows) {
    context.set([])
    use(SchreibtTable) {
      rows.delegate = this
      rows.resolveStrategy = Closure.DELEGATE_FIRST
      rows()
    }
    context.get()
  }
  
  boolean isHeadRow(Row row) {
    null == row.values.find { value ->
      !(value instanceof ColumnHeader)
    }
  }
  
  int getRefColumn(Row header) {
    int result = -1
    int index = 0
    header.values.each { ColumnHeader column ->
      if (column.name == "REF") result = index
      index++
    }
    return result
  }
  
  int getIdColumn(Row header) {
    int result = -1
    int index = 0
    header.values.each { ColumnHeader column ->
      if (column.isIdentificator) result = index
      index++
    }
    return result
  }

  def rows(Closure rows) {
    def tableData = parseTable(rows)
    def head = null
    int columns = 0
    int lineNr = 0
    
    int colRef = -1
    int colId = -1
    
    tableData.each { Row row ->
      lineNr++    
      if (isHeadRow(row)) {
        head = row
        colRef = getRefColumn(head)
        colId = getIdColumn(head)
        columns = row.values.size()
      }
      else {
        if (row.values.size() != columns) throwColumnsDoNotMatchException(lineNr, row)
        // rowbuilder = table_Schreibt.insertRow()
		
        RowBuilder_Schreibt rowbuilder = null 
      
        // TODO NM check if there is a row with that id already
        // check if there is an ID -> search it
        // check if there is a Ref -> check if it has an ID -> search it
        if (colId != -1) {
          def id = row.values[colId]
          try {
            rowbuilder = table.findWhere.id(id)
          }
          catch (Exception e) {
          }
        }
        if (colRef != -1) {
          def ref = row.values[colRef]
          if (ref.isDefined()) {
            try {
              // TODO NM check if there was a rowbuilder already...
              // Bad: Not possible to compare both rowbuilders :-(
              rowbuilder = table.findWhere.id(ref.id)
            }
            catch (Exception e) {
            }
          }
        }
        
        if (rowbuilder != null) {
          if (colId != -1) {
            ColumnHeader column = head.values[colId]
            def method = "get" + column.javaName
            def id = row.values[colId]
            def value = rowbuilder."$method"()
            if (id != value) throwRedefinedIdException(lineNr, row)
          }
        }        
        
        if (rowbuilder == null) {
          rowbuilder = table.insertRow()
          if (colId != -1) {
            ColumnHeader column = head.values[colId]
            def method = "set" + column.javaName
            def value = row.values[colId]
          	rowbuilder."$method"(value)
          	
          	println "Adding Schreibt with $value"
          	
          	if (colRef != -1) {
              def ref = row.values[colRef]
              ref.id = value
          	}
          }
        }
        //def resultRow = new SchreibtTableRow()
        for (columnIndex in 0..(columns-1)) {
          if (columnIndex == colRef || columnIndex == colId) {
            continue;
          }

          ColumnHeader column = head.values[columnIndex]
          def method = "set" + column.javaName
          def value = row.values[columnIndex]
          if (value instanceof DatabaseReference) {
            println "Setting $method ( " + value.id + " ) on " + rowbuilder
          	rowbuilder."$method"(value.id)
          } else {
            println "Setting $method ( " + value + " ) on " + rowbuilder
          	rowbuilder."$method"(value)
          }
        }
      }
    }
  }
  
  def throwColumnsDoNotMatchException(int lineNr, Row row) {
    throwException("column count does not match", lineNr, row)
  }

  def throwRedefinedIdException(int lineNr, Row row) {
    throwException("Id redefined", lineNr, row)
  }
  
  def throwException(String message, int lineNr, Row row) {
    StringBuilder builder = new StringBuilder()
    builder.append("Error in Schreibt, line " + lineNr + ": " + message)
    if (row.values.size() > 0 ) {
      builder.append(" [Row: ")
      row.values.each { value ->
        builder.append(value)
        builder.append(" | ")
      }
      builder.setLength(builder.length() - 3)
      builder.append("]")
    }
    throw new IllegalArgumentException(builder.toString())
  }
}

// TODO NM Class should actually be named "DataSet", but there would be a naming conflict...
class DBUnitExamplesParser {

  DBUnitExamplesDataSet dataset = new DBUnitExamplesDataSet() {
      void initDataSet() { }
    }

  ProfessorTable professorTable = new ProfessorTable(dataset.table_Professor)
  
  LehrveranstaltungTable lehrveranstaltungTable = new LehrveranstaltungTable(dataset.table_Lehrveranstaltung)
  
  PruefungTable pruefungTable = new PruefungTable(dataset.table_Pruefung)
  
  StudentTable studentTable = new StudentTable(dataset.table_Student)
  
  BeaufsichtigtTable beaufsichtigtTable = new BeaufsichtigtTable(dataset.table_Beaufsichtigt)
  
  BesuchtTable besuchtTable = new BesuchtTable(dataset.table_Besucht)
  
  IsttutorTable isttutorTable = new IsttutorTable(dataset.table_Isttutor)
  
  SchreibtTable schreibtTable = new SchreibtTable(dataset.table_Schreibt)
  
  def tables(Closure table) {
    table.delegate = this
    table.resolveStrategy = Closure.DELEGATE_FIRST
    table()
  }
  
  def relations(Closure relations) {
    relations()
  }
 
  def createDataSet() {
    dataset.createDBUnitDataSet()
  }
}