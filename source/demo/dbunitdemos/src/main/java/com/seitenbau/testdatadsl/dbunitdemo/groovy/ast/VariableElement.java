package com.seitenbau.testdatadsl.dbunitdemo.groovy.ast;

public class VariableElement extends ColumnElement  {

	private final String name;
	
	public VariableElement(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}

}
