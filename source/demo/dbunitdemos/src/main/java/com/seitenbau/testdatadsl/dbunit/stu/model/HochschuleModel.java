package com.seitenbau.testdatadsl.dbunit.stu.model;

import com.seitenbau.testing.dbunit.generator.DataType;
import com.seitenbau.testing.dbunit.generator.DatabaseModel;
import com.seitenbau.testing.dbunit.generator.Table;

public class HochschuleModel extends DatabaseModel {
  
  public HochschuleModel()
  {
    database("Hochschule");
    packageName("com.seitenbau.stu.dbunit.hochschule");
    enableTableModelClassesGeneration();
    
    Table professoren = table("professor")
        .description("Die Tabelle mit den Professoren der Hochschule")
        .column("id", DataType.BIGINT) 
          .identifierColumn() 
          .autoInvokeNext()
        .column("name", DataType.VARCHAR)
        .column("vorname", DataType.VARCHAR)
        .column("titel", DataType.VARCHAR)
        .column("fakultaet", DataType.VARCHAR)
      .build();

    Table lehrveranstaltungen = table("lehrveranstaltung")
        .description("Die Tabelle mit den Lehrveranstaltungen der Hochschule")
        .column("id", DataType.BIGINT)
          .identifierColumn() 
          .autoInvokeNext()
        .column("professor_id", DataType.BIGINT)
          .references(professoren)
            .local("geleitetVon")
              .description("Gibt an, von welchem Professor eine Lehrveranstaltung geleitet wird.")
            .remote("leitet")
              .description("Gibt an, welche Lehrveranstaltungen ein Professor leitet.")
        .column("name", DataType.VARCHAR)
        .column("sws", DataType.INTEGER)
        .column("ects", DataType.DOUBLE)
        .column("tutoren", DataType.INTEGER)
      .build();
    
    Table pruefungen = table("pruefung")
        .description("Die Tabelle mit den Prüfungen der Hochschule")
        .column("id", DataType.BIGINT)
          .identifierColumn() 
          .autoInvokeNext()
        .column("lehrveranstaltung_id", DataType.BIGINT)
          .references(lehrveranstaltungen)
            .local("stoffVon")
              .description("Gibt an, zu welcher Lehrvanstaltung eine Prüfung gehört.")
            .remote("hatPruefung")
              .description("Ordnet Prüfungen einer Lehrveranstaltung zu.")
        .column("typ", DataType.VARCHAR)
        .column("zeitpunkt", DataType.DATE)
      .build();
    
    Table studenten = table("student")
        .description("Die Tabelle mit den immatrikulierten Studenten der Hochschule")
        .column("matrikelnummer", DataType.BIGINT)
          .identifierColumn() 
          .autoInvokeNext()
        .column("name", DataType.VARCHAR)
        .column("vorname", DataType.VARCHAR)
        .column("studiengang", DataType.VARCHAR)
        .column("semester", DataType.INTEGER)
        .column("immatrikuliert_seit", DataType.DATE)
      .build();

    table("beaufsichtigt")
        .column("professor_id", DataType.BIGINT)
          .references(professoren)
            .remote("beaufsichtigt")
              .description("Gibt an, welche Prüfungen ein Professor beaufsichtigt.")
        .column("pruefung_id", DataType.BIGINT)
          .references(pruefungen)
            .remote("beaufsichtigtVon")
              .description("Gibt an, welche Professoren eine Prüfung beaufsichtigen.")
      .build();
    
    table("besucht")
        .column("student_id", DataType.BIGINT)
          .references(studenten)
            .remote("besucht")
              .description("Gibt an, welche Lehrveranstaltungen ein Student besucht.")
        .column("lehrveranstaltung_id", DataType.BIGINT)
          .references(lehrveranstaltungen)
            .remote("besuchtVon")
              .description("Gibt an, welche Studenten eine Lehrveranstaltung besuchen.")
      .build();
    
    table("isttutor")
        .column("student_id", DataType.BIGINT)
          .references(studenten)
            .remote("istTutor")
              .description("Gibt an, bei welchen Lehrveranstaltungen ein Student Tutor ist.")
        .column("lehrveranstaltung_id", DataType.BIGINT)
          .references(lehrveranstaltungen)
            .remote("hatTutor")
              .description("Gibt an, welche Tutoren eine Lehrveranstaltung hat.")
      .build();
    
    table("schreibt")
        .column("student_id", DataType.BIGINT)
          .references(studenten)
            .remote("schreibt")
              .description("Gibt an, welche Prüfungen ein Student schreibt.")
        .column("pruefung_id", DataType.BIGINT)
          .references(pruefungen)
            .remote("geschriebenVon")
              .description("Gibt an, welche Studenten eine Prüfung schreiben.")
      .build();
  }
  
}
