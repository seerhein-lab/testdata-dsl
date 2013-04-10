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
public class StudentTable implements ITable
{
  public final static String NAME = "student";

  public static class Columns
  {
    public static final String Matrikelnummer = "matrikelnummer";
    public static final String Name = "name";
  }

  // @formatter:off
  public final static Column[] COLUMNS = new Column[] {
    // idx = 0
    new Column(Columns.Matrikelnummer, DataType.BIGINT),
    // idx = 1
    new Column(Columns.Name, DataType.VARCHAR)
  };

  static Map<String, EnumSet<Flags>> GENERATOR_METADATA;
  static {
    GENERATOR_METADATA = new HashMap<String, EnumSet<Flags>>();
    GENERATOR_METADATA.put(Columns.Matrikelnummer,EnumSet.of( Flags.AddNextIdMethod));
    GENERATOR_METADATA.put(Columns.Name,EnumSet.noneOf( Flags.class ));
  }
  // @formatter:on

  ITableMetaData _metaData;
  
  DBUnitExamplesDataSet _dataSet;
  
  Iterator<RowBuilder_Student> _iterator;
  
  public StudentTable()
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

  public List<RowBuilder_Student> rows = new ArrayList<RowBuilder_Student>();
  
  public interface RowSetters_Student<T extends RowSetters_Student>
  {
    T setMatrikelnummer(Integer intValue);
    T setMatrikelnummer(java.lang.Long value);
    T setMatrikelnummerRaw(Object value);
    T nextMatrikelnummer();
    T setName(java.lang.String value);
    T setNameRaw(Object value);
     
  }
  
  public interface RowGetters_Student<T extends RowGetters_Student>
  {
    java.lang.Long getMatrikelnummer();
    java.lang.String getName();
     
  }

  public static class RowBuilder_Student implements RowSetters_Student<RowBuilder_Student>, RowGetters_Student<RowBuilder_Student>
  {

    Object[] data;
    
    StudentTable table;
    
    RowBuilder_Student(StudentTable tableDelegate) {
      data=new Object[COLUMNS.length];
      table = tableDelegate;
    }
    

    public RowBuilder_Student setMatrikelnummer(Integer intValue)
    {
      data[ 0 ] = (intValue==null?null:Long.valueOf(intValue));
      return this;
    }
    public RowBuilder_Student setMatrikelnummer(java.lang.Long value)
    {
      data[ 0 ] = value;
      return this;
    }
    public RowBuilder_Student setMatrikelnummerRaw(Object value)
    {
      data[ 0 ] = value;
      return this;
    }
    public RowBuilder_Student nextMatrikelnummer()
    {
      DatasetIdGenerator generator = table.getDataset().getIdGenerator();
      Long nextId = generator.nextId(StudentTable.NAME,"matrikelnummer");
      setMatrikelnummer(nextId);
      return this;
    }

    public java.lang.Long getMatrikelnummer()
    {
      return (java.lang.Long) data[0];
    }

    public RowBuilder_Student setName(java.lang.String value)
    {
      data[ 1 ] = value;
      return this;
    }
    public RowBuilder_Student setNameRaw(Object value)
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
    * ds.table_Student.insertRow()
    *   .setMatrikelnummer( null )
    *   .setName( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Student insertRow()
    {
      return table.insertRow();
    }
    
    /**
    * Insert a new Row at the end of the Table
    * <code><pre>
    * ds.table_Student.insertRow()
    *   .setMatrikelnummer( null )
    *   .setName( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Student insertRow(StudentModel row)
    {
      return table.insertRow(row);
    }
    
    /**
    * Insert a new Row at the given position
    * <code><pre>
    * ds.table_Student.this.insertRowAt(2)
    *   .setMatrikelnummer( null )
    *   .setName( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Student insertRowAt(int index)
    {
      return table.insertRowAt(index);
    }

    /**
    * Insert a row at the end of the table
    * <code><pre>
    * ds.table_Student.insertRow(baseUser);
    * </pre></code>
    */
    public RowBuilder_Student insertRow(RowBuilder_Student theRow)
    {
      return table.insertRow(theRow);
    }
    
    public Object getValue(String column) throws RuntimeException {
      if(column.equals("matrikelnummer") ) {
        return data[0];
      }
      if(column.equals("name") ) {
        return data[1];
      }
      throw new RuntimeException(NAME + " col = " + column);
    }
    
    
    @Override
    public RowBuilder_Student clone() {
      RowBuilder_Student clone = new RowBuilder_Student(table);
      clone.setMatrikelnummer(getMatrikelnummer());
      clone.setName(getName());
      return clone;
    }
  }
  
  public StudentWhere findWhere = new StudentWhere(this);

  public static class StudentWhere
  {
    public List<RowBuilder_Student> rows;
    StudentTable table;
    
    public StudentWhere(StudentTable theTable) {
       rows = theTable.rows;
       table = theTable;
    }
    
