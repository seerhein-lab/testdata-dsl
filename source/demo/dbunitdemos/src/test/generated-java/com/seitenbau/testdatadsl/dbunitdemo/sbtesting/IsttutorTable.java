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
public class IsttutorTable implements ITable
{
  public final static String NAME = "isttutor";

  public static class Columns
  {
    public static final String StudentId = "studentID";
    public static final String LehrveranstaltungId = "lehrveranstaltungID";
  }

  // @formatter:off
  public final static Column[] COLUMNS = new Column[] {
    // idx = 0
    new Column(Columns.StudentId, DataType.BIGINT),
    // idx = 1
    new Column(Columns.LehrveranstaltungId, DataType.BIGINT)
  };

  static Map<String, EnumSet<Flags>> GENERATOR_METADATA;
  static {
    GENERATOR_METADATA = new HashMap<String, EnumSet<Flags>>();
    GENERATOR_METADATA.put(Columns.StudentId,EnumSet.noneOf( Flags.class ));
    GENERATOR_METADATA.put(Columns.LehrveranstaltungId,EnumSet.noneOf( Flags.class ));
  }
  // @formatter:on

  ITableMetaData _metaData;
  
  DBUnitDemoDataSet _dataSet;
  
  Iterator<RowBuilder_Isttutor> _iterator;
  
  public IsttutorTable()
  {
    _metaData=new DefaultTableMetaData(NAME, COLUMNS);
  }

  public void setDataset(DBUnitDemoDataSet dataSet)
  {
    _dataSet=dataSet;
  }
  
  public DBUnitDemoDataSet getDataset()
  {
    return _dataSet;
  }

  public List<RowBuilder_Isttutor> rows = new ArrayList<RowBuilder_Isttutor>();
  
  public interface RowSetters_Isttutor<T extends RowSetters_Isttutor>
  {
    T setStudentId(Integer intValue);
    T setStudentId(java.lang.Long value);
    T setStudentIdRaw(Object value);
    T setLehrveranstaltungId(Integer intValue);
    T setLehrveranstaltungId(java.lang.Long value);
    T setLehrveranstaltungIdRaw(Object value);
     
  }
  
  public interface RowGetters_Isttutor<T extends RowGetters_Isttutor>
  {
    java.lang.Long getStudentId();
    java.lang.Long getLehrveranstaltungId();
     
  }

  public static class RowBuilder_Isttutor implements RowSetters_Isttutor<RowBuilder_Isttutor>, RowGetters_Isttutor<RowBuilder_Isttutor>
  {

    Object[] data;
    
    IsttutorTable table;
    
    RowBuilder_Isttutor(IsttutorTable tableDelegate) {
      data=new Object[COLUMNS.length];
      table = tableDelegate;
    }
    

    public RowBuilder_Isttutor setStudentId(Integer intValue)
    {
      data[ 0 ] = (intValue==null?null:Long.valueOf(intValue));
      return this;
    }
    public RowBuilder_Isttutor setStudentId(java.lang.Long value)
    {
      data[ 0 ] = value;
      return this;
    }
    public RowBuilder_Isttutor setStudentIdRaw(Object value)
    {
      data[ 0 ] = value;
      return this;
    }

    public java.lang.Long getStudentId()
    {
      return (java.lang.Long) data[0];
    }

    public RowBuilder_Isttutor setLehrveranstaltungId(Integer intValue)
    {
      data[ 1 ] = (intValue==null?null:Long.valueOf(intValue));
      return this;
    }
    public RowBuilder_Isttutor setLehrveranstaltungId(java.lang.Long value)
    {
      data[ 1 ] = value;
      return this;
    }
    public RowBuilder_Isttutor setLehrveranstaltungIdRaw(Object value)
    {
      data[ 1 ] = value;
      return this;
    }

    public java.lang.Long getLehrveranstaltungId()
    {
      return (java.lang.Long) data[1];
    }
    /**
    * Insert a new Row at the end of the Table
    * <code><pre>
    * ds.table_Isttutor.insertRow()
    *   .setStudentId( null )
    *   .setLehrveranstaltungId( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Isttutor insertRow()
    {
      return table.insertRow();
    }
    
    /**
    * Insert a new Row at the end of the Table
    * <code><pre>
    * ds.table_Isttutor.insertRow()
    *   .setStudentId( null )
    *   .setLehrveranstaltungId( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Isttutor insertRow(IsttutorModel row)
    {
      return table.insertRow(row);
    }
    
    /**
    * Insert a new Row at the given position
    * <code><pre>
    * ds.table_Isttutor.this.insertRowAt(2)
    *   .setStudentId( null )
    *   .setLehrveranstaltungId( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Isttutor insertRowAt(int index)
    {
      return table.insertRowAt(index);
    }

    /**
    * Insert a row at the end of the table
    * <code><pre>
    * ds.table_Isttutor.insertRow(baseUser);
    * </pre></code>
    */
    public RowBuilder_Isttutor insertRow(RowBuilder_Isttutor theRow)
    {
      return table.insertRow(theRow);
    }
    
