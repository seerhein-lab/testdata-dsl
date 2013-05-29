package com.seitenbau.testdatadsl.dbunit.examples

import static com.seitenbau.testdatadsl.dbunit.stu.HochschuleRefs.*

import com.seitenbau.stu.dbunit.hochschule.dsl.HochschuleDSL
import com.seitenbau.testdatadsl.dbunit.common.util.DateUtil;

ExpandoMetaClass.enableGlobally() 
HochschuleDSL hochschule = new HochschuleDSL()
hochschule.tables {
  
  professorTable.rows {
    REF    | name    | vorname  | titel            | fakultaet
    WAESCH | "Wäsch" | "Jürgen" | "Prof. Dr.-Ing." | "Informatik"
    HAASE  | "Haase" | "Oliver" | "Prof. Dr."      | "Informatik"

    REF    | id | name    
    WAESCH | 5  | "Test" 

    id | name    
    5  | "Test 2"
    
    //REF    | id 
    //WAESCH | 1  

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
    HAASE     | P_DPATTERNS
  }

}

hochschule.relations {
  HAASE.leitet(DPATTERNS)
  DPATTERNS.geleitetVon(HAASE)
  WAESCH.beaufsichtigt(P_VSYS)
  // HAASE.beaufsichtigt(P_DPATTERNS)
  MOLL.besucht(VSYS)
  MOLL.istTutor(VSYS)
  P_VSYS.geschriebenVon(MOLL) //MOLL.schreibt(P_VSYS)
  MUSTERMANN.besucht(DPATTERNS)
}

println hochschule.createDataSet()
println "Vor Änderung: " + hochschule.dataset.table_Professor.findWhere.id(2).getName()

hochschule.tables {
  professorTable.rows {
    REF    | name
    HAASE  | "Und nochmal"
  }
}
println "Nach Änderung: " + hochschule.dataset.table_Professor.findWhere.id(2).getName()
hochschule.tables {
  professorTable.rows {
    id | name
    2  | "auch id geht"
  }
}
println "Nach Änderung 2: " + hochschule.dataset.table_Professor.findWhere.id(2).getName()
//println "Wäsch: " + hochschule.dataset.table_Professor.findWhere.id(5).getName()



