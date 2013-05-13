package com.seitenbau.testdatadsl.dbunitdemo.sbtesting.old;

import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;

import com.seitenbau.testdatadsl.dbunitdemo.IDataSetProvider;

public class OldSBTestingDataSetProvider implements IDataSetProvider {
	
	private final IDataSet dataset;

	public OldSBTestingDataSetProvider() {
		dataset = createDataSet();
	}
	
	private IDataSet createDataSet() {
		try {
			return new OldDefaultDataSet().createDBUnitDataSet();
		}
		catch (Exception e) {
			return null;
		}
	}

	public IDataSet getDataSet() throws DataSetException {
		if (dataset == null) throw new DataSetException("SB Testing Data Set Error");
		return dataset;
	}

}
