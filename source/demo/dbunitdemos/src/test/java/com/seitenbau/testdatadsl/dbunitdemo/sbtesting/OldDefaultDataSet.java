package com.seitenbau.testdatadsl.dbunitdemo.sbtesting;

import com.seitenbau.testdatadsl.dbunitdemo.JavaDataSetProvider.Parameters;

public class OldDefaultDataSet extends DBUnitExamplesDataSet {
	@Override
	protected void initDataSet() {
		table_Professor
			.insertRow()
				.setId(Parameters.Professor.HAASE_ID)
				.setName("Oliver Haase")
			.insertRow()
				.setId(Parameters.Professor.WAESCH_ID)
				.setName("Jürgen Wäsch");
	
		table_Lehrveranstaltung
			.insertRow()
				.setId(Parameters.Lehrveranstaltung.VERTEILTE_SYSTEME_ID)
				.setProfessorId(Parameters.Professor.HAASE_ID)
				.setName("Verteilte Systeme")
			.insertRow()
				.setId(Parameters.Lehrveranstaltung.DESIGN_PATTERNS_ID)
				.setProfessorId(Parameters.Professor.HAASE_ID)
				.setName("Design Patterns");
		
		table_Pruefung
			.insertRow()
				.setId(Parameters.Pruefung.VERTEILTE_SYSTEME_ID)
				.setLehrveranstaltungId(Parameters.Lehrveranstaltung.VERTEILTE_SYSTEME_ID)
				.setTyp("K90")
			.insertRow()
				.setId(Parameters.Pruefung.DESIGN_PATTERNS_ID)
				.setLehrveranstaltungId(Parameters.Lehrveranstaltung.DESIGN_PATTERNS_ID)
				.setTyp("M30");
		
		table_Student
			.insertRow()
				.setMatrikelnummer(287336)
				.setName("Nikolaus Moll")
			.insertRow()
				.setMatrikelnummer(123456)
				.setName("Max Mustermann");
		
		table_Beaufsichtigt
			.insertRow()
				.setProfessorId(Parameters.Professor.HAASE_ID)
				.setPruefungId(Parameters.Pruefung.VERTEILTE_SYSTEME_ID);
		table_Beaufsichtigt
			.insertRow()
				.setPruefungId(Parameters.Pruefung.VERTEILTE_SYSTEME_ID)
				.setProfessorId(Parameters.Professor.WAESCH_ID);
		
		table_Besucht
			.insertRow()
				.setStudentId(Parameters.Student.NIKOLAUS_MOLL_ID)
				.setLehrveranstaltungId(Parameters.Lehrveranstaltung.VERTEILTE_SYSTEME_ID);
		
		table_Besucht
			.insertRow()
				.setStudentId(Parameters.Student.MAX_MUSTERMANN_ID)
				.setLehrveranstaltungId(Parameters.Lehrveranstaltung.DESIGN_PATTERNS_ID);
		
		table_Isttutor
			.insertRow()
				.setStudentId(Parameters.Student.NIKOLAUS_MOLL_ID)
				.setLehrveranstaltungId(Parameters.Lehrveranstaltung.VERTEILTE_SYSTEME_ID);

		table_Schreibt
			.insertRow()
				.setStudentId(Parameters.Student.NIKOLAUS_MOLL_ID)
				.setPruefungId(Parameters.Lehrveranstaltung.VERTEILTE_SYSTEME_ID);
	}
}
