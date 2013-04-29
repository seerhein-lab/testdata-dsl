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
public class BeaufsichtigtTable implements ITable
{
  public final static String NAME = "beaufsichtigt";

  public static class Columns
  {
    public static final String ProfessorId = "professor_id";
    public static final String PruefungId = "pruefung_id";
  }

  // @formatter:off
  public final static Column[] COLUMNS = new Column[] {
    // idx = 0
    new Column(Columns.ProfessorId, DataType.BIGINT),
    // idx = 1
    new Column(Columns.PruefungId, DataType.BIGINT)
  };

  static Map<String, EnumSet<Flags>> GENERATOR_METADATA;
  static {
    GENERATOR_METADATA = new HashMap<String, EnumSet<Flags>>();
    GENERATOR_METADATA.put(Columns.ProfessorId,EnumSet.noneOf( Flags.class ));
    GENERATOR_METADATA.put(Columns.PruefungId,EnumSet.noneOf( Flags.class ));
  }
  // @formatter:on

  ITableMetaData _metaData;
  
  DBUnitExamplesDataSet _dataSet;
  
  Iterator<RowBuilder_Beaufsichtigt> _iterator;
  
  public BeaufsichtigtTable()
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

  public List<RowBuilder_Beaufsichtigt> rows = new ArrayList<RowBuilder_Beaufsichtigt>();
  
  public interface RowSetters_Beaufsichtigt<T extends RowSetters_Beaufsichtigt>
  {
    T setProfessorId(Integer intValue);
    T setProfessorId(java.lang.Long value);
    T setProfessorIdRaw(Object value);
    T setPruefungId(Integer intValue);
    T setPruefungId(java.lang.Long value);
    T setPruefungIdRaw(Object value);
     
  }
  
  public interface RowGetters_Beaufsichtigt<T extends RowGetters_Beaufsichtigt>
  {
    java.lang.Long getProfessorId();
    java.lang.Long getPruefungId();
     
  }

  public static class RowBuilder_Beaufsichtigt implements RowSetters_Beaufsichtigt<RowBuilder_Beaufsichtigt>, RowGetters_Beaufsichtigt<RowBuilder_Beaufsichtigt>
  {

    Object[] data;
    
    BeaufsichtigtTable table;
    
    RowBuilder_Beaufsichtigt(BeaufsichtigtTable tableDelegate) {
      data=new Object[COLUMNS.length];
      table = tableDelegate;
    }
    

    public RowBuilder_Beaufsichtigt setProfessorId(Integer intValue)
    {
      data[ 0 ] = (intValue==null?null:Long.valueOf(intValue));
      return this;
    }
    public RowBuilder_Beaufsichtigt setProfessorId(java.lang.Long value)
    {
      data[ 0 ] = value;
      return this;
    }
    public RowBuilder_Beaufsichtigt setProfessorIdRaw(Object value)
    {
      data[ 0 ] = value;
      return this;
    }

    public java.lang.Long getProfessorId()
    {
      return (java.lang.Long) data[0];
    }

    public RowBuilder_Beaufsichtigt setPruefungId(Integer intValue)
    {
      data[ 1 ] = (intValue==null?null:Long.valueOf(intValue));
      return this;
    }
    public RowBuilder_Beaufsichtigt setPruefungId(java.lang.Long value)
    {
      data[ 1 ] = value;
      return this;
    }
    public RowBuilder_Beaufsichtigt setPruefungIdRaw(Object value)
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
    * ds.table_Beaufsichtigt.insertRow()
    *   .setProfessorId( null )
    *   .setPruefungId( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Beaufsichtigt insertRow()
    {
      return table.insertRow();
    }
    
    /**
    * Insert a new Row at the end of the Table
    * <code><pre>
    * ds.table_Beaufsichtigt.insertRow()
    *   .setProfessorId( null )
    *   .setPruefungId( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Beaufsichtigt insertRow(BeaufsichtigtModel row)
    {
      return table.insertRow(row);
    }
    
    /**
    * Insert a new Row at the given position
    * <code><pre>
    * ds.table_Beaufsichtigt.this.insertRowAt(2)
    *   .setProfessorId( null )
    *   .setPruefungId( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Beaufsichtigt insertRowAt(int index)
    {
      return table.insertRowAt(index);
    }

    /**
    * Insert a row at the end of the table
    * <code><pre>
    * ds.table_Beaufsichtigt.insertRow(baseUser);
    * </pre></code>
    */
    public RowBuilder_Beaufsichtigt insertRow(RowBuilder_Beaufsichtigt theRow)
    {
      return table.insertRow(theRow);
    }
    
    public Object getValue(String column) throws RuntimeException {
      if(column.equalsIgnoreCase(Columns.ProfessorId) ) {
        return data[0];
      }
      if(column.equalsIgnoreCase(Columns.PruefungId) ) {
        return data[1];
      }
      throw new RuntimeException(NAME + " col = " + column);
    }
    

    public RowBuilder_Beaufsichtigt refProfessorId(RowGetters_Professor reference)
    {
      setProfessorId(reference.getId());
      return this;
    }

    public RowBuilder_Beaufsichtigt refPruefungId(RowGetters_Pruefung reference)
    {
      setPruefungId(reference.getId());
      return this;
    }
    
    @Override
    public RowBuilder_Beaufsichtigt clone() {
      RowBuilder_Beaufsichtigt clone = new RowBuilder_Beaufsichtigt(table);
      clone.setProfessorId(getProfessorId());
      clone.setPruefungId(getPruefungId());
      return clone;
    }
  }
  
