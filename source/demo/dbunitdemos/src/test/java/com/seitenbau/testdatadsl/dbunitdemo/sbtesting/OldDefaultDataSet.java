package com.seitenbau.testdatadsl.dbunitdemo.sbtesting;

import com.seitenbau.testdatadsl.dbunitdemo.JavaDataSetProvider.Parameters;
import com.seitenbau.testdatadsl.dbunitdemo.groovy.DateUtil;

public class OldDefaultDataSet extends DBUnitExamplesDataSet {
	@Override
	protected void initDataSet() {
		table_Professor
      .insertRow()
        .setId(Parameters.Professor.WAESCH_ID)
        .setName("Wäsch")
        .setVorname("Jürgen")
        .setTitel("Prof. Dr.-Ing.")
        .setFakultaet("Informatik")
			.insertRow()
				.setId(Parameters.Professor.HAASE_ID)
				.setName("Haase")
				.setVorname("Oliver")
				.setTitel("Prof. Dr.")
				.setFakultaet("Informatik");
	
		table_Lehrveranstaltung
			.insertRow()
				.setId(Parameters.Lehrveranstaltung.VERTEILTE_SYSTEME_ID)
				.setProfessorId(Parameters.Professor.HAASE_ID)
				.setName("Verteilte Systeme")
				.setSws(4)
				.setEcts(5.0d)
			.insertRow()
				.setId(Parameters.Lehrveranstaltung.DESIGN_PATTERNS_ID)
				.setProfessorId(Parameters.Professor.HAASE_ID)
				.setName("Design Patterns")
				.setSws(4)
				.setEcts(3.0d);
	
		table_Pruefung
			.insertRow()
				.setId(Parameters.Pruefung.VERTEILTE_SYSTEME_ID)
				.setLehrveranstaltungId(Parameters.Lehrveranstaltung.VERTEILTE_SYSTEME_ID)
				.setTyp("K90")
				.setZeitpunkt(DateUtil.getDate(2013, 4, 1, 14, 0, 0))
			.insertRow()
				.setId(Parameters.Pruefung.DESIGN_PATTERNS_ID)
				.setLehrveranstaltungId(Parameters.Lehrveranstaltung.DESIGN_PATTERNS_ID)
				.setTyp("M30")
				.setZeitpunkt(DateUtil.getDate(2013, 1, 6, 12, 0, 0));
	
		table_Student
			.insertRow()
				.setMatrikelnummer(287336)
				.setName("Moll")
				.setVorname("Nikolaus")
				.setStudiengang("MSI")
				.setSemester(4)
				.setImmatrikuliertSeit(DateUtil.getDate(2011, 9, 1))
			.insertRow()
				.setMatrikelnummer(123456)
				.setName("Mustermann")
				.setVorname("Max")
				.setStudiengang("BIT")
				.setSemester(3)
				.setImmatrikuliertSeit(DateUtil.getDate(2012, 3, 1));
		
		table_Beaufsichtigt
      .insertRow()
        .setProfessorId(Parameters.Professor.WAESCH_ID)
        .setPruefungId(Parameters.Pruefung.VERTEILTE_SYSTEME_ID)
			.insertRow()
				.setProfessorId(Parameters.Professor.HAASE_ID)
				.setPruefungId(Parameters.Pruefung.DESIGN_PATTERNS_ID);
		
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
