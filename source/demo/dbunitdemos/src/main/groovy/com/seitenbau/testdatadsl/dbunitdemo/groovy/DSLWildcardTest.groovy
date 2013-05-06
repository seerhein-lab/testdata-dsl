package com.seitenbau.testdatadsl.dbunitdemo.groovy

class DSLWildcardTest
{
  DSLWildcardTest with = this
  
  DSLWildcardTest set = this

  DSLWildcardTest and = this

  DSLWildcardTest name = this

  DSLWildcardTest vorname = this

  DSLWildcardTest matches(String regex) {
    return this
  }

  DSLWildcardTest contains(String text) {
    return this
  }
  
  DSLWildcardTest beaufsichtigt(String s) {
    return this
  }
}



