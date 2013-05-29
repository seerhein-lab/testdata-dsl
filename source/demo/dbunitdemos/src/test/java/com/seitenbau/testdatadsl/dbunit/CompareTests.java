package com.seitenbau.testdatadsl.dbunit;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.junit.Ignore;
import org.junit.Test;

public class CompareTests
{

  private static final IDataSet SIMPLEDSL = DataSetProvider.getSimpleDSLDataSet();
  private static final IDataSet STUDATASET = DataSetProvider.getSTUDataSet();
  private static final IDataSet XML = DataSetProvider.getXMLDataSet();
  private static final IDataSet FLATXML = DataSetProvider.getFlatXmlDataSet();
  private static final IDataSet JAVA = DataSetProvider.getJavaDataSet();
  private static final IDataSet SBTESTOLD = DataSetProvider.getOldSBTestingDataSet();
  private static final IDataSet SBTEST = DataSetProvider.getSBTestingDataSet();

  // Date comparison issues
  @Ignore
  @Test
  public void testCompareXMLandJava() throws Exception
  {
    Assertion.assertEquals(XML, JAVA);
  }

  // Date comparison issues
  @Ignore
  @Test
  public void testCompareXMLandFlatXML() throws Exception 
  {
    Assertion.assertEquals(XML, FLATXML);
  }

  @Test
  public void testCompareJavaAndSBTestOld() throws Exception 
  {
    Assertion.assertEquals(JAVA, SBTESTOLD);
  }

  @Test
  public void testCompareJavaAndSBTest() throws Exception
  {
    Assertion.assertEquals(JAVA, SBTEST);
  }

  // Date comparison issues
  @Ignore
  @Test
  public void testCompareJavaAndSimpleDSLTest() throws Exception
  {
    Assertion.assertEquals(JAVA, SIMPLEDSL);
  }
  
  @Test
  public void testCompareJavaAndSTUDataSetTest() throws Exception
  {
    Assertion.assertEquals(JAVA, STUDATASET);
  }
  
}
