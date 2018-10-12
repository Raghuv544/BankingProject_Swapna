package com.Banking.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Banking.Utilities.SeleniumHelper;
import com.Banking.Utilities.TestNGHelper;

public class HomePage {
	//create a constructor; it will have the same name as class name
	private WebDriver HomePageDriver;
	public HomePage(WebDriver HomePageDriver )
	{
		//System.out.println("I am a constructor");
		
		PageFactory.initElements(HomePageDriver, this);
	}
	
	/*public static void main(String[] args) {
		//Create object ref for HomePage class
		HomePage Hpage = new HomePage();
	}*/
	//create elements 
	//nothing but findElement by. etc
	@FindBy(id="txtuId")
	 private WebElement userName_tBox;
	@FindBy(id="txtPword")
	 private WebElement password_tBox;
	@FindBy(id="login")
	 private WebElement login_Button;
	//or another example : @FindBy(xpath="//*[@name='userName']")
	//start writing the method
	public void enterLoginDetails(String UserName, String PassWord)
	{
		SeleniumHelper.EnterText(userName_tBox, UserName); //eleminating the effort to write driver.web element
		SeleniumHelper.EnterText(password_tBox, PassWord);
		SeleniumHelper.ClickButton(login_Button);
		//verify the page title, and if its correct display a message
		//String ActualTitle = SeleniumHelper.GetTitle(HomePageDriver);
		TestNGHelper.assertEqual("Primus BANK", "Primus BANK", "Yes", "Successfully Navigated to AdminHomePage");
	}
	
}
