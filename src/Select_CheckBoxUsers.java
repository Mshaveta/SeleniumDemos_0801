import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/* Sel3- 3.141.59
 * Launch Browser:- Chrome- chromedriver.exe, FF-geckodriver.exe
 * WebDriver - Interface
 * ChromeDriver- class
 */
public class Select_CheckBoxUsers {
	WebDriver driver;//null
	public void browserLaunch() {
		String driverPath = System.getProperty("user.dir") + "\\src\\browser_drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();// Complex object-----local driver===
		// creating a ref of WebDriver interface, Object of class
		System.out.println("value of driver in browser launch-"+driver);
	}

	public void launchApp() {
		// Launch the application
		System.out.println("value of driver in app launch-"+driver);
		driver.get("http://shareurthoughts.herokuapp.com/admin");//null.get()--NPE
	}

	public boolean login() throws InterruptedException {
		driver.findElement(By.id("id_username")).sendKeys("admin");
		driver.findElement(By.id("id_password")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(2000);
		
		boolean res = driver.findElement(By.xpath("//a[@href='/admin/logout/']")).isDisplayed();
		return res;
	}

	
	public void deleteUser() {
		// Get page Heading:

		driver.findElement(By.linkText("Users")).click();

		driver.findElement(By.xpath("//td[text()='shaveta@btes.co.in']/preceding-sibling::td/input")).click();

		WebElement action_dd = driver.findElement(By.name("action"));
		// used only for <select> tag
		Select slc = new Select(action_dd);
		slc.selectByValue("delete_selected");
		slc.selectByVisibleText("Delete selected users");
		slc.selectByIndex(1);
	}

	public static void main(String[] args) throws InterruptedException {
		Select_CheckBoxUsers obj = new Select_CheckBoxUsers();
		obj.browserLaunch();
		obj.launchApp();
		boolean isLogin = obj.login();
		if(isLogin) {
			obj.deleteUser();
		}else {
			System.out.println("not Login");
		}
		
	}

}
