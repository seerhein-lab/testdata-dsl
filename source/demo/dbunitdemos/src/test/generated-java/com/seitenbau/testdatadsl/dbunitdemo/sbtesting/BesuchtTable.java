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
import com.seitenbau.testing.util.date.DateBuilder;

import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.ProfessorTable.RowGetters_Professor;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.LehrveranstaltungTable.RowGetters_Lehrveranstaltung;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.PruefungTable.RowGetters_Pruefung;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.StudentTable.RowGetters_Student;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.BeaufsichtigtTable.RowGetters_Beaufsichtigt;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.BesuchtTable.RowGetters_Besucht;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.IsttutorTable.RowGetters_Isttutor;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.SchreibtTable.RowGetters_Schreibt;

import static com.seitenbau.testing.util.DateUtil.*;

/* *******************************************************
  Generated via : codegeneration.GenerateDatabaseClasses
**********************************************************/
public class BesuchtTable implements ITable
{
  public final static String NAME = "besucht";

  public static class Columns
  {
    public static final String StudentId = "student_id";
    public static final String LehrveranstaltungId = "lehrveranstaltung_id";
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
  
  DBUnitExamplesDataSet _dataSet;
  
  Iterator<RowBuilder_Besucht> _iterator;
  
  public BesuchtTable()
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

  public List<RowBuilder_Besucht> rows = new ArrayList<RowBuilder_Besucht>();
  
  public interface RowSetters_Besucht<T extends RowSetters_Besucht>
  {
    T setStudentId(Integer intValue);
    T setStudentId(java.lang.Long value);
    T setStudentIdRaw(Object value);
    T setLehrveranstaltungId(Integer intValue);
    T setLehrveranstaltungId(java.lang.Long value);
    T setLehrveranstaltungIdRaw(Object value);
     
  }
  
  public interface RowGetters_Besucht<T extends RowGetters_Besucht>
  {
    java.lang.Long getStudentId();
    java.lang.Long getLehrveranstaltungId();
     
  }

  public static class RowBuilder_Besucht implements RowSetters_Besucht<RowBuilder_Besucht>, RowGetters_Besucht<RowBuilder_Besucht>
  {

    Object[] data;
    
    BesuchtTable table;
    
    RowBuilder_Besucht(BesuchtTable tableDelegate) {
      data=new Object[COLUMNS.length];
      table = tableDelegate;
    }
    

    public RowBuilder_Besucht setStudentId(Integer intValue)
    {
      data[ 0 ] = (intValue==null?null:Long.valueOf(intValue));
      return this;
    }
    public RowBuilder_Besucht setStudentId(java.lang.Long value)
    {
      data[ 0 ] = value;
      return this;
    }
    public RowBuilder_Besucht setStudentIdRaw(Object value)
    {
      data[ 0 ] = value;
      return this;
    }

    public java.lang.Long getStudentId()
    {
      return (java.lang.Long) data[0];
    }

