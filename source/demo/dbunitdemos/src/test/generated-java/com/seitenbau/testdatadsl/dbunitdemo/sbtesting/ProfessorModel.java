package com.seitenbau.testdatadsl.dbunitdemo.sbtesting;

import java.util.Date;
import com.seitenbau.testing.util.DateUtil;
import com.seitenbau.testing.util.date.Datum;
import com.seitenbau.testing.dbunit.extend.DatasetIdGenerator;

/* *******************************************************
  Generated via : codegeneration.GenerateDatabaseClasses
**********************************************************/
public class ProfessorModel
{
  /** actual type : java.lang.Long */
  protected java.lang.Object id;
  /** actual type : java.lang.String */
  protected java.lang.Object name;

  DatasetIdGenerator _generator;
  public void setIdGenerator(DatasetIdGenerator generator) 
  {
    _generator=generator;
  }

  public ProfessorModel setId(Integer intValue)
  {
    id = (intValue==null?null:Long.valueOf(intValue));
    return this;
  }
  public ProfessorModel setId(java.lang.Long value)
  {
    id = value;
    return this;
  }
  public ProfessorModel setIdRaw(Object value)
  {
    id =  value;
    return this;
  }
  public java.lang.Long getId()
  {
    return (java.lang.Long)  id;
  }
  public java.lang.Object getIdRaw()
  {
    return id;
  }
  public ProfessorModel nextId()
  {
    Long nextId = _generator.nextId("professor","ID");
    setId(nextId);
    return this;
  }
  public ProfessorModel setName(java.lang.String value)
  {
    name = value;
    return this;
  }
  public ProfessorModel setNameRaw(Object value)
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
