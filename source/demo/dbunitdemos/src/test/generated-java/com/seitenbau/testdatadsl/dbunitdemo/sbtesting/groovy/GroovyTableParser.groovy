package com.seitenbau.testdatadsl.dbunitdemo.sbtesting.groovy;

import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.DBUnitExamplesDataSet
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

}
//-----------------------------------


class ProfessorId {

  // TODO NM replace with IdGenerator
  static java.lang.Long nextId = 1

  private java.lang.Long id
  
  def ProfessorId() {
  }
  
  def ProfessorId(java.lang.Long id) {
    this.id = id
  }

  java.lang.Long getId() {
    if (id == null) {
      id = nextId++
    }
    return id
  }

  void setId(java.lang.Long id) {
    if (isDefined() && this.id != id) {
      throw new IllegalStateException("Id already set " + id + " vs " + this.id + " [Table: professor]");
    }
    this.id = id
  }

  boolean isDefined() {
    return this.id != null
  }
  
  String toString() {
    return id
  }

}
class LehrveranstaltungId {

  // TODO NM replace with IdGenerator
  static java.lang.Long nextId = 1

  private java.lang.Long id
  
  def LehrveranstaltungId() {
  }
  
  def LehrveranstaltungId(java.lang.Long id) {
    this.id = id
  }

  java.lang.Long getId() {
    if (id == null) {
      id = nextId++
    }
    return id
  }

  void setId(java.lang.Long id) {
    if (isDefined() && this.id != id) {
      throw new IllegalStateException("Id already set " + id + " vs " + this.id + " [Table: lehrveranstaltung]");
    }
    this.id = id
  }

  boolean isDefined() {
    return this.id != null
  }
  
  String toString() {
    return id
  }

}
class PruefungId {

  // TODO NM replace with IdGenerator
  static java.lang.Long nextId = 1

  private java.lang.Long id
  
  def PruefungId() {
  }
  
  def PruefungId(java.lang.Long id) {
    this.id = id
  }

  java.lang.Long getId() {
    if (id == null) {
      id = nextId++
    }
    return id
  }

  void setId(java.lang.Long id) {
    if (isDefined() && this.id != id) {
      throw new IllegalStateException("Id already set " + id + " vs " + this.id + " [Table: pruefung]");
    }
    this.id = id
  }

  boolean isDefined() {
    return this.id != null
  }
  
  String toString() {
    return id
  }

}
class StudentId {

  private java.lang.Long id
  
  def StudentId(java.lang.Long id) {
    this.id = id
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
    this.id = id
  }

  boolean isDefined() {
    return this.id != null
  }
  
  String toString() {
    return id
  }

}

class AbstractTableParser {
  
  static context = new ThreadLocal<List>()
  
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
    use(AbstractTableParser) {
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

  def rows(Closure rows) {
    def tableData = parseTable(rows)
    def head = null
    int columns = 0
    
    tableData.each { row ->
      if (isHeadRow(row)) {
        head = row
        columns = row.values.size()
      } else {
        def resultRow = createRow()
        for (columnIndex in 0..(columns-1)) {
          def column = head.values[columnIndex]
          def method = column.name
          def value = row.values[columnIndex]
          resultRow."$method"(value)
        }
       
        this.rows.add(resultRow)
      }
    }
  }
}

@Mixin(AbstractTableParser)
class ProfessorTable {

  ColumnHeader REF = new ColumnHeader(name: "REF", type: ProfessorId.class)

  ColumnHeader id = new ColumnHeader(name: "id", type: java.lang.Long)

  ColumnHeader name = new ColumnHeader(name: "name", type: java.lang.String)

  ColumnHeader vorname = new ColumnHeader(name: "vorname", type: java.lang.String)

  ColumnHeader titel = new ColumnHeader(name: "titel", type: java.lang.String)

  ColumnHeader fakultaet = new ColumnHeader(name: "fakultaet", type: java.lang.String)

  
  @ToString
  class ProfessorTableRow {
    
    ProfessorId REF
    
    def REF(ProfessorId REF){
      this.REF = REF
    }
    
    def REF() {
      this.REF
    }
    
    java.lang.Long id
    
    def id(java.lang.Long id){
      this.id = id
    }
    
    def id() {
      this.id
    }

    java.lang.String name
    
    def name(java.lang.String name){
      this.name = name
    }
    
    def name() {
      this.name
    }

    java.lang.String vorname
    
    def vorname(java.lang.String vorname){
      this.vorname = vorname
    }
    
    def vorname() {
      this.vorname
    }

    java.lang.String titel
    
