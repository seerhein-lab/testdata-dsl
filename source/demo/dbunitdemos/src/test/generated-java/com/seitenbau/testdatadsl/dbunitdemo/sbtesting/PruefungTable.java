package com.seitenbau.testdatadsl.dbunitdemo.sbtesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Iterator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.EnumSet;
import java.util.Map;
import java.util.HashMap;

import org.dbunit.dataset.ITable;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.ITableMetaData;
import org.dbunit.dataset.DefaultTableMetaData;
import org.dbunit.dataset.RowOutOfBoundsException;
import org.dbunit.dataset.NoSuchColumnException;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.datatype.DataType;

import com.seitenbau.testing.dbunit.extend.DatasetIdGenerator;
import com.seitenbau.testing.dbunit.generator.Flags;
import com.seitenbau.testing.util.date.Datum;

import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.ProfessorTable.RowGetters_Professor;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.LehrveranstaltungTable.RowGetters_Lehrveranstaltung;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.PruefungTable.RowGetters_Pruefung;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.StudentTable.RowGetters_Student;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.BeaufsichtigtTable.RowGetters_Beaufsichtigt;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.BesuchtTable.RowGetters_Besucht;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.IsttutorTable.RowGetters_Isttutor;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.SchreibtTable.RowGetters_Schreibt;

import static com.seitenbau.testing.util.DateString.*;

/* *******************************************************
  Generated via : codegeneration.GenerateDatabaseClasses
**********************************************************/
public class PruefungTable implements ITable
{
  public final static String NAME = "pruefung";

  public static class Columns
  {
    public static final String Id = "id";
    public static final String LehrveranstaltungId = "lehrveranstaltung_id";
    public static final String Typ = "typ";
    public static final String Zeitpunkt = "zeitpunkt";
  }

  // @formatter:off
  public final static Column[] COLUMNS = new Column[] {
    // idx = 0
    new Column(Columns.Id, DataType.BIGINT),
    // idx = 1
    new Column(Columns.LehrveranstaltungId, DataType.BIGINT),
    // idx = 2
    new Column(Columns.Typ, DataType.VARCHAR),
    // idx = 3
    new Column(Columns.Zeitpunkt, DataType.DATE)
  };

  static Map<String, EnumSet<Flags>> GENERATOR_METADATA;
  static {
    GENERATOR_METADATA = new HashMap<String, EnumSet<Flags>>();
    GENERATOR_METADATA.put(Columns.Id,EnumSet.of( Flags.AutoInvokeNextIdMethod));
    GENERATOR_METADATA.put(Columns.LehrveranstaltungId,EnumSet.noneOf( Flags.class ));
    GENERATOR_METADATA.put(Columns.Typ,EnumSet.noneOf( Flags.class ));
    GENERATOR_METADATA.put(Columns.Zeitpunkt,EnumSet.noneOf( Flags.class ));
  }
  // @formatter:on

  ITableMetaData _metaData;
  
  DBUnitExamplesDataSet _dataSet;
  
  Iterator<RowBuilder_Pruefung> _iterator;
  
  public PruefungTable()
  {
    _metaData=new DefaultTableMetaData(NAME, COLUMNS);
  }

  public void setDataset(DBUnitExamplesDataSet dataSet)
  {
    _dataSet=dataSet;
  }
  
  public DBUnitExamplesDataSet getDataset()
  {
    return _dataSet;
  }

  public List<RowBuilder_Pruefung> rows = new ArrayList<RowBuilder_Pruefung>();
  
  public interface RowSetters_Pruefung<T extends RowSetters_Pruefung>
  {
    T setId(Integer intValue);
    T setId(java.lang.Long value);
    T setIdRaw(Object value);
    T nextId();
    T setLehrveranstaltungId(Integer intValue);
    T setLehrveranstaltungId(java.lang.Long value);
    T setLehrveranstaltungIdRaw(Object value);
    T setTyp(java.lang.String value);
    T setTypRaw(Object value);
    T setZeitpunkt(String dateString);
    T setZeitpunkt(Datum datum);
    T setZeitpunkt(java.util.Date value);
    T setZeitpunktRaw(Object value);
     
  }
  
  public interface RowGetters_Pruefung<T extends RowGetters_Pruefung>
  {
    java.lang.Long getId();
    java.lang.Long getLehrveranstaltungId();
    java.lang.String getTyp();
    java.util.Date getZeitpunkt();
     
  }

