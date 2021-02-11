package Exp;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Sel3- 3.141.59
 * Launch Browser:- Chrome- chromedriver.exe, FF-geckodriver.exe
 * WebDriver - Interface
 * ChromeDriver- class
 */
public class CheckAllCheckBoxes {

	public static void main(String[] args) {
		
		String driverPath = System.getProperty("user.dir")
							+"\\src\\browser_drivers\\chromedriver.exe"; 
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();//Complex object
		//creating a ref of WebDriver interface, Object of class
		
		driver.manage().window().maximize();
		//Launch the application
		driver.get("http://shareurthoughts.herokuapp.com/admin/login/?next=/admin/");
		driver.findElement(By.id("id_username")).sendKeys("admin");
		driver.findElement(By.id("id_password")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.name("action")).sendKeys("Delete selected users");
		 
		List<WebElement> webElmns= driver.findElements(By.xpath("//table[@id='result_list']/tbody/tr/th/a"));
		Iterator<WebElement> itr = webElmns.iterator();
		int i=1;
		 while(itr.hasNext()) {
			String linkText = itr.next().getText();
			if(linkText.equals("smalhotra")) {
				driver.findElement(By.xpath("//table[@id='result_list']/tbody/tr["+i+"]/th/a/parent::th/preceding-sibling::td/input")).click(); 
			}
			i++;
		}
		 
	}

}