    public RowBuilder_Besucht setLehrveranstaltungId(Integer intValue)
    {
      data[ 1 ] = (intValue==null?null:Long.valueOf(intValue));
      return this;
    }
    public RowBuilder_Besucht setLehrveranstaltungId(java.lang.Long value)
    {
      data[ 1 ] = value;
      return this;
    }
    public RowBuilder_Besucht setLehrveranstaltungIdRaw(Object value)
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
    * ds.table_Besucht.insertRow()
    *   .setStudentId( null )
    *   .setLehrveranstaltungId( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Besucht insertRow()
    {
      return table.insertRow();
    }
    
    /**
    * Insert a new Row at the end of the Table
    * <code><pre>
    * ds.table_Besucht.insertRow()
    *   .setStudentId( null )
    *   .setLehrveranstaltungId( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Besucht insertRow(BesuchtModel row)
    {
      return table.insertRow(row);
    }
    
    /**
    * Insert a new Row at the given position
    * <code><pre>
    * ds.table_Besucht.this.insertRowAt(2)
    *   .setStudentId( null )
    *   .setLehrveranstaltungId( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Besucht insertRowAt(int index)
    {
      return table.insertRowAt(index);
    }

    /**
    * Insert a row at the end of the table
    * <code><pre>
    * ds.table_Besucht.insertRow(baseUser);
    * </pre></code>
    */
    public RowBuilder_Besucht insertRow(RowBuilder_Besucht theRow)
    {
      return table.insertRow(theRow);
    }
    
    public Object getValue(String column) throws RuntimeException {
      if(column.equalsIgnoreCase(Columns.StudentId) ) {
        return data[0];
      }
      if(column.equalsIgnoreCase(Columns.LehrveranstaltungId) ) {
        return data[1];
      }
      throw new RuntimeException(NAME + " col = " + column);
    }
    

    public RowBuilder_Besucht refStudentId(RowGetters_Student reference)
    {
      setStudentId(reference.getMatrikelnummer());
      return this;
    }

    public RowBuilder_Besucht refLehrveranstaltungId(RowGetters_Lehrveranstaltung reference)
    {
      setLehrveranstaltungId(reference.getId());
      return this;
    }
    
    @Override
    public RowBuilder_Besucht clone() {
      RowBuilder_Besucht clone = new RowBuilder_Besucht(table);
      clone.setStudentId(getStudentId());
      clone.setLehrveranstaltungId(getLehrveranstaltungId());
      return clone;
    }
  }
  
  public BesuchtWhere findWhere = new BesuchtWhere(this);

  public static class BesuchtWhere
  {
    public List<RowBuilder_Besucht> rows;
    BesuchtTable table;
    
    public BesuchtWhere(BesuchtTable theTable) {
       rows = theTable.rows;
       table = theTable;
    }
    
