package com.seitenbau.testdatadsl.stu

abstract class ColumnBinding<R>
{
  
  abstract void set(R row, Object value);

}
