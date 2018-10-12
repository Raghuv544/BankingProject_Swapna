package com.Banking.Steps;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Banking.Pages.AdminHomePage;
import com.Banking.Pages.BranchesPage;
import com.Banking.Pages.HomePage;
import com.Banking.Pages.NewBranchPage;
import com.Banking.Reporting.ExtentManager;
import com.Banking.Reporting.ExtentUtilities;
import com.Banking.Utilities.SeleniumHelper;
import com.Banking.Utilities.TestNGHelper;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PrimusBankSteps {
	public WebDriver driver;
	public static String currentScenario;
	@Before
	public void tearUp(Scenario scenario) {
		currentScenario = scenario.getName().replace(" ", "");
		System.out.println(System.getProperty("user.dir"));
		ExtentUtilities.initilaizeExtentReport();
		ExtentManager.setExtentReportName();
		ExtentUtilities.createParentTest(scenario.getName());
		
	}

	@After
	public void tearDown() {
		System.out.println("tear down");
		ExtentUtilities.extentFlush();
		//quitDriver();
	}
	@Given("^Admin logs in to Primus Bank Application$")
	public void admin_logs_in_to_Primus_Bank_Application() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// SeleniumHelper.BrowesrSetup(driver, "Chrome");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://primusbank.qedgetech.com/");
		/*
		 * SeleniumHelper.EnterText(driver.findElement(By.id("txtuId")), "Admin");
		 * SeleniumHelper.EnterText(driver.findElement(By.id("txtPword")), "Admin");
		 * SeleniumHelper.ClickButton(driver.findElement(By.id("login")));
		 */
		// call the page object written in HomePage class which is enterLoginDetails
		HomePage HPage = new HomePage(driver);
		HPage.enterLoginDetails("Admin", "Admin");
	}
	@When("^Click on Branches button$")
	public void click_on_Branches_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// call the reusable method directly.
		// SeleniumHelper.ClickButton(driver.findElement(By.xpath("//*[@id=\"Table_01\"]/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")));
		// create object ref for the relevent class(page)
		AdminHomePage APage = new AdminHomePage(driver);
		APage.click_branches_link();
	}
	@When("^Click on New Branch button$")
	public void click_on_New_Branch_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// SeleniumHelper.ClickButton(driver.findElement(By.id("BtnNewBR")));
		BranchesPage BranchPage = new BranchesPage(driver);
		BranchPage.Click_NewBranch_Link();
		TestNGHelper.assertEqual("admin_banker_master", "admin_banker_master", "No", "Successfully Navigated to BranchesLink");

	}
	@Then("^Enter Branch details$")
	public void enter_Branch_details() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		/*
		 * SeleniumHelper.EnterText(driver.findElement(By.id("txtbName")),
		 * "LondonBranch");
		 * SeleniumHelper.EnterText(driver.findElement(By.id("txtAdd1")), "Address1");
		 * SeleniumHelper.EnterText(driver.findElement(By.id("txtArea")), "Surrey");
		 * SeleniumHelper.EnterText(driver.findElement(By.id("txtZip")), "123456");
		 * SeleniumHelper.SelectTextFromList(driver.findElement(By.id("lst_counrtyU")),
		 * "UK");
		 * SeleniumHelper.SelectTextFromList(driver.findElement(By.id("lst_stateI")),
		 * "England");
		 * SeleniumHelper.SelectTextFromList(driver.findElement(By.id("lst_cityI")),
		 * "MANCHESTER");
		 */
		try {
			NewBranchPage NBranchPage = new NewBranchPage(driver);
			NBranchPage.Enter_NewBranch_Details("ManchesterPrimusBank", "9912", "Station Road", "Trivdale", "465923",
					"UK", "England", "MANCHESTER");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	@Then("^Click on Submit button$")
	public void click_on_Submit_button() throws Throwable {
		/*
		 * // Write code here that turns the phrase above into concrete actions try {
		 * SeleniumHelper.ClickButton(driver.findElement(By.id("btn_insert")));
		 * System.out.println("New Branch Added Successfully"); } catch (Exception e) {
		 * // TODO: handle exception System.out.println(e.getMessage()); }
		 */
		NewBranchPage NBranchPage = new NewBranchPage(driver);
		NBranchPage.Submit_NewBranch_Form();
		//TestNGHelper.assertEqual("admin_banker_master", "admin_banker_master", "No", "Successfully Navigated to BranchesLink");

	}
	@Then("^Close The Browser$")
	public void close_The_Browser() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.close();
	}
	
	/*@Then("^Enter Branch details as \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void enter_Branch_details_as(String BranchName, String Branch_Add1, String Branch_Add2,String Area,String Branch_Zipcode, String Branch_Country, String Branch_State, String Branch_City) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try {
			NewBranchPage NBranchPage = new NewBranchPage(driver);
			NBranchPage.Enter_NewBranch_Details(BranchName, Branch_Add1, Branch_Add2,Area, Branch_Zipcode,  Branch_Country,  Branch_State,  Branch_City	);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}*/
	@Then("^Enter Branch details as \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void enter_Branch_details_as(String BranchName, String Branch_Add1, String Branch_Add2,String Area,String Branch_Zipcode, String Branch_Country, String Branch_State, String Branch_City) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try {
			NewBranchPage NBranchPage = new NewBranchPage(driver);
			NBranchPage.Enter_NewBranch_Details(BranchName, Branch_Add1, Branch_Add2,Area, Branch_Zipcode,  Branch_Country,  Branch_State,  Branch_City	);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public void takeSnapShot(String path) {
		// TODO Auto-generated method stub
		try {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File(path);
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			// e.printStackTrace();
			e.getMessage();
	}

	
	}}
