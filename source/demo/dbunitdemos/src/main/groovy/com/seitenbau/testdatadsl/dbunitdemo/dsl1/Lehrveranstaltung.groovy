package com.seitenbau.testdatadsl.dbunitdemo.dsl1

class Lehrveranstaltung {
	long id;
	String name;
	int sws;
	double ects;
	
	def Lehrveranstaltung(Closure closure) {
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

	def ects(double ects) {
		this.ects = ects
	}
}
