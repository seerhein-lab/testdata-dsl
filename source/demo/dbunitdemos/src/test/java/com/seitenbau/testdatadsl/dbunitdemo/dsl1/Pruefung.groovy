package com.seitenbau.testdatadsl.dbunitdemo.dsl1

class Pruefung {
	long id
	String typ
	Object prueftStoffVon
	
	def Pruefung(closure) {
		closure.delegate = this
		closure()
		//println("Pruefung: $typ, prüft Stoff von $prueftStoffVon")
	}
	
	def typ(String typ) {
		this.typ = typ
	}
	
	def prueftStoffVon(Object lehrveranstaltung) {
		this.prueftStoffVon = lehrveranstaltung
	}
	
}
