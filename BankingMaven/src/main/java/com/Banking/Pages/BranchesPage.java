package com.Banking.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Banking.Utilities.SeleniumHelper;

public class BranchesPage {
	public BranchesPage(WebDriver driver)
	{
		PageFactory.initElements((WebDriver) driver, this);
	}
	@FindBy(xpath="//*[@id=\"BtnNewBR\"]")
		private WebElement NewBranch_Link;
	@FindBy(id="lst_countryS")
		private WebElement Country_List;
	@FindBy(id="lst_stateS")
		private WebElement State_List;
	@FindBy(id="lst_cityS")
		private WebElement City_List;
	@FindBy(id="btn_search")
		private WebElement Search_Link;
	@FindBy(id="btn_clsearch")
		private WebElement Clear_Link;
	
	public void Click_NewBranch_Link()
	{
		SeleniumHelper.ClickButton(NewBranch_Link);
	}
	public void Select_Branch_Address(String Country, String State, String City )
	{
		SeleniumHelper.SelectTextFromList(Country_List, Country);
		SeleniumHelper.SelectTextFromList(State_List, State);
		SeleniumHelper.SelectTextFromList(City_List, City);
	}
	public void Activate_Search()
	{
		SeleniumHelper.ClickButton(Search_Link);
	}
	public void Clear_Search() 
	{
		SeleniumHelper.ClickButton(Clear_Link);
	}
}
