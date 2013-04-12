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
public class LehrveranstaltungTable implements ITable
{
  public final static String NAME = "lehrveranstaltung";

  public static class Columns
  {
    public static final String Id = "id";
    public static final String ProfessorId = "professor_id";
    public static final String Name = "name";
    public static final String Sws = "sws";
    public static final String Ects = "ects";
  }

  // @formatter:off
  public final static Column[] COLUMNS = new Column[] {
    // idx = 0
    new Column(Columns.Id, DataType.BIGINT),
    // idx = 1
    new Column(Columns.ProfessorId, DataType.BIGINT),
    // idx = 2
    new Column(Columns.Name, DataType.VARCHAR),
    // idx = 3
    new Column(Columns.Sws, DataType.INTEGER),
    // idx = 4
    new Column(Columns.Ects, DataType.INTEGER)
  };

  static Map<String, EnumSet<Flags>> GENERATOR_METADATA;
  static {
    GENERATOR_METADATA = new HashMap<String, EnumSet<Flags>>();
    GENERATOR_METADATA.put(Columns.Id,EnumSet.of( Flags.AutoInvokeNextIdMethod));
    GENERATOR_METADATA.put(Columns.ProfessorId,EnumSet.noneOf( Flags.class ));
    GENERATOR_METADATA.put(Columns.Name,EnumSet.noneOf( Flags.class ));
    GENERATOR_METADATA.put(Columns.Sws,EnumSet.noneOf( Flags.class ));
    GENERATOR_METADATA.put(Columns.Ects,EnumSet.noneOf( Flags.class ));
  }
  // @formatter:on

  ITableMetaData _metaData;
  
  DBUnitExamplesDataSet _dataSet;
  
  Iterator<RowBuilder_Lehrveranstaltung> _iterator;
  
  public LehrveranstaltungTable()
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

  public List<RowBuilder_Lehrveranstaltung> rows = new ArrayList<RowBuilder_Lehrveranstaltung>();
  
  public interface RowSetters_Lehrveranstaltung<T extends RowSetters_Lehrveranstaltung>
  {
    T setId(Integer intValue);
    T setId(java.lang.Long value);
    T setIdRaw(Object value);
    T nextId();
    T setProfessorId(Integer intValue);
    T setProfessorId(java.lang.Long value);
    T setProfessorIdRaw(Object value);
    T setName(java.lang.String value);
    T setNameRaw(Object value);
    T setSws(java.lang.Integer value);
    T setSwsRaw(Object value);
    T setEcts(java.lang.Integer value);
    T setEctsRaw(Object value);
     
  }
  
  public interface RowGetters_Lehrveranstaltung<T extends RowGetters_Lehrveranstaltung>
  {
    java.lang.Long getId();
    java.lang.Long getProfessorId();
    java.lang.String getName();
    java.lang.Integer getSws();
    java.lang.Integer getEcts();
     
  }

  public static class RowBuilder_Lehrveranstaltung implements RowSetters_Lehrveranstaltung<RowBuilder_Lehrveranstaltung>, RowGetters_Lehrveranstaltung<RowBuilder_Lehrveranstaltung>
  {

    Object[] data;
    
    LehrveranstaltungTable table;
    
    RowBuilder_Lehrveranstaltung(LehrveranstaltungTable tableDelegate) {
      data=new Object[COLUMNS.length];
      table = tableDelegate;
    }
    

    public RowBuilder_Lehrveranstaltung setId(Integer intValue)
    {
      data[ 0 ] = (intValue==null?null:Long.valueOf(intValue));
      return this;
    }
    public RowBuilder_Lehrveranstaltung setId(java.lang.Long value)
    {
      data[ 0 ] = value;
      return this;
    }
    public RowBuilder_Lehrveranstaltung setIdRaw(Object value)
    {
      data[ 0 ] = value;
      return this;
    }
    public RowBuilder_Lehrveranstaltung nextId()
    {
      DatasetIdGenerator generator = table.getDataset().getIdGenerator();
      Long nextId = generator.nextId(LehrveranstaltungTable.NAME,"id");
      setId(nextId);
      return this;
    }

    public java.lang.Long getId()
    {
      return (java.lang.Long) data[0];
    }

    public RowBuilder_Lehrveranstaltung setProfessorId(Integer intValue)
    {
      data[ 1 ] = (intValue==null?null:Long.valueOf(intValue));
      return this;
    }
    public RowBuilder_Lehrveranstaltung setProfessorId(java.lang.Long value)
    {
      data[ 1 ] = value;
      return this;
    }
    public RowBuilder_Lehrveranstaltung setProfessorIdRaw(Object value)
    {
      data[ 1 ] = value;
      return this;
    }

    public java.lang.Long getProfessorId()
    {
      return (java.lang.Long) data[1];
    }

