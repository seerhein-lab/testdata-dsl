package com.seitenbau.testdatadsl.dbunitdemo.dsl1

class Lehrveranstaltung {
	long id;
	String name;
	
	def Lehrveranstaltung(closure) {
		closure.delegate = this
		closure()
		//println("Lehrveranstaltung: " + name)
	}
	
	def name(String name) {
		this.name = name
	}
}
