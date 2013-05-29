package com.seitenbau.testdatadsl.dbunit.simpledsl

import java.util.Formatter.DateTime;

import com.seitenbau.testing.asserts.fest.impl.DateAssert;

class Pruefung {
	long id
	String typ
	Date zeitpunkt = new Date(0);
	Object prueftStoffVon
	
	def Pruefung(Closure closure) {
		closure.delegate = this
		closure()
		//println("Pruefung: $typ, prüft Stoff von $prueftStoffVon")
	}
	
	def typ(String typ) {
		this.typ = typ
	}
	
	def zeitpunkt(String date) {
		// TODO
		//this.typ = typ
	}
	
	def prueftStoffVon(Object lehrveranstaltung) {
		this.prueftStoffVon = lehrveranstaltung
	}
	
}
