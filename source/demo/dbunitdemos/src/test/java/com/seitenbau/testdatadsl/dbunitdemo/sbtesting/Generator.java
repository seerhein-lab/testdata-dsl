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
				.addColumn("id", DataType.BIGINT, Flags.AutoInvokeNextIdMethod)
				.addColumn("name", DataType.VARCHAR);
		Table lehrveranstaltungen = db.addTable("lehrveranstaltung")
				.addColumn("id", DataType.BIGINT, Flags.AutoInvokeNextIdMethod)
				.addColumn("professor_id", DataType.BIGINT, professoren.ref("id"))
				.addColumn("name", DataType.VARCHAR);
		Table pruefungen = db.addTable("pruefung")
				.addColumn("id", DataType.BIGINT, Flags.AutoInvokeNextIdMethod)
				.addColumn("lehrveranstaltung_id", DataType.BIGINT, lehrveranstaltungen.ref("id"))
				.addColumn("typ", DataType.VARCHAR);
		Table studenten = db.addTable("student")
				.addColumn("matrikelnummer", DataType.BIGINT, Flags.AddNextIdMethod)
				.addColumn("name", DataType.VARCHAR);

		db.addTable("beaufsichtigt")
				.addColumn("professor_id", DataType.BIGINT, professoren.ref("id"))
				.addColumn("pruefung_id", DataType.BIGINT, pruefungen.ref("id"));
		db.addTable("besucht")
				.addColumn("student_id", DataType.BIGINT, studenten.ref("matrikelnummer"))
				.addColumn("lehrveranstaltung_id", DataType.BIGINT, lehrveranstaltungen.ref("id"));
		db.addTable("isttutor")
				.addColumn("student_id", DataType.BIGINT, studenten.ref("matrikelnummer"))
				.addColumn("lehrveranstaltung_id", DataType.BIGINT, lehrveranstaltungen.ref("id"));
		db.addTable("schreibt")
				.addColumn("student_id", DataType.BIGINT, studenten.ref("matrikelnummer"))
				.addColumn("pruefung_id", DataType.BIGINT, pruefungen.ref("id"));

		db.generate();
	}
}
