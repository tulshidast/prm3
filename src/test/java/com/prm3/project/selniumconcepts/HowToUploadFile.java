package com.prm3.project.selniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.prm3.project.Utility;

public class HowToUploadFile {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();

		 WebElement uploadFileButton =
		 driver.findElement(By.xpath("//input[@id='uploadfile']"));
		 JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		 javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",
		 uploadFileButton);
		 uploadFileButton.sendKeys("D:\\Class\\classworkspace\\com.prm3.project\\src\\test\\resources\\test.properties");
		WebElement buttonForDoubleClick = driver
				.findElement(By.xpath("//button[normalize-space()='Double click Here']"));

		int h = buttonForDoubleClick.getSize().getHeight();
		int w = buttonForDoubleClick.getSize().getWidth();

		System.out.println("Hight and width of button:" + h + " " + w);

		Actions actions = new Actions(driver);
		WebElement textarea1 = driver.findElement(By.xpath("//h2[text()='Text Area Field Two']/../div/textarea"));
		
		
		String s = Keys.chord(Keys.CONTROL, "a");
		textarea1.sendKeys(s);
		String s1 = Keys.chord(Keys.CONTROL, "c");
		textarea1.sendKeys(s1);

		String s3 = Keys.chord(Keys.CONTROL, "v");
		driver.findElement(By.xpath("//textarea")).sendKeys(s3);
		
		 javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",
		 buttonForDoubleClick);
		 actions.doubleClick(buttonForDoubleClick);

		System.out.println(Utility.getValueFromTable(driver, "table1", "1", "2"));
	}

}
