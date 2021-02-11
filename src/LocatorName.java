import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorName {

	public static void main(String[] args) {
		// Step1: Browser Launch
		String driverPath = System.getProperty("user.dir") + "\\src\\browser_drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		
		// Step2: Window Max.
		driver.manage().window().maximize();
		
		//Step3: Launch App
		driver.get("https://opensource-demo.orangehrmlive.com/");
	    driver.findElement(By.name("txtUsername")).sendKeys("Admin");	
	    driver.findElement(By.name("txtPassword")).sendKeys("admin123");
	    driver.findElement(By.name("Submit")).click();
	    
	}

}