    def titel(java.lang.String titel){
      this.titel = titel
    }
    
    def titel() {
      this.titel
    }

    java.lang.String fakultaet
    
    def fakultaet(java.lang.String fakultaet){
      this.fakultaet = fakultaet
    }
    
    def fakultaet() {
      this.fakultaet
    }

  }
  
  List<ProfessorTableRow> rows = []
  
  def createRow() {
    new ProfessorTableRow()
  }
}

@Mixin(AbstractTableParser)
class LehrveranstaltungTable {

  ColumnHeader REF = new ColumnHeader(name: "REF", type: LehrveranstaltungId.class)

  ColumnHeader id = new ColumnHeader(name: "id", type: java.lang.Long)

  ColumnHeader professor_id = new ColumnHeader(name: "professor_id", type: ProfessorId)

  ColumnHeader professor = new ColumnHeader(name: "professor", type: ProfessorId)

  ColumnHeader name = new ColumnHeader(name: "name", type: java.lang.String)

  ColumnHeader sws = new ColumnHeader(name: "sws", type: java.lang.Integer)

  ColumnHeader ects = new ColumnHeader(name: "ects", type: java.lang.Double)

  
  @ToString
  class LehrveranstaltungTableRow {
    
    LehrveranstaltungId REF
    
    def REF(LehrveranstaltungId REF){
      this.REF = REF
    }
    
    def REF() {
      this.REF
    }
    
    java.lang.Long id
    
    def id(java.lang.Long id){
      this.id = id
    }
    
    def id() {
      this.id
    }

    ProfessorId professor_id
    
    def professor_id(ProfessorId professor_id){
      this.professor_id = professor_id
    }
    
    def professor_id() {
      this.professor_id
    }

    def professor(ProfessorId professor_id){
      this.professor_id = professor_id
    }
    
    def professor() {
      this.professor_id
    }

    java.lang.String name
    
    def name(java.lang.String name){
      this.name = name
    }
    
    def name() {
      this.name
    }

    java.lang.Integer sws
    
    def sws(java.lang.Integer sws){
      this.sws = sws
    }
    
    def sws() {
      this.sws
    }

    java.lang.Double ects
    
    def ects(java.lang.Double ects){
      this.ects = ects
    }
    
    def ects() {
      this.ects
    }

  }
  
  List<LehrveranstaltungTableRow> rows = []
  
  def createRow() {
    new LehrveranstaltungTableRow()
  }
}

@Mixin(AbstractTableParser)
class PruefungTable {

  ColumnHeader REF = new ColumnHeader(name: "REF", type: PruefungId.class)

  ColumnHeader id = new ColumnHeader(name: "id", type: java.lang.Long)

  ColumnHeader lehrveranstaltung_id = new ColumnHeader(name: "lehrveranstaltung_id", type: LehrveranstaltungId)

  ColumnHeader lehrveranstaltung = new ColumnHeader(name: "lehrveranstaltung", type: LehrveranstaltungId)

  ColumnHeader typ = new ColumnHeader(name: "typ", type: java.lang.String)

  ColumnHeader zeitpunkt = new ColumnHeader(name: "zeitpunkt", type: java.util.Date)

  
  @ToString
  class PruefungTableRow {
    
    PruefungId REF
    
    def REF(PruefungId REF){
      this.REF = REF
    }
    
    def REF() {
      this.REF
    }
    
    java.lang.Long id
    
    def id(java.lang.Long id){
      this.id = id
    }
    
    def id() {
      this.id
    }

    LehrveranstaltungId lehrveranstaltung_id
    
    def lehrveranstaltung_id(LehrveranstaltungId lehrveranstaltung_id){
      this.lehrveranstaltung_id = lehrveranstaltung_id
    }
    
    def lehrveranstaltung_id() {
      this.lehrveranstaltung_id
    }

    def lehrveranstaltung(LehrveranstaltungId lehrveranstaltung_id){
      this.lehrveranstaltung_id = lehrveranstaltung_id
    }
    
    def lehrveranstaltung() {
      this.lehrveranstaltung_id
    }

    java.lang.String typ
    
    def typ(java.lang.String typ){
      this.typ = typ
    }
    
    def typ() {
      this.typ
    }

    java.util.Date zeitpunkt
    
    def zeitpunkt(java.util.Date zeitpunkt){
      this.zeitpunkt = zeitpunkt
    }
    
    def zeitpunkt() {
      this.zeitpunkt
    }

  }
  
  List<PruefungTableRow> rows = []
  
  def createRow() {
    new PruefungTableRow()
  }
}

@Mixin(AbstractTableParser)
class StudentTable {

