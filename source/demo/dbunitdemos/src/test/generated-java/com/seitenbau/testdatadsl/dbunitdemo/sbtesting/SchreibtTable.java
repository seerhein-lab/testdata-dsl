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
public class SchreibtTable implements ITable
{
  public final static String NAME = "schreibt";

  public static class Columns
  {
    public static final String StudentId = "studentID";
    public static final String PruefungId = "pruefungID";
  }

  // @formatter:off
  public final static Column[] COLUMNS = new Column[] {
    // idx = 0
    new Column(Columns.StudentId, DataType.BIGINT),
    // idx = 1
    new Column(Columns.PruefungId, DataType.BIGINT)
  };

  static Map<String, EnumSet<Flags>> GENERATOR_METADATA;
  static {
    GENERATOR_METADATA = new HashMap<String, EnumSet<Flags>>();
    GENERATOR_METADATA.put(Columns.StudentId,EnumSet.noneOf( Flags.class ));
    GENERATOR_METADATA.put(Columns.PruefungId,EnumSet.noneOf( Flags.class ));
  }
  // @formatter:on

  ITableMetaData _metaData;
  
  DBUnitDemoDataSet _dataSet;
  
  Iterator<RowBuilder_Schreibt> _iterator;
  
  public SchreibtTable()
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

  public List<RowBuilder_Schreibt> rows = new ArrayList<RowBuilder_Schreibt>();
  
  public interface RowSetters_Schreibt<T extends RowSetters_Schreibt>
  {
    T setStudentId(Integer intValue);
    T setStudentId(java.lang.Long value);
    T setStudentIdRaw(Object value);
    T setPruefungId(Integer intValue);
    T setPruefungId(java.lang.Long value);
    T setPruefungIdRaw(Object value);
     
  }
  
  public interface RowGetters_Schreibt<T extends RowGetters_Schreibt>
  {
    java.lang.Long getStudentId();
    java.lang.Long getPruefungId();
     
  }

  public static class RowBuilder_Schreibt implements RowSetters_Schreibt<RowBuilder_Schreibt>, RowGetters_Schreibt<RowBuilder_Schreibt>
  {

    Object[] data;
    
    SchreibtTable table;
    
    RowBuilder_Schreibt(SchreibtTable tableDelegate) {
      data=new Object[COLUMNS.length];
      table = tableDelegate;
    }
    

    public RowBuilder_Schreibt setStudentId(Integer intValue)
    {
      data[ 0 ] = (intValue==null?null:Long.valueOf(intValue));
      return this;
    }
    public RowBuilder_Schreibt setStudentId(java.lang.Long value)
    {
      data[ 0 ] = value;
      return this;
    }
    public RowBuilder_Schreibt setStudentIdRaw(Object value)
    {
      data[ 0 ] = value;
      return this;
    }

    public java.lang.Long getStudentId()
    {
      return (java.lang.Long) data[0];
    }

    public RowBuilder_Schreibt setPruefungId(Integer intValue)
    {
      data[ 1 ] = (intValue==null?null:Long.valueOf(intValue));
      return this;
    }
    public RowBuilder_Schreibt setPruefungId(java.lang.Long value)
    {
      data[ 1 ] = value;
      return this;
    }
    public RowBuilder_Schreibt setPruefungIdRaw(Object value)
    {
      data[ 1 ] = value;
      return this;
    }

    public java.lang.Long getPruefungId()
    {
      return (java.lang.Long) data[1];
    }
    /**
    * Insert a new Row at the end of the Table
    * <code><pre>
    * ds.table_Schreibt.insertRow()
    *   .setStudentId( null )
    *   .setPruefungId( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Schreibt insertRow()
    {
      return table.insertRow();
    }
    
    /**
    * Insert a new Row at the end of the Table
    * <code><pre>
    * ds.table_Schreibt.insertRow()
    *   .setStudentId( null )
    *   .setPruefungId( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Schreibt insertRow(SchreibtModel row)
    {
      return table.insertRow(row);
    }
    
    /**
    * Insert a new Row at the given position
    * <code><pre>
    * ds.table_Schreibt.this.insertRowAt(2)
    *   .setStudentId( null )
    *   .setPruefungId( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Schreibt insertRowAt(int index)
    {
      return table.insertRowAt(index);
    }

    /**
    * Insert a row at the end of the table
    * <code><pre>
    * ds.table_Schreibt.insertRow(baseUser);
    * </pre></code>
    */
    public RowBuilder_Schreibt insertRow(RowBuilder_Schreibt theRow)
    {
      return table.insertRow(theRow);
    }
    
