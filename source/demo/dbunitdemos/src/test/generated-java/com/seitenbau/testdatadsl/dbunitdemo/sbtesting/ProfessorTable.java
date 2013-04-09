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
public class ProfessorTable implements ITable
{
  public final static String NAME = "professor";

  public static class Columns
  {
    public static final String Id = "ID";
    public static final String Name = "name";
  }

  // @formatter:off
  public final static Column[] COLUMNS = new Column[] {
    // idx = 0
    new Column(Columns.Id, DataType.BIGINT),
    // idx = 1
    new Column(Columns.Name, DataType.VARCHAR)
  };

  static Map<String, EnumSet<Flags>> GENERATOR_METADATA;
  static {
    GENERATOR_METADATA = new HashMap<String, EnumSet<Flags>>();
    GENERATOR_METADATA.put(Columns.Id,EnumSet.of( Flags.AutoInvokeNextIdMethod));
    GENERATOR_METADATA.put(Columns.Name,EnumSet.noneOf( Flags.class ));
  }
  // @formatter:on

  ITableMetaData _metaData;
  
  DBUnitDemoDataSet _dataSet;
  
  Iterator<RowBuilder_Professor> _iterator;
  
  public ProfessorTable()
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

  public List<RowBuilder_Professor> rows = new ArrayList<RowBuilder_Professor>();
  
  public interface RowSetters_Professor<T extends RowSetters_Professor>
  {
    T setId(Integer intValue);
    T setId(java.lang.Long value);
    T setIdRaw(Object value);
    T nextId();
    T setName(java.lang.String value);
    T setNameRaw(Object value);
     
  }
  
  public interface RowGetters_Professor<T extends RowGetters_Professor>
  {
    java.lang.Long getId();
    java.lang.String getName();
     
  }

  public static class RowBuilder_Professor implements RowSetters_Professor<RowBuilder_Professor>, RowGetters_Professor<RowBuilder_Professor>
  {

    Object[] data;
    
    ProfessorTable table;
    
    RowBuilder_Professor(ProfessorTable tableDelegate) {
      data=new Object[COLUMNS.length];
      table = tableDelegate;
    }
    

    public RowBuilder_Professor setId(Integer intValue)
    {
      data[ 0 ] = (intValue==null?null:Long.valueOf(intValue));
      return this;
    }
    public RowBuilder_Professor setId(java.lang.Long value)
    {
      data[ 0 ] = value;
      return this;
    }
    public RowBuilder_Professor setIdRaw(Object value)
    {
      data[ 0 ] = value;
      return this;
    }
    public RowBuilder_Professor nextId()
    {
      DatasetIdGenerator generator = table.getDataset().getIdGenerator();
      Long nextId = generator.nextId(ProfessorTable.NAME,"ID");
      setId(nextId);
      return this;
    }

    public java.lang.Long getId()
    {
      return (java.lang.Long) data[0];
    }

    public RowBuilder_Professor setName(java.lang.String value)
    {
      data[ 1 ] = value;
      return this;
    }
    public RowBuilder_Professor setNameRaw(Object value)
    {
      data[ 1 ] = value;
      return this;
    }

    public java.lang.String getName()
    {
      return (java.lang.String) data[1];
    }
    /**
    * Insert a new Row at the end of the Table
    * <code><pre>
    * ds.table_Professor.insertRow()
    *   .setId( null )
    *   .setName( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Professor insertRow()
    {
      return table.insertRow();
    }
    
    /**
    * Insert a new Row at the end of the Table
    * <code><pre>
    * ds.table_Professor.insertRow()
    *   .setId( null )
    *   .setName( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Professor insertRow(ProfessorModel row)
    {
      return table.insertRow(row);
    }
    
    /**
    * Insert a new Row at the given position
    * <code><pre>
    * ds.table_Professor.this.insertRowAt(2)
    *   .setId( null )
    *   .setName( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Professor insertRowAt(int index)
    {
      return table.insertRowAt(index);
    }

    /**
    * Insert a row at the end of the table
    * <code><pre>
    * ds.table_Professor.insertRow(baseUser);
    * </pre></code>
    */
    public RowBuilder_Professor insertRow(RowBuilder_Professor theRow)
    {
      return table.insertRow(theRow);
    }
    
    public Object getValue(String column) throws RuntimeException {
      if(column.equals("ID") ) {
        return data[0];
      }
      if(column.equals("name") ) {
        return data[1];
      }
      throw new RuntimeException(NAME + " col = " + column);
    }
    
    
    @Override
    public RowBuilder_Professor clone() {
      RowBuilder_Professor clone = new RowBuilder_Professor(table);
      clone.setId(getId());
      clone.setName(getName());
      return clone;
    }
  }
  
  public ProfessorWhere findWhere = new ProfessorWhere(this);

  public static class ProfessorWhere
  {
    public List<RowBuilder_Professor> rows;
    ProfessorTable table;
    
    public ProfessorWhere(ProfessorTable theTable) {
       rows = theTable.rows;
       table = theTable;
    }
    
