package com.prm3.project.selniumconcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownNotUnderSelectTag {

	public static void main(String[] args) {

		// String s="str";
		// String s1=new String("str");
		//
		// System.out.println(s.equals(s1));
		// System.out.println(s==s1);

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.airvistara.com/in/en");

		driver.manage().window().maximize();

//		driver.findElement(By.xpath("(//button[@data-dismiss='modal']//img[@alt='close'])[1]")).click();
//
//		driver.findElement(By.xpath("//img[contains(@src,'dropdown')]")).click();
//
//		List<WebElement> countries = driver.findElements(By.xpath("//ul[@id='country-scroll']//li//span"));
//
//		for (WebElement elm : countries) {
//			if (elm.getText().contains("Nepal")) {
//				elm.click();
//				break;
//			}
//
//		}
		
		
	    JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
	    //javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("(//img[contains(@src,'twitter')])[1]")));
	    javascriptExecutor.executeScript("window.scrollBy(0,500)", "");
	    javascriptExecutor.executeScript("window.scrollBy(0,-250)", "");
	}

}
