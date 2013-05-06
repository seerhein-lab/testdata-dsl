package com.seitenbau.testdatadsl.dbunitdemo.groovy

import com.seitenbau.testdatadsl.dbunitdemo.dsl1.Lehrveranstaltung;
import com.seitenbau.testdatadsl.dbunitdemo.dsl1.Pruefung;

import groovy.transform.*

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



