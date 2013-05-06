package com.seitenbau.testdatadsl.dbunitdemo.groovy

import groovy.lang.Closure;

class DataBuilder {
  
  def professor(Closure data){
    data.delegate = this
    data.resolveStrategy = Closure.DELEGATE_FIRST
    data()
  }
  
  def lehrveranstalltung(Closure dataSepc) {
    
  }
  
  def defineData(Closure data){
    data.delegate = this
    data.resolveStrategy = Closure.DELEGATE_FIRST
    data()
  }
  
}
