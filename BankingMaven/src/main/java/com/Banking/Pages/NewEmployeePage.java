package com.Banking.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Banking.Utilities.SeleniumHelper;

public class NewEmployeePage {
	public NewEmployeePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="BtnNew")
		private WebElement New_Employee;
	public void Launch_NewEmployee_screen()
	{
		SeleniumHelper.ClickButton(New_Employee);
	}
}
