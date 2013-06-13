package com.seitenbau.testdatadsl.dbunit.stu.model;

import com.seitenbau.testing.dbunit.generator.DataType;
import com.seitenbau.testing.dbunit.generator.DatabaseModel;
import com.seitenbau.testing.dbunit.generator.Flags;
import com.seitenbau.testing.dbunit.generator.Table;

public class SBTestingModel extends DatabaseModel {
  
  public SBTestingModel()
  {
    database("Hochschule");
    packageName("com.seitenbau.stu.dbunit.hochschule");
    
    Table professoren = addTable("professor")
        .addColumn("id", DataType.BIGINT, Flags.AutoInvokeNextIdMethod) 
        .addColumn("name", DataType.VARCHAR)
        .addColumn("vorname", DataType.VARCHAR)
        .addColumn("titel", DataType.VARCHAR)
        .addColumn("fakultaet", DataType.VARCHAR);

    Table lehrveranstaltungen = addTable("lehrveranstaltung")
        .addColumn("id", DataType.BIGINT, Flags.AutoInvokeNextIdMethod)
        .addColumn("professor_id", DataType.BIGINT, professoren.ref("id"))
        .addColumn("name", DataType.VARCHAR)
        .addColumn("sws", DataType.INTEGER)
        .addColumn("ects", DataType.DOUBLE);
    
    Table pruefungen = addTable("pruefung")
        .addColumn("id", DataType.BIGINT, Flags.AutoInvokeNextIdMethod)
        .addColumn("lehrveranstaltung_id", DataType.BIGINT, lehrveranstaltungen.ref("id"))
        .addColumn("typ", DataType.VARCHAR)
        .addColumn("zeitpunkt", DataType.DATE);
    
    Table studenten = addTable("student")
        .addColumn("matrikelnummer", DataType.BIGINT, Flags.AutoInvokeNextIdMethod)
        .addColumn("name", DataType.VARCHAR)
        .addColumn("vorname", DataType.VARCHAR)
        .addColumn("studiengang", DataType.VARCHAR)
        .addColumn("semester", DataType.INTEGER)
        .addColumn("immatrikuliert_seit", DataType.DATE);

    addTable("beaufsichtigt")
        .addColumn("professor_id", DataType.BIGINT, professoren.ref("id"))
        .addColumn("pruefung_id", DataType.BIGINT, pruefungen.ref("id"));
    
    addTable("besucht")
        .addColumn("student_id", DataType.BIGINT, studenten.ref("matrikelnummer"))
        .addColumn("lehrveranstaltung_id", DataType.BIGINT, lehrveranstaltungen.ref("id"));
    
    addTable("isttutor")
        .addColumn("student_id", DataType.BIGINT, studenten.ref("matrikelnummer"))
        .addColumn("lehrveranstaltung_id", DataType.BIGINT, lehrveranstaltungen.ref("id"));
    
    addTable("schreibt")
        .addColumn("student_id", DataType.BIGINT, studenten.ref("matrikelnummer"))
        .addColumn("pruefung_id", DataType.BIGINT, pruefungen.ref("id"));
  }
  
}
