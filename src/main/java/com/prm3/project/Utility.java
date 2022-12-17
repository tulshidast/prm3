package com.prm3.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public static void takesScreenshot(WebDriver driver, String fileName) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("src/test/resources/screenshot/" + fileName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) throws IOException {
		File file = new File("src/test/resources/test.properties");
		FileInputStream fileInputStream = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		return properties.getProperty(key);
	}

	public static List<Object> readExcel() throws IOException {
		// if your excel is type xlsx you have replace HSSF with XSSF
		List<Object> list = new ArrayList<Object>();
		File file = new File("src/test/resources/testdatafile.xls");
		FileInputStream fileInputStream = new FileInputStream(file);

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);

		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);

		int lastRowNum = hssfSheet.getLastRowNum();

		for (int i = 1; i <= lastRowNum; i++) {
			HSSFRow row = hssfSheet.getRow(i);
			int lastCellNum = row.getLastCellNum();
			for (int j = 0; j < lastCellNum; j++) {
				if (row.getCell(j).getCellType().equals(CellType.STRING)) {
					list.add(row.getCell(j).getStringCellValue());
				}

				if (row.getCell(j).getCellType().equals(CellType.NUMERIC)) {
					list.add((int) row.getCell(j).getNumericCellValue());
				}
			}
		}
		hssfWorkbook.close();
		return list;
	}

	public static String getValueFromTable(WebDriver driver, String id, String rowIndex, String tdIndex) {
		return driver
				.findElement(By.xpath("//table[@id='" + id + "']//tbody//tr[" + rowIndex + "]/td[" + tdIndex + "]"))
				.getText();
	}

	public static void waitForElementToBeClickableForGivenTime(WebElement element, WebDriver driver, long time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
