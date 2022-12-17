package com.prm3.project.selniumconcepts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.prm3.project.Utility;

public class HowToHandleAlert {

	public static void main(String[] args) throws IOException {

		System.out.println(Utility.getProperty("chromedriverpath"));
		System.setProperty("webdriver.chrome.driver", Utility.getProperty("chromedriverpath"));
		WebDriver driver = new ChromeDriver();
		System.out.println(Utility.getProperty("url"));
		driver.get(Utility.getProperty("url"));
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@name='submit']")).click();

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());

		// alert.dismiss();
		alert.accept();

		// alert.sendKeys("I am accepting alert");

		driver.switchTo().alert().dismiss();

	}

}