    public RowCollection_Professor rowComparesTo(Comparable<RowBuilder_Professor> toSearch) {
      RowCollection_Professor modifiers = new RowCollection_Professor(table);
      for (RowBuilder_Professor row : rows) 
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
    public RowCollection_Professor id(java.lang.Long toSearch) {
      RowCollection_Professor modifiers = new RowCollection_Professor(table);
      for (RowBuilder_Professor row : rows) 
      {
        if (row.getId().equals(toSearch)) 
        {
          modifiers.add(row);
        }
      }
      if(modifiers.isEmpty()) {
        throw new RuntimeException("No Row with ID = " + toSearch );
      }
      return modifiers;
    }
    public RowCollection_Professor id(Integer toSearch) 
    {
      return id( Long.valueOf(toSearch) );
    }
    public RowCollection_Professor name(java.lang.String toSearch) {
      RowCollection_Professor modifiers = new RowCollection_Professor(table);
      for (RowBuilder_Professor row : rows) 
      {
        if (row.getName().equals(toSearch)) 
        {
          modifiers.add(row);
        }
      }
      if(modifiers.isEmpty()) {
        throw new RuntimeException("No Row with name = " + toSearch );
      }
      return modifiers;
    }
  }
  
  /** Inner class! Use RowCollection_Professor in your code ! */
  public static class RowModify_Professor extends RowBuilder_Professor 
  {
      List<RowBuilder_Professor> _rows;

      public RowModify_Professor(ProfessorTable theTable) {
        super(theTable);
        _rows = new ArrayList<RowBuilder_Professor>();
      }
      
      public void add(RowBuilder_Professor row) {
          _rows.add(row);
      }
      
      public boolean isEmpty() {
          return _rows.isEmpty();
      }

      public RowModify_Professor delete() {
          for(RowBuilder_Professor row : _rows) {
            table.rows.remove(row);
          }
          return this;
      }
        

      public RowModify_Professor setId(Integer intValue)
      {
        for(RowBuilder_Professor row : _rows) {
          row.setId(intValue);
        }
        return this;
      }

      public RowModify_Professor setId(java.lang.Long value)
      {
        for(RowBuilder_Professor row : _rows) {
          row.setId(value);
        }
        return this;
      }
      public RowModify_Professor setIdRaw(Object value)
      {
        for(RowBuilder_Professor row : _rows) {
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

      public RowModify_Professor setName(java.lang.String value)
      {
        for(RowBuilder_Professor row : _rows) {
          row.setName(value);
        }
        return this;
      }
      public RowModify_Professor setNameRaw(Object value)
      {
        for(RowBuilder_Professor row : _rows) {
          row.setNameRaw(value);
        }
        return this;
      }
      public java.lang.String getName()
      {
        if(_rows.size()!=1) {
          throw new RuntimeException("There where multiple Row in the result! " + _rows.size() );
        }
        return _rows.get(0).getName();
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
      public RowModify_Professor clone() {
        RowModify_Professor clone = new RowModify_Professor(table);
        for(RowBuilder_Professor row:_rows) {
          clone._rows.add(row.clone());
        }
        return clone;
      }

  }
  
  public static class RowCollection_Professor extends RowModify_Professor {
    public ProfessorWhere where = new ProfessorWhere(table);
    
    public RowCollection_Professor(ProfessorTable theTable)
    {
      super(theTable);
    }
    
  }

  /**
  * Insert a new empty Row.
  * <code><pre>
  * ds.table_Professor.insertRow()
  *   .setId( null )
  *   .setName( null )
  *   ;
  * </pre></code>
  */
  public RowBuilder_Professor insertRow()
  {
    RowBuilder_Professor row = new RowBuilder_Professor(this);
    row.nextId();
    rows.add(row);
    return row;
  }
  
  /**
  * <code><pre>
  * ds.table_Professor.insertRow()
  * </pre></code>
  */
  public RowBuilder_Professor insertRow(ProfessorModel rowToAdd)
  {
    RowBuilder_Professor row = new RowBuilder_Professor(this);
    row.setIdRaw( rowToAdd.getIdRaw() );
    row.setNameRaw( rowToAdd.getNameRaw() );
    rows.add(row);
    return row;
  }

  /**
  * <code><pre>
  * ds.table_Professor.insertRow(data);
  * </pre></code>
  */
  public RowBuilder_Professor insertRow(RowBuilder_Professor theRow)
  {
    rows.add(theRow);
    return theRow;
  }
  
  /**
  * <code><pre>
  * ds.table_Professor.insertRows(data);
  * </pre></code>
  */
  public void insertRows(RowBuilder_Professor...theRows)
  {
    rows.addAll(Arrays.asList(theRows));
  }
  
  /**
  * Insert new row at the given index
  * <code><pre>
  * ds.table_Professor.insertRowAt(3)
  *   ;
  * </pre></code>
  */
  public RowBuilder_Professor insertRowAt(int index)
  {
    RowBuilder_Professor row = new RowBuilder_Professor(this);
    rows.add(index, row);
    return row;
  }
  
  /**
  * Insert new row Object at the given index
  * <code><pre>
  * ds.table_Professor.insertRowAt(3)
  * </pre></code>
  */
  public RowBuilder_Professor insertRowAt(int index,RowBuilder_Professor theRow)
  {
    rows.add(index, theRow);
    return theRow;
  }
  
  /**
   * Remove a row from the builder by the given index.
   *
   * @return the deleted row
   */ 
  public RowBuilder_Professor deleteRow(int index)
  {
    RowBuilder_Professor rowBuilder = rows.get(index);
    rows.remove(rowBuilder);
    return rowBuilder;
  }
  
  /**
   * Remove a row from the builder
   */ 
  public RowBuilder_Professor deleteRow(RowBuilder_Professor rowToDelete)
  {
    rows.remove(rowToDelete);
    return rowToDelete;
  }

  /**
  * Creates a new row but does not add it to the table
  */
  public RowBuilder_Professor newRow()
  {
    RowBuilder_Professor row = new RowBuilder_Professor(this);
    return row;
  }
  
  /**
  * Returns the next Object. The internal iterator is started at 
  * the first call.
  */
  public RowBuilder_Professor next()
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
