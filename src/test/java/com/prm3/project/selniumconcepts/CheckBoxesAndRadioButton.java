package com.prm3.project.selniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxesAndRadioButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement maleRadioButton = driver.findElement(By.xpath("//input[@id='radio1']"));
		// System.out.println(maleRadioButton.isDisplayed());
		// System.out.println(maleRadioButton.isEnabled());
		// maleRadioButton.click();
		// System.out.println(maleRadioButton.isSelected());

		// WebElement femaleRadioButton =
		// driver.findElement(By.xpath("//input[@id='radio2']"));
		//
		WebElement disabledButton = driver.findElement(By.xpath("//button[@id='but1']"));
		System.out.println(disabledButton.isEnabled());

		// WebElement orangeCheckBox =
		// driver.findElement(By.xpath("//input[@id='checkbox1']"));
		// WebElement blueCheckBox =
		// driver.findElement(By.xpath("//input[@id='checkbox2']"));
		// System.out.println(orangeCheckBox.isEnabled());
		// orangeCheckBox.click();
		// System.out.println(orangeCheckBox.isSelected());
		//
		//
		// System.out.println(blueCheckBox.isEnabled());
		// blueCheckBox.click();
		// System.out.println(blueCheckBox.isSelected());

	}

}
