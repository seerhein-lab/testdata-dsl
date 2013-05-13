package com.seitenbau.testdatadsl.dbunitdemo.groovy
//  
//testData.relations {
//    
//  vsys besuchtVon [
//    nikolaus, 
//    ben
//  ]
//  
//  haase leitet [
//    vsys, 
//    designpatterns
//  ]
//  
//}
//
//class LehrveranstaltungId {
//  
//  def id = LehrveranstaltungIdGenerator.getId()
//  
//  def besuchtVon(List ids){
//    ids.each { studentId ->
//      testData.lehrveranstalltungStudentTable.rows {
//        lehrveranstaltung | student
//        id                | studentId
//      }
//    }
//  }
//  
//}
