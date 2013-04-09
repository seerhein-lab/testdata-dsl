package com.seitenbau.testdatadsl.dbunitdemo.dsl1


class DslBinding extends Binding {
	
	def List<Professor> professoren = new LinkedList<Professor>();
	def List<Student> studenten = new LinkedList<Student>();
	def List<Lehrveranstaltung> lehrveranstaltungen = new LinkedList<Lehrveranstaltung>();
	def List<Pruefung> pruefungen = new LinkedList<Pruefung>();
	
	public DslBinding() {
	}
	
	def getVariable(String name) {
		//println("Binding.getVariable: $name");
		if (this.variables.containsKey(name)) {
			return super.getVariable(name);
		} else {
			return name;
		}
	}

	void setVariable(String name, Object value) {
		//println("Binding.setVariable: $name: $value");
		super.setVariable(name, value);
	}
	
	def addProfessor(Professor p) {
		professoren.add(p);
	}
	
	def addStudent(Student s) {
		studenten.add(s);
	}

	def addLehrveranstaltung(Lehrveranstaltung l) {
		lehrveranstaltungen.add(l);
	}
	
	def addPruefung(Pruefung p) {
		pruefungen.add(p);
	}

}
