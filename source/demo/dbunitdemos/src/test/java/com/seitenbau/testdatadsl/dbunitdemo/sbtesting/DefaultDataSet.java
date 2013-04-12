package com.seitenbau.testdatadsl.dbunitdemo.sbtesting;

import java.text.SimpleDateFormat;

import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.LehrveranstaltungTable.RowBuilder_Lehrveranstaltung;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.ProfessorTable.RowBuilder_Professor;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.PruefungTable.RowBuilder_Pruefung;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.StudentTable.RowBuilder_Student;

public class DefaultDataSet extends DBUnitExamplesDataSet {
	@Override
	protected void initDataSet() {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat( "dd.MM.yyyy HH:mm:ss" );
	
			RowBuilder_Professor haase = 
					table_Professor
						.insertRow()
							.setName("Haase")
							.setVorname("Oliver")
							.setTitel("Prof. Dr.")
							.setFakultaet("Informatik");
			RowBuilder_Professor waesch = 
					table_Professor
						.insertRow()
							.setName("Wäsch")
							.setVorname("Jürgen")
							.setTitel("Prof. Dr.-Ing.")
							.setFakultaet("Informatik");
	
			RowBuilder_Lehrveranstaltung vsys = 
					table_Lehrveranstaltung
						.insertRow()
							.setName("Verteilte Systeme")
							.refProfessorId(haase)
							.setSws(4)
							.setEcts(5);
			RowBuilder_Lehrveranstaltung design_patterns = 
					table_Lehrveranstaltung
						.insertRow()
							.setName("Design Patterns")
							.refProfessorId(haase)
							.setSws(4)
							.setEcts(3);
							
			
			RowBuilder_Pruefung p_vsys = 
					table_Pruefung
						.insertRow()
							.setTyp("K90")
							.refLehrveranstaltungId(vsys)
							.setZeitpunkt(dateFormat.parse("01.04.2013 14:00:00"));
	
			RowBuilder_Pruefung p_design_patterns = 
					table_Pruefung
						.insertRow()
							.setTyp("M30")
							.refLehrveranstaltungId(design_patterns)
							.setZeitpunkt(dateFormat.parse("06.01.2013 12:00:00"));
			
			RowBuilder_Student moll = 
					table_Student
						.insertRow()
							.setMatrikelnummer(287336)
							.setName("Moll")
							.setVorname("Nikolaus")
							.setStudiengang("MSI")
							.setSemester(4)
							.setImmatrikuliertSeit(dateFormat.parse("01.09.2011 00:00:00"));
			RowBuilder_Student mustermann = 
					table_Student
						.insertRow()
							.setMatrikelnummer(123456)
							.setName("Mustermann")
							.setVorname("Max")
							.setStudiengang("BIT")
							.setSemester(3)
							.setImmatrikuliertSeit(dateFormat.parse("01.03.2012 00:00:00"));
							
			
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
		catch (Exception e) {
		}
	}
}
