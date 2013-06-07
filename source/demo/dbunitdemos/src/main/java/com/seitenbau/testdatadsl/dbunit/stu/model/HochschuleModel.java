package com.seitenbau.testdatadsl.dbunit.stu.model;

import com.seitenbau.testing.dbunit.generator.DataType;
import com.seitenbau.testing.dbunit.generator.DatabaseModel;
import com.seitenbau.testing.dbunit.generator.Table;

public class HochschuleModel extends DatabaseModel {
  
  public HochschuleModel()
  {
    database("Hochschule");
    packageName("com.seitenbau.stu.dbunit.hochschule");
    
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
              .min(1)
              .max(1)
        .column("name", DataType.VARCHAR)
        .column("sws", DataType.INTEGER)
        .column("ects", DataType.DOUBLE)
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
              .min(1)
              .max(1)
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
              .max(1)
        .column("pruefung_id", DataType.BIGINT)
          .references(pruefungen)
            .remote("beaufsichtigtVon")
              .description("Gibt an, welche Professoren eine Prüfung beaufsichtigen.")
              .max(1)
      .build();
    
    table("besucht")
        .column("student_id", DataType.BIGINT)
          .references(studenten)
            .remote("besucht")
              .description("Gibt an, welche Lehrveranstaltungen ein Student besucht.")
              .max(1)
        .column("lehrveranstaltung_id", DataType.BIGINT)
          .references(lehrveranstaltungen)
            .remote("besuchtVon")
              .description("Gibt an, welche Studenten eine Lehrveranstaltung besuchen.")
              .max(1)
      .build();
    
    table("isttutor")
        .column("student_id", DataType.BIGINT)
          .references(studenten)
            .remote("istTutor")
              .description("Gibt an, bei welchen Lehrveranstaltungen ein Student Tutor ist.")
              .max(1)
        .column("lehrveranstaltung_id", DataType.BIGINT)
          .references(lehrveranstaltungen)
            .remote("hatTutor")
              .description("Gibt an, welche Tutoren eine Lehrveranstaltung hat.")
              .max(1)
      .build();
    
    table("schreibt")
        .column("student_id", DataType.BIGINT)
          .references(studenten)
            .remote("schreibt")
              .description("Gibt an, welche Prüfungen ein Student schreibt.")
              .max(1)
        .column("pruefung_id", DataType.BIGINT)
          .references(pruefungen)
            .remote("geschriebenVon")
              .description("Gibt an, welche Studenten eine Prüfung schreiben.")
              .max(1)
      .build();
  }
  
}