  ColumnHeader REF = new ColumnHeader(name: "REF", type: StudentId.class)

  ColumnHeader matrikelnummer = new ColumnHeader(name: "matrikelnummer", type: java.lang.Long)

  ColumnHeader name = new ColumnHeader(name: "name", type: java.lang.String)

  ColumnHeader vorname = new ColumnHeader(name: "vorname", type: java.lang.String)

  ColumnHeader studiengang = new ColumnHeader(name: "studiengang", type: java.lang.String)

  ColumnHeader semester = new ColumnHeader(name: "semester", type: java.lang.Integer)

  ColumnHeader immatrikuliert_seit = new ColumnHeader(name: "immatrikuliert_seit", type: java.util.Date)

  
  @ToString
  class StudentTableRow {
    
    StudentId REF
    
    def REF(StudentId REF){
      this.REF = REF
    }
    
    def REF() {
      this.REF
    }
    
    java.lang.Long matrikelnummer
    
    def matrikelnummer(java.lang.Long matrikelnummer){
      this.matrikelnummer = matrikelnummer
    }
    
    def matrikelnummer() {
      this.matrikelnummer
    }

    java.lang.String name
    
    def name(java.lang.String name){
      this.name = name
    }
    
    def name() {
      this.name
    }

    java.lang.String vorname
    
    def vorname(java.lang.String vorname){
      this.vorname = vorname
    }
    
    def vorname() {
      this.vorname
    }

    java.lang.String studiengang
    
    def studiengang(java.lang.String studiengang){
      this.studiengang = studiengang
    }
    
    def studiengang() {
      this.studiengang
    }

    java.lang.Integer semester
    
    def semester(java.lang.Integer semester){
      this.semester = semester
    }
    
    def semester() {
      this.semester
    }

    java.util.Date immatrikuliert_seit
    
    def immatrikuliert_seit(java.util.Date immatrikuliert_seit){
      this.immatrikuliert_seit = immatrikuliert_seit
    }
    
    def immatrikuliert_seit() {
      this.immatrikuliert_seit
    }

  }
  
  List<StudentTableRow> rows = []
  
  def createRow() {
    new StudentTableRow()
  }
}

@Mixin(AbstractTableParser)
class BeaufsichtigtTable {

  ColumnHeader professor_id = new ColumnHeader(name: "professor_id", type: ProfessorId)

  ColumnHeader professor = new ColumnHeader(name: "professor", type: ProfessorId)

  ColumnHeader pruefung_id = new ColumnHeader(name: "pruefung_id", type: PruefungId)

  ColumnHeader pruefung = new ColumnHeader(name: "pruefung", type: PruefungId)

  
  @ToString
  class BeaufsichtigtTableRow {
    
    ProfessorId professor_id
    
    def professor_id(ProfessorId professor_id){
      this.professor_id = professor_id
    }
    
    def professor_id() {
      this.professor_id
    }

    def professor(ProfessorId professor_id){
      this.professor_id = professor_id
    }
    
    def professor() {
      this.professor_id
    }

    PruefungId pruefung_id
    
    def pruefung_id(PruefungId pruefung_id){
      this.pruefung_id = pruefung_id
    }
    
    def pruefung_id() {
      this.pruefung_id
    }

    def pruefung(PruefungId pruefung_id){
      this.pruefung_id = pruefung_id
    }
    
    def pruefung() {
      this.pruefung_id
    }

  }
  
  List<BeaufsichtigtTableRow> rows = []
  
  def createRow() {
    new BeaufsichtigtTableRow()
  }
}

@Mixin(AbstractTableParser)
class BesuchtTable {

  ColumnHeader student_id = new ColumnHeader(name: "student_id", type: StudentId)

  ColumnHeader student = new ColumnHeader(name: "student", type: StudentId)

  ColumnHeader lehrveranstaltung_id = new ColumnHeader(name: "lehrveranstaltung_id", type: LehrveranstaltungId)

  ColumnHeader lehrveranstaltung = new ColumnHeader(name: "lehrveranstaltung", type: LehrveranstaltungId)

  
  @ToString
  class BesuchtTableRow {
    
    StudentId student_id
    
    def student_id(StudentId student_id){
      this.student_id = student_id
    }
    
    def student_id() {
      this.student_id
    }

    def student(StudentId student_id){
      this.student_id = student_id
    }
    
    def student() {
      this.student_id
    }

    LehrveranstaltungId lehrveranstaltung_id
    
    def lehrveranstaltung_id(LehrveranstaltungId lehrveranstaltung_id){
      this.lehrveranstaltung_id = lehrveranstaltung_id
    }
    