    public Object getValue(String column) throws RuntimeException {
      if(column.equals("studentID") ) {
        return data[0];
      }
      if(column.equals("lehrveranstaltungID") ) {
        return data[1];
      }
      throw new RuntimeException(NAME + " col = " + column);
    }
    

    public RowBuilder_Isttutor refStudentId(RowGetters_Student reference)
    {
      setStudentId(reference.getMatrikelnummer());
      return this;
    }

    public RowBuilder_Isttutor refLehrveranstaltungId(RowGetters_Lehrveranstaltung reference)
    {
      setLehrveranstaltungId(reference.getId());
      return this;
    }
    
    @Override
    public RowBuilder_Isttutor clone() {
      RowBuilder_Isttutor clone = new RowBuilder_Isttutor(table);
      clone.setStudentId(getStudentId());
      clone.setLehrveranstaltungId(getLehrveranstaltungId());
      return clone;
    }
  }
  
  public IsttutorWhere findWhere = new IsttutorWhere(this);

  public static class IsttutorWhere
  {
    public List<RowBuilder_Isttutor> rows;
    IsttutorTable table;
    
    public IsttutorWhere(IsttutorTable theTable) {
       rows = theTable.rows;
       table = theTable;
    }
    
    public RowCollection_Isttutor rowComparesTo(Comparable<RowBuilder_Isttutor> toSearch) {
      RowCollection_Isttutor modifiers = new RowCollection_Isttutor(table);
      for (RowBuilder_Isttutor row : rows) 
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
    public RowCollection_Isttutor studentId(java.lang.Long toSearch) {
      RowCollection_Isttutor modifiers = new RowCollection_Isttutor(table);
      for (RowBuilder_Isttutor row : rows) 
      {
        if (row.getStudentId().equals(toSearch)) 
        {
          modifiers.add(row);
        }
      }
      if(modifiers.isEmpty()) {
        throw new RuntimeException("No Row with studentID = " + toSearch );
      }
      return modifiers;
    }
    public RowCollection_Isttutor studentId(Integer toSearch) 
    {
      return studentId( Long.valueOf(toSearch) );
    }
    public RowCollection_Isttutor lehrveranstaltungId(java.lang.Long toSearch) {
      RowCollection_Isttutor modifiers = new RowCollection_Isttutor(table);
      for (RowBuilder_Isttutor row : rows) 
      {
        if (row.getLehrveranstaltungId().equals(toSearch)) 
        {
          modifiers.add(row);
        }
      }
      if(modifiers.isEmpty()) {
        throw new RuntimeException("No Row with lehrveranstaltungID = " + toSearch );
      }
      return modifiers;
    }
    public RowCollection_Isttutor lehrveranstaltungId(Integer toSearch) 
    {
      return lehrveranstaltungId( Long.valueOf(toSearch) );
    }
  }
  
  /** Inner class! Use RowCollection_Isttutor in your code ! */
  public static class RowModify_Isttutor extends RowBuilder_Isttutor 
  {
      List<RowBuilder_Isttutor> _rows;

      public RowModify_Isttutor(IsttutorTable theTable) {
        super(theTable);
        _rows = new ArrayList<RowBuilder_Isttutor>();
      }
      
      public void add(RowBuilder_Isttutor row) {
          _rows.add(row);
      }
      
      public boolean isEmpty() {
          return _rows.isEmpty();
      }

      public RowModify_Isttutor delete() {
          for(RowBuilder_Isttutor row : _rows) {
            table.rows.remove(row);
          }
          return this;
      }
        

      public RowModify_Isttutor setStudentId(Integer intValue)
      {
        for(RowBuilder_Isttutor row : _rows) {
          row.setStudentId(intValue);
        }
        return this;
      }

