package com.prm.testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.prm.pages.AccountPage;
import com.prm.pages.LoginPage;
import com.prm3.project.Utility;

public class LoginFunctinality {

	LoginPage loginPage;
	AccountPage accountPage;
	WebDriver driver;

	@BeforeMethod
	public void setUp() throws IOException {
		this.driver = Utility.getDriver();
		loginPage = new LoginPage(driver);
		accountPage = new AccountPage(driver);
		driver.get(Utility.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void verifyValidLogin() throws IOException {
		Reporter.log("Before launch application");
		loginPage.loginToApplication();
		Reporter.log("Application launched successfully");
		Utility.scrollIntoView(driver, accountPage.getLogoutLink());
		assertEquals(accountPage.getText(accountPage.getLogoutLink()), "Logout");
	}

	@Test
	public void verifyTest() {
		assertTrue(false);
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility.takesScreenshot(driver, result.getName() + "_" + System.currentTimeMillis());
		}
		 driver.quit();
	}

}
