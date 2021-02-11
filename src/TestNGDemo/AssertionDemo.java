package TestNGDemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
/*
 * Assertion: used for validation 
 * types: 
 * Hard Assertion --- can't perform End to end execution in method, if any ecexotion occurs
 * Soft Assertion---end 2 end execution, report accurate
 */
public class AssertionDemo {
	SoftAssert sa = new SoftAssert();
	@Test(enabled=false)
	public void verifyTitle_hardAssertion() {
		System.out.println("Start Execution");
		String expcTitle="Facebook";
		String actualTitle="facebook";
		Assert.assertEquals(actualTitle, expcTitle,"Not Matched!");//Exception
		
		//Assert.assertTrue(condition);
		  
	}
	
	@Test
	public void verifyTitle_softAssertion() {
		 
		System.out.println("Start Execution");
		String expcTitle="Facebook";
		String actualTitle="facebook";
		
		sa.assertEquals(actualTitle, expcTitle,"Not Matched!");//Fail, e2e exec.
		
		System.out.println("End Execution");
		sa.assertAll();
		
	}
}
