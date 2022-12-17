package com.prm3.project.selniumconcepts;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HowToHandleMultipleWindows {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.open('https://www.flipkart.com/','_blank');");

		System.out.println(driver.getTitle());
		WebElement amazonTextField=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        amazonTextField.sendKeys("iphone");
        
		// it will return current window handle
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allWindoHandle = driver.getWindowHandles();

		for (String handle : allWindoHandle) {
			if (!(handle.equals(parentWindowHandle))) {
				driver.switchTo().window(handle);

			}
			System.out.println(handle);
		}

		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("user1");
		//driver.close();
		driver.switchTo().window(parentWindowHandle);
		amazonTextField.clear();
		driver.quit();
	}

}
