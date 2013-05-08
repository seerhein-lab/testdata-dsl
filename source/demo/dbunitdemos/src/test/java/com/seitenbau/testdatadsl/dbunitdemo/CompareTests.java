package com.seitenbau.testdatadsl.dbunitdemo;

import org.dbunit.Assertion;
import org.junit.Ignore;
import org.junit.Test;

import com.seitenbau.testdatadsl.dbunitdemo.dsl1.GroovySimpleDSLDataSetProvider;
import com.seitenbau.testdatadsl.dbunitdemo.groovy.GroovyOpOverloadingDataSetProvider;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.OldSBTestingDataSetProvider;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.SBTestingDataSetProvider;

public class CompareTests
{

  private static final IDataSetProvider GROOVY = new GroovySimpleDSLDataSetProvider();
  private static final IDataSetProvider GROOVY2 = new GroovyOpOverloadingDataSetProvider();
  //private static final IDataSetProvider XML = new XmlDataSetProvider();
  //private static final IDataSetProvider FLATXML = new FlatXmlDataSetProvider();
  private static final IDataSetProvider JAVA = new JavaDataSetProvider();
  private static final IDataSetProvider SBTESTOLD = new OldSBTestingDataSetProvider();
  private static final IDataSetProvider SBTEST = new SBTestingDataSetProvider();

//  @Test
//  public void testCompareXMLandJava() throws Exception
//  {
//    Assertion.assertEquals(XML.getDataSet(), JAVA.getDataSet());
//  }
//
//  @Test
//  public void testCompareXMLandFlatXML() throws Exception
//  {
//    Assertion.assertEquals(XML.getDataSet(), FLATXML.getDataSet());
//  }

  @Test
  public void testCompareJavaAndSBTestOld() throws Exception
  {
    Assertion.assertEquals(JAVA.getDataSet(), SBTESTOLD.getDataSet());
  }

  @Test
  public void testCompareJavaAndSBTest() throws Exception
  {
    Assertion.assertEquals(JAVA.getDataSet(), SBTEST.getDataSet());
  }

  @Ignore
  @Test
  public void testCompareJavaAndGroovyTest() throws Exception
  {
    Assertion.assertEquals(JAVA.getDataSet(), GROOVY.getDataSet());
  }
  
  @Test
  public void testCompareJavaAndGroovy2Test() throws Exception
  {
    Assertion.assertEquals(JAVA.getDataSet(), GROOVY2.getDataSet());
  }
  
}
