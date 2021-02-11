package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DependsOnMethodsBasicDemo {
	WebDriver driver;
	@Test
	public void browserLaunch() {
		System.out.println("browserLaunch");
	}

	@Test(dependsOnMethods = "browserLaunch")
	public void appLaunch() {
		System.out.println("appLaunch");
	}

	@Test
	public void login() {
		System.out.println("login");
	}

	@Test
	public void logout() {
		System.out.println("logout");
	}
}
