package com.prm3.project.selniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HowToHandleFrame {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();

		WebElement header = driver.findElement(By.xpath("//h1[@class]"));
		System.out.println(header.getText());

		WebElement frame = driver.findElement(By.xpath("//iframe[@id='navbar-iframe']"));
		driver.switchTo().frame(frame);

		System.out.println(driver.findElement(By.xpath("//a[@id='b-getorpost']")).getText());

		// driver.switchTo().defaultContent();
		//
		// WebElement header1=driver.findElement(By.xpath("//h1[@class]"));
		// System.out.println(header1.getText());

		driver.findElement(By.xpath("//a[@id='b-getorpost']")).click();
		System.out.println(driver.findElement(By.xpath("//span[text()='Sign in']/..")).getText());
	    driver.navigate().back();
	    
	    WebElement header3 = driver.findElement(By.xpath("//h1[@class]"));
		System.out.println(header3.getText());
	}

}
