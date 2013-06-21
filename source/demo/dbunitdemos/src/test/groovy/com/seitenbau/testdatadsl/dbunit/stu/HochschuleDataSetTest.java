package com.seitenbau.testdatadsl.dbunit.stu;

import org.dbunit.dataset.DataSetException;
import org.junit.Test;

import com.seitenbau.testing.dbunit.dsl.DataSetRegistry;

public class HochschuleDataSetTest
{

  @Test
  public void chechVSYSTutors() throws DataSetException
  {
    // prepare
    DataSetRegistry.use(new HochschuleDataSet());

    // verify
    //assertThat(VSYS.getTutoren()).isEqualTo(1);
  }

  @Test
  public void chechDPATTERNSTutors() throws DataSetException
  {
    // prepare
    DataSetRegistry.use(new HochschuleDataSet());

    // verify
    //assertThat(DPATTERNS.getTutoren()).isEqualTo(0);
  }
}
