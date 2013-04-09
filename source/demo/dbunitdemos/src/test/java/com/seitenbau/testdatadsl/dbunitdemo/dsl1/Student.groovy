package com.seitenbau.testdatadsl.dbunitdemo.dsl1

class Student {
	long matrikelnummer
	String name
	Object[] besucht
	Object[] schreibt
	Object[] isttutor
	
	def Student(closure) {
		closure.delegate = this
		closure()
		//println("Student $name, $matrikelnummer, besucht $besucht, schreibt $schreibt, ist Tutor bei $isttutor")	
	}
	
	def name(String name) {
		this.name = name
	}
	
	def matrikelnummer(nr) {
		this.matrikelnummer = nr
	}
	
	def besucht(Object[] lehrveranstaltungen) {
		this.besucht = lehrveranstaltungen
	}

	def schreibt(Object[] pruefungen) {
		this.schreibt = pruefungen
	}
	
	def isttutor(Object[] lehrveranstaltungen) {
		this.isttutor = lehrveranstaltungen
	}

}
