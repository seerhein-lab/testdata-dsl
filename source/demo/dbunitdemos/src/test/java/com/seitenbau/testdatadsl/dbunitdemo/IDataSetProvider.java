package com.seitenbau.testdatadsl.dbunitdemo;

import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;

public interface IDataSetProvider {
	IDataSet getDataSet() throws DataSetException;
}
