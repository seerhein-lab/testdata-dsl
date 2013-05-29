package com.seitenbau.testdatadsl.dbunit.stu

import static com.seitenbau.testdatadsl.dbunit.stu.HochschuleRefs.*
import com.seitenbau.stu.dbunit.hochschule.dsl.HochschuleDSL;

import com.seitenbau.testdatadsl.dbunit.common.util.DateUtil;

class HochschuleDataSet extends HochschuleDSL
{

  HochschuleDataSet(){
    
    relations {
      WAESCH.beaufsichtigt(P_VSYS)
      HAASE.leitet(VSYS, DPATTERNS)
      HAASE.beaufsichtigt(P_DPATTERNS)
      P_VSYS.stoffVon(VSYS)
      DPATTERNS.hatPruefung(P_DPATTERNS)
      MOLL.schreibt(P_VSYS)
      MOLL.besucht(VSYS)
      VSYS.hatTutor(MOLL)
      MUSTERMANN.besucht(DPATTERNS)
    }
    
    tables {
      
      professorTable.rows {
        REF    | name    | vorname  | titel            | fakultaet
        WAESCH | "Wäsch" | "Jürgen" | "Prof. Dr.-Ing." | "Informatik"
        HAASE  | "Haase" | "Oliver" | "Prof. Dr."      | "Informatik"
      }
    
      lehrveranstaltungTable.rows {
        REF       | id  | name                | sws | ects
        VSYS      | 1   | "Verteilte Systeme" | 4   | 5
        DPATTERNS | 2   | "Design Patterns"   | 4   | 3
      }
    
      pruefungTable.rows {
        REF         | id  | typ   | zeitpunkt
        P_VSYS      | 1   | "K90" | DateUtil.getDate(2013, 4, 1, 14, 0, 0)
        P_DPATTERNS | 2   | "M30" | DateUtil.getDate(2013, 1, 6, 12, 0, 0)
      }
    
      studentTable.rows {
        REF        | matrikelnummer | name         | vorname    | studiengang | semester | immatrikuliert_seit
        MOLL       | 287336         | "Moll"       | "Nikolaus" | "MSI"       | 4        | DateUtil.getDate(2011, 9, 1)
        MUSTERMANN | 123456         | "Mustermann" | "Max"      | "BIT"       | 3        | DateUtil.getDate(2012, 3, 1)
      }
      
    }
  }
  
}
