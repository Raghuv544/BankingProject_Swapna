package com.Banking.Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/** used method name: SeleniumHelper, passing Parameters
 * 	used parameters driver,Browser*/
public class SeleniumHelper {
	public static String GetTitle(WebDriver driver)
	{
		//return the value
		return driver.getTitle();
	}
	public static void BrowesrSetup(WebDriver driver, String Browser) {
		String ActualBrowser = Browser.toLowerCase();
		if (ActualBrowser.equals("chrome")) {
			try {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println("Chrome browser is launched");

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		} else if (ActualBrowser.equals("firefox")) {
			try {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				System.out.println("Firefox browser is launched");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		} else {
			try {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				System.out.println("IE browser is launched");

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}
	/** used method name: SelectFromList, passing Parameters
	 * 	used parameters ListBoxEle,ListItemText*/
	public static void SelectTextFromList(WebElement ListBoxElement, String ListItemText) {
		try {
			// create object ref for select class
			Select List = new Select(ListBoxElement);
			List.selectByVisibleText(ListItemText);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	/** used method name: SelectIndexFromList, passing Parameters
	 * 	used parameters ListBoxElement,Index*/
	public static void SelectIndexFromList(WebElement ListBoxElement, int Index) {
		try {
			Select List = new Select(ListBoxElement);
			List.selectByIndex(Index);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	/** used method name: EnterText, passing Parameters
	 * 	used parameters TextBoxElement,TextData*/
	public static void EnterText(WebElement TextBoxElement, String TextData )
	{	try {	
			TextBoxElement.sendKeys(TextData);
			System.out.println("The entered Text is "+ TextData);
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	}
	}
	/** used method name: ClickButton, passing Parameters
	 * 	used parameter ButtonElement*/
	//Can use this method for images aswell
	public static void ClickButton(WebElement ButtonElement)
	{
		try {	
			ButtonElement.click();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	//implement a reusable method to capture a screen shot
	/*File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File ("//BankingMaven//ScreenShots//error.png"));*/
	public static void quitDriver() {
		// TODO Auto-generated method stub
		
	}
	public static void takeSnapShot(WebDriver driver, String path) {
		// TODO Auto-generated method stub
		try {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File(path);
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			// e.printStackTrace();
			e.getMessage();
	}
	}
	
	}
