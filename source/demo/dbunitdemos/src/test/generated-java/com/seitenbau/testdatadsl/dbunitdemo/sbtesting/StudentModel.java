package com.seitenbau.testdatadsl.dbunitdemo.sbtesting;

import java.util.Date;
import com.seitenbau.testing.util.DateUtil;
import com.seitenbau.testing.util.date.Datum;
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
 
}
