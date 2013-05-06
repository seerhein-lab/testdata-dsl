package com.seitenbau.testdatadsl.dbunitdemo.groovy

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