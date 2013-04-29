package com.seitenbau.testdatadsl.dbunitdemo.sbtesting;

import java.util.Date;
import com.seitenbau.testing.util.DateUtil;
import com.seitenbau.testing.util.date.DateBuilder;
import com.seitenbau.testing.dbunit.extend.DatasetIdGenerator;

/* *******************************************************
  Generated via : codegeneration.GenerateDatabaseClasses
**********************************************************/
public class BeaufsichtigtModel
{
  /** actual type : java.lang.Long */
  protected java.lang.Object professorId;
  /** actual type : java.lang.Long */
  protected java.lang.Object pruefungId;

  DatasetIdGenerator _generator;
  public void setIdGenerator(DatasetIdGenerator generator) 
  {
    _generator=generator;
  }

  public BeaufsichtigtModel setProfessorId(Integer intValue)
  {
    professorId = (intValue==null?null:Long.valueOf(intValue));
    return this;
  }
  public BeaufsichtigtModel setProfessorId(java.lang.Long value)
  {
    professorId = value;
    return this;
  }
  public BeaufsichtigtModel setProfessorIdRaw(Object value)
  {
    professorId =  value;
    return this;
  }
  public java.lang.Long getProfessorId()
  {
    return (java.lang.Long)  professorId;
  }
  public java.lang.Object getProfessorIdRaw()
  {
    return professorId;
  }
  public BeaufsichtigtModel setPruefungId(Integer intValue)
  {
    pruefungId = (intValue==null?null:Long.valueOf(intValue));
    return this;
  }
  public BeaufsichtigtModel setPruefungId(java.lang.Long value)
  {
    pruefungId = value;
    return this;
  }
  public BeaufsichtigtModel setPruefungIdRaw(Object value)
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
