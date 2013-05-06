package com.seitenbau.testdatadsl.dbunitdemo.groovy

import groovy.lang.Closure;
import groovy.transform.ToString;

import java.util.List;

class CommonTableParser {
  
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
     new Var(name: property)
   }

  def parseTableClosure(Closure tableData){
    context.set([])
    use(TableParser) {
      tableData.delegate = this
      tableData()
    }
    context.get()
    // context aufräumen?
  }
  
  static def parse(Closure tableData) {
    return new CommonTableParser().parseTableClosure(tableData)  
  }

}