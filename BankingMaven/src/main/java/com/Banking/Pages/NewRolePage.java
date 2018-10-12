package com.Banking.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Banking.Utilities.SeleniumHelper;

public class NewRolePage {
	public NewRolePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="txtRname")
		private WebElement Role_Name ;
	@FindBy(id="txtRDesc")
		private WebElement Role_Description;
	@FindBy(id="lstRtypeN")
		private WebElement Role_Type;
	@FindBy(id="btninsert")
		private WebElement Submit_Role;
	@FindBy(id="Btn_Reset")
		private WebElement Reset_RoleForm;
	@FindBy(id="Btn_cancel")
		private WebElement Cancel_RoleForm;
	public void Enter_Role_Details(String R_Name,String R_Desc,String R_Type)
	{
		SeleniumHelper.EnterText(Role_Name, R_Name);
		SeleniumHelper.EnterText(Role_Description, R_Desc);
		SeleniumHelper.SelectTextFromList(Role_Type, R_Type);
	}
	public void Submit_New_Role_Form()
	{
		SeleniumHelper.ClickButton(Submit_Role);
	}
	public void Reset_NewRole_Form()
	{
		SeleniumHelper.ClickButton(Reset_RoleForm);
	}
	public void Cancel_NewRole_Form() {
		SeleniumHelper.ClickButton(Cancel_RoleForm);
	}
}
