package com.seitenbau.testdatadsl.dbunitdemo.sbtesting;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.seitenbau.testdatadsl.dbunitdemo.JavaDataSetProvider.Parameters;

public class OldDefaultDataSet extends DBUnitExamplesDataSet {
	@Override
	protected void initDataSet() {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat( "dd.MM.yyyy HH:mm:ss" );
	
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
					.setEcts(5)
				.insertRow()
					.setId(Parameters.Lehrveranstaltung.DESIGN_PATTERNS_ID)
					.setProfessorId(Parameters.Professor.HAASE_ID)
					.setName("Design Patterns")
					.setSws(4)
					.setEcts(3);
		
			table_Pruefung
				.insertRow()
					.setId(Parameters.Pruefung.VERTEILTE_SYSTEME_ID)
					.setLehrveranstaltungId(Parameters.Lehrveranstaltung.VERTEILTE_SYSTEME_ID)
					.setTyp("K90")
					.setZeitpunkt(dateFormat.parse("01.04.2013 14:00:00"))
				.insertRow()
					.setId(Parameters.Pruefung.DESIGN_PATTERNS_ID)
					.setLehrveranstaltungId(Parameters.Lehrveranstaltung.DESIGN_PATTERNS_ID)
					.setTyp("M30")
					.setZeitpunkt(dateFormat.parse("06.01.2013 12:00:00"));
		
			table_Student
				.insertRow()
					.setMatrikelnummer(287336)
					.setName("Moll")
					.setVorname("Nikolaus")
					.setStudiengang("MSI")
					.setSemester(4)
					.setImmatrikuliertSeit(dateFormat.parse("01.09.2011 00:00:00"))
				.insertRow()
					.setMatrikelnummer(123456)
					.setName("Mustermann")
					.setVorname("Max")
					.setStudiengang("BIT")
					.setSemester(3)
					.setImmatrikuliertSeit(dateFormat.parse("01.03.2012 00:00:00"));
			
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
