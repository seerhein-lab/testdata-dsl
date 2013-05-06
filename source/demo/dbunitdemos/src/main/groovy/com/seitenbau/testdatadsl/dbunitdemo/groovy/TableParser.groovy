package com.seitenbau.testdatadsl.dbunitdemo.groovy

import groovy.lang.Closure;
import groovy.transform.ToString;

import java.util.List;

@ToString
class Var {
  String name
  
  def Var() {
    name = "_"
  }
  
  def isPlaceholder() {
    return name == "_"
  }
}


@ToString
class Values {

  List values = []

  def and(arg) {
    values.add(arg)
    this
  }
}

@ToString
class Row {

  List values = []

  def or(arg) {
    values.add(arg)
    this
  }
}

class TableParser {
  
  static context = new ThreadLocal<List>()

  static List getRows() {
    context.get()
  }

  static or(self, arg) {
    println("or (obj)")
    appendRow(self, arg)
  }

  static or(Integer self, Integer arg) {
    println("or (int)")
    appendRow(self, arg)
  }

  static or(Boolean self, Boolean arg) {
    println("or (bool)")
    appendRow(self, arg)
  }

  static and(self, arg) {
    def values = new Values(values: [self])
    values.and(arg)
  }

  static appendRow(value, nextValue) {
    def row = new Row(values: [value])
    rows.add(row)
    row.or(nextValue)
  }

  def getProperty(String property) {
    new Var(name: property)
  }

  def parseTableClosure(Closure tableData){
    context.set([])
    use(TableParser) {
      tableData.delegate = this
      //tableData.resolveStrategy = Closure.DELEGATE_FIRST
      tableData()
    }
    context.get()
    // context aufräumen?
  }
  
  static def parse(Closure tableData) {
    return new TableParser().parseTableClosure(tableData)  
  }

}