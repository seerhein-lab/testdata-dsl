package com.seitenbau.testdatadsl.dbunit.ast;

public class VariableElement extends ColumnElement  {

  private final String name;

  public VariableElement(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

}
