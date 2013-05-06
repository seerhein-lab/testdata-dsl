package com.seitenbau.testdatadsl.dbunitdemo.groovy

import com.seitenbau.testdatadsl.dbunitdemo.dsl1.Lehrveranstaltung;
import com.seitenbau.testdatadsl.dbunitdemo.dsl1.Pruefung;

import groovy.transform.*

class ColumnHeader {
  String label

  Class type


}

class ProfessorTable {

  HochschuleTableParser parser
  
  def ProfessorTable(HochschuleTableParser parser) {
    this.parser = parser
  }

    ColumnHeader REF = new ColumnHeader(label: "REF", type: String.class)

  ColumnHeader name = new ColumnHeader(label: "name", type: String.class)

  ColumnHeader vorname = new ColumnHeader(label: "vorname", type: String.class)

  ColumnHeader titel = new ColumnHeader(label: "titel", type: String.class)

  ColumnHeader fakultaet = new ColumnHeader(label: "fakultaet", type: String.class)

  ColumnHeader leitet = new ColumnHeader(label: "leitet", type: Lehrveranstaltung.class)

  ColumnHeader beaufsichtigt = new ColumnHeader(label: "beaufsichtigt", type: Pruefung.class)

  def rows(Closure rows) {
    parser.parseTable("professor", rows)
  }
}

class LehrveranstaltungTable {
  
  HochschuleTableParser parser
  
  def LehrveranstaltungTable(HochschuleTableParser parser) {
    this.parser = parser
  }

  ColumnHeader REF = new ColumnHeader(label: "REF", type: String.class)

  ColumnHeader name = new ColumnHeader(label: "name", type: String.class)

  ColumnHeader ects = new ColumnHeader(label: "ects", type: Double.class)

  ColumnHeader sws = new ColumnHeader(label: "titel", type: Integer.class)

  def rows(Closure rows) {
    parser.parseTable("lehrveranstaltung", rows)
  }

}

class PruefungTable {
  
  HochschuleTableParser parser
  
  def PruefungTable(HochschuleTableParser parser) {
    this.parser = parser
  }

  ColumnHeader REF = new ColumnHeader(label: "REF", type: String.class)
  
  ColumnHeader lehrveranstaltung = new ColumnHeader(label: "lehrveranstaltung", type: Lehrveranstaltung.class)

  ColumnHeader typ = new ColumnHeader(label: "typ", type: String.class)

  ColumnHeader zeitpunkt = new ColumnHeader(label: "zeitpunkt", type: Date.class)

  def rows(Closure rows) {
    parser.parseTable("pruefung", rows)
  }
}

class StudentTable {
  
  HochschuleTableParser parser
  
  def StudentTable(HochschuleTableParser parser) {
    this.parser = parser
  }
  
  ColumnHeader matrikelnummer = new ColumnHeader(label: "matrikelnummer", type: Integer.class)

  ColumnHeader name = new ColumnHeader(label: "name", type: String.class)

  ColumnHeader vorname = new ColumnHeader(label: "vorname", type: String.class)

  ColumnHeader studiengang = new ColumnHeader(label: "studiengang", type: String.class)
  
  ColumnHeader semester = new ColumnHeader(label: "semester", type: Integer.class)

  ColumnHeader immatrikuliertSeit = new ColumnHeader(label: "immatrikuliertSeit", type: Date.class)

  ColumnHeader besucht = new ColumnHeader(label: "besucht", type: Lehrveranstaltung.class)

  ColumnHeader istTutor = new ColumnHeader(label: "besucht", type: Lehrveranstaltung.class)

  ColumnHeader schreibt = new ColumnHeader(label: "besucht", type: Pruefung.class)
  
  def rows(Closure rows) {
    parser.parseTable("student", rows)
  }

}

class HochschuleTableParser {

  ProfessorTable professorTable = new ProfessorTable(this)

  LehrveranstaltungTable lehrveranstaltungTable = new LehrveranstaltungTable(this)

  PruefungTable pruefungTable = new PruefungTable(this)
  
  StudentTable studentTable = new StudentTable(this)
  
  static context = new ThreadLocal<List>()
  
  def result = [:]

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
    context.get().add(row)
    row.or(nextValue)
  }

  def getProperty(String property) {
    //println "getProperty: $property"
    if (property == "professorTable") return professorTable;
    if (property == "lehrveranstaltungTable") return lehrveranstaltungTable;
    if (property == "pruefungTable") return pruefungTable
    if (property == "studentTable") return studentTable
    if (property == "context") return context;

    new Var(name: property)
  }

  def asListOfRows(Closure tableData) {
    result = [:]
    use(HochschuleTableParser) {
      tableData.delegate = this
      tableData.resolveStrategy = Closure.DELEGATE_FIRST

      tableData()
    }
    result
  }

  def parseTable(String table, Closure tableData) {
    context.set([])
    use(HochschuleTableParser) {
      tableData.delegate = this
      tableData.resolveStrategy = Closure.DELEGATE_FIRST

      tableData()
    }
    result[table] = context.get()
  }

}

HochschuleTableParser parser = new HochschuleTableParser()
def table = parser.asListOfRows {

  professorTable.rows {
    REF    | name    | vorname  | titel            | fakultaet    | leitet               | beaufsichtigt
    WAESCH | "Wäsch" | "Jürgen" | "Prof. Dr.-Ing." | "Informatik" | _                    | P_VSYS & P_DPATTERNS
    HAASE  | "Haase" | "Oliver" | "Prof. Dr."      | "Informatik" | VSYS & DPATTERNS     | P_DPATTERNS & P_VSYS
  }

  lehrveranstaltungTable.rows {
    REF       | name                | sws | ects
    VSYS      | "Verteilte Systeme" | 4   | 5
    DPATTERNS | "Design Patterns"   | 4   | 3
  }

  pruefungTable.rows {
    REF         | lehrveranstaltung | typ   | zeitpunkt
    P_VSYS      | VSYS              | "K90" | "2013-04-01 14:00:00"
    P_DPATTERNS | DPATTERNS         | "M30" | "2013-01-06 12:00:00"
  }

  studentTable.rows {
    matrikelnummer | name         | vorname    | studiengang | semester | immatrikuliertSeit | besucht   | istTutor | schreibt
    287336         | "Moll"       | "Nikolaus" | "MSI"       | 4        | "2011-09-01"       | VSYS      | VSYS     | P_VSYS
    123456         | "Mustermann" | "Max"      | "BIT"       | 3        | "2012-03-01"       | DPATTERNS | _        | _
  }
}

println table



