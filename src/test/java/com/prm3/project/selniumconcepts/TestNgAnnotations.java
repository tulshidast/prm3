package com.prm3.project.selniumconcepts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.prm3.project.Utility;

public class TestNgAnnotations {
	WebDriver driver;

	@BeforeSuite
	public void beforSuite() {
		System.out.println("before suite");
	}

	@BeforeTest
	public void beforeTestPlan() {
		System.out.println("before test plan");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("before class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}

	@Test
	public void verifyLogin() {
		System.out.println("test case");
	}
	
	@Test
	public void verifyLogin1() {
		System.out.println("test case");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("after method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("after class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("after test plan");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite");
	}

}
