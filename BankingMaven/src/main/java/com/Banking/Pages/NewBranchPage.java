package com.Banking.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Banking.Utilities.SeleniumHelper;

public class NewBranchPage {
	//Create a constructor
	public NewBranchPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="txtbName")
		private WebElement Branch_Name;
	@FindBy(id="txtAdd1")
		private WebElement Address_1;
	@FindBy(id="Txtadd2")
		private WebElement Address_2;
	@FindBy(id="txtArea")
		private WebElement Branch_Area;
	@FindBy(id="txtZip")
		private WebElement Zip_Code;
	@FindBy(id="lst_counrtyU")
		private WebElement Select_Country;
	@FindBy(id="lst_stateI")
		private WebElement Select_State;
	@FindBy(id="lst_cityI")
		private WebElement Select_City;
	@FindBy(id="btn_insert")
		private WebElement Submit_Form;
	@FindBy(id="Btn_Reset")
		private WebElement Reset_Form;
	@FindBy(id="Btn_cancel")
		private WebElement Cancel_Form;
	public void Enter_NewBranch_Details(String B_Name, String Address1, String Address2, String Area,
			String ZipCode, String Country, String State, String City )
	{
		SeleniumHelper.EnterText(Branch_Name, B_Name);
		SeleniumHelper.EnterText(Address_1, Address1);
		SeleniumHelper.EnterText(Address_2, Address2);
		//SeleniumHelper.EnterText(Branch_Area, Area);
		SeleniumHelper.EnterText(Zip_Code, ZipCode);
		SeleniumHelper.SelectTextFromList(Select_Country, Country);
		SeleniumHelper.SelectTextFromList(Select_State, State);
		SeleniumHelper.SelectTextFromList(Select_City, City);
	}
	public void Submit_NewBranch_Form()
	{
		SeleniumHelper.ClickButton(Submit_Form);
	}
	public void Reset_NewBranch_Form()
	{
		SeleniumHelper.ClickButton(Reset_Form);
	}
	public void Cancel_NewBranch_Form() {
		SeleniumHelper.ClickButton(Cancel_Form);
	}
}
