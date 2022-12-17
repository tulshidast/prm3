package com.prm3.project.selniumconcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigationCommand {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
		driver.navigate().to("https://www.amazon.in/");

		Thread.sleep(1000);
		driver.navigate().back();

		Thread.sleep(1000);
		driver.navigate().forward();

		Thread.sleep(1000);
		driver.navigate().refresh();

	}

}
