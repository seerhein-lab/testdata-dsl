package com.seitenbau.testdatadsl.dbunitdemo.groovy;

import java.util.List;

public class VariableListElement extends ColumnElement {
	
	private final List<VariableElement> list;

	public VariableListElement(List<VariableElement> list) {
		this.list = list;
	}
	
	public String toString() {
		final StringBuilder result = new StringBuilder();
		result.append("(");
		for (VariableElement e : list) {
			if (result.length() > 1) {
				result.append(", ");
			}
			result.append(e.toString());
		}
		result.append(")");
		return result.toString();
	}

}
