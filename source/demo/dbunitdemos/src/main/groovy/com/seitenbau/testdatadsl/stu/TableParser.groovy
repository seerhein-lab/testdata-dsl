package com.seitenbau.testdatadsl.stu

import java.util.List;

import groovy.lang.Closure;

public class TableParser
{
  public interface IParsedRowCallback {
    void parsedRow(TableRowModel row);
  }
  
  private static ThreadLocal<List<TableRowModel>> context = new ThreadLocal<List<TableRowModel>>()
  private static ThreadLocal<IParsedRowCallback> callbacks = new ThreadLocal<IParsedRowCallback>()
  
  public static or(self, arg) {
    appendRow(self, arg)
  }

  public static or(Integer self, Integer arg) {
    appendRow(self, arg)
  }

  public static or(Boolean self, Boolean arg) {
    appendRow(self, arg)
  }

  public static appendRow(value, nextValue) {
    println "appendRow " + value + ", " + nextValue
    def row = new TableRowModel(values: [value])
    context.get().add(row)
    row.or(nextValue)
  }

  public static List<TableRowModel> parseTable(Closure rows, IParsedRowCallback callback) {
    callbacks.set(callback)
    context.set([])
    use(TableParser) {
      rows.delegate = this
      rows.resolveStrategy = Closure.DELEGATE_FIRST
      rows()
    }
    
    final List<TableRowModel> result = context.get()
    context.set([])
    return result;
  }

}