    public RowCollection_Student rowComparesTo(Comparable<RowBuilder_Student> toSearch) {
      RowCollection_Student modifiers = new RowCollection_Student(table);
      for (RowBuilder_Student row : rows) 
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
    public RowCollection_Student matrikelnummer(java.lang.Long toSearch) {
      RowCollection_Student modifiers = new RowCollection_Student(table);
      for (RowBuilder_Student row : rows) 
      {
        if (row.getMatrikelnummer().equals(toSearch)) 
        {
          modifiers.add(row);
        }
      }
      if(modifiers.isEmpty()) {
        throw new RuntimeException("No Row with matrikelnummer = " + toSearch );
      }
      return modifiers;
    }
    public RowCollection_Student matrikelnummer(Integer toSearch) 
    {
      return matrikelnummer( Long.valueOf(toSearch) );
    }
    public RowCollection_Student name(java.lang.String toSearch) {
      RowCollection_Student modifiers = new RowCollection_Student(table);
      for (RowBuilder_Student row : rows) 
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
  
  /** Inner class! Use RowCollection_Student in your code ! */
  public static class RowModify_Student extends RowBuilder_Student 
  {
      List<RowBuilder_Student> _rows;

      public RowModify_Student(StudentTable theTable) {
        super(theTable);
        _rows = new ArrayList<RowBuilder_Student>();
      }
      
      public void add(RowBuilder_Student row) {
          _rows.add(row);
      }
      
      public boolean isEmpty() {
          return _rows.isEmpty();
      }

      public RowModify_Student delete() {
          for(RowBuilder_Student row : _rows) {
            table.rows.remove(row);
          }
          return this;
      }
        

      public RowModify_Student setMatrikelnummer(Integer intValue)
      {
        for(RowBuilder_Student row : _rows) {
          row.setMatrikelnummer(intValue);
        }
        return this;
      }

      public RowModify_Student setMatrikelnummer(java.lang.Long value)
      {
        for(RowBuilder_Student row : _rows) {
          row.setMatrikelnummer(value);
        }
        return this;
      }
      public RowModify_Student setMatrikelnummerRaw(Object value)
      {
        for(RowBuilder_Student row : _rows) {
          row.setMatrikelnummerRaw(value);
        }
        return this;
      }
      public java.lang.Long getMatrikelnummer()
      {
        if(_rows.size()!=1) {
          throw new RuntimeException("There where multiple Row in the result! " + _rows.size() );
        }
        return _rows.get(0).getMatrikelnummer();
      }

      public RowModify_Student setName(java.lang.String value)
      {
        for(RowBuilder_Student row : _rows) {
          row.setName(value);
        }
        return this;
      }
      public RowModify_Student setNameRaw(Object value)
      {
        for(RowBuilder_Student row : _rows) {
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
      public RowModify_Student clone() {
        RowModify_Student clone = new RowModify_Student(table);
        for(RowBuilder_Student row:_rows) {
          clone._rows.add(row.clone());
        }
        return clone;
      }

  }
  
  public static class RowCollection_Student extends RowModify_Student {
    public StudentWhere where = new StudentWhere(table);
    
    public RowCollection_Student(StudentTable theTable)
    {
      super(theTable);
    }
    
  }

  /**
  * Insert a new empty Row.
  * <code><pre>
  * ds.table_Student.insertRow()
  *   .setMatrikelnummer( null )
  *   .setName( null )
  *   ;
  * </pre></code>
  */
  public RowBuilder_Student insertRow()
  {
    RowBuilder_Student row = new RowBuilder_Student(this);
    rows.add(row);
    return row;
  }
  
  /**
  * <code><pre>
  * ds.table_Student.insertRow()
  * </pre></code>
  */
  public RowBuilder_Student insertRow(StudentModel rowToAdd)
  {
    RowBuilder_Student row = new RowBuilder_Student(this);
    row.setMatrikelnummerRaw( rowToAdd.getMatrikelnummerRaw() );
    row.setNameRaw( rowToAdd.getNameRaw() );
    rows.add(row);
    return row;
  }

  /**
  * <code><pre>
  * ds.table_Student.insertRow(data);
  * </pre></code>
  */
  public RowBuilder_Student insertRow(RowBuilder_Student theRow)
  {
    rows.add(theRow);
    return theRow;
  }
  
  /**
  * <code><pre>
  * ds.table_Student.insertRows(data);
  * </pre></code>
  */
  public void insertRows(RowBuilder_Student...theRows)
  {
    rows.addAll(Arrays.asList(theRows));
  }
  
  /**
  * Insert new row at the given index
  * <code><pre>
  * ds.table_Student.insertRowAt(3)
  *   ;
  * </pre></code>
  */
  public RowBuilder_Student insertRowAt(int index)
  {
    RowBuilder_Student row = new RowBuilder_Student(this);
    rows.add(index, row);
    return row;
  }
  
  /**
  * Insert new row Object at the given index
  * <code><pre>
  * ds.table_Student.insertRowAt(3)
  * </pre></code>
  */
  public RowBuilder_Student insertRowAt(int index,RowBuilder_Student theRow)
  {
    rows.add(index, theRow);
    return theRow;
  }
  
  /**
   * Remove a row from the builder by the given index.
   *
   * @return the deleted row
   */ 
  public RowBuilder_Student deleteRow(int index)
  {
    RowBuilder_Student rowBuilder = rows.get(index);
    rows.remove(rowBuilder);
    return rowBuilder;
  }
  
  /**
   * Remove a row from the builder
   */ 
  public RowBuilder_Student deleteRow(RowBuilder_Student rowToDelete)
  {
    rows.remove(rowToDelete);
    return rowToDelete;
  }

  /**
  * Creates a new row but does not add it to the table
  */
  public RowBuilder_Student newRow()
  {
    RowBuilder_Student row = new RowBuilder_Student(this);
    return row;
  }
  
  /**
  * Returns the next Object. The internal iterator is started at 
  * the first call.
  */
  public RowBuilder_Student next()
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
