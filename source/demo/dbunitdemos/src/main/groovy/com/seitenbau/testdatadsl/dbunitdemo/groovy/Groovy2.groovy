package com.seitenbau.testdatadsl.dbunitdemo.groovy

import groovy.transform.ThreadInterrupt;
import groovy.transform.ToString;

class Column {
	String name;
}

class Table {
  String name
	List columns = []

  def Table(String name) {
    this.name = name
  }
  
	def addColumn(String name) {
		def column = new Column()
		column.name = name
		columns.add(column)
		this
	}
	
	def containsColumn(String name) {
		for (Column c in columns) {
			if (c.name == name) {
				return true;
			}
		}
		
		return false;
	}
	
	def parse(Closure tableData) {
		TableParser.parse(this, tableData)
	}
}

@ToString
class TableData {
  def variables = [:]
  def tables = [:]
}

class TableModel {

  static def columnId = "REF"
  
  static def placeHolder = new Var();

  def model = [:]
    
  def newTable(String name) {
    def table = new Table(name)
    model[name] = table
    return table
  }
  
  def parse(Map tables) {

    def variables = [:]
    TableData result = new TableData()

    for (e in tables) {
      Table table = model[e.key]
      
      def data = new TableParser().parseTableClosure(e.value)

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
        } else if (!table.containsColumn(name)) {
          throw new IllegalArgumentException("Column " + name + " not part of table");
        }
      }
      
      def tablerows = []
      for (row in data) {
        if (row == head) {
          continue;
        }
        
        def resultRow = [:]
        resultRow["TABLE_TYPE"] = e.key
        
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
            resultRow[field] = value
          }
        }
        
        if (!ref.isPlaceholder()) {
          result.variables[ref.name] = resultRow;
        }
        
        tablerows.add(resultRow);
      }
      result.tables[e.key] = tablerows 
    }
    
    return result;
  }
}


@ToString
class Row {

	List values = []

	def or(arg) {
		values.add(arg)
		this
	}
}

@ToString
class Values {

	List values = []

	def and(arg) {
		values.add(arg)
		this
	}
}

@ToString
class Var {
	String name
	
	def Var() {
		name = "_"
	}
	
	def isPlaceholder() {
		return name == "_"
	}
}

class TableParser {
	
	static context = new ThreadLocal<List>()

	static List getRows() {
		context.get()
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

	static and(self, arg) {
		def values = new Values(values: [self])
		values.and(arg)
	}

	static appendRow(value, nextValue) {
		def row = new Row(values: [value])
		rows.add(row)
		row.or(nextValue)
	}

	def getProperty(String property) {
		new Var(name: property)
	}

	def parseTableClosure(Closure tableData){
		context.set([])
		use(TableParser) {
			tableData.delegate = this
			tableData.resolveStrategy = Closure.DELEGATE_FIRST
			tableData()
		}
		context.get()
	}

	static parse(Table table, Closure tableData) {
	}
}

//def table = TableParser.parse {
//	a    |  b
//	"A"  |  "B"
//	1    |  2
//	true | false
//}
//println table

TableModel tableModel = new TableModel()
tableModel.newTable("professor")
  .addColumn("name")
  .addColumn("vorname")
  .addColumn("titel")
  .addColumn("fakultaet")
  .addColumn("leitet")
  .addColumn("beaufsichtigt")
 
tableModel.newTable("lehrveranstaltung")
	.addColumn("name")
	.addColumn("sws")
	.addColumn("ects")
	
tableModel.newTable("pruefung")
	.addColumn("lehrveranstaltung_id")
	.addColumn("typ")
	.addColumn("zeitpunkt")
	
tableModel.newTable("student")
	.addColumn("matrikelnummer")
	.addColumn("name")
	.addColumn("vorname")
	.addColumn("studiengang")
	.addColumn("semester")
	.addColumn("immatrikuliert_seit")
	.addColumn("besucht")
	.addColumn("istTutor")
	.addColumn("schreibt")

//def professor = professorTable.parse {
//  test:
//	REF    | name    | vorname  | titel            | fakultaet    | leitet               | beaufsichtigt
//	HAASE  | "Haase" | "Oliver" | "Prof. Dr."      | "Informatik" | VSYS & DPATTERNS & X | P_DPATTERNS
//	WAESCH | "Wäsch" | "Jürgen" | "Prof. Dr.-Ing." | "Informatik" | _                    | P_VSYS
//  _      | "One"   | "Any"    | "Prof."          | "Ufologie"   | _                    | _
//  test2:
//  _      | "One"   | "Any"    | "Prof."          | "Ufologie"   | _                    | _
//}
//
//def lehrveranstaltung = lehrveranstaltungTable.parse {
//	REF       | name                | sws | ects
//  VSYS      | "Verteilte Systeme" | 4   | 5
//  DPATTERNS | "Design Patterns"   | 4   | 3
//}
//
//def pruefung = pruefungTable.parse {
//	REF         | typ   | zeitpunkt
//	P_VSYS      | "K90" | "2013-04-01 14:00:00"
//	P_DPATTERNS | "M30" | "2013-01-06 12:00:00"
//}
//
//def student = studentTable.parse {
//	REF        | matrikelnummer | name         | vorname    | studiengang | semester | immatrikuliert_seit | besucht   | istTutor | schreibt
//	MOLL       | 287336         | "Moll"       | "Nikolaus" | "MSI"       | 4        | "2011-09-01"        | VSYS      | VSYS     | P_VSYS
//	MUSTERMANN | 123456         | "Mustermann" | "Max"      | "BIT"       | 3        | "2012-03-01"        | DPATTERNS | _        | _
//}


def fixture = [
  "professor": {
    REF    | name    | vorname  | titel            | fakultaet    | leitet               | beaufsichtigt
    HAASE  | "Haase" | "Oliver" | "Prof. Dr."      | "Informatik" | VSYS & DPATTERNS & X | P_DPATTERNS
    WAESCH | "Wäsch" | "Jürgen" | "Prof. Dr.-Ing." | "Informatik" | _                    | P_VSYS
    _      | "One"   | "Any"    | "Prof."          | "Ufologie"   | _                    | _
  },
  
  "lehrveranstaltung": {
    REF       | name                | sws | ects
    VSYS      | "Verteilte Systeme" | 4   | 5
    DPATTERNS | "Design Patterns"   | 4   | 3
  },

	"pruefung": {
    REF         | typ   | zeitpunkt
    P_VSYS      | "K90" | "2013-04-01 14:00:00"
    P_DPATTERNS | "M30" | "2013-01-06 12:00:00"
  },

	"student": {
    REF        | matrikelnummer | name         | vorname    | studiengang | semester | immatrikuliert_seit | besucht   | istTutor | schreibt
    MOLL       | 287336         | "Moll"       | "Nikolaus" | "MSI"       | 4        | "2011-09-01"        | VSYS      | VSYS     | P_VSYS
    MUSTERMANN | 123456         | "Mustermann" | "Max"      | "BIT"       | 3        | "2012-03-01"        | DPATTERNS | _        | _
	}
]

println tableModel.parse(fixture)

//println professor
//println lehrveranstaltung
//println pruefung
//println student