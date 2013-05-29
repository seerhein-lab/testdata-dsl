package com.seitenbau.testdatadsl.dbunit.simpledsl

abstract class DslDefinition extends Script {
		
	def professor(Closure closure) {
		def binding = (DslBinding)getBinding()
		Professor p = new Professor(closure)
		binding.addProfessor(p)
		return p
	}

	def lehrveranstaltung(Closure closure) {
		def binding = (DslBinding)getBinding()
		Lehrveranstaltung l = new Lehrveranstaltung(closure)
		binding.addLehrveranstaltung(l)
		return l
	}

	def pruefung(Closure closure) {
		def binding = (DslBinding)getBinding()
		Pruefung p = new Pruefung(closure)
		binding.addPruefung(p)
		return p
	}
	
	def student(Closure closure) {
		def binding = (DslBinding)getBinding()
		Student s = new Student(closure)
		binding.addStudent(s)
		return s
	}

	def methodMissing(String methodName, args) {
		println("Method missing: " + methodName)
	}
}