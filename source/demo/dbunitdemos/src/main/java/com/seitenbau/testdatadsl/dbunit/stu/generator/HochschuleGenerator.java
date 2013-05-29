package com.seitenbau.testdatadsl.dbunit.stu.generator;

import com.seitenbau.testdatadsl.dbunit.stu.model.HochschuleModel;

public class HochschuleGenerator {
  
	public static void main(String[] args) throws Exception {
	  new HochschuleModel().generate();
	}
}
