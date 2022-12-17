package com.prm3.project.selniumconcepts;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		driver.manage().window().maximize();

		Actions actions = new Actions(driver);
		WebElement elm = driver.findElement(By.xpath("//a[@aria-label='Google apps']"));
		//actions.moveToElement(elm).build().perform();
		
		WebElement searchField=driver.findElement(By.xpath("//input[@name='q']"));
		searchField.sendKeys(Keys.chord("Z"));
		//actions.(searchField,KeyEvent.VK_Z).build().perform();
		
		

	}

}
