package TestNGDemo;

import org.testng.annotations.Test;

public class GroupingDemo {
	@Test(groups="smoke",enabled=false)
	public void verifyUrl() {
		System.out.println("TC1- verifyUrl-Smoke");
	}
	// OR = { "sanity" , "smoke" , "regression" }
	//AND =  {"sanity,smoke"}
	@Test(groups={ "sanity","smoke","regression" },enabled=false)
	public void launchBrowser() {
		System.out.println("TC2- launchBrowser-Sanity");
	}
	@Test(groups={"regression,smoke"})
	public void verifyTitle() {
		System.out.println("TC3- verifyTitle-regression");
	}
	@Test(groups="smoke",enabled=false)
	public void verifyLogin() {
		System.out.println("TC4- verifyLogin-Smoke");
	}
	@Test(groups="sanity",enabled=false)
	public void verifyLogout() {
		System.out.println("TC5- verifyLogout-Sanity");
	}
}