    public RowCollection_Besucht rowComparesTo(Comparable<RowBuilder_Besucht> toSearch) {
      RowCollection_Besucht modifiers = new RowCollection_Besucht(table);
      for (RowBuilder_Besucht row : rows) 
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
    public RowCollection_Besucht studentId(java.lang.Long toSearch) {
      RowCollection_Besucht modifiers = new RowCollection_Besucht(table);
      for (RowBuilder_Besucht row : rows) 
      {
        if (row.getStudentId().equals(toSearch)) 
        {
          modifiers.add(row);
        }
      }
      if(modifiers.isEmpty()) {
        throw new RuntimeException("No Row with student_id = " + toSearch );
      }
      return modifiers;
    }
    public RowCollection_Besucht studentId(Integer toSearch) 
    {
      return studentId( Long.valueOf(toSearch) );
    }
    public RowCollection_Besucht lehrveranstaltungId(java.lang.Long toSearch) {
      RowCollection_Besucht modifiers = new RowCollection_Besucht(table);
      for (RowBuilder_Besucht row : rows) 
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
    public RowCollection_Besucht lehrveranstaltungId(Integer toSearch) 
    {
      return lehrveranstaltungId( Long.valueOf(toSearch) );
    }
  }
  
  /** Inner class! Use RowCollection_Besucht in your code ! */
  public static class RowModify_Besucht extends RowBuilder_Besucht 
  {
      List<RowBuilder_Besucht> _rows;

      public RowModify_Besucht(BesuchtTable theTable) {
        super(theTable);
        _rows = new ArrayList<RowBuilder_Besucht>();
      }
      
      public void add(RowBuilder_Besucht row) {
          _rows.add(row);
      }
      
      public boolean isEmpty() {
          return _rows.isEmpty();
      }

      public RowModify_Besucht delete() {
          for(RowBuilder_Besucht row : _rows) {
            table.rows.remove(row);
          }
          return this;
      }
        

      public RowModify_Besucht setStudentId(Integer intValue)
      {
        for(RowBuilder_Besucht row : _rows) {
          row.setStudentId(intValue);
        }
        return this;
      }

      public RowModify_Besucht setStudentId(java.lang.Long value)
      {
        for(RowBuilder_Besucht row : _rows) {
          row.setStudentId(value);
        }
        return this;
      }
      public RowModify_Besucht setStudentIdRaw(Object value)
      {
        for(RowBuilder_Besucht row : _rows) {
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

      public RowModify_Besucht setLehrveranstaltungId(Integer intValue)
      {
        for(RowBuilder_Besucht row : _rows) {
          row.setLehrveranstaltungId(intValue);
        }
        return this;
      }

      public RowModify_Besucht setLehrveranstaltungId(java.lang.Long value)
      {
        for(RowBuilder_Besucht row : _rows) {
          row.setLehrveranstaltungId(value);
        }
        return this;
      }
      public RowModify_Besucht setLehrveranstaltungIdRaw(Object value)
      {
        for(RowBuilder_Besucht row : _rows) {
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
      public RowModify_Besucht clone() {
        RowModify_Besucht clone = new RowModify_Besucht(table);
        for(RowBuilder_Besucht row:_rows) {
          clone._rows.add(row.clone());
        }
        return clone;
      }

  }
  
  public static class RowCollection_Besucht extends RowModify_Besucht {
    public BesuchtWhere where = new BesuchtWhere(table);
    
    public RowCollection_Besucht(BesuchtTable theTable)
    {
      super(theTable);
    }
    
  }

  /**
  * Insert a new empty Row.
  * <code><pre>
  * ds.table_Besucht.insertRow()
  *   .setStudentId( null )
  *   .setLehrveranstaltungId( null )
  *   ;
  * </pre></code>
  */
  public RowBuilder_Besucht insertRow()
  {
    RowBuilder_Besucht row = new RowBuilder_Besucht(this);
    rows.add(row);
    return row;
  }
  
  /**
  * <code><pre>
  * ds.table_Besucht.insertRow()
  * </pre></code>
  */
  public RowBuilder_Besucht insertRow(BesuchtModel rowToAdd)
  {
    RowBuilder_Besucht row = new RowBuilder_Besucht(this);
    row.setStudentIdRaw( rowToAdd.getStudentIdRaw() );
    row.setLehrveranstaltungIdRaw( rowToAdd.getLehrveranstaltungIdRaw() );
    rows.add(row);
    return row;
  }

  /**
  * <code><pre>
  * ds.table_Besucht.insertRow(data);
  * </pre></code>
  */
  public RowBuilder_Besucht insertRow(RowBuilder_Besucht theRow)
  {
    rows.add(theRow);
    return theRow;
  }
  
  /**
  * <code><pre>
  * ds.table_Besucht.insertRows(data);
  * </pre></code>
  */
  public void insertRows(RowBuilder_Besucht...theRows)
  {
    rows.addAll(Arrays.asList(theRows));
  }
  
  /**
  * Insert new row at the given index
  * <code><pre>
  * ds.table_Besucht.insertRowAt(3)
  *   ;
  * </pre></code>
  */
  public RowBuilder_Besucht insertRowAt(int index)
  {
    RowBuilder_Besucht row = new RowBuilder_Besucht(this);
    rows.add(index, row);
    return row;
  }
  
  /**
  * Insert new row Object at the given index
  * <code><pre>
  * ds.table_Besucht.insertRowAt(3)
  * </pre></code>
  */
  public RowBuilder_Besucht insertRowAt(int index,RowBuilder_Besucht theRow)
  {
    rows.add(index, theRow);
    return theRow;
  }
  
  /**
   * Remove a row from the builder by the given index.
   *
   * @return the deleted row
   */ 
  public RowBuilder_Besucht deleteRow(int index)
  {
    RowBuilder_Besucht rowBuilder = rows.get(index);
    rows.remove(rowBuilder);
    return rowBuilder;
  }
  
  /**
   * Remove a row from the builder
   */ 
  public RowBuilder_Besucht deleteRow(RowBuilder_Besucht rowToDelete)
  {
    rows.remove(rowToDelete);
    return rowToDelete;
  }

  /**
  * Creates a new row but does not add it to the table
  */
  public RowBuilder_Besucht newRow()
  {
    RowBuilder_Besucht row = new RowBuilder_Besucht(this);
    return row;
  }
  
  /**
  * Returns the next Object. The internal iterator is started at 
  * the first call.
  */
  public RowBuilder_Besucht next()
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
  
  static Date toDate(DateBuilder datum)
  {
    return datum.asDate();
  }
 
}
