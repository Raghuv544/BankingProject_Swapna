package com.Banking.Steps;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*import com.sun.java_cup.internal.runtime.Scanner;
*/
public class DisplayAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Enter a number");
		//Scanner in = new Scanner(System.in); 	
		String Browser = "chrome";
		String s=Browser.toLowerCase();
		/*switch(s) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver1 = new FirefoxDriver();
			break;
		default:
			WebDriverManager.iedriver().setup();
			WebDriver driver2 = new InternetExplorerDriver();
}*/
}
}
