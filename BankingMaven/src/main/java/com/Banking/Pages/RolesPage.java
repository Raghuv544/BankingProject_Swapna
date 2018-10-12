package com.Banking.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Banking.Utilities.SeleniumHelper;

public class RolesPage {
	public RolesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="btnRoles")
		private WebElement New_Role;
	public void Create_New_Role()
	{
		SeleniumHelper.ClickButton(New_Role);
	}
}
