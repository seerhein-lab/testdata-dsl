package com.seitenbau.testdatadsl.dbunitdemo.sbtesting;

import java.util.Date;
import com.seitenbau.testing.util.DateUtil;
import com.seitenbau.testing.util.date.Datum;
import com.seitenbau.testing.dbunit.extend.DatasetIdGenerator;

/* *******************************************************
  Generated via : codegeneration.GenerateDatabaseClasses
**********************************************************/
public class PruefungModel
{
  /** actual type : java.lang.Long */
  protected java.lang.Object id;
  /** actual type : java.lang.Long */
  protected java.lang.Object lehrveranstaltungId;
  /** actual type : java.lang.String */
  protected java.lang.Object typ;
  /** actual type : java.util.Date */
  protected java.lang.Object zeitpunkt;

  DatasetIdGenerator _generator;
  public void setIdGenerator(DatasetIdGenerator generator) 
  {
    _generator=generator;
  }

  public PruefungModel setId(Integer intValue)
  {
    id = (intValue==null?null:Long.valueOf(intValue));
    return this;
  }
  public PruefungModel setId(java.lang.Long value)
  {
    id = value;
    return this;
  }
  public PruefungModel setIdRaw(Object value)
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
  public PruefungModel nextId()
  {
    Long nextId = _generator.nextId("pruefung","id");
    setId(nextId);
    return this;
  }
  public PruefungModel setLehrveranstaltungId(Integer intValue)
  {
    lehrveranstaltungId = (intValue==null?null:Long.valueOf(intValue));
    return this;
  }
  public PruefungModel setLehrveranstaltungId(java.lang.Long value)
  {
    lehrveranstaltungId = value;
    return this;
  }
  public PruefungModel setLehrveranstaltungIdRaw(Object value)
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
  public PruefungModel setTyp(java.lang.String value)
  {
    typ = value;
    return this;
  }
  public PruefungModel setTypRaw(Object value)
  {
    typ =  value;
    return this;
  }
  public java.lang.String getTyp()
  {
    return (java.lang.String)  typ;
  }
  public java.lang.Object getTypRaw()
  {
    return typ;
  }
  public PruefungModel setZeitpunkt(String dateString)
  {
    zeitpunkt = DateUtil.asDate(dateString);
    return this;
  }
  public PruefungModel setZeitpunkt(Datum datum)
  {
    zeitpunkt = datum.asDate();
    return this;
  }
  public PruefungModel setZeitpunkt(java.util.Date value)
  {
    zeitpunkt = value;
    return this;
  }
  public PruefungModel setZeitpunktRaw(Object value)
  {
    zeitpunkt =  value;
    return this;
  }
  public java.util.Date getZeitpunkt()
  {
    return (java.util.Date)  zeitpunkt;
  }
  public java.lang.Object getZeitpunktRaw()
  {
    return zeitpunkt;
  }
 
}
