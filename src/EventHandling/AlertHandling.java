package EventHandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertHandling {
	WebDriver driver;
	Alert alt;

	@BeforeClass
	public void browserLaunch() {
		String driverPath = System.getProperty("user.dir") + "\\src\\browser_drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get("file:///D:/2020_batches_data/Batches_Docs/08_01/template_7/alerts.html");
	}

	@Test(priority=1,enabled=false)
	public void alertBox() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='Alert Box']")).click();
		alt = driver.switchTo().alert();
		String actAlertMsg = alt.getText();// alert message
		String expAlertMsg = "This is a warning message!";
		Assert.assertEquals(actAlertMsg, expAlertMsg);
		Thread.sleep(3000);

		System.out.println("Alert Box Accept method calling");
		alt.accept();
	}

	@Test(priority=2,enabled=false)
	public void confirmBox() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='Confirm Box']")).click();
		alt = driver.switchTo().alert();
		String actAlertMsg = alt.getText();// alert message
		System.out.println(actAlertMsg);
		Thread.sleep(3000);

		alt.dismiss();
	}

	@Test(priority=1)
	public void prompotBox() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='PromptBox']")).click();
		alt = driver.switchTo().alert();
		
		Thread.sleep(3000);
		alt.sendKeys("User name ");
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
		 
	}

}