    public RowBuilder_Lehrveranstaltung setName(java.lang.String value)
    {
      data[ 2 ] = value;
      return this;
    }
    public RowBuilder_Lehrveranstaltung setNameRaw(Object value)
    {
      data[ 2 ] = value;
      return this;
    }

    public java.lang.String getName()
    {
      return (java.lang.String) data[2];
    }

    public RowBuilder_Lehrveranstaltung setSws(java.lang.Integer value)
    {
      data[ 3 ] = value;
      return this;
    }
    public RowBuilder_Lehrveranstaltung setSwsRaw(Object value)
    {
      data[ 3 ] = value;
      return this;
    }

    public java.lang.Integer getSws()
    {
      return (java.lang.Integer) data[3];
    }

    public RowBuilder_Lehrveranstaltung setEcts(java.lang.Integer value)
    {
      data[ 4 ] = value;
      return this;
    }
    public RowBuilder_Lehrveranstaltung setEctsRaw(Object value)
    {
      data[ 4 ] = value;
      return this;
    }

    public java.lang.Integer getEcts()
    {
      return (java.lang.Integer) data[4];
    }
    /**
    * Insert a new Row at the end of the Table
    * <code><pre>
    * ds.table_Lehrveranstaltung.insertRow()
    *   .setId( null )
    *   .setProfessorId( null )
    *   .setName( null )
    *   .setSws( null )
    *   .setEcts( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Lehrveranstaltung insertRow()
    {
      return table.insertRow();
    }
    
    /**
    * Insert a new Row at the end of the Table
    * <code><pre>
    * ds.table_Lehrveranstaltung.insertRow()
    *   .setId( null )
    *   .setProfessorId( null )
    *   .setName( null )
    *   .setSws( null )
    *   .setEcts( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Lehrveranstaltung insertRow(LehrveranstaltungModel row)
    {
      return table.insertRow(row);
    }
    
    /**
    * Insert a new Row at the given position
    * <code><pre>
    * ds.table_Lehrveranstaltung.this.insertRowAt(2)
    *   .setId( null )
    *   .setProfessorId( null )
    *   .setName( null )
    *   .setSws( null )
    *   .setEcts( null )
    *   ;
    * </pre></code>
    */
    public RowBuilder_Lehrveranstaltung insertRowAt(int index)
    {
      return table.insertRowAt(index);
    }

    /**
    * Insert a row at the end of the table
    * <code><pre>
    * ds.table_Lehrveranstaltung.insertRow(baseUser);
    * </pre></code>
    */
    public RowBuilder_Lehrveranstaltung insertRow(RowBuilder_Lehrveranstaltung theRow)
    {
      return table.insertRow(theRow);
    }
    
    public Object getValue(String column) throws RuntimeException {
      if(column.equals("id") ) {
        return data[0];
      }
      if(column.equals("professor_id") ) {
        return data[1];
      }
      if(column.equals("name") ) {
        return data[2];
      }
      if(column.equals("sws") ) {
        return data[3];
      }
      if(column.equals("ects") ) {
        return data[4];
      }
      throw new RuntimeException(NAME + " col = " + column);
    }
    

    public RowBuilder_Lehrveranstaltung refProfessorId(RowGetters_Professor reference)
    {
      setProfessorId(reference.getId());
      return this;
    }
    
    @Override
    public RowBuilder_Lehrveranstaltung clone() {
      RowBuilder_Lehrveranstaltung clone = new RowBuilder_Lehrveranstaltung(table);
      clone.setId(getId());
      clone.setProfessorId(getProfessorId());
      clone.setName(getName());
      clone.setSws(getSws());
      clone.setEcts(getEcts());
      return clone;
    }
  }
  
  public LehrveranstaltungWhere findWhere = new LehrveranstaltungWhere(this);

  public static class LehrveranstaltungWhere
  {
    public List<RowBuilder_Lehrveranstaltung> rows;
    LehrveranstaltungTable table;
    
    public LehrveranstaltungWhere(LehrveranstaltungTable theTable) {
       rows = theTable.rows;
       table = theTable;
    }
    
