package com.seitenbau.testdatadsl.dbunitdemo.sbtesting;

import com.seitenbau.testing.dbunit.generator.DataType;
import com.seitenbau.testing.dbunit.generator.DatabaseModel;
import com.seitenbau.testing.dbunit.generator.Flags;
import com.seitenbau.testing.dbunit.generator.Table;

public class Generator {
	public static void main(String[] args) throws Exception {
		DatabaseModel db = new DatabaseModel() {
			{
				database("DBUnitExamples");
				packageName("com.seitenbau.testdatadsl.dbunitdemo.sbtesting");
			}
		};

		Table professoren = db.addTable("professor")
				.addColumn("id", DataType.BIGINT, Flags.AutoInvokeNextIdMethod, Flags.ReferenceColumn)
				.addColumn("name", DataType.VARCHAR)
				.addColumn("vorname", DataType.VARCHAR)
				.addColumn("titel", DataType.VARCHAR)
				.addColumn("fakultaet", DataType.VARCHAR);
		Table lehrveranstaltungen = db.addTable("lehrveranstaltung")
				.addColumn("id", DataType.BIGINT, Flags.AutoInvokeNextIdMethod, Flags.ReferenceColumn)
				.addColumn("professor_id", DataType.BIGINT, professoren)
				.addColumn("name", DataType.VARCHAR)
				.addColumn("sws", DataType.INTEGER)
				.addColumn("ects", DataType.DOUBLE);
		Table pruefungen = db.addTable("pruefung")
				.addColumn("id", DataType.BIGINT, Flags.AutoInvokeNextIdMethod, Flags.ReferenceColumn)
				.addColumn("lehrveranstaltung_id", DataType.BIGINT, lehrveranstaltungen)
				.addColumn("typ", DataType.VARCHAR)
				.addColumn("zeitpunkt", DataType.DATE);
		Table studenten = db.addTable("student")
				.addColumn("matrikelnummer", DataType.BIGINT, Flags.AddNextIdMethod, Flags.ReferenceColumn)
				.addColumn("name", DataType.VARCHAR)
				.addColumn("vorname", DataType.VARCHAR)
				.addColumn("studiengang", DataType.VARCHAR)
				.addColumn("semester", DataType.INTEGER)
				.addColumn("immatrikuliert_seit", DataType.DATE);

		db.addTable("beaufsichtigt")
				.addColumn("professor_id", DataType.BIGINT, professoren)
				.addColumn("pruefung_id", DataType.BIGINT, pruefungen);
		db.addTable("besucht")
				.addColumn("student_id", DataType.BIGINT, studenten)
				.addColumn("lehrveranstaltung_id", DataType.BIGINT, lehrveranstaltungen);
		db.addTable("isttutor")
				.addColumn("student_id", DataType.BIGINT, studenten)
				.addColumn("lehrveranstaltung_id", DataType.BIGINT, lehrveranstaltungen);
		db.addTable("schreibt")
				.addColumn("student_id", DataType.BIGINT, studenten)
				.addColumn("pruefung_id", DataType.BIGINT, pruefungen);
	
		db.generate();
	}
}
