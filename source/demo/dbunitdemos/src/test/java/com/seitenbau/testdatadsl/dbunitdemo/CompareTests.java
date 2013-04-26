package com.seitenbau.testdatadsl.dbunitdemo;

import org.dbunit.Assertion;
import org.junit.Ignore;
import org.junit.Test;

import com.seitenbau.testdatadsl.dbunitdemo.dsl1.GroovyDataSetProvider;
import com.seitenbau.testdatadsl.dbunitdemo.groovy.GroovyDataSetProvider2;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.OldSBTestingDataSetProvider;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.SBTestingDataSetProvider;

public class CompareTests
{

  private static final IDataSetProvider GROOVY = new GroovyDataSetProvider();
  private static final IDataSetProvider GROOVY2 = new GroovyDataSetProvider2();
  private static final IDataSetProvider XML = new XmlDataSetProvider();
  private static final IDataSetProvider JAVA = new JavaDataSetProvider();
  private static final IDataSetProvider SBTESTOLD = new OldSBTestingDataSetProvider();
  private static final IDataSetProvider SBTEST = new SBTestingDataSetProvider();

  @Test
  public void testCompareXMLandJava() throws Exception
  {
    Assertion.assertEquals(XML.getDataSet(), JAVA.getDataSet());
  }

  @Test
  public void testCompareXMLandSBTestOld() throws Exception
  {
    Assertion.assertEquals(XML.getDataSet(), SBTESTOLD.getDataSet());
  }

  @Test
  public void testCompareXMLandSBTest() throws Exception
  {
    Assertion.assertEquals(XML.getDataSet(), SBTEST.getDataSet());
  }

  @Ignore
  @Test
  public void testCompareXMLandGroovyTest() throws Exception
  {
    Assertion.assertEquals(XML.getDataSet(), GROOVY.getDataSet());
  }
  
  @Test
  public void testCompareXMLandGroovy2Test() throws Exception
  {
    Assertion.assertEquals(XML.getDataSet(), GROOVY2.getDataSet());
  }
  
}
