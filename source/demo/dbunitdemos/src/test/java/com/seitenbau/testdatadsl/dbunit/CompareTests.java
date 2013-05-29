package com.seitenbau.testdatadsl.dbunit;

import org.dbunit.Assertion;
import org.junit.Ignore;
import org.junit.Test;

import com.seitenbau.testdatadsl.dbunit.common.datasetproviders.IDataSetProvider;
import com.seitenbau.testdatadsl.dbunit.flatxml.FlatXmlDataSetProvider;
import com.seitenbau.testdatadsl.dbunit.java.JavaDataSetProvider;
import com.seitenbau.testdatadsl.dbunit.sbtesting.datasetprovider.OldSBTestingDataSetProvider;
import com.seitenbau.testdatadsl.dbunit.sbtesting.datasetprovider.SBTestingDataSetProvider;
import com.seitenbau.testdatadsl.dbunit.simpledsl.SimpleDSLDataSetProvider;
import com.seitenbau.testdatadsl.dbunit.stu.STUDataSetProvider;
import com.seitenbau.testdatadsl.dbunit.xml.XmlDataSetProvider;

public class CompareTests
{

  private static final IDataSetProvider SIMPLEDSL = new SimpleDSLDataSetProvider();
  private static final IDataSetProvider STUDATASET = new STUDataSetProvider();
  private static final IDataSetProvider XML = new XmlDataSetProvider();
  private static final IDataSetProvider FLATXML = new FlatXmlDataSetProvider();
  private static final IDataSetProvider JAVA = new JavaDataSetProvider();
  private static final IDataSetProvider SBTESTOLD = new OldSBTestingDataSetProvider();
  private static final IDataSetProvider SBTEST = new SBTestingDataSetProvider();

  // Date comparison issues
  @Ignore
  @Test
  public void testCompareXMLandJava() throws Exception
  {
    Assertion.assertEquals(XML.getDataSet(), JAVA.getDataSet());
  }

  // Date comparison issues
  @Ignore
  @Test
  public void testCompareXMLandFlatXML() throws Exception
  {
    Assertion.assertEquals(XML.getDataSet(), FLATXML.getDataSet());
  }

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

  // Date comparison issues
  @Ignore
  @Test
  public void testCompareJavaAndSimpleDSLTest() throws Exception
  {
    Assertion.assertEquals(JAVA.getDataSet(), SIMPLEDSL.getDataSet());
  }
  
  @Test
  public void testCompareJavaAndSTUDataSetTest() throws Exception
  {
    Assertion.assertEquals(JAVA.getDataSet(), STUDATASET.getDataSet());
  }
  
}