    public Object getValue(String column) throws RuntimeException {
      if(column.equals("studentID") ) {
        return data[0];
      }
      if(column.equals("pruefungID") ) {
        return data[1];
      }
      throw new RuntimeException(NAME + " col = " + column);
    }
    

    public RowBuilder_Schreibt refStudentId(RowGetters_Student reference)
    {
      setStudentId(reference.getMatrikelnummer());
      return this;
    }

    public RowBuilder_Schreibt refPruefungId(RowGetters_Pruefung reference)
    {
      setPruefungId(reference.getId());
      return this;
    }
    
    @Override
    public RowBuilder_Schreibt clone() {
      RowBuilder_Schreibt clone = new RowBuilder_Schreibt(table);
      clone.setStudentId(getStudentId());
      clone.setPruefungId(getPruefungId());
      return clone;
    }
  }
  
  public SchreibtWhere findWhere = new SchreibtWhere(this);

  public static class SchreibtWhere
  {
    public List<RowBuilder_Schreibt> rows;
    SchreibtTable table;
    
    public SchreibtWhere(SchreibtTable theTable) {
       rows = theTable.rows;
       table = theTable;
    }
    
    public RowCollection_Schreibt rowComparesTo(Comparable<RowBuilder_Schreibt> toSearch) {
      RowCollection_Schreibt modifiers = new RowCollection_Schreibt(table);
      for (RowBuilder_Schreibt row : rows) 
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
    public RowCollection_Schreibt studentId(java.lang.Long toSearch) {
      RowCollection_Schreibt modifiers = new RowCollection_Schreibt(table);
      for (RowBuilder_Schreibt row : rows) 
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
    public RowCollection_Schreibt studentId(Integer toSearch) 
    {
      return studentId( Long.valueOf(toSearch) );
    }
    public RowCollection_Schreibt pruefungId(java.lang.Long toSearch) {
      RowCollection_Schreibt modifiers = new RowCollection_Schreibt(table);
      for (RowBuilder_Schreibt row : rows) 
      {
        if (row.getPruefungId().equals(toSearch)) 
        {
          modifiers.add(row);
        }
      }
      if(modifiers.isEmpty()) {
        throw new RuntimeException("No Row with pruefungID = " + toSearch );
      }
      return modifiers;
    }
    public RowCollection_Schreibt pruefungId(Integer toSearch) 
    {
      return pruefungId( Long.valueOf(toSearch) );
    }
  }
  
  /** Inner class! Use RowCollection_Schreibt in your code ! */
  public static class RowModify_Schreibt extends RowBuilder_Schreibt 
  {
      List<RowBuilder_Schreibt> _rows;

      public RowModify_Schreibt(SchreibtTable theTable) {
        super(theTable);
        _rows = new ArrayList<RowBuilder_Schreibt>();
      }
      
      public void add(RowBuilder_Schreibt row) {
          _rows.add(row);
      }
      
      public boolean isEmpty() {
          return _rows.isEmpty();
      }

      public RowModify_Schreibt delete() {
          for(RowBuilder_Schreibt row : _rows) {
            table.rows.remove(row);
          }
          return this;
      }
        

      public RowModify_Schreibt setStudentId(Integer intValue)
      {
        for(RowBuilder_Schreibt row : _rows) {
          row.setStudentId(intValue);
        }
        return this;
      }

      public RowModify_Schreibt setStudentId(java.lang.Long value)
      {
        for(RowBuilder_Schreibt row : _rows) {
          row.setStudentId(value);
        }
        return this;
      }
      public RowModify_Schreibt setStudentIdRaw(Object value)
      {
        for(RowBuilder_Schreibt row : _rows) {
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

      public RowModify_Schreibt setPruefungId(Integer intValue)
      {
        for(RowBuilder_Schreibt row : _rows) {
          row.setPruefungId(intValue);
        }
        return this;
      }

      public RowModify_Schreibt setPruefungId(java.lang.Long value)
      {
        for(RowBuilder_Schreibt row : _rows) {
          row.setPruefungId(value);
        }
        return this;
      }
      public RowModify_Schreibt setPruefungIdRaw(Object value)
      {
        for(RowBuilder_Schreibt row : _rows) {
          row.setPruefungIdRaw(value);
        }
        return this;
      }
      public java.lang.Long getPruefungId()
      {
        if(_rows.size()!=1) {
          throw new RuntimeException("There where multiple Row in the result! " + _rows.size() );
        }
        return _rows.get(0).getPruefungId();
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
      public RowModify_Schreibt clone() {
        RowModify_Schreibt clone = new RowModify_Schreibt(table);
        for(RowBuilder_Schreibt row:_rows) {
          clone._rows.add(row.clone());
        }
        return clone;
      }

  }
  
  public static class RowCollection_Schreibt extends RowModify_Schreibt {
    public SchreibtWhere where = new SchreibtWhere(table);
    
    public RowCollection_Schreibt(SchreibtTable theTable)
    {
      super(theTable);
    }
    
  }

  /**
  * Insert a new empty Row.
  * <code><pre>
  * ds.table_Schreibt.insertRow()
  *   .setStudentId( null )
  *   .setPruefungId( null )
  *   ;
  * </pre></code>
  */
  public RowBuilder_Schreibt insertRow()
  {
    RowBuilder_Schreibt row = new RowBuilder_Schreibt(this);
    rows.add(row);
    return row;
  }
  
  /**
  * <code><pre>
  * ds.table_Schreibt.insertRow()
  * </pre></code>
  */
  public RowBuilder_Schreibt insertRow(SchreibtModel rowToAdd)
  {
    RowBuilder_Schreibt row = new RowBuilder_Schreibt(this);
    row.setStudentIdRaw( rowToAdd.getStudentIdRaw() );
    row.setPruefungIdRaw( rowToAdd.getPruefungIdRaw() );
    rows.add(row);
    return row;
  }

  /**
  * <code><pre>
  * ds.table_Schreibt.insertRow(data);
  * </pre></code>
  */
  public RowBuilder_Schreibt insertRow(RowBuilder_Schreibt theRow)
  {
    rows.add(theRow);
    return theRow;
  }
  
  /**
  * <code><pre>
  * ds.table_Schreibt.insertRows(data);
  * </pre></code>
  */
  public void insertRows(RowBuilder_Schreibt...theRows)
  {
    rows.addAll(Arrays.asList(theRows));
  }
  
  /**
  * Insert new row at the given index
  * <code><pre>
  * ds.table_Schreibt.insertRowAt(3)
  *   ;
  * </pre></code>
  */
  public RowBuilder_Schreibt insertRowAt(int index)
  {
    RowBuilder_Schreibt row = new RowBuilder_Schreibt(this);
    rows.add(index, row);
    return row;
  }
  
  /**
  * Insert new row Object at the given index
  * <code><pre>
  * ds.table_Schreibt.insertRowAt(3)
  * </pre></code>
  */
  public RowBuilder_Schreibt insertRowAt(int index,RowBuilder_Schreibt theRow)
  {
    rows.add(index, theRow);
    return theRow;
  }
  
  /**
   * Remove a row from the builder by the given index.
   *
   * @return the deleted row
   */ 
  public RowBuilder_Schreibt deleteRow(int index)
  {
    RowBuilder_Schreibt rowBuilder = rows.get(index);
    rows.remove(rowBuilder);
    return rowBuilder;
  }
  
  /**
   * Remove a row from the builder
   */ 
  public RowBuilder_Schreibt deleteRow(RowBuilder_Schreibt rowToDelete)
  {
    rows.remove(rowToDelete);
    return rowToDelete;
  }

  /**
  * Creates a new row but does not add it to the table
  */
  public RowBuilder_Schreibt newRow()
  {
    RowBuilder_Schreibt row = new RowBuilder_Schreibt(this);
    return row;
  }
  
  /**
  * Returns the next Object. The internal iterator is started at 
  * the first call.
  */
  public RowBuilder_Schreibt next()
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
