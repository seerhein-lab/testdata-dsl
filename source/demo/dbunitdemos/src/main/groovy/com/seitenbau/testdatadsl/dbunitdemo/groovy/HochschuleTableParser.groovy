package com.seitenbau.testdatadsl.dbunitdemo.groovy

//import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.DBUnitExamplesDataSet;
//import com.seitenbau.testing.dbunit.generator.DataSet;
//
//import groovy.transform.*
//
//class ColumnHeader {
//  
//  String name
//
//  Class type
//
//}
//
//class ProfessorId {
//  
//  static int nextId = 1
//      
//  def id = nextId++
//      
//}
//
//class LehrveranstaltungId {
//  
//  static int nextId = 1
//  
//  def id = nextId++
//  
//}
//
//class PruefungId {
//  
//  static int nextId = 1
//  
//  def id = nextId++
//  
//}
//
//class StudentId {
//  
//  static int nextId = 1
//  
//  def id = nextId++ 
//  
//}
//
//class AbstractTableParser {
//  
//  static context = new ThreadLocal<List>()
//  
//  static or(self, arg) {
//    appendRow(self, arg)
//  }
//
//  static or(Integer self, Integer arg) {
//    appendRow(self, arg)
//  }
//
//  static or(Boolean self, Boolean arg) {
//    appendRow(self, arg)
//  }
//
//  static appendRow(value, nextValue) {
//    def row = new Row(values: [value])
//    context.get().add(row)
//    row.or(nextValue)
//  }
//  
//  def parseTable(Closure rows) {
//    context.set([])
//    use(AbstractTableParser) {
//      rows.delegate = this
//      rows.resolveStrategy = Closure.DELEGATE_FIRST
//      rows()
//    }
//    context.get()
//  }
//  
//  boolean isHeadRow(Row row) {
//    null == row.values.find { value ->
//      !(value instanceof ColumnHeader)
//    }
//  }
//
//  def rows(Closure rows) {
//    def tableData = parseTable(rows)
//    def head = null
//    int columns = 0
//    
//    tableData.each { row ->
//      if (isHeadRow(row)) {
//        head = row
//        columns = row.values.size()
//      } else {
//        def resultRow = createRow()
//        for (columnIndex in 0..(columns-1)) {
//          def column = head.values[columnIndex]
//          def method = column.name
//          def value = row.values[columnIndex]
//          resultRow."$method"(value)
//        }
//       
//        this.rows.add(resultRow)
//      }
//    }
//  }
//}
//
//@Mixin(AbstractTableParser)
//class ProfessorTable {
//
//  ColumnHeader REF = new ColumnHeader(name: "REF", type: ProfessorId.class)
//
//  ColumnHeader name = new ColumnHeader(name: "name", type: String.class)
//
//  ColumnHeader vorname = new ColumnHeader(name: "vorname", type: String.class)
//
//  ColumnHeader titel = new ColumnHeader(name: "titel", type: String.class)
//
//  ColumnHeader fakultaet = new ColumnHeader(name: "fakultaet", type: String.class)
//
//  @ToString
//  class ProfessorTableRow {
//    
//    ProfessorId REF
//    
//    def REF(ProfessorId REF){
//      this.REF = REF
//    }
//    
//    def REF() {
//      this.REF
//    }
//
//    String name
//    
//    def name(String name){
//      this.name = name
//    }
//    
//    def name() {
//      this.name
//    }
//
//    String vorname
//    
//    def vorname(String vorname){
//      this.vorname = vorname
//    }
//    
//    def vorname() {
//      this.vorname
//    }
//
//    String titel
//    
//    def titel(String titel){
//      this.titel = titel
//    }
//    
//    def titel() {
//      this.titel
//    }
//
//    String fakultaet
//    
//    def fakultaet(String fakultaet){
//      this.fakultaet = fakultaet
//    }
//    
//    def fakultaet() {
//      this.fakultaet
//    }
//
//  }
//  
//  List<ProfessorTableRow> rows = []
//  
//  def createRow() {
//    new ProfessorTableRow()
//  }
//}
//
//@Mixin(AbstractTableParser)
//class LehrveranstaltungTable {
//
//  ColumnHeader REF = new ColumnHeader(name: "REF", type: LehrveranstaltungId.class)
//
//  ColumnHeader name = new ColumnHeader(name: "name", type: String.class)
//
//  ColumnHeader ects = new ColumnHeader(name: "ects", type: Double.class)
//
//  ColumnHeader sws = new ColumnHeader(name: "sws", type: Integer.class)
//
//  ColumnHeader professor = new ColumnHeader(name: "professor", type: ProfessorId.class)
//  
//  @ToString
//  class LehrveranstaltungTableRow {
//    
//    LehrveranstaltungId REF
//    
//    def REF(LehrveranstaltungId REF){
//      this.REF = REF
//    }
//    
//    def REF() {
//      this.REF
//    }
//
//    String name
//    
//    def name(String name){
//      this.name = name
//    }
//    
//    def name() {
//      this.name
//    }
//
//    Double ects
//
//    def ects(Double ects){
//      this.ects = ects
//    }
//    
//    def ects() {
//      this.ects
//    }
//
//    Integer sws
//
//    def sws(Integer sws){
//      this.sws = sws
//    }
//    
//    def sws() {
//      this.sws
//    }
//
//    ProfessorId professor
//
//    def professor(ProfessorId professor){
//      this.professor = professor
//    }
//    
//    def professor() {
//      this.professor
//    }
//  }
//  
//  List<LehrveranstaltungTableRow> rows = []
//
//  def createRow() {
//    new LehrveranstaltungTableRow()
//  }
//
//}
//
//@Mixin(AbstractTableParser)
//class PruefungTable {
//
//  ColumnHeader REF = new ColumnHeader(name: "REF", type: PruefungId.class)
//  
//  ColumnHeader lehrveranstaltung = new ColumnHeader(name: "lehrveranstaltung", type: LehrveranstaltungId.class)
//
//  ColumnHeader typ = new ColumnHeader(name: "typ", type: String.class)
//
//  ColumnHeader zeitpunkt = new ColumnHeader(name: "zeitpunkt", type: Date.class)
//  
//  @ToString
//  class PruefungTableRow {
//    
//    PruefungId REF
//    
//    def REF(PruefungId REF){
//      this.REF = REF
//    }
//    
//    def REF() {
//      this.REF
//    }
//    
//    LehrveranstaltungId lehrveranstaltung
//
//    def lehrveranstaltung(LehrveranstaltungId lehrveranstaltung){
//      this.lehrveranstaltung = lehrveranstaltung
//    }
//    
//    def lehrveranstaltung() {
//      this.lehrveranstaltung
//    }
//
//    String typ
//    
//    def typ(String typ){
//      this.typ = typ
//    }
//    
//    def typ() {
//      this.typ
//    }
//
//    String zeitpunkt
//
//    def zeitpunkt(String zeitpunkt){
//      this.zeitpunkt = zeitpunkt
//    }
//    
//    def zeitpunkt() {
//      this.zeitpunkt
//    }
//
//  }
//  
//  List<PruefungTableRow> rows = []
//    
//  def createRow() {
//    new PruefungTableRow()
//  }
//}
//
//@Mixin(AbstractTableParser)
//class StudentTable {
//  
//  ColumnHeader REF = new ColumnHeader(name: "REF", type: StudentId.class)
//
//  ColumnHeader matrikelnummer = new ColumnHeader(name: "matrikelnummer", type: Integer.class)
//
//  ColumnHeader name = new ColumnHeader(name: "name", type: String.class)
//
//  ColumnHeader vorname = new ColumnHeader(name: "vorname", type: String.class)
//
//  ColumnHeader studiengang = new ColumnHeader(name: "studiengang", type: String.class)
//  
//  ColumnHeader semester = new ColumnHeader(name: "semester", type: Integer.class)
//
//  ColumnHeader immatrikuliertSeit = new ColumnHeader(name: "immatrikuliertSeit", type: Date.class)
//
//  @ToString
//  class StudentTableRow {
//    
//    StudentId REF
//    
//    def REF(StudentId REF){
//      this.REF = REF
//    }
//    
//    def REF() {
//      this.REF
//    }
//    
//    String name
//
//    def name(String name){
//      this.name = name
//    }
//    
//    def name() {
//      this.name
//    }
//
//    Integer matrikelnummer
//    
//    def matrikelnummer(Integer matrikelnummer){
//      this.matrikelnummer = matrikelnummer
//    }
//    
//    def matrikelnummer() {
//      this.matrikelnummer
//    }
//
//    String vorname
//    
//    def vorname(String vorname){
//      this.vorname = vorname
//    }
//    
//    def vorname() {
//      this.vorname
//    }
//
//    String studiengang
//
//    def studiengang(String studiengang){
//      this.studiengang = studiengang
//    }
//    
//    def studiengang() {
//      this.studiengang
//    }
//
//    Integer semester
//    
//    def semester(Integer semester){
//      this.semester = semester
//    }
//    
//    def semester() {
//      this.semester
//    }
//
//    String immatrikuliertSeit
//       
//    def immatrikuliertSeit(String immatrikuliertSeit){
//      this.immatrikuliertSeit = immatrikuliertSeit
//    }
//    
//    def immatrikuliertSeit() {
//      this.immatrikuliertSeit
//    }
//
//  }
//  
//  List<StudentTableRow> rows = []
//  
//  def createRow() {
//    new StudentTableRow()
//  }
//
//}
//
//
//@Mixin(AbstractTableParser)
//class BeaufsichtigtTable {
//  
//  ColumnHeader professor = new ColumnHeader(name: "professor", type: ProfessorId.class)
//
//  ColumnHeader pruefung = new ColumnHeader(name: "pruefung", type: PruefungId.class)
//
//  @ToString
//  class BeaufsichtigtTableRow {
//    
//    ProfessorId professor
//
//    def professor(ProfessorId professor){
//      this.professor = professor
//    }
//    
//    def professor() {
//      this.professor
//    }
//
//    PruefungId pruefung
//
//    def pruefung(PruefungId pruefung){
//      this.pruefung = pruefung
//    }
//    
//    def pruefung() {
//      this.pruefung
//    }
//
//  }
//  
//  List<BeaufsichtigtTableRow> rows = []
//
//  def createRow() {
//    new BeaufsichtigtTableRow()
//  }
//}
//  
//@Mixin(AbstractTableParser)
//class BesuchtTable {
//    
//  ColumnHeader student = new ColumnHeader(name: "student", type: StudentId.class)
//
//  ColumnHeader lehrveranstaltung = new ColumnHeader(name: "lehrveranstaltung", type: LehrveranstaltungId.class)
//
//  @ToString
//  class BesuchtTableRow {
//    
//    StudentId student
//
//    def student(StudentId student){
//      this.student = student
//    }
//    
//    def student() {
//      this.student
//    }
//
//    LehrveranstaltungId lehrveranstaltung
//
//    def lehrveranstaltung(LehrveranstaltungId lehrveranstaltung){
//      this.lehrveranstaltung = lehrveranstaltung
//    }
//    
//    def lehrveranstaltung() {
//      this.lehrveranstaltung
//    }
//  
//  }
//  
//  List<BesuchtTableRow> rows = []
//  
//  def createRow() {
//    new BesuchtTableRow()
//  }
//
//}
//
//@Mixin(AbstractTableParser)
//class IstTutorTable {
//    
//  ColumnHeader student = new ColumnHeader(name: "student", type: StudentId.class)
//
//  ColumnHeader lehrveranstaltung = new ColumnHeader(name: "lehrveranstaltung", type: LehrveranstaltungId.class)
//  
//  @ToString
//  class IstTutorTableRow {
//    
//    StudentId student
//
//    def student(StudentId student){
//      this.student = student
//    }
//    
//    def student() {
//      this.student
//    }
//
//    LehrveranstaltungId lehrveranstaltung
//
//    def lehrveranstaltung(LehrveranstaltungId lehrveranstaltung){
//      this.lehrveranstaltung = lehrveranstaltung
//    }
//    
//    def lehrveranstaltung() {
//      this.lehrveranstaltung
//    }
//
//  }
//  
//  List<IstTutorTableRow> rows = []
//  
//  def createRow() {
//    new IstTutorTableRow()
//  }
//
//}
//
//@Mixin(AbstractTableParser)
//class SchreibtTable {
//  
//  ColumnHeader student = new ColumnHeader(name: "student", type: StudentId.class)
//
//  ColumnHeader pruefung = new ColumnHeader(name: "pruefung", type: PruefungId.class)
//
//  @ToString
//  class SchreibtTableRow {
//    
//    StudentId student
//
//    def student(StudentId student){
//      this.student = student
//    }
//    
//    def student() {
//      this.student
//    }
//
//    PruefungId pruefung
//
//    def pruefung(PruefungId pruefung){
//      this.pruefung = pruefung
//    }
//    
//    def pruefung() {
//      this.pruefung
//    }
//
//  }
//
//  List<SchreibtTableRow> rows = []
//
//  def createRow() {
//    new SchreibtTableRow()
//  }
//
//}
//
//
//class HochschuleTable {
//
//  ProfessorTable professorTable = new ProfessorTable()
//
//  LehrveranstaltungTable lehrveranstaltungTable = new LehrveranstaltungTable()
//
//  PruefungTable pruefungTable = new PruefungTable()
//  
//  StudentTable studentTable = new StudentTable()
//  
//  BeaufsichtigtTable beaufsichtigtTable = new BeaufsichtigtTable()
//
//  BesuchtTable besuchtTable = new BesuchtTable()
//
//  IstTutorTable istTutorTable = new IstTutorTable()
//
//  SchreibtTable schreibtTable = new SchreibtTable()
//  
//  def tables(Closure table) {
//    table.delegate = this
//    table.resolveStrategy = Closure.DELEGATE_FIRST
//    table()
//  }
//  
//  def createDataSet() {
//    DBUnitExamplesDataSet dataset = new DBUnitExamplesDataSet() {
//      void initDataSet() { 
//        addProfessorTable()
//        addLehrveranstaltungTable()
//        addPruefungTable()
//        addStudentTable()
//        addBeaufsichtigtTable()
//        addSchreibtTable()
//        addBesuchtTable()
//        addistTutorTable()
//      }
//      
//      void addProfessorTable() {
//        professorTable.rows.each { tableRow ->
//          def row = table_Professor.insertRow()
//          if (tableRow.REF) row.setId(tableRow.REF.id)
//          if (tableRow.name) row.setName(tableRow.name)
//          if (tableRow.vorname) row.setVorname(tableRow.vorname)
//          if (tableRow.fakultaet) row.setFakultaet(tableRow.fakultaet)
//          if (tableRow.titel) row.setTitel(tableRow.titel)
//        }
//      }
//
//      void addLehrveranstaltungTable() {
//        lehrveranstaltungTable.rows.each { tableRow ->
//          def row = table_Lehrveranstaltung.insertRow()
//          if (tableRow.REF) row.setId(tableRow.REF.id)
//          if (tableRow.name) row.setName(tableRow.name)
//          if (tableRow.professor) row.setProfessorId(tableRow.professor.id)
//          if (tableRow.ects) row.setEcts(tableRow.ects)
//          if (tableRow.sws) row.setSws(tableRow.sws)
//        }
//      }
//
//      void addPruefungTable() {
//        pruefungTable.rows.each { tableRow ->
//          def row = table_Pruefung.insertRow()
//          if (tableRow.REF) row.setId(tableRow.REF.id)
//          if (tableRow.lehrveranstaltung) row.setLehrveranstaltungId(tableRow.lehrveranstaltung.id)
//          if (tableRow.typ) row.setTyp(tableRow.typ)
//          if (tableRow.zeitpunkt) row.setZeitpunkt(tableRow.zeitpunkt)
//        }
//      }
//
//      void addStudentTable() {
//        studentTable.rows.each { tableRow ->
//          def row = table_Student.insertRow()
//          if (tableRow.REF) row.setMatrikelnummer(tableRow.REF.id)
//          if (tableRow.name) row.setName(tableRow.name)
//          if (tableRow.vorname) row.setVorname(tableRow.vorname)
//          if (tableRow.studiengang) row.setStudiengang(tableRow.studiengang)
//          if (tableRow.semester) row.setSemester(tableRow.semester)
//          if (tableRow.immatrikuliertSeit) row.setImmatrikuliertSeit(tableRow.immatrikuliertSeit)
//        }
//      }
//      
//      void addBeaufsichtigtTable() {
//        beaufsichtigtTable.rows.each { tableRow ->
//          def row = table_Beaufsichtigt.insertRow()
//          if (tableRow.professor && tableRow.pruefung) {
//            row.setProfessorId(tableRow.professor.id)
//            row.setPruefungId(tableRow.pruefung.id)
//          }
//        }
//      }
//
//      void addSchreibtTable() {
//        schreibtTable.rows.each { tableRow ->
//          def row = table_Schreibt.insertRow()
//          if (tableRow.student && tableRow.pruefung) {
//            row.setStudentId(tableRow.student.id)
//            row.setPruefungId(tableRow.pruefung.id)
//          }
//        }
//      }
//      
//      void addBesuchtTable() {
//        besuchtTable.rows.each { tableRow ->
//          def row = table_Besucht.insertRow()
//          if (tableRow.student && tableRow.lehrveranstaltung) {
//            row.setStudentId(tableRow.student.id)
//            row.setLehrveranstaltungId(tableRow.lehrveranstaltung.id)
//          }
//        }
//      }
//      
//      void addistTutorTable() {
//        istTutorTable.rows.each { tableRow ->
//          def row = table_Isttutor.insertRow()
//          if (tableRow.student && tableRow.lehrveranstaltung) {
//            row.setStudentId(tableRow.student.id)
//            row.setLehrveranstaltungId(tableRow.lehrveranstaltung.id)
//          }
//        }
//      }
//    }
//    dataset.createDBUnitDataSet()
//  }
//}