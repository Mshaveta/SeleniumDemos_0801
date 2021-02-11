package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Prioritization {
	WebDriver driver;
	@Test(priority=0)
	public void browserLaunch() {
		String driverPath = System.getProperty("user.dir") + "\\src\\browser_drivers\\chromedriver.exe";
		System.setProperty("webdriverchrome.driver", driverPath);
		driver = new ChromeDriver();
	}
	
	@Test(priority=1)
	public void appLaunch() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	@Test(priority=2)
	public void login(){
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test(priority=3)
	public void logout() {
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	 
	

}
