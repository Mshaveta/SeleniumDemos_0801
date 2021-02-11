import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Sel3- 3.141.59
 * Launch Browser:- Chrome- chromedriver.exe, FF-geckodriver.exe
 * WebDriver - Interface
 * ChromeDriver- class
 */
public class LocatorTagName {

	public static void main(String[] args) {
		
		String driverPath = System.getProperty("user.dir")
							+"\\src\\browser_drivers\\chromedriver.exe"; 
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();//Complex object
		//creating a ref of WebDriver interface, Object of class
		
		//Launch the application
		driver.get("file:///D:/2020_batches_data/Batches_Docs/08_01/LearnSel_08_01/sampleHrml.html");
		 
		
		int count =  driver.findElements(By.tagName("input")).size();
		
		driver.findElements(By.tagName("input")).get(2).sendKeys("testdata");
		 
	}

}
