package com.seitenbau.testdatadsl.dbunitdemo.sbtesting;

import java.util.Date;
import com.seitenbau.testing.util.DateUtil;
import com.seitenbau.testing.util.date.Datum;
import com.seitenbau.testing.dbunit.extend.DatasetIdGenerator;

/* *******************************************************
  Generated via : codegeneration.GenerateDatabaseClasses
**********************************************************/
public class BesuchtModel
{
  /** actual type : java.lang.Long */
  protected java.lang.Object studentId;
  /** actual type : java.lang.Long */
  protected java.lang.Object lehrveranstaltungId;

  DatasetIdGenerator _generator;
  public void setIdGenerator(DatasetIdGenerator generator) 
  {
    _generator=generator;
  }

  public BesuchtModel setStudentId(Integer intValue)
  {
    studentId = (intValue==null?null:Long.valueOf(intValue));
    return this;
  }
  public BesuchtModel setStudentId(java.lang.Long value)
  {
    studentId = value;
    return this;
  }
  public BesuchtModel setStudentIdRaw(Object value)
  {
    studentId =  value;
    return this;
  }
  public java.lang.Long getStudentId()
  {
    return (java.lang.Long)  studentId;
  }
  public java.lang.Object getStudentIdRaw()
  {
    return studentId;
  }
  public BesuchtModel setLehrveranstaltungId(Integer intValue)
  {
    lehrveranstaltungId = (intValue==null?null:Long.valueOf(intValue));
    return this;
  }
  public BesuchtModel setLehrveranstaltungId(java.lang.Long value)
  {
    lehrveranstaltungId = value;
    return this;
  }
  public BesuchtModel setLehrveranstaltungIdRaw(Object value)
  {
    lehrveranstaltungId =  value;
    return this;
  }
  public java.lang.Long getLehrveranstaltungId()
  {
    return (java.lang.Long)  lehrveranstaltungId;
  }
  public java.lang.Object getLehrveranstaltungIdRaw()
  {
    return lehrveranstaltungId;
  }
 
}
