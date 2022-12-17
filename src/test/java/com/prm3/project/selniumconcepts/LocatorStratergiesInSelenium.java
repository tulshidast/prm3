package com.prm3.project.selniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorStratergiesInSelenium {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.tutorialsninja.com/demo/");
		driver.manage().window().maximize();

		//driver.findElements(By.tagName("input")).get(2).sendKeys("test");

		// driver.findElement(By.linkText("Cameras")).click();
		//
		// driver.findElement(By.partialLinkText("Noteboo")).click();
		//
		// driver.findElement(By.id("wishlist-total")).click();
		driver.findElement(By.cssSelector("input[class='form-control input-lg']")).sendKeys("test");
		Thread.sleep(2000);

		driver.findElement(By.name("search")).clear();
		driver.findElement(By.cssSelector("a#wishlist-total")).click();
		System.out.println(driver.findElement(By.xpath("(//a)[24]")).getText());
		
	}

}
