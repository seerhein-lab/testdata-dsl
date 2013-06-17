package com.seitenbau.testdatadsl.dbunit.examples

import static com.seitenbau.testdatadsl.dbunit.stu.HochschuleRefs.*

import com.seitenbau.stu.dbunit.hochschule.HochschuleBuilder
import com.seitenbau.testdatadsl.dbunit.common.util.DateUtil
import com.seitenbau.testing.dbunit.dsl.DataSetRegistry

HochschuleBuilder dataset = new HochschuleBuilder()
dataset.tables {
  
  lehrveranstaltungTable.rows {
    //id  | name | sws | ects | professor
    sws   | id
    true  | 1
  }

}
DataSetRegistry.use(dataset)
println dataset.lehrveranstaltungTable.getRowCount()
println dataset.lehrveranstaltungTable.findWhere.id(1).getRowCount()

