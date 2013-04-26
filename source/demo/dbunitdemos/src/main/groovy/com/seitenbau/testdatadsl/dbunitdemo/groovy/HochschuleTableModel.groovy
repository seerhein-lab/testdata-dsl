package com.seitenbau.testdatadsl.dbunitdemo.groovy

import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.DBUnitExamplesDataSet
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.LehrveranstaltungTable.RowBuilder_Lehrveranstaltung
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.ProfessorTable.RowBuilder_Professor
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.PruefungTable.RowBuilder_Pruefung
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.StudentTable.RowBuilder_Student

// pseudo-generated
@Mixin(DBUnitExamplesDataSet)
class HochschuleTableModel extends AbstractTableModel {

  def HochschuleTableModel() {
    TableModel professor = new TableModel(name: "professor")
    professor.addColumn(new TableColumn(name: "id"))
    professor.addColumn(new TableColumn(name: "name"))
    professor.addColumn(new TableColumn(name: "vorname"))
    professor.addColumn(new TableColumn(name: "titel"))
    professor.addColumn(new TableColumn(name: "fakultaet"))
    tables["professor"] = professor

    TableModel lehrveranstaltung = new TableModel(name: "lehrveranstaltung")
    lehrveranstaltung.addColumn(new TableColumn(name: "id"))
    lehrveranstaltung.addColumn(new TableColumn(name: "name"))
    lehrveranstaltung.addColumn(new TableColumn(name: "sws"))
    lehrveranstaltung.addColumn(new TableColumn(name: "ects"))
    tables["lehrveranstaltung"] = lehrveranstaltung

    TableModel pruefung = new TableModel(name: "pruefung")
    pruefung.addColumn(new TableColumn(name: "typ"))
    pruefung.addColumn(new TableColumn(name: "zeitpunkt"))
    tables["pruefung"] = pruefung

    TableModel student = new TableModel(name: "student")
    student.addColumn(new TableColumn(name: "matrikelnummer"))
    student.addColumn(new TableColumn(name: "name"))
    student.addColumn(new TableColumn(name: "vorname"))
    student.addColumn(new TableColumn(name: "studiengang"))
    student.addColumn(new TableColumn(name: "semester"))
    student.addColumn(new TableColumn(name: "immatrikuliertSeit"))
    tables["student"] = student

    // relations
    professor.addColumn(new TableColumn(name: "leitet", ref: lehrveranstaltung.ref("id")))
    professor.addColumn(new TableColumn(name: "beaufsichtigt", ref: pruefung.ref("id")))

    pruefung.addColumn(new TableColumn(name: "lehrveranstaltung", ref: lehrveranstaltung.ref("id")))

    student.addColumn(new TableColumn(name: "besucht", ref: lehrveranstaltung.ref("id")))
    student.addColumn(new TableColumn(name: "istTutor", ref: lehrveranstaltung.ref("id")))
    student.addColumn(new TableColumn(name: "schreibt", ref: pruefung.ref("id")))
  }

  def applyReferences(tabledata, variables) {
    def professor = tabledata["professor"]
    for (TableDataRow row in professor) {
      applyReferencesLeitet(row, variables)
      applyReferencesBeaufsichtigt(row, variables)
    }

    def lehrveranstaltung = tabledata["lehrveranstaltung "]
    for (TableDataRow row in lehrveranstaltung) {
    }

    def pruefung = tabledata["pruefung"]
    for (TableDataRow row in pruefung) {
      applyReferencesLehrveranstaltung(row, variables)
    }

    def student = tabledata["student"]
    for (TableDataRow row in student) {
      applyReferencesBesucht(row, variables)
      applyReferencesIstTutor(row, variables)
      applyReferencesSchreibt(row, variables)
    }
  }

  def applyReferencesLeitet(row, variables) {
    def value = row.values["leitet"]
    if (value instanceof Var) {
      if (!value.isPlaceholder()) {
        println row.values["name"] + " leitet "  + variables[value.name].rowBuilder
        variables[value.name].rowBuilder.refProfessorId(row.rowBuilder)
      }
    }
    if (value instanceof Values) {
      for (Var actualValue : value.values) {
        println row.values["name"] + " leitet "  + variables[actualValue.name].rowBuilder
        variables[actualValue.name].rowBuilder.refProfessorId(row.rowBuilder)
      }
    }
  }

