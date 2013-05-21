package com.seitenbau.testdatadsl.dbunitdemo.dsl;

import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.dsl.LehrveranstaltungRef;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.dsl.ProfessorRef;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.dsl.PruefungRef;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.dsl.StudentRef;

public class DemoRefs {

  public static ProfessorRef WAESCH = new ProfessorRef();
  public static ProfessorRef HAASE = new ProfessorRef();
  
  public static LehrveranstaltungRef VSYS = new LehrveranstaltungRef();
  public static LehrveranstaltungRef DPATTERNS = new LehrveranstaltungRef();

  public static PruefungRef P_VSYS = new PruefungRef();
  public static PruefungRef P_DPATTERNS = new PruefungRef();

  public static StudentRef MOLL = new StudentRef();
  public static StudentRef MUSTERMANN = new StudentRef();
}