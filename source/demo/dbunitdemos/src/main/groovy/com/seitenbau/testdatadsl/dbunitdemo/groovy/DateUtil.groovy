package com.seitenbau.testdatadsl.dbunitdemo.groovy

class DateUtil
{
  static Date getDate(int year, int month, int dom, int hour = 0, int minute = 0, int second = 0) 
  {
    Calendar cal = Calendar.getInstance()
    cal.set(Calendar.YEAR, year)
    cal.set(Calendar.MONTH, month)
    cal.set(Calendar.DAY_OF_MONTH, dom)
    cal.set(Calendar.HOUR, hour)
    cal.set(Calendar.MINUTE, minute)
    cal.set(Calendar.SECOND, second)
    cal.set(Calendar.MILLISECOND, 0)
    return cal.getTime()
  }
}
