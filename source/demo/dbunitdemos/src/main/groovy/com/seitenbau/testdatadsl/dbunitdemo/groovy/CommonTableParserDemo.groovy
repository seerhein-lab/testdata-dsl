package com.seitenbau.testdatadsl.dbunitdemo.groovy

def table = CommonTableParser.parse {
 	a    |  b
  "A"  |  "B"
	1    |  2
	true | false
}
println table