  public BeaufsichtigtWhere findWhere = new BeaufsichtigtWhere(this);

  public static class BeaufsichtigtWhere
  {
    public List<RowBuilder_Beaufsichtigt> rows;
    BeaufsichtigtTable table;
    
    public BeaufsichtigtWhere(BeaufsichtigtTable theTable) {
       rows = theTable.rows;
       table = theTable;
    }
    
    public RowCollection_Beaufsichtigt rowComparesTo(Comparable<RowBuilder_Beaufsichtigt> toSearch) {
      RowCollection_Beaufsichtigt modifiers = new RowCollection_Beaufsichtigt(table);
      for (RowBuilder_Beaufsichtigt row : rows) 
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
    public RowCollection_Beaufsichtigt professorId(java.lang.Long toSearch) {
      RowCollection_Beaufsichtigt modifiers = new RowCollection_Beaufsichtigt(table);
      for (RowBuilder_Beaufsichtigt row : rows) 
      {
        if (row.getProfessorId().equals(toSearch)) 
        {
          modifiers.add(row);
        }
      }
      if(modifiers.isEmpty()) {
        throw new RuntimeException("No Row with professor_id = " + toSearch );
      }
      return modifiers;
    }
    public RowCollection_Beaufsichtigt professorId(Integer toSearch) 
    {
      return professorId( Long.valueOf(toSearch) );
    }
    public RowCollection_Beaufsichtigt pruefungId(java.lang.Long toSearch) {
      RowCollection_Beaufsichtigt modifiers = new RowCollection_Beaufsichtigt(table);
      for (RowBuilder_Beaufsichtigt row : rows) 
      {
        if (row.getPruefungId().equals(toSearch)) 
        {
          modifiers.add(row);
        }
      }
      if(modifiers.isEmpty()) {
        throw new RuntimeException("No Row with pruefung_id = " + toSearch );
      }
      return modifiers;
    }
    public RowCollection_Beaufsichtigt pruefungId(Integer toSearch) 
    {
      return pruefungId( Long.valueOf(toSearch) );
    }
  }
  
  /** Inner class! Use RowCollection_Beaufsichtigt in your code ! */
  public static class RowModify_Beaufsichtigt extends RowBuilder_Beaufsichtigt 
  {
      List<RowBuilder_Beaufsichtigt> _rows;

      public RowModify_Beaufsichtigt(BeaufsichtigtTable theTable) {
        super(theTable);
        _rows = new ArrayList<RowBuilder_Beaufsichtigt>();
      }
      
      public void add(RowBuilder_Beaufsichtigt row) {
          _rows.add(row);
      }
      
      public boolean isEmpty() {
          return _rows.isEmpty();
      }

      public RowModify_Beaufsichtigt delete() {
          for(RowBuilder_Beaufsichtigt row : _rows) {
            table.rows.remove(row);
          }
          return this;
      }
        

      public RowModify_Beaufsichtigt setProfessorId(Integer intValue)
      {
        for(RowBuilder_Beaufsichtigt row : _rows) {
          row.setProfessorId(intValue);
        }
        return this;
      }

      public RowModify_Beaufsichtigt setProfessorId(java.lang.Long value)
      {
        for(RowBuilder_Beaufsichtigt row : _rows) {
          row.setProfessorId(value);
        }
        return this;
      }
      public RowModify_Beaufsichtigt setProfessorIdRaw(Object value)
      {
        for(RowBuilder_Beaufsichtigt row : _rows) {
          row.setProfessorIdRaw(value);
        }
        return this;
      }
      public java.lang.Long getProfessorId()
      {
        if(_rows.size()!=1) {
          throw new RuntimeException("There where multiple Row in the result! " + _rows.size() );
        }
        return _rows.get(0).getProfessorId();
      }