  def applyReferencesBeaufsichtigt(row, variables) {
    def value = row.values["beaufsichtigt"]
    if (value instanceof Var) {
      if (!value.isPlaceholder()) {
        println row.values["name"] + " beaufsichtigt "  + variables[value.name].rowBuilder
        table_Beaufsichtigt.insertRow()
            .refProfessorId(row.rowBuilder)
            .refPruefungId(variables[value.name].rowBuilder)
      }
    }
    if (value instanceof Values) {
      for (Var actualValue : value.values) {
        println row.values["name"] + " beaufsichtigt "  + variables[actualValue.name].rowBuilder
        table_Beaufsichtigt.insertRow()
            .refProfessorId(row.rowBuilder)
            .refPruefungId(variables[actualValue.name].rowBuilder)
      }
    }
  }

  def applyReferencesBesucht(row, variables) {
    def value = row.values["besucht"]
    if (value instanceof Var) {
      if (!value.isPlaceholder()) {
        println row.values["name"] + " besucht "  + variables[value.name].rowBuilder
        table_Besucht.insertRow()
            .refStudentId(row.rowBuilder)
            .refLehrveranstaltungId(variables[value.name].rowBuilder)
      }
    }
    if (value instanceof Values) {
      for (Var actualValue : value.values) {
        println row.values["name"] + " besucht "  + variables[actualValue.name].rowBuilder
        table_Besucht.insertRow()
            .refStudentId(row.rowBuilder)
            .refLehrveranstaltungId(variables[actualValue.name].rowBuilder)
      }
    }
  }

  def applyReferencesIstTutor(row, variables) {
    def value = row.values["istTutor"]
    if (value instanceof Var) {
      if (!value.isPlaceholder()) {
        println row.values["name"] + " istTutor "  + variables[value.name].rowBuilder
        table_Isttutor.insertRow()
            .refStudentId(row.rowBuilder)
            .refLehrveranstaltungId(variables[value.name].rowBuilder)
      }
    }
    if (value instanceof Values) {
      for (Var actualValue : value.values) {
        println row.values["name"] + " istTutor "  + variables[actualValue.name].rowBuilder
        table_Isttutor.insertRow()
            .refStudentId(row.rowBuilder)
            .refLehrveranstaltungId(variables[actualValue.name].rowBuilder)
      }
    }
  }

  def applyReferencesSchreibt(row, variables) {
    def value = row.values["schreibt"]
    if (value instanceof Var) {
      if (!value.isPlaceholder()) {
        println row.values["name"] + " schreibt "  + variables[value.name].rowBuilder
        table_Schreibt.insertRow()
            .refStudentId(row.rowBuilder)
            .refPruefungId(variables[value.name].rowBuilder)
      }
    }
    if (value instanceof Values) {
      for (Var actualValue : value.values) {
        println row.values["name"] + " schreibt "  + variables[actualValue.name].rowBuilder
        table_Schreibt.insertRow()
            .refStudentId(row.rowBuilder)
            .refPruefungId(variables[actualValue.name].rowBuilder)
      }
    }
  }

  def applyReferencesLehrveranstaltung(row, variables) {
    def value = row.values["lehrveranstaltung"]
    if (value instanceof Var) {
      if (!value.isPlaceholder()) {
        println row.values["typ"] + " ist Prüfung von "  + variables[value.name].rowBuilder
        row.rowBuilder.refLehrveranstaltungId(variables[value.name].rowBuilder)
      }
    }
  }

  def apply_professor(tablerows, variables) {
    apply_table(table_Professor, tablerows, variables)
  }

  def apply_lehrveranstaltung(tablerows, variables) {
    apply_table(table_Lehrveranstaltung, tablerows, variables)
  }

  def apply_pruefung(tablerows, variables) {
    apply_table(table_Pruefung, tablerows, variables)
  }

  def apply_student(tablerows, variables) {
    apply_table(table_Student, tablerows, variables)
  }

}
