package com.seitenbau.testdatadsl.dbunitdemo.groovy;

public class VariableElement extends ColumnElement  {

	private final String name;
	
	public VariableElement(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}

}
