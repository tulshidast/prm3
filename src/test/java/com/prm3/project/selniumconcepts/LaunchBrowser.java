package com.prm3.project.selniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://open.spotify.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='/search']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='What do you want to listen to?']")).sendKeys("vande mataram");
		Thread.sleep(5000);
		driver.findElements(By.xpath("//div[@role='presentation']//div[@role='row']//img")).get(0).click();
		// WebElement element = driver.findElement(By.xpath("//a[text()='WebDriver']"));
		// element.click();
		//
		//
		// System.out.println(driver.getTitle());
		// System.out.println(driver.getPageSource());
		// System.out.println(driver.getCurrentUrl());
	}
}
