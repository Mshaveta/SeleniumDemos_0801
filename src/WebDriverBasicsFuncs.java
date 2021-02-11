import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Sel3- 3.141.59
 * Launch Browser:- Chrome- chromedriver.exe, FF-geckodriver.exe
 * WebDriver - Interface
 * ChromeDriver- class
 */
public class WebDriverBasicsFuncs {

	public static void main(String[] args) {
		
		String driverPath = System.getProperty("user.dir")
							+"\\src\\browser_drivers\\chromedriver.exe"; 
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();//Complex object
		//creating a ref of WebDriver interface, Object of class
		
		//Launch the application
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		 
		driver.manage().window().maximize();
		
		//get the url of an application
		String actualUrl = driver.getCurrentUrl();
		String expUrl = "https://opensource-demo.orangehrmlive.com/";
		if(actualUrl.equals(expUrl)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		
		//get the title of application
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
	}

}
