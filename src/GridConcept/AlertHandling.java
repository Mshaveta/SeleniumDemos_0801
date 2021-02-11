package GridConcept;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class AlertHandling {
	WebDriver driver;
	Alert alt;

//	@Test
//	public void browserLaunch() {
//		String driverPath = System.getProperty("user.dir") + "\\src\\browser_drivers\\geckodriver.exe";
//		System.setProperty("webdriver.gecko.driver", driverPath);
//		driver = new ChromeDriver();
//		driver.get("file:///D:/2020_batches_data/Batches_Docs/08_01/template_7/alerts.html");
//	}
	@Test
	public void remotebrowserLaunch() throws MalformedURLException {
		DesiredCapabilities cap =  DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.ANY);
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
	}

	 

}
