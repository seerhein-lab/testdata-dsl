package com.seitenbau.testdatadsl.dbunitdemo.dsl1

abstract class DslDefinition extends Script {
		
	def professor(closure) {
		def binding = (DslBinding)getBinding()
		Professor p = new Professor(closure)
		binding.addProfessor(p)
		return p
	}

	def lehrveranstaltung(closure) {
		def binding = (DslBinding)getBinding()
		Lehrveranstaltung l = new Lehrveranstaltung(closure)
		binding.addLehrveranstaltung(l)
		return l
	}

	def pruefung(closure) {
		def binding = (DslBinding)getBinding()
		Pruefung p = new Pruefung(closure)
		binding.addPruefung(p)
		return p
	}
	
	def student(closure) {
		def binding = (DslBinding)getBinding()
		Student s = new Student(closure)
		binding.addStudent(s)
		return s
	}

	def methodMissing(String methodName, args) {
		println("Method missing: " + methodName)
	}
}