import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Sel3- 3.141.59
 * Launch Browser:- Chrome- chromedriver.exe, FF-geckodriver.exe
 * WebDriver - Interface
 * ChromeDriver- class
 */
public class LocatorXPath {

	public static void main(String[] args) {
		
		String driverPath = System.getProperty("user.dir")
							+"\\src\\browser_drivers\\chromedriver.exe"; 
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();//Complex object
		//creating a ref of WebDriver interface, Object of class
		
		//Launch the application
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		 
		
		 
	}

}
