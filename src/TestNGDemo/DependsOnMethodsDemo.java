package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DependsOnMethodsDemo {
	WebDriver driver;
	@Test
	public void browserLaunch() {
		String driverPath = System.getProperty("user.dir") + "\\src\\browser_drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
	}

	@Test(dependsOnMethods = "browserLaunch")
	public void appLaunch() {
		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	@Test(dependsOnMethods = "appLaunch")
	public void login() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = "login")
	public void logout() {
		//driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
}
