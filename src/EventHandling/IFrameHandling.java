package EventHandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * iframe (By index)
 * iframe(By name,id)
 * iframe(WebElemnt)
 * 
 */
public class IFrameHandling {
	WebDriver driver;
	Alert alt;

	@BeforeClass
	public void browserLaunch() {
		String driverPath = System.getProperty("user.dir") + "\\src\\browser_drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("file:///D:/2020_batches_data/Batches_Docs/08_01/template_7/iFrames.html");
	}

	@Test(priority = 1)
	public void alertBox() throws InterruptedException {

		// switch to iframe1
		driver.switchTo().frame(0);
		driver.findElement(By.id("name")).sendKeys("Iframe handling");

		// come out from the iframe1
		driver.switchTo().defaultContent();
		boolean res = driver.findElement(By.xpath("//h1[text()='iFrames Handling']")).isEnabled();
		Assert.assertTrue(res);

		Thread.sleep(5000);

		// switch to iframe2
		WebElement ifelm2 = driver.findElement(By.xpath("//iframe[contains(@src,'iframe_alerts_data')]"));
		driver.switchTo().frame(ifelm2);

		// click on Alert button
		driver.findElement(By.xpath("//input[@value='Alert Box']")).click();
		// swicth to ALert
		Alert alt = driver.switchTo().alert();
		String msg = alt.getText();
		System.out.println(msg);

		alt.accept();

		// come out from the iframe2
		driver.switchTo().defaultContent();
		String resMsg = driver.findElement(By.xpath("//h1[text()='iFrames Handling']")).getText();
		System.out.println("page Heading-" + resMsg);

	}

//	@AfterClass
//	public void closeBrowser() {
//		driver.close();
//		 
//	}

}
