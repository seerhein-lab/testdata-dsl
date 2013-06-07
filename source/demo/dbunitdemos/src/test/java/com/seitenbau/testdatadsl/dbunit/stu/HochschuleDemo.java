package com.seitenbau.testdatadsl.dbunit.stu;

import com.seitenbau.testing.dbunit.dsl.ScopeRegistry;

import static com.seitenbau.testdatadsl.dbunit.stu.HochschuleRefs.*;
import com.seitenbau.testdatadsl.dbunit.stu.HochschuleDataSet;

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

    ScopeRegistry.use(dataSet);
   
    println("Nachname " + MUSTERMANN.getName() + " Count", dataSet.studentTable.findWhere.name(MUSTERMANN).getRowCount());
    println("Vorname " + MUSTERMANN.getVorname() + " Count", dataSet.studentTable.findWhere.vorname(MUSTERMANN).getRowCount());
  }

  private static void println(String message, Object value) 
  {
    System.out.println(message + " = " + value);
  }
  
}
