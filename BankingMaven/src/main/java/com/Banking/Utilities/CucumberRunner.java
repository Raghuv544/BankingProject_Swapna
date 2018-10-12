package com.Banking.Utilities;



import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
                                strict = true,
                                monochrome = true, 
                                features = "Features",
                                glue = "com.Banking.Steps",
                                plugin = {	"pretty", "html:target/cucumber-html-report", 
                                       		 "json:target/cucumber-reports/Cucumber.json"}, 
                                tags={"@CreateBranchTC1"}
                                )
                                

public class CucumberRunner extends AbstractTestNGCucumberTests {

}

