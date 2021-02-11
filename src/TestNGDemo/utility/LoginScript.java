package TestNGDemo.utility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
 * DatProvider Concept - @DataProvider Annotation
 */

public class LoginScript {
	WebDriver driver;
	@BeforeClass
	public void browserLaunch() {
		String driverPath = System.getProperty("user.dir") + "\\src\\browser_drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("http://shareurthoughts.herokuapp.com/admin");
	}


	@DataProvider
	public String[][] dp() throws IOException {
		// Step1: Fetch WorkBook Filepath
		String wbkPath = System.getProperty("user.dir") + "\\src\\testData\\testData.xlsx";
		// Step2: Create an object of XlsReader Class
		XlsReader xlr = new XlsReader(wbkPath);

		// S3: Row Count
		int rCount = xlr.getRowCount("Login");

		System.out.println("Total Rows - " + rCount);

		// S4: Cell Count
		int cCount = xlr.getCellCount();
		System.out.println("Total Cols - " + cCount);

		// create an String 2D Array
		String[][] testData = new String[rCount - 1][cCount];// 4*2

		// Read cell Data
		for (int row = 1; row < rCount; row++) {
			for (int cell = 0; cell < cCount; cell++) {
				testData[row - 1][cell] = xlr.getCellData("Login", row, cell);// 10,11,20,21
			}
		}

		return testData;

	}

	@BeforeMethod
	public void clearFields() {
		driver.findElement(By.id("id_username")).clear();
		driver.findElement(By.id("id_password")).clear();
	}
	@Test(dataProvider = "dp")
	public void f(String uname, String pwd) {
		driver.findElement(By.id("id_username")).sendKeys(uname);
		driver.findElement(By.id("id_password")).sendKeys(pwd);
		driver.findElement(By.id("login-form")).submit();
	}

}
