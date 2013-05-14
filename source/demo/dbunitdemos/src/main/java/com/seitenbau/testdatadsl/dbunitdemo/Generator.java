package com.seitenbau.testdatadsl.dbunitdemo;

import com.seitenbau.testing.dbunit.generator.DataType;
import com.seitenbau.testing.dbunit.generator.DatabaseModel;
import com.seitenbau.testing.dbunit.generator.Flags;
import com.seitenbau.testing.dbunit.generator.RelationDescription;
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
				.addColumn("id", DataType.BIGINT, Flags.AutoInvokeNextIdMethod, Flags.IdentifierColumn)
				.addColumn("name", DataType.VARCHAR)
				.addColumn("vorname", DataType.VARCHAR)
				.addColumn("titel", DataType.VARCHAR)
				.addColumn("fakultaet", DataType.VARCHAR);
		Table lehrveranstaltungen = db.addTable("lehrveranstaltung")
				.addColumn("id", DataType.BIGINT, Flags.AutoInvokeNextIdMethod, Flags.IdentifierColumn)
				.addColumn("professor_id", DataType.BIGINT, RelationDescription.oneToMany("geleitetVon", professoren, "leitet"))
				.addColumn("name", DataType.VARCHAR)
				.addColumn("sws", DataType.INTEGER)
				.addColumn("ects", DataType.DOUBLE);
		Table pruefungen = db.addTable("pruefung")
				.addColumn("id", DataType.BIGINT, Flags.AutoInvokeNextIdMethod, Flags.IdentifierColumn)
				.addColumn("lehrveranstaltung_id", DataType.BIGINT, RelationDescription.oneToOne("stoffVon", lehrveranstaltungen, "hatPruefung"))
				.addColumn("typ", DataType.VARCHAR)
				.addColumn("zeitpunkt", DataType.DATE);
		Table studenten = db.addTable("student")
				.addColumn("matrikelnummer", DataType.BIGINT, Flags.AddNextIdMethod, Flags.IdentifierColumn)
				.addColumn("name", DataType.VARCHAR)
				.addColumn("vorname", DataType.VARCHAR)
				.addColumn("studiengang", DataType.VARCHAR)
				.addColumn("semester", DataType.INTEGER)
				.addColumn("immatrikuliert_seit", DataType.DATE);

		db.addTable("beaufsichtigt")
				.addColumn("professor_id", DataType.BIGINT, RelationDescription.toOne(professoren, "beaufsichtigt"))
				.addColumn("pruefung_id", DataType.BIGINT, RelationDescription.toOne(pruefungen, "beaufsichtigtVon"));
		db.addTable("besucht")
				.addColumn("student_id", DataType.BIGINT, RelationDescription.toOne(studenten, "besucht"))
				.addColumn("lehrveranstaltung_id", DataType.BIGINT, RelationDescription.toOne(lehrveranstaltungen, "besuchtVon"));
		db.addTable("isttutor")
				.addColumn("student_id", DataType.BIGINT, RelationDescription.toOne(studenten, "istTutor"))
				.addColumn("lehrveranstaltung_id", DataType.BIGINT, RelationDescription.toOne(lehrveranstaltungen, "hatTutor"));
		db.addTable("schreibt")
				.addColumn("student_id", DataType.BIGINT, RelationDescription.toOne(studenten, "schreibt"))
				.addColumn("pruefung_id", DataType.BIGINT, RelationDescription.toOne(pruefungen, "geschriebenVon"));
	
		db.generate();
	}
}
