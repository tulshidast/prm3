package com.prm3.project.selniumconcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandaleDropdownUnderSelectTag {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/newtours/index.php");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();

		WebElement dropdown = driver.findElement(By.xpath("//select[@name='country']"));

		Select select = new Select(dropdown);
		System.out.println(select.getFirstSelectedOption().getText());

		System.out.println(select.isMultiple());

		List<WebElement> options = select.getOptions();
		for (WebElement el : options) {
			select.selectByVisibleText(el.getText());
		}

		System.out.println(select.isMultiple());

		select.selectByIndex(5);

		Thread.sleep(3000);

		select.selectByValue("AUSTRALIA");

		Thread.sleep(3000);
		select.selectByVisibleText("INDIA");

	}

}
