package testng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.prm3.project.Utility;

public class HardNSoftAssert {

	WebDriver driver;

	@BeforeMethod
	public void getWebDriver() {
		driver = Utility.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.guru99.com/test/newtours/index.php");
	}

	@Test(priority=-1)
	public void verifyValidLogin() {
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		WebElement loginSuccessfullyMsg = driver.findElement(By.xpath("//h3[text()='Login Successfully']"));
		assertEquals(loginSuccessfullyMsg.getText(), "Login Successfull");
		System.out.println("Verification 1 done");
		Assert.assertNotEquals(loginSuccessfullyMsg.getText(), "Login Successfull", "verification not Successful");
		System.out.println("Verification 2 done");
	}

	@Test(priority=2,enabled=false)
	public void verifyRegisterPageTitle() {
		driver.findElement(By.linkText("REGISTER")).click();
		String title = driver.getTitle();
		Assert.assertTrue(title.equals("Register: Mercury Tours"), "Register page title is inccorect");
		Reporter.log("Verification 3 done");
		System.out.println("Verification 3 done");
		assertFalse(title.equals("Register:"));
		Reporter.log("verification 4 done");
		System.out.println("Verification 3 done");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
