package com.seitenbau.testdatadsl.dbunitdemo.sbtesting;

import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.LehrveranstaltungTable.RowBuilder_Lehrveranstaltung;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.ProfessorTable.RowBuilder_Professor;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.PruefungTable.RowBuilder_Pruefung;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.StudentTable.RowBuilder_Student;

public class DefaultDataSet extends DBUnitExamplesDataSet {
	@Override
	protected void initDataSet() {
		RowBuilder_Professor haase = 
				table_Professor
					.insertRow()
						.setName("Oliver Haase");
		RowBuilder_Professor waesch = 
				table_Professor
					.insertRow()
						.setName("Jürgen Wäsch");

		RowBuilder_Lehrveranstaltung vsys = 
				table_Lehrveranstaltung
					.insertRow()
						.setName("Verteilte Systeme")
						.refProfessorId(haase);
		RowBuilder_Lehrveranstaltung design_patterns = 
				table_Lehrveranstaltung
					.insertRow()
						.setName("Design Patterns")
						.refProfessorId(haase);
		
		RowBuilder_Pruefung p_vsys = 
				table_Pruefung
					.insertRow()
						.setTyp("K90")
						.refLehrveranstaltungId(vsys);
		RowBuilder_Pruefung p_design_patterns = 
				table_Pruefung
					.insertRow()
						.setTyp("M30")
						.refLehrveranstaltungId(design_patterns);
		
		RowBuilder_Student moll = 
				table_Student
					.insertRow()
						.setMatrikelnummer(287336)
						.setName("Nikolaus Moll");
		RowBuilder_Student mustermann = 
				table_Student
					.insertRow()
						.setMatrikelnummer(123456)
						.setName("Max Mustermann");
		
		table_Beaufsichtigt
			.insertRow()
				.refProfessorId(haase)
				.refPruefungId(p_vsys)
			.insertRow()
				.refPruefungId(p_design_patterns)
				.refProfessorId(waesch);
		
		table_Besucht
			.insertRow()
				.refStudentId(moll)
				.refLehrveranstaltungId(vsys)
			.insertRow()
				.refStudentId(mustermann)
				.refLehrveranstaltungId(design_patterns);
		
		table_Isttutor
			.insertRow()
				.refStudentId(moll)
				.refLehrveranstaltungId(vsys);

		table_Schreibt
			.insertRow()
				.refStudentId(moll)
				.refPruefungId(p_vsys);
	}
}