    def lehrveranstaltung_id() {
      this.lehrveranstaltung_id
    }

    def lehrveranstaltung(LehrveranstaltungId lehrveranstaltung_id){
      this.lehrveranstaltung_id = lehrveranstaltung_id
    }
    
    def lehrveranstaltung() {
      this.lehrveranstaltung_id
    }

  }
  
  List<BesuchtTableRow> rows = []
  
  def createRow() {
    new BesuchtTableRow()
  }
}

@Mixin(AbstractTableParser)
class IsttutorTable {

  ColumnHeader student_id = new ColumnHeader(name: "student_id", type: StudentId)

  ColumnHeader student = new ColumnHeader(name: "student", type: StudentId)

  ColumnHeader lehrveranstaltung_id = new ColumnHeader(name: "lehrveranstaltung_id", type: LehrveranstaltungId)

  ColumnHeader lehrveranstaltung = new ColumnHeader(name: "lehrveranstaltung", type: LehrveranstaltungId)

  
  @ToString
  class IsttutorTableRow {
    
    StudentId student_id
    
    def student_id(StudentId student_id){
      this.student_id = student_id
    }
    
    def student_id() {
      this.student_id
    }

    def student(StudentId student_id){
      this.student_id = student_id
    }
    
    def student() {
      this.student_id
    }

    LehrveranstaltungId lehrveranstaltung_id
    
    def lehrveranstaltung_id(LehrveranstaltungId lehrveranstaltung_id){
      this.lehrveranstaltung_id = lehrveranstaltung_id
    }
    
    def lehrveranstaltung_id() {
      this.lehrveranstaltung_id
    }

    def lehrveranstaltung(LehrveranstaltungId lehrveranstaltung_id){
      this.lehrveranstaltung_id = lehrveranstaltung_id
    }
    
    def lehrveranstaltung() {
      this.lehrveranstaltung_id
    }

  }
  
  List<IsttutorTableRow> rows = []
  
  def createRow() {
    new IsttutorTableRow()
  }
}

@Mixin(AbstractTableParser)
class SchreibtTable {

  ColumnHeader student_id = new ColumnHeader(name: "student_id", type: StudentId)

  ColumnHeader student = new ColumnHeader(name: "student", type: StudentId)

  ColumnHeader pruefung_id = new ColumnHeader(name: "pruefung_id", type: PruefungId)

  ColumnHeader pruefung = new ColumnHeader(name: "pruefung", type: PruefungId)

  
  @ToString
  class SchreibtTableRow {
    
    StudentId student_id
    
    def student_id(StudentId student_id){
      this.student_id = student_id
    }
    
    def student_id() {
      this.student_id
    }

    def student(StudentId student_id){
      this.student_id = student_id
    }
    
    def student() {
      this.student_id
    }

    PruefungId pruefung_id
    
    def pruefung_id(PruefungId pruefung_id){
      this.pruefung_id = pruefung_id
    }
    
    def pruefung_id() {
      this.pruefung_id
    }

    def pruefung(PruefungId pruefung_id){
      this.pruefung_id = pruefung_id
    }
    
    def pruefung() {
      this.pruefung_id
    }

  }
  
  List<SchreibtTableRow> rows = []
  
  def createRow() {
    new SchreibtTableRow()
  }
}


class DBUnitExamplesTable {

  ProfessorTable professorTable = new ProfessorTable()
  
  LehrveranstaltungTable lehrveranstaltungTable = new LehrveranstaltungTable()
  
  PruefungTable pruefungTable = new PruefungTable()
  
  StudentTable studentTable = new StudentTable()
  
  BeaufsichtigtTable beaufsichtigtTable = new BeaufsichtigtTable()
  
  BesuchtTable besuchtTable = new BesuchtTable()
  
  IsttutorTable isttutorTable = new IsttutorTable()
  
  SchreibtTable schreibtTable = new SchreibtTable()
  
  
  def tables(Closure table) {
    table.delegate = this
    table.resolveStrategy = Closure.DELEGATE_FIRST
    table()
  }
  