  public static class RowBuilder_Pruefung implements RowSetters_Pruefung<RowBuilder_Pruefung>, RowGetters_Pruefung<RowBuilder_Pruefung>
  {

    Object[] data;
    
    PruefungTable table;
    
    RowBuilder_Pruefung(PruefungTable tableDelegate) {
      data=new Object[COLUMNS.length];
      table = tableDelegate;
    }
    

    public RowBuilder_Pruefung setId(Integer intValue)
    {
      data[ 0 ] = (intValue==null?null:Long.valueOf(intValue));
      return this;
    }
    public RowBuilder_Pruefung setId(java.lang.Long value)
    {
      data[ 0 ] = value;
      return this;
    }
    public RowBuilder_Pruefung setIdRaw(Object value)
    {
      data[ 0 ] = value;
      return this;
    }
    public RowBuilder_Pruefung nextId()
    {
      DatasetIdGenerator generator = table.getDataset().getIdGenerator();
      Long nextId = generator.nextId(PruefungTable.NAME,"id");
      setId(nextId);
      return this;
    }

    public java.lang.Long getId()
    {
      return (java.lang.Long) data[0];
    }

    public RowBuilder_Pruefung setLehrveranstaltungId(Integer intValue)
    {
      data[ 1 ] = (intValue==null?null:Long.valueOf(intValue));
      return this;
    }
    public RowBuilder_Pruefung setLehrveranstaltungId(java.lang.Long value)
    {
      data[ 1 ] = value;
      return this;
    }
    public RowBuilder_Pruefung setLehrveranstaltungIdRaw(Object value)
    {
      data[ 1 ] = value;
      return this;
    }

    public java.lang.Long getLehrveranstaltungId()
    {
      return (java.lang.Long) data[1];
    }

    public RowBuilder_Pruefung setTyp(java.lang.String value)
    {
      data[ 2 ] = value;
      return this;
    }
    public RowBuilder_Pruefung setTypRaw(Object value)
    {
      data[ 2 ] = value;
      return this;
    }

    public java.lang.String getTyp()
    {
      return (java.lang.String) data[2];
    }

    public RowBuilder_Pruefung setZeitpunkt(String dateString)
    {
      data[ 3 ] = toDate(dateString);
      return this;
    }
    public RowBuilder_Pruefung setZeitpunkt(Datum datum)
    {
      data[ 3 ] = toDate(datum);
      return this;
    }
    public RowBuilder_Pruefung setZeitpunkt(java.util.Date value)
    {
      data[ 3 ] = value;
      return this;
    }
    public RowBuilder_Pruefung setZeitpunktRaw(Object value)
    {
      data[ 3 ] = value;
      return this;
    }

    public java.util.Date getZeitpunkt()
    {
      return (java.util.Date) data[3];
    }
    /**
    * Insert a new Row at the end of the Table
    * <code><pre>
    * ds.table_Pruefung.insertRow()
    *   .setId( null )
    *   .setLehrveranstaltungId( null )
    *   .setTyp( null )
    *   .setZeitpunkt( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Pruefung insertRow()
    {
      return table.insertRow();
    }
    
    /**
    * Insert a new Row at the end of the Table
    * <code><pre>
    * ds.table_Pruefung.insertRow()
    *   .setId( null )
    *   .setLehrveranstaltungId( null )
    *   .setTyp( null )
    *   .setZeitpunkt( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Pruefung insertRow(PruefungModel row)
    {
      return table.insertRow(row);
    }
    
    /**
    * Insert a new Row at the given position
    * <code><pre>
    * ds.table_Pruefung.this.insertRowAt(2)
    *   .setId( null )
    *   .setLehrveranstaltungId( null )
    *   .setTyp( null )
    *   .setZeitpunkt( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Pruefung insertRowAt(int index)
    {
      return table.insertRowAt(index);
    }

    /**
    * Insert a row at the end of the table
    * <code><pre>
    * ds.table_Pruefung.insertRow(baseUser);
    * </pre></code>
    */
    public RowBuilder_Pruefung insertRow(RowBuilder_Pruefung theRow)
    {
      return table.insertRow(theRow);
    }
    
