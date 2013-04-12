package com.seitenbau.testdatadsl.dbunitdemo.dsl1

class Student {
	long matrikelnummer
	String name
	String vorname
	String studiengang
	int semester
	Date immatrikuliert_seit = new Date(0);
	
	Object[] besucht
	Object[] schreibt
	Object[] isttutor
	
	def Student(closure) {
		closure.delegate = this
		closure()
		//println("Student $name, $matrikelnummer, besucht $besucht, schreibt $schreibt, ist Tutor bei $isttutor")	
	}

	def matrikelnummer(nr) {
		this.matrikelnummer = nr
	}

	def name(String name) {
		this.name = name
	}
	
	def vorname(String vorname) {
		this.vorname = vorname
	}
	
	def studiengang(String studiengang) {
		this.studiengang = studiengang
	}
	
	def semester(int semester) {
		this.semester = semester
	}

	def immatrikuliert_seit(String date) {
		// TODO
		//this.immatrikuliert_seit = name
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
