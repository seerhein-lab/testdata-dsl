package com.seitenbau.testdatadsl.dbunitdemo.groovy

DSLWildcardTest professor = new DSLWildcardTest()
professor.with.name.matches("regex").and.vorname.contains("x").set.beaufsichtigt("VSYS")
//"name" 
//matches "regex" and vorname contains "x" set beaufsichtigt "VSYS"
//professor with { name matches "regex" and contains "x" } beaufsichtigt "VSYS"
//professor with  println "with" } beaufsichtigt { "VSYS" }

