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
          .relationTo(professoren)
            .local("geleitetVon")
              .description("Gibt an, von welchem Professor eine Lehrveranstaltung geleitet wird.")
            .target("leitet")
              .description("Gibt an, welche Lehrveranstaltungen ein Professor leitet.")
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
          .relationTo(lehrveranstaltungen)
            .local("stoffVon")
              .description("Gibt an, zu welcher Lehrvanstaltung eine Prüfung gehört.")
            .target("hatPruefung")
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
          .relationTo(professoren)
            .target("beaufsichtigt")
              .description("Gibt an, welche Prüfungen ein Professor beaufsichtigt.")
        .column("pruefung_id", DataType.BIGINT)
          .relationTo(pruefungen)
            .target("beaufsichtigtVon")
              .description("Gibt an, welche Professoren eine Prüfung beaufsichtigen.")
      .build();

    table("besucht")
        .column("student_id", DataType.BIGINT)
          .relationTo(studenten)
            .target("besucht")
              .description("Gibt an, welche Lehrveranstaltungen ein Student besucht.")
        .column("lehrveranstaltung_id", DataType.BIGINT)
          .relationTo(lehrveranstaltungen)
            .target("besuchtVon")
              .description("Gibt an, welche Studenten eine Lehrveranstaltung besuchen.")
      .build();

    table("isttutor")
        .column("student_id", DataType.BIGINT)
          .relationTo(studenten)
            .target("istTutor")
              .description("Gibt an, bei welchen Lehrveranstaltungen ein Student Tutor ist.")
        .column("lehrveranstaltung_id", DataType.BIGINT)
          .relationTo(lehrveranstaltungen)
            .target("hatTutor")
              .description("Gibt an, welche Tutoren eine Lehrveranstaltung hat.")
      .build();

    table("schreibt")
        .column("student_id", DataType.BIGINT)
          .relationTo(studenten)
            .target("schreibt")
              .description("Gibt an, welche Prüfungen ein Student schreibt.")
        .column("pruefung_id", DataType.BIGINT)
          .relationTo(pruefungen)
            .target("geschriebenVon")
              .description("Gibt an, welche Studenten eine Prüfung schreiben.")
      .build();
  }

}