      public RowModify_Isttutor setStudentId(java.lang.Long value)
      {
        for(RowBuilder_Isttutor row : _rows) {
          row.setStudentId(value);
        }
        return this;
      }
      public RowModify_Isttutor setStudentIdRaw(Object value)
      {
        for(RowBuilder_Isttutor row : _rows) {
          row.setStudentIdRaw(value);
        }
        return this;
      }
      public java.lang.Long getStudentId()
      {
        if(_rows.size()!=1) {
          throw new RuntimeException("There where multiple Row in the result! " + _rows.size() );
        }
        return _rows.get(0).getStudentId();
      }

      public RowModify_Isttutor setLehrveranstaltungId(Integer intValue)
      {
        for(RowBuilder_Isttutor row : _rows) {
          row.setLehrveranstaltungId(intValue);
        }
        return this;
      }

      public RowModify_Isttutor setLehrveranstaltungId(java.lang.Long value)
      {
        for(RowBuilder_Isttutor row : _rows) {
          row.setLehrveranstaltungId(value);
        }
        return this;
      }
      public RowModify_Isttutor setLehrveranstaltungIdRaw(Object value)
      {
        for(RowBuilder_Isttutor row : _rows) {
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
      public RowModify_Isttutor clone() {
        RowModify_Isttutor clone = new RowModify_Isttutor(table);
        for(RowBuilder_Isttutor row:_rows) {
          clone._rows.add(row.clone());
        }
        return clone;
      }

  }
  
  public static class RowCollection_Isttutor extends RowModify_Isttutor {
    public IsttutorWhere where = new IsttutorWhere(table);
    
    public RowCollection_Isttutor(IsttutorTable theTable)
    {
      super(theTable);
    }
    
  }

  /**
  * Insert a new empty Row.
  * <code><pre>
  * ds.table_Isttutor.insertRow()
  *   .setStudentId( null )
  *   .setLehrveranstaltungId( null )
  *   ;
  * </pre></code>
  */
  public RowBuilder_Isttutor insertRow()
  {
    RowBuilder_Isttutor row = new RowBuilder_Isttutor(this);
    rows.add(row);
    return row;
  }
  
  /**
  * <code><pre>
  * ds.table_Isttutor.insertRow()
  * </pre></code>
  */
  public RowBuilder_Isttutor insertRow(IsttutorModel rowToAdd)
  {
    RowBuilder_Isttutor row = new RowBuilder_Isttutor(this);
    row.setStudentIdRaw( rowToAdd.getStudentIdRaw() );
    row.setLehrveranstaltungIdRaw( rowToAdd.getLehrveranstaltungIdRaw() );
    rows.add(row);
    return row;
  }

  /**
  * <code><pre>
  * ds.table_Isttutor.insertRow(data);
  * </pre></code>
  */
  public RowBuilder_Isttutor insertRow(RowBuilder_Isttutor theRow)
  {
    rows.add(theRow);
    return theRow;
  }
  
  /**
  * <code><pre>
  * ds.table_Isttutor.insertRows(data);
  * </pre></code>
  */
  public void insertRows(RowBuilder_Isttutor...theRows)
  {
    rows.addAll(Arrays.asList(theRows));
  }
  
  /**
  * Insert new row at the given index
  * <code><pre>
  * ds.table_Isttutor.insertRowAt(3)
  *   ;
  * </pre></code>
  */
  public RowBuilder_Isttutor insertRowAt(int index)
  {
    RowBuilder_Isttutor row = new RowBuilder_Isttutor(this);
    rows.add(index, row);
    return row;
  }
  
  /**
  * Insert new row Object at the given index
  * <code><pre>
  * ds.table_Isttutor.insertRowAt(3)
  * </pre></code>
  */
  public RowBuilder_Isttutor insertRowAt(int index,RowBuilder_Isttutor theRow)
  {
    rows.add(index, theRow);
    return theRow;
  }
  
  /**
   * Remove a row from the builder by the given index.
   *
   * @return the deleted row
   */ 
  public RowBuilder_Isttutor deleteRow(int index)
  {
    RowBuilder_Isttutor rowBuilder = rows.get(index);
    rows.remove(rowBuilder);
    return rowBuilder;
  }
  
  /**
   * Remove a row from the builder
   */ 
  public RowBuilder_Isttutor deleteRow(RowBuilder_Isttutor rowToDelete)
  {
    rows.remove(rowToDelete);
    return rowToDelete;
  }

  /**
  * Creates a new row but does not add it to the table
  */
  public RowBuilder_Isttutor newRow()
  {
    RowBuilder_Isttutor row = new RowBuilder_Isttutor(this);
    return row;
  }
  
  /**
  * Returns the next Object. The internal iterator is started at 
  * the first call.
  */
  public RowBuilder_Isttutor next()
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
