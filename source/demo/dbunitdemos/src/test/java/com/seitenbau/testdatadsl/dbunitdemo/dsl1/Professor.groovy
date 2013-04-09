package com.seitenbau.testdatadsl.dbunitdemo.dsl1

// ? -> ExpandoMetaClass.enableGlobally()

class Professor {
	
	long id;
	String name;
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
	
	def beaufsichtigt(Object[] pruefungen) {
		this.beaufsichtigt = pruefungen
	} 

	def leitet(Object[] lehrveranstaltungen) {
		this.leitet = lehrveranstaltungen
	} 
}
