package com.prm3.project.selniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleMultiselectDropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement dropdown = driver.findElement(By.xpath("//select[@id='multiselect1']"));
		Select select = new Select(dropdown);

		System.out.println(select.isMultiple());

		select.selectByIndex(2);
		select.selectByValue("audix");
		select.selectByVisibleText("Volvo");

		for (WebElement elm : select.getAllSelectedOptions()) {
			System.out.println(elm.getText());
		}

		select.deselectByIndex(2);
		select.deselectByValue("audix");
		select.deselectByVisibleText("Volvo");

		select.selectByIndex(2);
		select.selectByValue("audix");
		select.selectByVisibleText("Volvo");

		select.deselectAll();
	}

}
