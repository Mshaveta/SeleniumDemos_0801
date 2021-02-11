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
public class ClickOnLinks_FB {

	public static void main(String[] args) {

		String driverPath = System.getProperty("user.dir") + "\\src\\browser_drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();// Complex object
		// creating a ref of WebDriver interface, Object of class

		// Launch the application
		driver.get("https://www.facebook.com/");
		// Get page Heading:
		String pageHeading = driver
				.findElement(By.xpath(
						"//h2[contains(text(),'Facebook helps you connect and share with the people in your life')]"))
				.getText();
		System.out.println("pageHeading-" + pageHeading);
		
		
		
		//CLikc on Single link Item:
		driver.findElement(By.linkText("Log In")).click();
		
		driver.navigate().back();

		// count total links
		List<WebElement> items = driver.findElements(By.xpath("//ul[contains(@class,'pageFooterLinkList')]/li/a"));
		items.size();
		
		
		
		
		int count = driver.findElements(By.xpath("//ul[contains(@class,'pageFooterLinkList')]/li/a")).size();

		System.out.println("Total-" + count);
		
		 
		
		driver
		.findElement(By.xpath("//ul[contains(@class,'pageFooterLinkList')]/li[4]/a"));

		for (int i = 1; i <= count; i++) {
			String linkText = driver
					.findElement(By.xpath("//ul[contains(@class,'pageFooterLinkList')]/li[" + i + "]/a")).getText();
			System.out.println("Link Text-" + linkText);
			
			String linkHref = driver
					.findElement(By.xpath("//ul[contains(@class,'pageFooterLinkList')]/li[" + i + "]/a")).getAttribute("href");
			System.out.println("Link Ref.-" + linkHref);
			
			driver.navigate().to(linkHref);
			driver.navigate().back();
			
		}

	}

}
