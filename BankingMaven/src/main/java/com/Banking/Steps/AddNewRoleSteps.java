package com.Banking.Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Banking.Pages.AdminHomePage;
import com.Banking.Pages.HomePage;
import com.Banking.Pages.NewRolePage;
import com.Banking.Pages.RolesPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddNewRoleSteps {
	public WebDriver driver;

	@Given("^Admin Logs In to The application$")
	public void admin_Logs_In_to_The_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://primusbank.qedgetech.com/");
		HomePage HPage= new HomePage(driver);
		HPage.enterLoginDetails("Admin", "Admin");
	}

	@Then("^Go to Roles Page$")
	public void go_to_Roles_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		AdminHomePage AH_Page = new AdminHomePage(driver);
		AH_Page.click_roles_link();
	}

	@When("^Click On New Role button$")
	public void click_On_New_Role_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		RolesPage R_Page= new RolesPage(driver);
		R_Page.Create_New_Role();
	}

	@Then("^Enter New Role Details$")
	public void enter_New_Role_Details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		/*NewRolePage NR_Page= new NewRolePage(driver);
		NR_Page.*/
		NewRolePage NR_Page = new NewRolePage(driver);
		NR_Page.Enter_Role_Details("QAanalyst", "Quality Assurance Analyst", "D");
	}

	@Then("^Click Submit button$")
	public void click_Submit_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		NewRolePage NR_Page= new NewRolePage(driver);
		NR_Page.Submit_New_Role_Form();
	}
	

}