    public Object getValue(String column) throws RuntimeException {
      if(column.equals("id") ) {
        return data[0];
      }
      if(column.equals("lehrveranstaltung_id") ) {
        return data[1];
      }
      if(column.equals("typ") ) {
        return data[2];
      }
      if(column.equals("zeitpunkt") ) {
        return data[3];
      }
      throw new RuntimeException(NAME + " col = " + column);
    }
    

    public RowBuilder_Pruefung refLehrveranstaltungId(RowGetters_Lehrveranstaltung reference)
    {
      setLehrveranstaltungId(reference.getId());
      return this;
    }
    
    @Override
    public RowBuilder_Pruefung clone() {
      RowBuilder_Pruefung clone = new RowBuilder_Pruefung(table);
      clone.setId(getId());
      clone.setLehrveranstaltungId(getLehrveranstaltungId());
      clone.setTyp(getTyp());
      clone.setZeitpunkt(getZeitpunkt());
      return clone;
    }
  }
  
  public PruefungWhere findWhere = new PruefungWhere(this);

  public static class PruefungWhere
  {
    public List<RowBuilder_Pruefung> rows;
    PruefungTable table;
    
    public PruefungWhere(PruefungTable theTable) {
       rows = theTable.rows;
       table = theTable;
    }
    
    public RowCollection_Pruefung rowComparesTo(Comparable<RowBuilder_Pruefung> toSearch) {
      RowCollection_Pruefung modifiers = new RowCollection_Pruefung(table);
      for (RowBuilder_Pruefung row : rows) 
      {
        if (toSearch.compareTo( row ) == 0) 
        {
          modifiers.add(row);
        }
      }
      if(modifiers.isEmpty()) {
        throw new RuntimeException("No Row with ${column.name} = " + toSearch );
      }
      return modifiers;
    }
    public RowCollection_Pruefung id(java.lang.Long toSearch) {
      RowCollection_Pruefung modifiers = new RowCollection_Pruefung(table);
      for (RowBuilder_Pruefung row : rows) 
      {
        if (row.getId().equals(toSearch)) 
        {
          modifiers.add(row);
        }
      }
      if(modifiers.isEmpty()) {
        throw new RuntimeException("No Row with id = " + toSearch );
      }
      return modifiers;
    }
    public RowCollection_Pruefung id(Integer toSearch) 
    {
      return id( Long.valueOf(toSearch) );
    }
    public RowCollection_Pruefung lehrveranstaltungId(java.lang.Long toSearch) {
      RowCollection_Pruefung modifiers = new RowCollection_Pruefung(table);
      for (RowBuilder_Pruefung row : rows) 
      {
        if (row.getLehrveranstaltungId().equals(toSearch)) 
        {
          modifiers.add(row);
        }
      }
      if(modifiers.isEmpty()) {
        throw new RuntimeException("No Row with lehrveranstaltung_id = " + toSearch );
      }
      return modifiers;
    }
    public RowCollection_Pruefung lehrveranstaltungId(Integer toSearch) 
    {
      return lehrveranstaltungId( Long.valueOf(toSearch) );
    }
    public RowCollection_Pruefung typ(java.lang.String toSearch) {
      RowCollection_Pruefung modifiers = new RowCollection_Pruefung(table);
      for (RowBuilder_Pruefung row : rows) 
      {
        if (row.getTyp().equals(toSearch)) 
        {
          modifiers.add(row);
        }
      }
      if(modifiers.isEmpty()) {
        throw new RuntimeException("No Row with typ = " + toSearch );
      }
      return modifiers;
    }
    public RowCollection_Pruefung zeitpunkt(java.util.Date toSearch) {
      RowCollection_Pruefung modifiers = new RowCollection_Pruefung(table);
      for (RowBuilder_Pruefung row : rows) 
      {
        if (row.getZeitpunkt().equals(toSearch)) 
        {
          modifiers.add(row);
        }
      }
      if(modifiers.isEmpty()) {
        throw new RuntimeException("No Row with zeitpunkt = " + toSearch );
      }
      return modifiers;
    }
  }
  
  /** Inner class! Use RowCollection_Pruefung in your code ! */
  public static class RowModify_Pruefung extends RowBuilder_Pruefung 
  {
      List<RowBuilder_Pruefung> _rows;

