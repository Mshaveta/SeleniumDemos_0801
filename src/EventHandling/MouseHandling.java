package EventHandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * iframe (By index)
 * iframe(By name,id)
 * iframe(WebElemnt)
 * 
 */
public class MouseHandling {
	WebDriver driver;
	Alert alt;

	@BeforeClass
	public void browserLaunch() {
		String driverPath = System.getProperty("user.dir") + "\\src\\browser_drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		// driver.get("file:///D:/2020_batches_data/Batches_Docs/08_01/template_7/nested_menus.html");
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1, enabled = false)
	public void menuItems() throws InterruptedException {
		WebElement mItem1 = driver.findElement(By.xpath("//a[contains(@title,'Projects')]"));
		WebElement mItem2 = driver.findElement(By.xpath("//a[contains(@title,'Active projects')]"));
		WebElement mItem3 = driver.findElement(By.xpath("//a[text()='Alerts Handling']"));

		Actions act = new Actions(driver);
		act.moveToElement(mItem1).perform();

		act.moveToElement(mItem2).perform();
		act.moveToElement(mItem3).perform();

		Thread.sleep(2000);
		mItem3.click();

	}

	@Test
	public void dragDrop() throws InterruptedException {
		
		WebElement frame = driver.findElement(By.xpath("//iframe[contains(@src,'droppable')]"));
		driver.switchTo().frame(frame);
		
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).build().perform();

		 

	}

//	@AfterClass
//	public void closeBrowser() {
//		driver.close();
//		 
//	}

}
