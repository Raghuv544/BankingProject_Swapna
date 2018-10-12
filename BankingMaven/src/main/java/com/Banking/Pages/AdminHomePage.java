package com.Banking.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Banking.Utilities.SeleniumHelper;
import com.Banking.Utilities.TestNGHelper;

public class AdminHomePage {
	private WebDriver AdminHomePageDriver;
	//Create constructor with same name as class name
	public AdminHomePage(WebDriver AdminHomePageDriver )
	{
		//page factory is a library so to use keywords like @findby use this library
		//'this' refers to the current page(current class=AdminHomePage)
		PageFactory.initElements(AdminHomePageDriver, this);
	}
	/*public static void main(String[] args) {
		//Create objet ref for HomePage class
		HomePage Hpage = new HomePage();
	}*/
	//create elements 
	//nothing but findElement by. etc
	@FindBy(xpath="//*[@id=\"Table_01\"]/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")
	 private WebElement branches_link;
	@FindBy(xpath="//*[@id=\"Table_01\"]/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")
	 private WebElement roles_link;
	@FindBy(xpath="//*[@id=\"Table_01\"]/tbody/tr[2]/td/table/tbody/tr[6]/td/a/img")
	 private WebElement users_link;
	@FindBy(xpath="//*[@id=\"Table_01\"]/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")
	 private WebElement employee_link;
	@FindBy(xpath="//*[@id=\"Table_02\"]/tbody/tr/td[2]/a/img")
	 private WebElement changePW_link;
	@FindBy(xpath="//*[@id=\"Table_02\"]/tbody/tr/td[3]/a/img")
	 private WebElement logout_link;
	//write methods to use the above links
	public void click_branches_link()
	{
		SeleniumHelper.ClickButton(branches_link);
		TestNGHelper.assertEqual("admin_banker_master", "admin_banker_master", "No", "Successfully Navigated to BranchesLink");

	}
	public void click_roles_link()
	{
		SeleniumHelper.ClickButton(roles_link);
	}
	public void click_users_link()
	{
		SeleniumHelper.ClickButton(users_link);
	}
	public void click_employee_link()
	{
		SeleniumHelper.ClickButton(employee_link);
	}
	public void click_changePW_link()
	{
		SeleniumHelper.ClickButton(changePW_link);
	}
	public void click_logout_link()
	{
		SeleniumHelper.ClickButton(logout_link);
	}
}
