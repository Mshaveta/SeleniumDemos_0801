package GridConcept;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Browserlaunchremotemachine {
	@Parameters("browser")
	@Test
	public void launchBrowser(String browserName) throws MalformedURLException {
		URL url = new URL("http://localhost:4444/wd/hub");
		if(browserName.equalsIgnoreCase("chrome")) {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.ANY);
			WebDriver driver = new RemoteWebDriver(url,capabilities);
			driver.get("https://www.facebook.com/");
		}else if(browserName.equalsIgnoreCase("FF")) {
			DesiredCapabilities ffCap = DesiredCapabilities.firefox();
			ffCap.setBrowserName("firefox");
			ffCap.setPlatform(Platform.ANY);
			WebDriver driver1 = new RemoteWebDriver(url,ffCap);
			driver1.get("https://www.facebook.com/");
		}
		
		
		
	}
}
