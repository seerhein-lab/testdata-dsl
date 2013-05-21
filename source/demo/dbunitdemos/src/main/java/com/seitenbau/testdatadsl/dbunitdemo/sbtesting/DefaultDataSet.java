package com.seitenbau.testdatadsl.dbunitdemo.sbtesting;

import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.LehrveranstaltungTable.RowBuilder_Lehrveranstaltung;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.ProfessorTable.RowBuilder_Professor;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.PruefungTable.RowBuilder_Pruefung;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.StudentTable.RowBuilder_Student;
import com.seitenbau.testdatadsl.stu.util.DateUtil;

public class DefaultDataSet extends DBUnitExamplesDataSet {
	@Override
	protected void initDataSet() {
    RowBuilder_Professor waesch = 
        table_Professor
          .insertRow()
            .setName("Wäsch")
            .setVorname("Jürgen")
            .setTitel("Prof. Dr.-Ing.")
            .setFakultaet("Informatik");
		RowBuilder_Professor haase = 
				table_Professor
					.insertRow()
						.setName("Haase")
						.setVorname("Oliver")
						.setTitel("Prof. Dr.")
						.setFakultaet("Informatik");

		RowBuilder_Lehrveranstaltung vsys = 
				table_Lehrveranstaltung
					.insertRow()
						.setName("Verteilte Systeme")
						.refProfessorId(haase)
						.setSws(4)
						.setEcts(5.0d);
		RowBuilder_Lehrveranstaltung design_patterns = 
				table_Lehrveranstaltung
					.insertRow()
						.setName("Design Patterns")
						.refProfessorId(haase)
						.setSws(4)
						.setEcts(3.0d);
						
		
		RowBuilder_Pruefung p_vsys = 
				table_Pruefung
					.insertRow()
						.setTyp("K90")
						.refLehrveranstaltungId(vsys)
						.setZeitpunkt(DateUtil.getDate(2013, 4, 1, 14, 0, 0));

		RowBuilder_Pruefung p_design_patterns = 
				table_Pruefung
					.insertRow()
						.setTyp("M30")
						.refLehrveranstaltungId(design_patterns)
						.setZeitpunkt(DateUtil.getDate(2013, 1, 6, 12, 0, 0));
		
		RowBuilder_Student moll = 
				table_Student
					.insertRow()
						.setMatrikelnummer(287336)
						.setName("Moll")
						.setVorname("Nikolaus")
						.setStudiengang("MSI")
						.setSemester(4)
						.setImmatrikuliertSeit(DateUtil.getDate(2011, 9, 1));
		RowBuilder_Student mustermann = 
				table_Student
					.insertRow()
						.setMatrikelnummer(123456)
						.setName("Mustermann")
						.setVorname("Max")
						.setStudiengang("BIT")
						.setSemester(3)
						.setImmatrikuliertSeit(DateUtil.getDate(2012, 3, 1));
						
		
		table_Beaufsichtigt
			.insertRow()
			  .refProfessorId(waesch)
				.refPruefungId(p_vsys)
			.insertRow()
			  .refProfessorId(haase)
			  .refPruefungId(p_design_patterns);
		
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
