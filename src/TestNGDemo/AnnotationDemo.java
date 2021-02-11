package TestNGDemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationDemo {
	@AfterMethod
	public void afterMethodAnnotation() {
		 System.out.println("@After Method");
	}
	
	@Test(enabled=false)
	public void browserLaunch() {
		System.out.println("@Test - browserLaunch");
	}
	
	@Test
	public void login() {
		System.out.println("@Test - login");
	}
	
	@BeforeMethod
	public void beforeMethodAnnotation() {
		 System.out.println("@Before Method");
	}
	@BeforeClass
	public void beforeClassAnnotation() {
		 System.out.println("@Before Class");
	}
	
	@AfterClass
	public void afterClassAnnotation() {
		 System.out.println("@After Class");
	}
	
	@BeforeTest
	public void beforeTestAnnotation() {
		 System.out.println("@Before Test");
	}
	
	@AfterTest
	public void afterTestAnnotation() {
		 System.out.println("@After Test");
	}
	
	@BeforeSuite
	public void beforeSuiteAnnotation() {
		 System.out.println("@Before Suite");
	}
	
	@AfterSuite
	public void afterSuiteAnnotation() {
		 System.out.println("@After Suite");
	}
	
	

}
