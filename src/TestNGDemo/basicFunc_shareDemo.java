package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class basicFunc_shareDemo {
	WebDriver driver;
	@Test
	public void browserLaunch() {
		String driverPath = System.getProperty("user.dir") + "\\src\\browser_drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
	}

	@Test(dependsOnMethods = "browserLaunch")
	public void appLaunch() {
		driver.get("http://shareurthoughts.herokuapp.com/admin");

	}

	@Test(dependsOnMethods = "appLaunch")
	public void login() throws InterruptedException {
		driver.findElement(By.id("id_username")).sendKeys("admin");
		driver.findElement(By.id("id_password")).sendKeys("admin");
		driver.findElement(By.id("login-form")).submit();
		
		//driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = "login")
	public void logout() {
		//driver.findElement(By.id("welcome")).click();
		boolean isPresentbtn = driver.findElement(By.xpath("//a[contains(@href,'logout')]")).isDisplayed();
		 
		Assert.assertTrue(false);///tc will be passed oonly if valus of this var is isPresentbtn
		
		Assert.assertFalse(false);//pass
		driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
	}
}
