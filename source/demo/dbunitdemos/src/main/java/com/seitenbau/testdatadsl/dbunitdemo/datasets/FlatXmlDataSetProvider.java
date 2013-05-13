package com.seitenbau.testdatadsl.dbunitdemo.datasets;

import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

import com.seitenbau.testdatadsl.dbunitdemo.IDataSetProvider;

public class FlatXmlDataSetProvider implements IDataSetProvider
{

  private final IDataSet dataset;

  public FlatXmlDataSetProvider()
  {
    IDataSet r = null;
    try
    {
      FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
      builder.setColumnSensing(true);
      builder.setCaseSensitiveTableNames(false);
      r = builder.build(this.getClass().getResourceAsStream("flatdataset.xml"));
    }
    catch (Exception e)
    {
      e.printStackTrace();
      r = null;
    }
    dataset = r;
  }

  public IDataSet getDataSet() throws DataSetException
  {
    if (dataset == null)
      throw new DataSetException("Xml Data Set error");
    return dataset;
  }

}
