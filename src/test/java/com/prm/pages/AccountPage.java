package com.prm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage extends BasePage {

	WebDriver driver;
	WebElement logoutLink; 

	public AccountPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	public WebElement getLogoutLink() {
		setLogoutLink();
		return logoutLink;
	}

	public void setLogoutLink() {
		this.logoutLink = driver.findElement(By.xpath("//a[text()='Newsletter']//following-sibling::a"));
	}
	
}
