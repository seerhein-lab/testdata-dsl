package com.seitenbau.testdatadsl.dbunit.stu;

import static com.seitenbau.testdatadsl.dbunit.stu.HochschuleRefs.HAASE;
import static com.seitenbau.testdatadsl.dbunit.stu.HochschuleRefs.MUSTERMANN;
import static com.seitenbau.testdatadsl.dbunit.stu.HochschuleRefs.VSYS;

import com.seitenbau.testing.dbunit.dsl.DataSetRegistry;

public class HochschuleDemo
{

  public static void main(String[] args)
  {
    HochschuleDataSet dataSet = new HochschuleDataSet();
    println("VSYS name", dataSet.lehrveranstaltungTable.findWhere.name(VSYS).getName());

    String moll_name;
    Object moll_lvid;
    long moll_nr = 287336;
    String lvname = "Verteilte Systeme";

    long lvid = dataSet.lehrveranstaltungTable.findWhere.name(lvname).getId();
    Object profid = dataSet.lehrveranstaltungTable.findWhere.id(lvid).getProfessorId();
    String profname = profid != null ? dataSet.professorTable.findWhere.id((Long)profid).getName() : "null";
    println("Leiter von " + lvname, profname + " [erwartet: Haase]");



    moll_name = dataSet.studentTable.findWhere.matrikelnummer(moll_nr).getName();
    moll_lvid = dataSet.besuchtTable.findWhere.studentId(moll_nr).getLehrveranstaltungId();
    String moll_lvname = moll_lvid != null ? dataSet.lehrveranstaltungTable.findWhere.id((Long)moll_lvid).getName() : " null";
    println(moll_name + " besucht", moll_lvname);

    DataSetRegistry.use(dataSet);

    println("Nachname " + MUSTERMANN.getName() + " Count", dataSet.studentTable.findWhere.name(MUSTERMANN).getRowCount());
    println("Vorname " + MUSTERMANN.getVorname() + " Count", dataSet.studentTable.findWhere.vorname(MUSTERMANN).getRowCount());

    dataSet.professorTable.deleteRow(HAASE);
    println("HAASE REL COUNT: ", dataSet.beaufsichtigtTable.getWhere.professorId(HAASE).isPresent());
    dataSet.beaufsichtigtTable.deleteAllAssociations(HAASE);
    println("HAASE REL COUNT: ", dataSet.beaufsichtigtTable.getWhere.professorId(HAASE).isPresent());
   //dataSet.professorTable.deleteRow(HAASE);
  }

  private static void println(String message, Object value)
  {
    System.out.println(message + " = " + value);
  }

}
