package com.seitenbau.testdatadsl.dbunitdemo.groovy

import static com.seitenbau.testdatadsl.dbunitdemo.groovy.DemoRefs.*

import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.groovy.DBUnitExamplesTable
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.groovy.LehrveranstaltungId
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.groovy.ProfessorId
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.groovy.PruefungId
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.groovy.StudentId

class DemoRefs {

  static ProfessorId WAESCH = new ProfessorId()
  static ProfessorId HAASE = new ProfessorId()
  
  static LehrveranstaltungId VSYS = new LehrveranstaltungId()
  static LehrveranstaltungId DPATTERNS = new LehrveranstaltungId()

  static PruefungId P_VSYS = new PruefungId()
  static PruefungId P_DPATTERNS = new PruefungId()

  static StudentId MOLL = new StudentId(287336)
  static StudentId MUSTERMANN = new StudentId(123456)
}

DBUnitExamplesTable hochschule = new DBUnitExamplesTable()
hochschule.tables {

  professorTable.rows {
    REF    | id | name    | vorname  | titel            | fakultaet
    WAESCH | 3 | "Wäsch" | "Jürgen" | "Prof. Dr.-Ing." | "Informatik"
    HAASE  | 4 | "Haase" | "Oliver" | "Prof. Dr."      | "Informatik"
  }

  lehrveranstaltungTable.rows {
    REF       | name                | sws | ects | professor
    VSYS      | "Verteilte Systeme" | 4   | 5    | HAASE
    DPATTERNS | "Design Patterns"   | 4   | 3    | HAASE
  }

  pruefungTable.rows {
    REF         | lehrveranstaltung | typ   | zeitpunkt
    P_VSYS      | VSYS              | "K90" | DateUtil.getDate(2013, 4, 1, 14, 0, 0)
    P_DPATTERNS | DPATTERNS         | "M30" | DateUtil.getDate(2013, 1, 6, 12, 0, 0)
  }

  studentTable.rows {
    REF        | matrikelnummer | name         | vorname    | studiengang | semester | immatrikuliert_seit
    MOLL       | 287336         | "Moll"       | "Nikolaus" | "MSI"       | 4        | DateUtil.getDate(2011, 9, 1)
    MUSTERMANN | 123456         | "Mustermann" | "Max"      | "BIT"       | 3        | DateUtil.getDate(2012, 3, 1)
  }

  beaufsichtigtTable.rows {
    professor | pruefung
    WAESCH    | P_VSYS
    HAASE     | P_DPATTERNS
  }

  besuchtTable.rows {
    student    | lehrveranstaltung
    MOLL       | VSYS
    MUSTERMANN | DPATTERNS
  }

  isttutorTable.rows {
    student    | lehrveranstaltung
    MOLL       | VSYS
  }

  schreibtTable.rows {
    student    | pruefung
    MOLL       | P_VSYS
  }
}

println hochschule.createDataSet()
println hochschule.createDataSet()

println hochschule.professorTable.rows.toString().replaceAll("com.seitenbau.testdatadsl.dbunitdemo.sbtesting.groovy.", "")
println hochschule.lehrveranstaltungTable.rows.toString().replaceAll("com.seitenbau.testdatadsl.dbunitdemo.sbtesting.groovy.", "")
println hochschule.pruefungTable.rows.toString().replaceAll("com.seitenbau.testdatadsl.dbunitdemo.sbtesting.groovy.", "")
println hochschule.studentTable.rows.toString().replaceAll("com.seitenbau.testdatadsl.dbunitdemo.sbtesting.groovy.", "")
println hochschule.beaufsichtigtTable.rows.toString().replaceAll("com.seitenbau.testdatadsl.dbunitdemo.sbtesting.groovy.", "")
println hochschule.besuchtTable.rows.toString().replaceAll("com.seitenbau.testdatadsl.dbunitdemo.sbtesting.groovy.", "")
println hochschule.isttutorTable.rows.toString().replaceAll("com.seitenbau.testdatadsl.dbunitdemo.sbtesting.groovy.", "")
println hochschule.schreibtTable.rows.toString().replaceAll("com.seitenbau.testdatadsl.dbunitdemo.sbtesting.groovy.", "")





