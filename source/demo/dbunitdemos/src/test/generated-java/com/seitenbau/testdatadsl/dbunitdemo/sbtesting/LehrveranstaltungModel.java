package com.seitenbau.testdatadsl.dbunitdemo.sbtesting;

import java.util.Date;
import com.seitenbau.testing.util.DateUtil;
import com.seitenbau.testing.util.date.Datum;
import com.seitenbau.testing.dbunit.extend.DatasetIdGenerator;

/* *******************************************************
  Generated via : codegeneration.GenerateDatabaseClasses
**********************************************************/
public class LehrveranstaltungModel
{
  /** actual type : java.lang.Long */
  protected java.lang.Object id;
  /** actual type : java.lang.Long */
  protected java.lang.Object professorId;
  /** actual type : java.lang.String */
  protected java.lang.Object name;

  DatasetIdGenerator _generator;
  public void setIdGenerator(DatasetIdGenerator generator) 
  {
    _generator=generator;
  }

  public LehrveranstaltungModel setId(Integer intValue)
  {
    id = (intValue==null?null:Long.valueOf(intValue));
    return this;
  }
  public LehrveranstaltungModel setId(java.lang.Long value)
  {
    id = value;
    return this;
  }
  public LehrveranstaltungModel setIdRaw(Object value)
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
  public LehrveranstaltungModel nextId()
  {
    Long nextId = _generator.nextId("lehrveranstaltung","id");
    setId(nextId);
    return this;
  }
  public LehrveranstaltungModel setProfessorId(Integer intValue)
  {
    professorId = (intValue==null?null:Long.valueOf(intValue));
    return this;
  }
  public LehrveranstaltungModel setProfessorId(java.lang.Long value)
  {
    professorId = value;
    return this;
  }
  public LehrveranstaltungModel setProfessorIdRaw(Object value)
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
  public LehrveranstaltungModel setName(java.lang.String value)
  {
    name = value;
    return this;
  }
  public LehrveranstaltungModel setNameRaw(Object value)
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
