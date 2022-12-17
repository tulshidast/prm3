package com.prm3.project.selniumconcepts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.prm3.project.Utility;

public class LoginScenarioUsingExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/newtours/index.php");

		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(String.valueOf(Utility.readExcel().get(0)));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(String.valueOf(Utility.readExcel().get(1)));
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
	}

}
