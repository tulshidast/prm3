package com.prm3.project.selniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HowToScrollInSelenium {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.album.alexflueras.ro/");
		
//		int x=driver.manage().window().getSize().getWidth();
//		
//		System.out.println(x);
//		x= (int) (x*0.50);
//		System.out.println(x);
//		String s=String.valueOf(x);

		driver.manage().window().maximize();

		//WebElement elm = driver.findElement(By.xpath("(//img[contains(@src,'twitter')])[1]"));
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		// javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",elm);
//		javascriptExecutor.executeScript("window.scrollBy(0,30)", "");
//		Thread.sleep(2000);
//		javascriptExecutor.executeScript("window.scrollBy(0,-20)", "");
//		Thread.sleep(2000);
		
     	javascriptExecutor.executeScript("window.scrollBy(1000,0)", "");
//		Thread.sleep(2000);
//		javascriptExecutor.executeScript("window.scrollBy(-500,0)", "");
//		Thread.sleep(2000);
		
		//javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollWidth)", "");
	}

}
