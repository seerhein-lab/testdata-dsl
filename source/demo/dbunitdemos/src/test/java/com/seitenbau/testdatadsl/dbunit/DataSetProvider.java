package com.seitenbau.testdatadsl.dbunit;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.dataset.xml.XmlDataSet;

import com.seitenbau.testdatadsl.dbunit.java.JavaDataSetProvider;
import com.seitenbau.testdatadsl.dbunit.sbtesting.OldSBTestingDataSet;
import com.seitenbau.testdatadsl.dbunit.sbtesting.SBTestingDataSet;
import com.seitenbau.testdatadsl.dbunit.simpledsl.SimpleDSLDataSetProvider;
import com.seitenbau.testdatadsl.dbunit.stu.HochschuleDataSet;

public class DataSetProvider
{

  private static IDataSet xmlDataSet = null;

  public static IDataSet getXMLDataSet()
  {
    if (xmlDataSet == null)
    {
      try
      {
        xmlDataSet = new XmlDataSet(DataSetProvider.class.getResourceAsStream("xml/dataset.xml"));
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return xmlDataSet;
  }

  private static IDataSet flatXmlDataSet = null;

  public static IDataSet getFlatXmlDataSet()
  {
    if (flatXmlDataSet == null)
    {
      try
      {
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        builder.setColumnSensing(true);
        builder.setCaseSensitiveTableNames(false);
        flatXmlDataSet = builder.build(DataSetProvider.class.getResourceAsStream("flatxml/flatdataset.xml"));
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return flatXmlDataSet;
  }
  
  private static IDataSet simpleDSLDataSet = null;

  public static IDataSet getSimpleDSLDataSet()
  {
    if (simpleDSLDataSet == null)
    {
      simpleDSLDataSet = new SimpleDSLDataSetProvider().getDataSet();
    }
    return simpleDSLDataSet;
  }

  private static IDataSet stuDataSet = null;

  public static IDataSet getSTUDataSet()
  {
    if (stuDataSet == null)
    {
      stuDataSet = new HochschuleDataSet().createDataSet();
    }
    return stuDataSet;
  }

  private static IDataSet javaDataSet = null;

  public static IDataSet getJavaDataSet()
  {
    if (javaDataSet == null) 
    {
      javaDataSet = JavaDataSetProvider.createDataSet();
    }
    return javaDataSet;
  }

  private static IDataSet oldSBTestingDataSet = null;

  public static IDataSet getOldSBTestingDataSet()
  {
    if (oldSBTestingDataSet == null) 
    {
      oldSBTestingDataSet = new OldSBTestingDataSet().createDBUnitDataSet();   
    }
    return oldSBTestingDataSet;
  }

  private static IDataSet sbTestingDataSet = null;

  public static IDataSet getSBTestingDataSet()
  {
    if (sbTestingDataSet == null) 
    {
      sbTestingDataSet = new SBTestingDataSet().createDBUnitDataSet();   
    }
    return sbTestingDataSet;
  }

}
