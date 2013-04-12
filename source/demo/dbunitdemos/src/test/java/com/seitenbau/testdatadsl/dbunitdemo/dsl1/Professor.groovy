package com.seitenbau.testdatadsl.dbunitdemo.dsl1

// ? -> ExpandoMetaClass.enableGlobally()

class Professor {
	
	long id;
	String name;
	String vorname;
	String titel;
	String fakultaet;
	
	Object[] beaufsichtigt;
	Object[] leitet;
	
	def Professor(closure) {
		closure.delegate = this
		closure()
		//println("Professor: $name, leitet: $leitet, beaufsichtigt: $beaufsichtigt")
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
