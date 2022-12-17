package com.prm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.prm3.project.Utility;

public class LoginPage extends BasePage {
	WebDriver driver;
	WebElement userNameTextBox;
	WebElement passwordTextBox;
	WebElement LoginButton;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public WebElement getUserNameTextBox() {
		setUserNameTextBox();
		return userNameTextBox;
	}

	public void setUserNameTextBox() {
		userNameTextBox = driver.findElement(By.xpath("//input[@id='input-email']"));
	}

	public WebElement getPasswordTextBox() {
		setPasswordTextBox();
		return passwordTextBox;
	}

	public void setPasswordTextBox() {
		this.passwordTextBox = driver.findElement(By.xpath("//input[@id='input-password']"));
	}

	public WebElement getLoginButton() {
		setLoginButton();
		return LoginButton;
	}

	public void setLoginButton() {
		LoginButton = driver.findElement(By.xpath("//input[@value='Login']"));
	}

	public void loginToApplication() throws IOException {
		this.clickOnLoginLink();
		getUserNameTextBox().sendKeys(Utility.getProperty("email"));
		getPasswordTextBox().sendKeys(Utility.getProperty("password"));
		getLoginButton().click();
	}
}
