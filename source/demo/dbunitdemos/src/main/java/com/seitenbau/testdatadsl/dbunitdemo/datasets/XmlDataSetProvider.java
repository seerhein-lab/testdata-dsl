package com.seitenbau.testdatadsl.dbunitdemo.datasets;

import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;

import com.seitenbau.testdatadsl.dbunitdemo.IDataSetProvider;

public class XmlDataSetProvider implements IDataSetProvider {

	private final IDataSet dataset;

	public XmlDataSetProvider() {
		IDataSet r = null;
		try {
			r = new XmlDataSet(this.getClass().getResourceAsStream(
					"dataset.xml"));
		} catch (Exception e) {
			r = null;
		}
		dataset = r;
	}

	public IDataSet getDataSet() throws DataSetException {
		if (dataset == null)
			throw new DataSetException("Xml Data Set error");
		return dataset;
	}

}
