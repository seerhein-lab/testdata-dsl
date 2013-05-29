package com.seitenbau.testdatadsl.dbunit.stu;

import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;

import com.seitenbau.testdatadsl.dbunit.common.datasetproviders.IDataSetProvider;

public class STUDataSetProvider implements IDataSetProvider
{

  private final IDataSet dataSet = new HochschuleDataSet().createDataSet();
  
  @Override
  public IDataSet getDataSet() throws DataSetException
  {
    return dataSet;
  }

}
