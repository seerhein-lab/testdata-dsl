package com.seitenbau.testdatadsl.dbunitdemo.groovy

import groovy.transform.ToString

//def table = TableParser.parse {
//	a    |  b
//	"A"  |  "B"
//	1    |  2
//	true | false
//}
//println table


def fixture = [
  "professor": {
    REF    | name    | vorname  | titel            | fakultaet    | leitet               | beaufsichtigt
    HAASE  | "Haase" | "Oliver" | "Prof. Dr."      | "Informatik" | VSYS & DPATTERNS     | P_DPATTERNS
    WAESCH | "Wäsch" | "Jürgen" | "Prof. Dr.-Ing." | "Informatik" | _                    | P_VSYS
  },
  
  "lehrveranstaltung": {
    REF       | name                | sws | ects
    VSYS      | "Verteilte Systeme" | 4   | 5
    DPATTERNS | "Design Patterns"   | 4   | 3
  },

	"pruefung": {
    REF         | lehrveranstaltung | typ   | zeitpunkt
    P_VSYS      | VSYS              | "K90" | "2013-04-01 14:00:00"
    P_DPATTERNS | DPATTERNS         | "M30" | "2013-01-06 12:00:00"
  },

  "student": {
    matrikelnummer | name         | vorname    | studiengang | semester | immatrikuliert_seit | besucht   | istTutor | schreibt
    287336         | "Moll"       | "Nikolaus" | "MSI"       | 4        | "2011-09-01"        | VSYS      | VSYS     | P_VSYS
    123456         | "Mustermann" | "Max"      | "BIT"       | 3        | "2012-03-01"        | DPATTERNS | _        | _
  }
]

HochschuleTableModel model = new HochschuleTableModel()
model.apply(fixture)
println model.createDBUnitDataSet()

