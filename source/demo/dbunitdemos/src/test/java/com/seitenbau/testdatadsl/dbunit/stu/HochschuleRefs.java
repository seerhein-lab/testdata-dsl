package com.seitenbau.testdatadsl.dbunit.stu;

import com.seitenbau.stu.dbunit.hochschule.LehrveranstaltungRef;
import com.seitenbau.stu.dbunit.hochschule.ProfessorRef;
import com.seitenbau.stu.dbunit.hochschule.PruefungRef;
import com.seitenbau.stu.dbunit.hochschule.RefFactory;
import com.seitenbau.stu.dbunit.hochschule.StudentRef;

public class HochschuleRefs {

  public static ProfessorRef WAESCH = RefFactory.createProfessorRef();
  public static ProfessorRef HAASE = RefFactory.createProfessorRef();
  
  public static LehrveranstaltungRef VSYS = RefFactory.createLehrveranstaltungRef();
  public static LehrveranstaltungRef DPATTERNS = RefFactory.createLehrveranstaltungRef();

  public static PruefungRef P_VSYS = RefFactory.createPruefungRef();
  public static PruefungRef P_DPATTERNS = RefFactory.createPruefungRef();

  public static StudentRef MOLL = RefFactory.createStudentRef();
  public static StudentRef MUSTERMANN = RefFactory.createStudentRef();
}