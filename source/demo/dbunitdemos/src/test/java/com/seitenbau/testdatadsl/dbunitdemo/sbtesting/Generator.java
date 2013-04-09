package com.seitenbau.testdatadsl.dbunitdemo.sbtesting;

import com.seitenbau.testing.dbunit.generator.DataType;
import com.seitenbau.testing.dbunit.generator.DatabaseModel;
import com.seitenbau.testing.dbunit.generator.Flags;
import com.seitenbau.testing.dbunit.generator.Table;

public class Generator {
	public static void main(String[] args) throws Exception {
		DatabaseModel db = new DatabaseModel() {
			{
				database("DBUnitDemo");
				packageName("com.seitenbau.testdatadsl.dbunitdemo.sbtesting");
			}
		};

		Table professoren = db.addTable("professor")
				.addColumn("ID", DataType.BIGINT, Flags.AutoInvokeNextIdMethod)
				.addColumn("name", DataType.VARCHAR);
		Table lehrveranstaltungen = db.addTable("lehrveranstaltung")
				.addColumn("ID", DataType.BIGINT, Flags.AutoInvokeNextIdMethod)
				.addColumn("professorID", DataType.BIGINT, professoren.ref("ID"))
				.addColumn("name", DataType.VARCHAR);
		Table pruefungen = db.addTable("pruefung")
				.addColumn("ID", DataType.BIGINT, Flags.AutoInvokeNextIdMethod)
				.addColumn("lehrveranstaltungID", DataType.BIGINT, lehrveranstaltungen.ref("ID"))
				.addColumn("typ", DataType.VARCHAR);
		Table studenten = db.addTable("student")
				.addColumn("matrikelnummer", DataType.BIGINT, Flags.AddNextIdMethod)
				.addColumn("name", DataType.VARCHAR);

		db.addTable("beaufsichtigt")
				.addColumn("professorID", DataType.BIGINT, professoren.ref("ID"))
				.addColumn("pruefungID", DataType.BIGINT, pruefungen.ref("ID"));
		db.addTable("besucht")
				.addColumn("studentID", DataType.BIGINT, studenten.ref("matrikelnummer"))
				.addColumn("lehrveranstaltungID", DataType.BIGINT, lehrveranstaltungen.ref("ID"));
		db.addTable("isttutor")
				.addColumn("studentID", DataType.BIGINT, studenten.ref("matrikelnummer"))
				.addColumn("lehrveranstaltungID", DataType.BIGINT, lehrveranstaltungen.ref("ID"));
		db.addTable("schreibt")
				.addColumn("studentID", DataType.BIGINT, studenten.ref("matrikelnummer"))
				.addColumn("pruefungID", DataType.BIGINT, pruefungen.ref("ID"));

		db.generate();
	}
}
