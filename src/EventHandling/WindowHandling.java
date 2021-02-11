package EventHandling;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowHandling {
	WebDriver driver;

	@BeforeClass
	public void browserLaunch() {
		String driverPath = System.getProperty("user.dir") + "\\src\\browser_drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");// parent
	}

	@Test
	public void windowHandling() {
		String parentWind = driver.getWindowHandle();// Parent Window
		// System.out.println("parent Window - "+parentWind);

		String parentTtl = driver.getTitle();
		System.out.println("Parent Title -" + parentTtl);

		// fetch the ids of all the windows -- p+Child winds
		Set<String> wHandles = driver.getWindowHandles();// 4
		// System.out.println("Before Removing -"+wHandles);
		wHandles.remove(parentWind);
		// System.out.println("After Removing -"+wHandles);//3 child windows id

		// iteration of elmns
		Iterator<String> itr = wHandles.iterator();// 3
		int i = 1;
		while (itr.hasNext()) {
			String childWindow = itr.next();
			// System.out.println(i+". "+childWindow);
			driver.switchTo().window(childWindow);
			String childTtl = driver.getTitle();
			System.out.println("Child window Title -" + childTtl);

			i++;
		}

		driver.switchTo().window(parentWind);
		System.out.println("Parent Title -----" + parentTtl);
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
