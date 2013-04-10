package com.seitenbau.testdatadsl.dbunitdemo.sbtesting;

import com.seitenbau.testing.dbunit.util.DbCompare;
import com.seitenbau.testing.util.DateUtil;
import com.seitenbau.testing.util.date.Datum;
import com.seitenbau.testing.dbunit.extend.DatasetIdGenerator;
import com.seitenbau.testing.dbunit.extend.impl.DefaultIdGenerator;
import org.dbunit.dataset.DefaultDataSet;
import org.dbunit.dataset.IDataSet;
import java.util.Date;

import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.ProfessorTable.RowBuilder_Professor;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.ProfessorModel;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.LehrveranstaltungTable.RowBuilder_Lehrveranstaltung;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.LehrveranstaltungModel;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.PruefungTable.RowBuilder_Pruefung;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.PruefungModel;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.StudentTable.RowBuilder_Student;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.StudentModel;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.BeaufsichtigtTable.RowBuilder_Beaufsichtigt;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.BeaufsichtigtModel;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.BesuchtTable.RowBuilder_Besucht;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.BesuchtModel;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.IsttutorTable.RowBuilder_Isttutor;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.IsttutorModel;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.SchreibtTable.RowBuilder_Schreibt;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.SchreibtModel;

/*********************************************************
  Generated via {@link com.seitenbau.testing.dbunit.generator.DatabaseModel#generate }
**********************************************************/
public class DBUnitExamplesDataSet
             implements com.seitenbau.testing.dbunit.extend.DbUnitDatasetFactory
{
  Datum _jetzt = DateUtil.datum();
  
  DatasetIdGenerator _idGenerator;

  public ProfessorTable table_Professor = new ProfessorTable();
  public LehrveranstaltungTable table_Lehrveranstaltung = new LehrveranstaltungTable();
  public PruefungTable table_Pruefung = new PruefungTable();
  public StudentTable table_Student = new StudentTable();
  public BeaufsichtigtTable table_Beaufsichtigt = new BeaufsichtigtTable();
  public BesuchtTable table_Besucht = new BesuchtTable();
  public IsttutorTable table_Isttutor = new IsttutorTable();
  public SchreibtTable table_Schreibt = new SchreibtTable();

  public DBUnitExamplesDataSet() 
  {
    table_Professor.setDataset(this);
    table_Lehrveranstaltung.setDataset(this);
    table_Pruefung.setDataset(this);
    table_Student.setDataset(this);
    table_Beaufsichtigt.setDataset(this);
    table_Besucht.setDataset(this);
    table_Isttutor.setDataset(this);
    table_Schreibt.setDataset(this);
    beforeInitDataSet();
    initDataSet();
    afterInitDataSet();
  }

  public IDataSet createDBUnitDataSet()
  {
    beforeDataSetCreation();
 try {     DefaultDataSet dataSet = new DefaultDataSet();
    dataSet.addTable(table_Professor);
    table_Professor.resetIterator();
    dataSet.addTable(table_Lehrveranstaltung);
    table_Lehrveranstaltung.resetIterator();
    dataSet.addTable(table_Pruefung);
    table_Pruefung.resetIterator();
    dataSet.addTable(table_Student);
    table_Student.resetIterator();
    dataSet.addTable(table_Beaufsichtigt);
    table_Beaufsichtigt.resetIterator();
    dataSet.addTable(table_Besucht);
    table_Besucht.resetIterator();
    dataSet.addTable(table_Isttutor);
    table_Isttutor.resetIterator();
    dataSet.addTable(table_Schreibt);
    table_Schreibt.resetIterator();
     afterDataSetCreation(dataSet);
     return finalModify( dataSet );
    } catch(org.dbunit.database.AmbiguousTableNameException e) {
       throw new RuntimeException(e);
    } 
  }
  
  /**
   * Injection point. Last processing template method to modify the resulting 
   * Dataset created by createDBUnitDataSet(). 
   * You should really know what you're doing!
   *
   * @param dataSet
   * @return
   */
  protected DefaultDataSet finalModify(DefaultDataSet dataSet)
  {
    return dataSet;
  }
  
  /**
   * Template Method, get's called after createDBUnitDataSet() method
   * Use this only if really needed.
   */
  protected void afterDataSetCreation(DefaultDataSet dataSet)  throws org.dbunit.database.AmbiguousTableNameException  {
  }

  /**
   * Template Method, get's called before createDBUnitDataSet() method.
   * Use this only if really needed. 
   */
  protected void beforeDataSetCreation()
  {
  }
  
  /**
   * Template Method, got called after the initDataSet() method
   */
  protected void afterInitDataSet()
  {
  }

  /**
   * Tempalte Method, got called before the initDataSet() method
   */
  protected void beforeInitDataSet()
  {
  }

  /**
   * Initialize the Dataset content here.
   */
  protected void initDataSet()
  {
  }
  
  /** Compare the given Date to be 'equal' around (+-15s). */
  public Date around(Datum datum) 
  {
      return DbCompare.warp(datum);
  }

  /** 
   * <p>
   * Create org get the 'current' timestamp as Datum Builder. 
   * Subsequent calls will give you the same builder again!
   * This allows you to use the same "now" for the complete testclass.
   * </p>
   */
  public Datum jetzt()
  {
    return _jetzt;
  }
  
  /**
   * Change the used id generator
   **/
  public void setIdGenerator(DatasetIdGenerator gen)
  {
    _idGenerator = gen;
  }
  
  public DatasetIdGenerator getIdGenerator()
  {
    if(_idGenerator == null) 
    {
      _idGenerator = new DefaultIdGenerator();
    }
    return _idGenerator;
  }
  
  
  /** run the given modifiers on this dataset */
  public DBUnitExamplesDataSet modify(DBUnitExamplesDataSetModifier...modifiers) 
  {
    if(modifiers==null) { return this; }
    for(DBUnitExamplesDataSetModifier modifier : modifiers) 
    {
      modifier.modify(this);
    }
    return this;
  }
  
  public static interface DBUnitExamplesDataSetModifier {
    void modify(DBUnitExamplesDataSet dataset);
  }
  
  /* ************************************************************ */
  /* *             convenient add(*) methods                    * */
  /* ************************************************************ */
  
  /** 
   * Adds the given row into the Table 'professor'
   */
  public RowBuilder_Professor add(RowBuilder_Professor row) 
  {
    return table_Professor.insertRow(row);
  }
  /** 
   * Adds the given row into the Table 'professor'
   */
  public RowBuilder_Professor add(ProfessorModel row) 
  {
    return table_Professor.insertRow(row);
  }
  /**
   * ! work in progress !
   * create a new Model of the Type ProfessorModel with 
   * the same IdGenerator that this Dataset  
   */
  public ProfessorModel createProfessor() 
  {
    ProfessorModel model = new ProfessorModel();
    model.setIdGenerator(getIdGenerator());
    model.nextId();
    return model;
  }
  /** 
   * Adds the given row into the Table 'lehrveranstaltung'
   */
  public RowBuilder_Lehrveranstaltung add(RowBuilder_Lehrveranstaltung row) 
  {
    return table_Lehrveranstaltung.insertRow(row);
  }
  /** 
   * Adds the given row into the Table 'lehrveranstaltung'
   */
  public RowBuilder_Lehrveranstaltung add(LehrveranstaltungModel row) 
  {
    return table_Lehrveranstaltung.insertRow(row);
  }
  /**
   * ! work in progress !
   * create a new Model of the Type LehrveranstaltungModel with 
   * the same IdGenerator that this Dataset  
   */
  public LehrveranstaltungModel createLehrveranstaltung() 
  {
    LehrveranstaltungModel model = new LehrveranstaltungModel();
    model.setIdGenerator(getIdGenerator());
    model.nextId();
    return model;
  }
  /** 
   * Adds the given row into the Table 'pruefung'
   */
  public RowBuilder_Pruefung add(RowBuilder_Pruefung row) 
  {
    return table_Pruefung.insertRow(row);
  }
  /** 
   * Adds the given row into the Table 'pruefung'
   */
  public RowBuilder_Pruefung add(PruefungModel row) 
  {
    return table_Pruefung.insertRow(row);
  }
  /**
   * ! work in progress !
   * create a new Model of the Type PruefungModel with 
   * the same IdGenerator that this Dataset  
   */
  public PruefungModel createPruefung() 
  {
    PruefungModel model = new PruefungModel();
    model.setIdGenerator(getIdGenerator());
    model.nextId();
    return model;
  }
  /** 
   * Adds the given row into the Table 'student'
   */
  public RowBuilder_Student add(RowBuilder_Student row) 
  {
    return table_Student.insertRow(row);
  }
  /** 
   * Adds the given row into the Table 'student'
   */
  public RowBuilder_Student add(StudentModel row) 
  {
    return table_Student.insertRow(row);
  }
  /**
   * ! work in progress !
   * create a new Model of the Type StudentModel with 
   * the same IdGenerator that this Dataset  
   */
  public StudentModel createStudent() 
  {
    StudentModel model = new StudentModel();
    model.setIdGenerator(getIdGenerator());
    model.nextMatrikelnummer();
    return model;
  }
  /** 
   * Adds the given row into the Table 'beaufsichtigt'
   */
  public RowBuilder_Beaufsichtigt add(RowBuilder_Beaufsichtigt row) 
  {
    return table_Beaufsichtigt.insertRow(row);
  }
  /** 
   * Adds the given row into the Table 'beaufsichtigt'
   */
  public RowBuilder_Beaufsichtigt add(BeaufsichtigtModel row) 
  {
    return table_Beaufsichtigt.insertRow(row);
  }
  /**
   * ! work in progress !
   * create a new Model of the Type BeaufsichtigtModel with 
   * the same IdGenerator that this Dataset  
   */
  public BeaufsichtigtModel createBeaufsichtigt() 
  {
    BeaufsichtigtModel model = new BeaufsichtigtModel();
    model.setIdGenerator(getIdGenerator());
    return model;
  }
  /** 
   * Adds the given row into the Table 'besucht'
   */
  public RowBuilder_Besucht add(RowBuilder_Besucht row) 
  {
    return table_Besucht.insertRow(row);
  }
  /** 
   * Adds the given row into the Table 'besucht'
   */
  public RowBuilder_Besucht add(BesuchtModel row) 
  {
    return table_Besucht.insertRow(row);
  }
  /**
   * ! work in progress !
   * create a new Model of the Type BesuchtModel with 
   * the same IdGenerator that this Dataset  
   */
  public BesuchtModel createBesucht() 
  {
    BesuchtModel model = new BesuchtModel();
    model.setIdGenerator(getIdGenerator());
    return model;
  }
  /** 
   * Adds the given row into the Table 'isttutor'
   */
  public RowBuilder_Isttutor add(RowBuilder_Isttutor row) 
  {
    return table_Isttutor.insertRow(row);
  }
  /** 
   * Adds the given row into the Table 'isttutor'
   */
  public RowBuilder_Isttutor add(IsttutorModel row) 
  {
    return table_Isttutor.insertRow(row);
  }
  /**
   * ! work in progress !
   * create a new Model of the Type IsttutorModel with 
   * the same IdGenerator that this Dataset  
   */
  public IsttutorModel createIsttutor() 
  {
    IsttutorModel model = new IsttutorModel();
    model.setIdGenerator(getIdGenerator());
    return model;
  }
  /** 
   * Adds the given row into the Table 'schreibt'
   */
  public RowBuilder_Schreibt add(RowBuilder_Schreibt row) 
  {
    return table_Schreibt.insertRow(row);
  }
  /** 
   * Adds the given row into the Table 'schreibt'
   */
  public RowBuilder_Schreibt add(SchreibtModel row) 
  {
    return table_Schreibt.insertRow(row);
  }
  /**
   * ! work in progress !
   * create a new Model of the Type SchreibtModel with 
   * the same IdGenerator that this Dataset  
   */
  public SchreibtModel createSchreibt() 
  {
    SchreibtModel model = new SchreibtModel();
    model.setIdGenerator(getIdGenerator());
    return model;
  }
}