      public RowModify_Pruefung(PruefungTable theTable) {
        super(theTable);
        _rows = new ArrayList<RowBuilder_Pruefung>();
      }
      
      public void add(RowBuilder_Pruefung row) {
          _rows.add(row);
      }
      
      public boolean isEmpty() {
          return _rows.isEmpty();
      }

      public RowModify_Pruefung delete() {
          for(RowBuilder_Pruefung row : _rows) {
            table.rows.remove(row);
          }
          return this;
      }
        

      public RowModify_Pruefung setId(Integer intValue)
      {
        for(RowBuilder_Pruefung row : _rows) {
          row.setId(intValue);
        }
        return this;
      }

      public RowModify_Pruefung setId(java.lang.Long value)
      {
        for(RowBuilder_Pruefung row : _rows) {
          row.setId(value);
        }
        return this;
      }
      public RowModify_Pruefung setIdRaw(Object value)
      {
        for(RowBuilder_Pruefung row : _rows) {
          row.setIdRaw(value);
        }
        return this;
      }
      public java.lang.Long getId()
      {
        if(_rows.size()!=1) {
          throw new RuntimeException("There where multiple Row in the result! " + _rows.size() );
        }
        return _rows.get(0).getId();
      }

      public RowModify_Pruefung setLehrveranstaltungId(Integer intValue)
      {
        for(RowBuilder_Pruefung row : _rows) {
          row.setLehrveranstaltungId(intValue);
        }
        return this;
      }

      public RowModify_Pruefung setLehrveranstaltungId(java.lang.Long value)
      {
        for(RowBuilder_Pruefung row : _rows) {
          row.setLehrveranstaltungId(value);
        }
        return this;
      }
      public RowModify_Pruefung setLehrveranstaltungIdRaw(Object value)
      {
        for(RowBuilder_Pruefung row : _rows) {
          row.setLehrveranstaltungIdRaw(value);
        }
        return this;
      }
      public java.lang.Long getLehrveranstaltungId()
      {
        if(_rows.size()!=1) {
          throw new RuntimeException("There where multiple Row in the result! " + _rows.size() );
        }
        return _rows.get(0).getLehrveranstaltungId();
      }

      public RowModify_Pruefung setTyp(java.lang.String value)
      {
        for(RowBuilder_Pruefung row : _rows) {
          row.setTyp(value);
        }
        return this;
      }
      public RowModify_Pruefung setTypRaw(Object value)
      {
        for(RowBuilder_Pruefung row : _rows) {
          row.setTypRaw(value);
        }
        return this;
      }
      public java.lang.String getTyp()
      {
        if(_rows.size()!=1) {
          throw new RuntimeException("There where multiple Row in the result! " + _rows.size() );
        }
        return _rows.get(0).getTyp();
      }

      public RowModify_Pruefung setZeitpunkt(String dateString)
      {
        for(RowBuilder_Pruefung row : _rows) {
          row.setZeitpunkt(dateString);
        }
        return this;
      }
      public RowModify_Pruefung setZeitpunkt(Datum datum)
      {
        for(RowBuilder_Pruefung row : _rows) {
          row.setZeitpunkt(datum);
        }
        return this;
      }
      public RowModify_Pruefung setZeitpunkt(java.util.Date value)
      {
        for(RowBuilder_Pruefung row : _rows) {
          row.setZeitpunkt(value);
        }
        return this;
      }
      public RowModify_Pruefung setZeitpunktRaw(Object value)
      {
        for(RowBuilder_Pruefung row : _rows) {
          row.setZeitpunktRaw(value);
        }
        return this;
      }
      public java.util.Date getZeitpunkt()
      {
        if(_rows.size()!=1) {
          throw new RuntimeException("There where multiple Row in the result! " + _rows.size() );
        }
        return _rows.get(0).getZeitpunkt();
      }
      public Object getValue(String column)
      {
        if(_rows.size()!=1) {
          throw new RuntimeException("There where multiple Row in the result! " + _rows.size() );
        }
        return _rows.get(0).getValue(column);
      }
      
      /** 
       * Return the count of rows contained in this collection
       */
      public int getRowCount()
      {
        return _rows.size();
      }
      
      @Override
      public RowModify_Pruefung clone() {
        RowModify_Pruefung clone = new RowModify_Pruefung(table);
        for(RowBuilder_Pruefung row:_rows) {
          clone._rows.add(row.clone());
        }
        return clone;
      }

  }
  
