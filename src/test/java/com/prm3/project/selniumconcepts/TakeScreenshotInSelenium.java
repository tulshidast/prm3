package com.prm3.project.selniumconcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.prm3.project.Utility;

public class TakeScreenshotInSelenium {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		Utility.takesScreenshot(driver, "google_home_page_"+System.currentTimeMillis());

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("mobile");
		
		Thread.sleep(2000);
		
		Utility.takesScreenshot(driver, "search_results_"+System.currentTimeMillis());
		List<WebElement> list = driver.findElements(By.xpath("//ul//div[@class='wM6W7d']/span"));

		System.out.println("Search result found = " + list.size());

		for (WebElement elm : list) {
			System.out.println(elm.getText());
		}

	}

}
