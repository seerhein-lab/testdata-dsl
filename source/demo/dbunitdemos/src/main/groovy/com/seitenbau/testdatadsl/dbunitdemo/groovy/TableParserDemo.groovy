package com.seitenbau.testdatadsl.dbunitdemo.groovy

def table = TableParser.parse {
	a    |  b
	"A"  |  "B"
	1    |  2
	true | false
}
println table