      public RowModify_Beaufsichtigt setPruefungId(Integer intValue)
      {
        for(RowBuilder_Beaufsichtigt row : _rows) {
          row.setPruefungId(intValue);
        }
        return this;
      }

      public RowModify_Beaufsichtigt setPruefungId(java.lang.Long value)
      {
        for(RowBuilder_Beaufsichtigt row : _rows) {
          row.setPruefungId(value);
        }
        return this;
      }
      public RowModify_Beaufsichtigt setPruefungIdRaw(Object value)
      {
        for(RowBuilder_Beaufsichtigt row : _rows) {
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
      public RowModify_Beaufsichtigt clone() {
        RowModify_Beaufsichtigt clone = new RowModify_Beaufsichtigt(table);
        for(RowBuilder_Beaufsichtigt row:_rows) {
          clone._rows.add(row.clone());
        }
        return clone;
      }

  }
  
  public static class RowCollection_Beaufsichtigt extends RowModify_Beaufsichtigt {
    public BeaufsichtigtWhere where = new BeaufsichtigtWhere(table);
    
    public RowCollection_Beaufsichtigt(BeaufsichtigtTable theTable)
    {
      super(theTable);
    }
    
  }

  /**
  * Insert a new empty Row.
  * <code><pre>
  * ds.table_Beaufsichtigt.insertRow()
  *   .setProfessorId( null )
  *   .setPruefungId( null )
  *   ;
  * </pre></code>
  */
  public RowBuilder_Beaufsichtigt insertRow()
  {
    RowBuilder_Beaufsichtigt row = new RowBuilder_Beaufsichtigt(this);
    rows.add(row);
    return row;
  }
  
  /**
  * <code><pre>
  * ds.table_Beaufsichtigt.insertRow()
  * </pre></code>
  */
  public RowBuilder_Beaufsichtigt insertRow(BeaufsichtigtModel rowToAdd)
  {
    RowBuilder_Beaufsichtigt row = new RowBuilder_Beaufsichtigt(this);
    row.setProfessorIdRaw( rowToAdd.getProfessorIdRaw() );
    row.setPruefungIdRaw( rowToAdd.getPruefungIdRaw() );
    rows.add(row);
    return row;
  }

  /**
  * <code><pre>
  * ds.table_Beaufsichtigt.insertRow(data);
  * </pre></code>
  */
  public RowBuilder_Beaufsichtigt insertRow(RowBuilder_Beaufsichtigt theRow)
  {
    rows.add(theRow);
    return theRow;
  }
  
  /**
  * <code><pre>
  * ds.table_Beaufsichtigt.insertRows(data);
  * </pre></code>
  */
  public void insertRows(RowBuilder_Beaufsichtigt...theRows)
  {
    rows.addAll(Arrays.asList(theRows));
  }
  
  /**
  * Insert new row at the given index
  * <code><pre>
  * ds.table_Beaufsichtigt.insertRowAt(3)
  *   ;
  * </pre></code>
  */
  public RowBuilder_Beaufsichtigt insertRowAt(int index)
  {
    RowBuilder_Beaufsichtigt row = new RowBuilder_Beaufsichtigt(this);
    rows.add(index, row);
    return row;
  }
  
  /**
  * Insert new row Object at the given index
  * <code><pre>
  * ds.table_Beaufsichtigt.insertRowAt(3)
  * </pre></code>
  */
  public RowBuilder_Beaufsichtigt insertRowAt(int index,RowBuilder_Beaufsichtigt theRow)
  {
    rows.add(index, theRow);
    return theRow;
  }
  
  /**
   * Remove a row from the builder by the given index.
   *
   * @return the deleted row
   */ 
  public RowBuilder_Beaufsichtigt deleteRow(int index)
  {
    RowBuilder_Beaufsichtigt rowBuilder = rows.get(index);
    rows.remove(rowBuilder);
    return rowBuilder;
  }
  
  /**
   * Remove a row from the builder
   */ 
  public RowBuilder_Beaufsichtigt deleteRow(RowBuilder_Beaufsichtigt rowToDelete)
  {
    rows.remove(rowToDelete);
    return rowToDelete;
  }

  /**
  * Creates a new row but does not add it to the table
  */
  public RowBuilder_Beaufsichtigt newRow()
  {
    RowBuilder_Beaufsichtigt row = new RowBuilder_Beaufsichtigt(this);
    return row;
  }
  
  /**
  * Returns the next Object. The internal iterator is started at 
  * the first call.
  */
  public RowBuilder_Beaufsichtigt next()
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
