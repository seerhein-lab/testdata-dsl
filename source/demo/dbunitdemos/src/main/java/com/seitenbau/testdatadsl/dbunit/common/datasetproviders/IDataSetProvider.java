package com.seitenbau.testdatadsl.dbunit.common.datasetproviders;

import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;

public interface IDataSetProvider {
	IDataSet getDataSet() throws DataSetException;
}
