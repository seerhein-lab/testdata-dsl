package com.seitenbau.testdatadsl.dbunitdemo.sbtesting;

import java.util.Date;
import com.seitenbau.testing.util.DateUtil;
import com.seitenbau.testing.util.date.Datum;
import com.seitenbau.testing.dbunit.extend.DatasetIdGenerator;

/* *******************************************************
  Generated via : codegeneration.GenerateDatabaseClasses
**********************************************************/
public class SchreibtModel
{
  /** actual type : java.lang.Long */
  protected java.lang.Object studentId;
  /** actual type : java.lang.Long */
  protected java.lang.Object pruefungId;

  DatasetIdGenerator _generator;
  public void setIdGenerator(DatasetIdGenerator generator) 
  {
    _generator=generator;
  }

  public SchreibtModel setStudentId(Integer intValue)
  {
    studentId = (intValue==null?null:Long.valueOf(intValue));
    return this;
  }
  public SchreibtModel setStudentId(java.lang.Long value)
  {
    studentId = value;
    return this;
  }
  public SchreibtModel setStudentIdRaw(Object value)
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
  public SchreibtModel setPruefungId(Integer intValue)
  {
    pruefungId = (intValue==null?null:Long.valueOf(intValue));
    return this;
  }
  public SchreibtModel setPruefungId(java.lang.Long value)
  {
    pruefungId = value;
    return this;
  }
  public SchreibtModel setPruefungIdRaw(Object value)
  {
    pruefungId =  value;
    return this;
  }
  public java.lang.Long getPruefungId()
  {
    return (java.lang.Long)  pruefungId;
  }
  public java.lang.Object getPruefungIdRaw()
  {
    return pruefungId;
  }
 
}
