package com.seitenbau.testdatadsl.dbunitdemo.dsl1

class Lehrveranstaltung {
	long id;
	String name;
	int sws;
	int ects;
	
	def Lehrveranstaltung(closure) {
		closure.delegate = this
		closure()
		//println("Lehrveranstaltung: " + name)
	}
	
	def name(String name) {
		this.name = name
	}

	def sws(int sws) {
		this.sws = sws
	}

	def ects(int ects) {
		this.ects = ects
	}
}
