package com.seitenbau.testdatadsl.dbunitdemo.groovy.ast;

public class ValueElement extends ColumnElement {
	private final Object value;
	
	public ValueElement(Object value) {
		this.value = value;
	}
	
	public String toString() {
		if (value == null) {
			return "null";
		}
		return value.toString();
	}
}
