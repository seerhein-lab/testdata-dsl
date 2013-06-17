package com.seitenbau.testdatadsl.dbunit.stu.generator;

import com.seitenbau.testdatadsl.dbunit.stu.model.SBTestingModel;

public class SBTGenerator {

  public static void main(String[] args) throws Exception {
    new SBTestingModel().generate();
  }
}
