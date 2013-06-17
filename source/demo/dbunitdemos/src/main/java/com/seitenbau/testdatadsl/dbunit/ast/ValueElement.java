package com.seitenbau.testdatadsl.dbunit.ast;

public class ValueElement extends ColumnElement {
  private final Object value;

  public ValueElement(Object value) {
    this.value = value;
  }

  @Override
  public String toString() {
    if (value == null) {
      return "null";
    }
    return "\"" + value.toString() + "\"";
  }
}