    public RowCollection_Lehrveranstaltung rowComparesTo(Comparable<RowBuilder_Lehrveranstaltung> toSearch) {
      RowCollection_Lehrveranstaltung modifiers = new RowCollection_Lehrveranstaltung(table);
      for (RowBuilder_Lehrveranstaltung row : rows) 
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
    public RowCollection_Lehrveranstaltung id(java.lang.Long toSearch) {
      RowCollection_Lehrveranstaltung modifiers = new RowCollection_Lehrveranstaltung(table);
      for (RowBuilder_Lehrveranstaltung row : rows) 
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
    public RowCollection_Lehrveranstaltung id(Integer toSearch) 
    {
      return id( Long.valueOf(toSearch) );
    }
    public RowCollection_Lehrveranstaltung professorId(java.lang.Long toSearch) {
      RowCollection_Lehrveranstaltung modifiers = new RowCollection_Lehrveranstaltung(table);
      for (RowBuilder_Lehrveranstaltung row : rows) 
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
    public RowCollection_Lehrveranstaltung professorId(Integer toSearch) 
    {
      return professorId( Long.valueOf(toSearch) );
    }
    public RowCollection_Lehrveranstaltung name(java.lang.String toSearch) {
      RowCollection_Lehrveranstaltung modifiers = new RowCollection_Lehrveranstaltung(table);
      for (RowBuilder_Lehrveranstaltung row : rows) 
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
    public RowCollection_Lehrveranstaltung sws(java.lang.Integer toSearch) {
      RowCollection_Lehrveranstaltung modifiers = new RowCollection_Lehrveranstaltung(table);
      for (RowBuilder_Lehrveranstaltung row : rows) 
      {
        if (row.getSws().equals(toSearch)) 
        {
          modifiers.add(row);
        }
      }
      if(modifiers.isEmpty()) {
        throw new RuntimeException("No Row with sws = " + toSearch );
      }
      return modifiers;
    }
    public RowCollection_Lehrveranstaltung ects(java.lang.Integer toSearch) {
      RowCollection_Lehrveranstaltung modifiers = new RowCollection_Lehrveranstaltung(table);
      for (RowBuilder_Lehrveranstaltung row : rows) 
      {
        if (row.getEcts().equals(toSearch)) 
        {
          modifiers.add(row);
        }
      }
      if(modifiers.isEmpty()) {
        throw new RuntimeException("No Row with ects = " + toSearch );
      }
      return modifiers;
    }
  }
  
  /** Inner class! Use RowCollection_Lehrveranstaltung in your code ! */
  public static class RowModify_Lehrveranstaltung extends RowBuilder_Lehrveranstaltung 
  {
      List<RowBuilder_Lehrveranstaltung> _rows;

      public RowModify_Lehrveranstaltung(LehrveranstaltungTable theTable) {
        super(theTable);
        _rows = new ArrayList<RowBuilder_Lehrveranstaltung>();
      }
      
      public void add(RowBuilder_Lehrveranstaltung row) {
          _rows.add(row);
      }
      
      public boolean isEmpty() {
          return _rows.isEmpty();
      }

      public RowModify_Lehrveranstaltung delete() {
          for(RowBuilder_Lehrveranstaltung row : _rows) {
            table.rows.remove(row);
          }
          return this;
      }
        

      public RowModify_Lehrveranstaltung setId(Integer intValue)
      {
        for(RowBuilder_Lehrveranstaltung row : _rows) {
          row.setId(intValue);
        }
        return this;
      }

      public RowModify_Lehrveranstaltung setId(java.lang.Long value)
      {
        for(RowBuilder_Lehrveranstaltung row : _rows) {
          row.setId(value);
        }
        return this;
      }
      public RowModify_Lehrveranstaltung setIdRaw(Object value)
      {
        for(RowBuilder_Lehrveranstaltung row : _rows) {
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

      public RowModify_Lehrveranstaltung setProfessorId(Integer intValue)
      {
        for(RowBuilder_Lehrveranstaltung row : _rows) {
          row.setProfessorId(intValue);
        }
        return this;
      }

      public RowModify_Lehrveranstaltung setProfessorId(java.lang.Long value)
      {
        for(RowBuilder_Lehrveranstaltung row : _rows) {
          row.setProfessorId(value);
        }
        return this;
      }
      public RowModify_Lehrveranstaltung setProfessorIdRaw(Object value)
      {
        for(RowBuilder_Lehrveranstaltung row : _rows) {
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

      public RowModify_Lehrveranstaltung setName(java.lang.String value)
      {
        for(RowBuilder_Lehrveranstaltung row : _rows) {
          row.setName(value);
        }
        return this;
      }
      public RowModify_Lehrveranstaltung setNameRaw(Object value)
      {
        for(RowBuilder_Lehrveranstaltung row : _rows) {
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

      public RowModify_Lehrveranstaltung setSws(java.lang.Integer value)
      {
        for(RowBuilder_Lehrveranstaltung row : _rows) {
          row.setSws(value);
        }
        return this;
      }
      public RowModify_Lehrveranstaltung setSwsRaw(Object value)
      {
        for(RowBuilder_Lehrveranstaltung row : _rows) {
          row.setSwsRaw(value);
        }
        return this;
      }
      public java.lang.Integer getSws()
      {
        if(_rows.size()!=1) {
          throw new RuntimeException("There where multiple Row in the result! " + _rows.size() );
        }
        return _rows.get(0).getSws();
      }

      public RowModify_Lehrveranstaltung setEcts(java.lang.Integer value)
      {
        for(RowBuilder_Lehrveranstaltung row : _rows) {
          row.setEcts(value);
        }
        return this;
      }
      public RowModify_Lehrveranstaltung setEctsRaw(Object value)
      {
        for(RowBuilder_Lehrveranstaltung row : _rows) {
          row.setEctsRaw(value);
        }
        return this;
      }
      public java.lang.Integer getEcts()
      {
        if(_rows.size()!=1) {
          throw new RuntimeException("There where multiple Row in the result! " + _rows.size() );
        }
        return _rows.get(0).getEcts();
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
      public RowModify_Lehrveranstaltung clone() {
        RowModify_Lehrveranstaltung clone = new RowModify_Lehrveranstaltung(table);
        for(RowBuilder_Lehrveranstaltung row:_rows) {
          clone._rows.add(row.clone());
        }
        return clone;
      }

  }
  
  public static class RowCollection_Lehrveranstaltung extends RowModify_Lehrveranstaltung {
    public LehrveranstaltungWhere where = new LehrveranstaltungWhere(table);
    
    public RowCollection_Lehrveranstaltung(LehrveranstaltungTable theTable)
    {
      super(theTable);
    }
    
  }

  /**
  * Insert a new empty Row.
  * <code><pre>
  * ds.table_Lehrveranstaltung.insertRow()
  *   .setId( null )
  *   .setProfessorId( null )
  *   .setName( null )
  *   .setSws( null )
  *   .setEcts( null )
  *   ;
  * </pre></code>
  */
  public RowBuilder_Lehrveranstaltung insertRow()
  {
    RowBuilder_Lehrveranstaltung row = new RowBuilder_Lehrveranstaltung(this);
    row.nextId();
    rows.add(row);
    return row;
  }
  
  /**
  * <code><pre>
  * ds.table_Lehrveranstaltung.insertRow()
  * </pre></code>
  */
  public RowBuilder_Lehrveranstaltung insertRow(LehrveranstaltungModel rowToAdd)
  {
    RowBuilder_Lehrveranstaltung row = new RowBuilder_Lehrveranstaltung(this);
    row.setIdRaw( rowToAdd.getIdRaw() );
    row.setProfessorIdRaw( rowToAdd.getProfessorIdRaw() );
    row.setNameRaw( rowToAdd.getNameRaw() );
    row.setSwsRaw( rowToAdd.getSwsRaw() );
    row.setEctsRaw( rowToAdd.getEctsRaw() );
    rows.add(row);
    return row;
  }

  /**
  * <code><pre>
  * ds.table_Lehrveranstaltung.insertRow(data);
  * </pre></code>
  */
  public RowBuilder_Lehrveranstaltung insertRow(RowBuilder_Lehrveranstaltung theRow)
  {
    rows.add(theRow);
    return theRow;
  }
  
  /**
  * <code><pre>
  * ds.table_Lehrveranstaltung.insertRows(data);
  * </pre></code>
  */
  public void insertRows(RowBuilder_Lehrveranstaltung...theRows)
  {
    rows.addAll(Arrays.asList(theRows));
  }
  
  /**
  * Insert new row at the given index
  * <code><pre>
  * ds.table_Lehrveranstaltung.insertRowAt(3)
  *   ;
  * </pre></code>
  */
  public RowBuilder_Lehrveranstaltung insertRowAt(int index)
  {
    RowBuilder_Lehrveranstaltung row = new RowBuilder_Lehrveranstaltung(this);
    rows.add(index, row);
    return row;
  }
  
  /**
  * Insert new row Object at the given index
  * <code><pre>
  * ds.table_Lehrveranstaltung.insertRowAt(3)
  * </pre></code>
  */
  public RowBuilder_Lehrveranstaltung insertRowAt(int index,RowBuilder_Lehrveranstaltung theRow)
  {
    rows.add(index, theRow);
    return theRow;
  }
  
  /**
   * Remove a row from the builder by the given index.
   *
   * @return the deleted row
   */ 
  public RowBuilder_Lehrveranstaltung deleteRow(int index)
  {
    RowBuilder_Lehrveranstaltung rowBuilder = rows.get(index);
    rows.remove(rowBuilder);
    return rowBuilder;
  }
  
  /**
   * Remove a row from the builder
   */ 
  public RowBuilder_Lehrveranstaltung deleteRow(RowBuilder_Lehrveranstaltung rowToDelete)
  {
    rows.remove(rowToDelete);
    return rowToDelete;
  }

  /**
  * Creates a new row but does not add it to the table
  */
  public RowBuilder_Lehrveranstaltung newRow()
  {
    RowBuilder_Lehrveranstaltung row = new RowBuilder_Lehrveranstaltung(this);
    return row;
  }
  
  /**
  * Returns the next Object. The internal iterator is started at 
  * the first call.
  */
  public RowBuilder_Lehrveranstaltung next()
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
