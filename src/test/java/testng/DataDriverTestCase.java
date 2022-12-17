package testng;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.prm3.project.Utility;

public class DataDriverTestCase {

	WebDriver driver;

	@BeforeMethod
	public void getWebDriver() {
		driver = Utility.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}

	@Test(dataProvider = "loginDp")
	public void verifyValidLogin(String user, String password) {
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		WebElement loginSuccessfullyMsg = driver.findElement(By.xpath("//h3[text()='Login Successfully']"));
		assertEquals(loginSuccessfullyMsg.getText(), "Login Successfully");
	}

	@DataProvider(name = "loginDp")
	public String[][] dataProvide() {
		String array[][] = { { "admin", "pass" }, { "admin1", "pass1" }, { "admin2", "pass2" } };
		return array;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
