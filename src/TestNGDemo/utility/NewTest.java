package TestNGDemo.utility;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class NewTest {
	
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  //n=1s=a
	  //n=2,s=b
	  //login-- username/password
  }

  @DataProvider// -- return type : 2D array
  public Object[][] dp() {
	  /* fetch the data from Excel Sheet / external Resource*/
	 
    Object[][] data =  new Object[][] {
    
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
    
    return data;
  }
}
