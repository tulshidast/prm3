package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParellelExecution {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void launchGoogle() {

		driver.get("https://www.google.co.in/");
	}

	@Test
	public void launchAmazon() {

		driver.get("https://www.amazon.in/");
	}

	@Test
	public void launchFlipkart() {

		driver.get("https://www.flipkart.com/");
	}

	@Test
	public void launchGuru99() {

		driver.get("https://demo.guru99.com/test/newtours/register.php");
	}

	// @AfterMethod
	// public void tearDown()
	// {
	// driver.close();
	// }
}