  public static class RowCollection_Pruefung extends RowModify_Pruefung {
    public PruefungWhere where = new PruefungWhere(table);
    
    public RowCollection_Pruefung(PruefungTable theTable)
    {
      super(theTable);
    }
    
  }

  /**
  * Insert a new empty Row.
  * <code><pre>
  * ds.table_Pruefung.insertRow()
  *   .setId( null )
  *   .setLehrveranstaltungId( null )
  *   .setTyp( null )
  *   .setZeitpunkt( null )
  *   ;
  * </pre></code>
  */
  public RowBuilder_Pruefung insertRow()
  {
    RowBuilder_Pruefung row = new RowBuilder_Pruefung(this);
    row.nextId();
    rows.add(row);
    return row;
  }
  
  /**
  * <code><pre>
  * ds.table_Pruefung.insertRow()
  * </pre></code>
  */
  public RowBuilder_Pruefung insertRow(PruefungModel rowToAdd)
  {
    RowBuilder_Pruefung row = new RowBuilder_Pruefung(this);
    row.setIdRaw( rowToAdd.getIdRaw() );
    row.setLehrveranstaltungIdRaw( rowToAdd.getLehrveranstaltungIdRaw() );
    row.setTypRaw( rowToAdd.getTypRaw() );
    row.setZeitpunktRaw( rowToAdd.getZeitpunktRaw() );
    rows.add(row);
    return row;
  }

  /**
  * <code><pre>
  * ds.table_Pruefung.insertRow(data);
  * </pre></code>
  */
  public RowBuilder_Pruefung insertRow(RowBuilder_Pruefung theRow)
  {
    rows.add(theRow);
    return theRow;
  }
  
  /**
  * <code><pre>
  * ds.table_Pruefung.insertRows(data);
  * </pre></code>
  */
  public void insertRows(RowBuilder_Pruefung...theRows)
  {
    rows.addAll(Arrays.asList(theRows));
  }
  
  /**
  * Insert new row at the given index
  * <code><pre>
  * ds.table_Pruefung.insertRowAt(3)
  *   ;
  * </pre></code>
  */
  public RowBuilder_Pruefung insertRowAt(int index)
  {
    RowBuilder_Pruefung row = new RowBuilder_Pruefung(this);
    rows.add(index, row);
    return row;
  }
  
  /**
  * Insert new row Object at the given index
  * <code><pre>
  * ds.table_Pruefung.insertRowAt(3)
  * </pre></code>
  */
  public RowBuilder_Pruefung insertRowAt(int index,RowBuilder_Pruefung theRow)
  {
    rows.add(index, theRow);
    return theRow;
  }
  
  /**
   * Remove a row from the builder by the given index.
   *
   * @return the deleted row
   */ 
  public RowBuilder_Pruefung deleteRow(int index)
  {
    RowBuilder_Pruefung rowBuilder = rows.get(index);
    rows.remove(rowBuilder);
    return rowBuilder;
  }
  
  /**
   * Remove a row from the builder
   */ 
  public RowBuilder_Pruefung deleteRow(RowBuilder_Pruefung rowToDelete)
  {
    rows.remove(rowToDelete);
    return rowToDelete;
  }

  /**
  * Creates a new row but does not add it to the table
  */
  public RowBuilder_Pruefung newRow()
  {
    RowBuilder_Pruefung row = new RowBuilder_Pruefung(this);
    return row;
  }
  
  /**
  * Returns the next Object. The internal iterator is started at 
  * the first call.
  */
  public RowBuilder_Pruefung next()
  {
    if(_iterator == null) {
      _iterator = rows.iterator();
    }
    return _iterator.next();
  }
  
  public void resetIterator() {
    _iterator = null;
  }

  public ITableMetaData getTableMetaData() {
      return _metaData;
  }
  
  public int getRowCount() {
      return rows.size();
  }
   
  public Object getValue(int row, String column) throws DataSetException {
      if (row >= rows.size() || row < 0) {
        throw new RowOutOfBoundsException();
      }
      return rows.get(row).getValue(column);
  }

  static Date toDate(String dateString)
  {
    return asDate(dateString);
  }
  
  static Date toDate(Datum datum)
  {
    return datum.asDate();
  }
 
}