  def createDataSet() {
    DBUnitExamplesDataSet dataset = new DBUnitExamplesDataSet() {
      void initDataSet() { 
        addProfessorTable()
        addLehrveranstaltungTable()
        addPruefungTable()
        addStudentTable()
        addBeaufsichtigtTable()
        addBesuchtTable()
        addIsttutorTable()
        addSchreibtTable()
      }
      
      void addProfessorTable() {
        professorTable.rows.each { tableRow ->
          def row = table_Professor.insertRow()
          // if primary key column has a value set REF to that value else use REFs value
          if (tableRow.id != null) {
            row.setId(tableRow.id)
            tableRow.REF.id = tableRow.id
          } else {
            if (tableRow.REF != null) {
              row.setId(tableRow.REF.id)
              tableRow.id = tableRow.REF.id
            }
          }
          if (tableRow.name) row.setName(tableRow.name)
          if (tableRow.vorname) row.setVorname(tableRow.vorname)
          if (tableRow.titel) row.setTitel(tableRow.titel)
          if (tableRow.fakultaet) row.setFakultaet(tableRow.fakultaet)
        }
      }

      void addLehrveranstaltungTable() {
        lehrveranstaltungTable.rows.each { tableRow ->
          def row = table_Lehrveranstaltung.insertRow()
          // if primary key column has a value set REF to that value else use REFs value
          if (tableRow.id != null) {
            row.setId(tableRow.id)
            tableRow.REF.id = tableRow.id
          } else {
            if (tableRow.REF != null) {
              row.setId(tableRow.REF.id)
              tableRow.id = tableRow.REF.id
            }
          }
          if (tableRow.professor_id) row.setProfessorId(tableRow.professor_id.id)
          if (tableRow.name) row.setName(tableRow.name)
          if (tableRow.sws) row.setSws(tableRow.sws)
          if (tableRow.ects) row.setEcts(tableRow.ects)
        }
      }

      void addPruefungTable() {
        pruefungTable.rows.each { tableRow ->
          def row = table_Pruefung.insertRow()
          // if primary key column has a value set REF to that value else use REFs value
          if (tableRow.id != null) {
            row.setId(tableRow.id)
            tableRow.REF.id = tableRow.id
          } else {
            if (tableRow.REF != null) {
              row.setId(tableRow.REF.id)
              tableRow.id = tableRow.REF.id
            }
          }
          if (tableRow.lehrveranstaltung_id) row.setLehrveranstaltungId(tableRow.lehrveranstaltung_id.id)
          if (tableRow.typ) row.setTyp(tableRow.typ)
          if (tableRow.zeitpunkt) row.setZeitpunkt(tableRow.zeitpunkt)
        }
      }

      void addStudentTable() {
        studentTable.rows.each { tableRow ->
          def row = table_Student.insertRow()
          // if primary key column has a value set REF to that value else use REFs value
          if (tableRow.matrikelnummer != null) {
            row.setMatrikelnummer(tableRow.matrikelnummer)
            tableRow.REF.id = tableRow.matrikelnummer
          } else {
            if (tableRow.REF != null) {
              row.setMatrikelnummer(tableRow.REF.id)
              tableRow.matrikelnummer = tableRow.REF.id
            }
          }
          if (tableRow.name) row.setName(tableRow.name)
          if (tableRow.vorname) row.setVorname(tableRow.vorname)
          if (tableRow.studiengang) row.setStudiengang(tableRow.studiengang)
          if (tableRow.semester) row.setSemester(tableRow.semester)
          if (tableRow.immatrikuliert_seit) row.setImmatrikuliertSeit(tableRow.immatrikuliert_seit)
        }
      }

      void addBeaufsichtigtTable() {
        beaufsichtigtTable.rows.each { tableRow ->
          def row = table_Beaufsichtigt.insertRow()
          if (tableRow.professor_id) row.setProfessorId(tableRow.professor_id.id)
          if (tableRow.pruefung_id) row.setPruefungId(tableRow.pruefung_id.id)
        }
      }

      void addBesuchtTable() {
        besuchtTable.rows.each { tableRow ->
          def row = table_Besucht.insertRow()
          if (tableRow.student_id) row.setStudentId(tableRow.student_id.id)
          if (tableRow.lehrveranstaltung_id) row.setLehrveranstaltungId(tableRow.lehrveranstaltung_id.id)
        }
      }

      void addIsttutorTable() {
        isttutorTable.rows.each { tableRow ->
          def row = table_Isttutor.insertRow()
          if (tableRow.student_id) row.setStudentId(tableRow.student_id.id)
          if (tableRow.lehrveranstaltung_id) row.setLehrveranstaltungId(tableRow.lehrveranstaltung_id.id)
        }
      }

      void addSchreibtTable() {
        schreibtTable.rows.each { tableRow ->
          def row = table_Schreibt.insertRow()
          if (tableRow.student_id) row.setStudentId(tableRow.student_id.id)
          if (tableRow.pruefung_id) row.setPruefungId(tableRow.pruefung_id.id)
        }
      }

    }
    dataset.createDBUnitDataSet()
  }
}