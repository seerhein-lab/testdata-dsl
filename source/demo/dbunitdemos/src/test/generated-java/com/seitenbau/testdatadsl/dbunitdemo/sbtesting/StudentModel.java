package com.seitenbau.testdatadsl.dbunitdemo.sbtesting;

import java.util.Date;
import com.seitenbau.testing.util.DateUtil;
import com.seitenbau.testing.util.date.DateBuilder;
import com.seitenbau.testing.dbunit.extend.DatasetIdGenerator;

/* *******************************************************
  Generated via : codegeneration.GenerateDatabaseClasses
**********************************************************/
public class StudentModel
{
  /** actual type : java.lang.Long */
  protected java.lang.Object matrikelnummer;
  /** actual type : java.lang.String */
  protected java.lang.Object name;
  /** actual type : java.lang.String */
  protected java.lang.Object vorname;
  /** actual type : java.lang.String */
  protected java.lang.Object studiengang;
  /** actual type : java.lang.Integer */
  protected java.lang.Object semester;
  /** actual type : java.util.Date */
  protected java.lang.Object immatrikuliertSeit;

  DatasetIdGenerator _generator;
  public void setIdGenerator(DatasetIdGenerator generator) 
  {
    _generator=generator;
  }

  public StudentModel setMatrikelnummer(Integer intValue)
  {
    matrikelnummer = (intValue==null?null:Long.valueOf(intValue));
    return this;
  }
  public StudentModel setMatrikelnummer(java.lang.Long value)
  {
    matrikelnummer = value;
    return this;
  }
  public StudentModel setMatrikelnummerRaw(Object value)
  {
    matrikelnummer =  value;
    return this;
  }
  public java.lang.Long getMatrikelnummer()
  {
    return (java.lang.Long)  matrikelnummer;
  }
  public java.lang.Object getMatrikelnummerRaw()
  {
    return matrikelnummer;
  }
  public StudentModel nextMatrikelnummer()
  {
    Long nextId = _generator.nextId("student","matrikelnummer");
    setMatrikelnummer(nextId);
    return this;
  }
  public StudentModel setName(java.lang.String value)
  {
    name = value;
    return this;
  }
  public StudentModel setNameRaw(Object value)
  {
    name =  value;
    return this;
  }
  public java.lang.String getName()
  {
    return (java.lang.String)  name;
  }
  public java.lang.Object getNameRaw()
  {
    return name;
  }
  public StudentModel setVorname(java.lang.String value)
  {
    vorname = value;
    return this;
  }
  public StudentModel setVornameRaw(Object value)
  {
    vorname =  value;
    return this;
  }
  public java.lang.String getVorname()
  {
    return (java.lang.String)  vorname;
  }
  public java.lang.Object getVornameRaw()
  {
    return vorname;
  }
  public StudentModel setStudiengang(java.lang.String value)
  {
    studiengang = value;
    return this;
  }
  public StudentModel setStudiengangRaw(Object value)
  {
    studiengang =  value;
    return this;
  }
  public java.lang.String getStudiengang()
  {
    return (java.lang.String)  studiengang;
  }
  public java.lang.Object getStudiengangRaw()
  {
    return studiengang;
  }
  public StudentModel setSemester(java.lang.Integer value)
  {
    semester = value;
    return this;
  }
  public StudentModel setSemesterRaw(Object value)
  {
    semester =  value;
    return this;
  }
  public java.lang.Integer getSemester()
  {
    return (java.lang.Integer)  semester;
  }
  public java.lang.Object getSemesterRaw()
  {
    return semester;
  }
  public StudentModel setImmatrikuliertSeit(String dateString)
  {
    immatrikuliertSeit = DateUtil.asDate(dateString);
    return this;
  }
  public StudentModel setImmatrikuliertSeit(DateBuilder datum)
  {
    immatrikuliertSeit = datum.asDate();
    return this;
  }
  public StudentModel setImmatrikuliertSeit(java.util.Date value)
  {
    immatrikuliertSeit = value;
    return this;
  }
  public StudentModel setImmatrikuliertSeitRaw(Object value)
  {
    immatrikuliertSeit =  value;
    return this;
  }
  public java.util.Date getImmatrikuliertSeit()
  {
    return (java.util.Date)  immatrikuliertSeit;
  }
  public java.lang.Object getImmatrikuliertSeitRaw()
  {
    return immatrikuliertSeit;
  }
 
}
