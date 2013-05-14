package com.seitenbau.testdatadsl.stu

import groovy.transform.ToString

@ToString
class TableRowModel
{
  List values = []

  public TableRowModel or(arg) {
    println "TableRowModel or(" + arg + ")"
    values.add(arg);
    return this;
  }
  
  public int getColumnCount() {
    return values.size();
  }
  
  public boolean isHeadRow() {
    if (values.size() == 0) {
      return false;
    }
    
    for (Object o : values) {
      if (!(o instanceof ColumnBinding)) {
        return false;
      }
    }
    
    return true;
  }
  
  public int getRefColumn() {
    int result = -1;
    int index = 0;
    values.each { ColumnBinding column ->
      if (column.name == "REF") result = index
      index++
    }
    return result;
  }
  
  public int getIdColumn() {
    int result = -1;
    int index = 0;
    values.each { ColumnBinding column ->
      if (column.isIdentificator) result = index
      index++
    }
    return result;
  }

}
