package TestNGDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parallel_Seq_Execution_Demo {
	WebDriver driver;
	
	@Parameters("browserName") //Chrome
	@Test 
	public void browserLaunch(String browser_name) {
		System.out.println("Browser Name-"+browser_name);
		if(browser_name.equalsIgnoreCase("chrome")) {
			
			String driverPath = System.getProperty("user.dir") + "\\src\\browser_drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			 driver = new ChromeDriver();
		}else if(browser_name.equalsIgnoreCase("ff")){
			String driverPath = System.getProperty("user.dir") + "\\src\\browser_drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			 driver = new FirefoxDriver();
		}else if(browser_name.equalsIgnoreCase("edge")) {
			String driverPath = System.getProperty("user.dir") + "\\src\\browser_drivers\\msedgedriver.exe";
			System.setProperty("webdriver.edge.driver", driverPath);
			 driver = new EdgeDriver();
		}
	}
	
	@Test(dependsOnMethods="browserLaunch")
	public void appLaunch() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
}
