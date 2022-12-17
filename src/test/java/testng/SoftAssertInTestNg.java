package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.prm3.project.Utility;

public class SoftAssertInTestNg {
	WebDriver driver;
	SoftAssert softassert;

	@BeforeMethod
	public void getWebDriver() {
		driver = Utility.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		softassert=new SoftAssert();
	}

	@Test(priority = -1)
	public void verifyValidLogin() {
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		WebElement loginSuccessfullyMsg = driver.findElement(By.xpath("//h3[text()='Login Successfully']"));
		softassert.assertEquals(loginSuccessfullyMsg.getText(), "Login Successfull");
		System.out.println("Verification 1 done");
		softassert.assertNotEquals(loginSuccessfullyMsg.getText(), "Login Successfull");
		System.out.println("Verification 2 done");
		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
