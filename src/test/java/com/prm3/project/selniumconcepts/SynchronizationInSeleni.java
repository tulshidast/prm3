package com.prm3.project.selniumconcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class SynchronizationInSeleni {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.co.in/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		// 250 mili seconds
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("mobile");
        
		// explicit wait 500 mili seconds
		// WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
		// wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul//div[@class='wM6W7d']/span"))));

		// fluent wait
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		fluentWait.withTimeout(Duration.ofSeconds(2));
		fluentWait.pollingEvery(Duration.ofMillis(1));
		fluentWait.ignoring(TimeoutException.class);
		fluentWait.until(ExpectedConditions
				.visibilityOfAllElements(driver.findElements(By.xpath("//ul//div[@class='wM6W7d']/span"))));

		List<WebElement> list = driver.findElements(By.xpath("//ul//div[@class='wM6W7d']/span"));

		System.out.println("Search result found = " + list.size());

		for (WebElement elm : list) {
			System.out.println(elm.getText());
			// if (elm.getText().contains("mobile")) {
			// System.out.println("test passed");
			// } else {
			// System.out.println("test failed");
			// }
		}

	}

}
