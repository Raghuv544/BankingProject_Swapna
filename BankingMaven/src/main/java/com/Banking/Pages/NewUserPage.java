package com.Banking.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Banking.Utilities.SeleniumHelper;

public class NewUserPage {
		public NewUserPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		@FindBy(id="Btnuser")
			private WebElement NewUser_Link;
		@FindBy(id="lst_branchS")
			private WebElement Select_Branch;
		@FindBy(id="lst_rolesS")
			private WebElement Select_Roles;
		@FindBy(id="btn_search")
			private WebElement Search_User;
		@FindBy(id="btn_clear")
			private WebElement Clear_Search;
		public void Launch_NewUser_Page()
		{
			SeleniumHelper.ClickButton(NewUser_Link);
		}
		public void Select_Branch_and_Role(String Branch, String Role)
		{
			SeleniumHelper.SelectTextFromList(Select_Branch, Branch);
			SeleniumHelper.SelectTextFromList(Select_Roles, Role);
		}
		public void SearchForUser()
		{
			SeleniumHelper.ClickButton(Search_User);
		}
		public void Clear_User_Search() {
			SeleniumHelper.ClickButton(Clear_Search);
		}
}
