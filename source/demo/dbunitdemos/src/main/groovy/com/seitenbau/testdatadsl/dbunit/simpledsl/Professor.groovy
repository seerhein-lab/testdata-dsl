package com.seitenbau.testdatadsl.dbunit.simpledsl

class Professor {

  long id;
  String name;
  String vorname;
  String titel;
  String fakultaet;

  Object[] beaufsichtigt;
  Object[] leitet;

  def Professor(Closure closure) {
    closure.delegate = this
    closure()
  }

  def name(String name) {
    this.name = name
  }

  def vorname(String vorname) {
    this.vorname = vorname
  }

  def titel(String titel) {
    this.titel = titel
  }

  def fakultaet(String fakultaet) {
    this.fakultaet = fakultaet
  }

  def beaufsichtigt(Object[] pruefungen) {
    this.beaufsichtigt = pruefungen
  }

  def leitet(Object[] lehrveranstaltungen) {
    this.leitet = lehrveranstaltungen
  }
}
