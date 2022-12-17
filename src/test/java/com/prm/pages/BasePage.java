package com.prm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.prm3.project.Utility;

public class BasePage {

	WebDriver driver;
	WebElement shopingCartLink;
	WebElement checkoutLink;
	WebElement myAccountLink;
	WebElement loginLink;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getShopingCartLink() {
		setShopingCartLink();
		return shopingCartLink;
	}

	public void setShopingCartLink() {
		shopingCartLink = driver.findElement(By.xpath("//span[text()='Shopping Cart']"));
	}

	public WebElement getCheckoutLink() {
		setCheckoutLink();
		return checkoutLink;
	}

	public void setCheckoutLink() {
		checkoutLink = driver.findElement(By.xpath("//span[text()='Checkout']"));
	}

	public WebElement getMyAccountLink() {
		setMyAccountLink();
		return myAccountLink;
	}

	public void setMyAccountLink() {
		myAccountLink = driver.findElement(By.xpath("//a[@title='My Account']"));
	}

	public WebElement getLoginLink() {
		setLoginLink();
		return loginLink;
	}

	public void setLoginLink() {
		loginLink = driver.findElement(By.xpath("//ul[starts-with(@class,'dropdown')]//li/a[contains(@href,'login')]"));
	}

	public void clickOnShoppingCart() {
		getShopingCartLink().click();
	}

	public void clickOnLoginLink() {
		getMyAccountLink().click();
		Utility.waitForElementToBeClickableForGivenTime(getLoginLink(), driver, 3);
		getLoginLink().click();
	}

	public String getText(WebElement element) {
		return element.getText();
	}
}
