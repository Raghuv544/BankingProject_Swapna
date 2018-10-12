package com.Banking.Reporting;

import com.Banking.Utilities.AutomationCore;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.relevantcodes.extentreports.ExtentReports;

import cucumber.deps.com.thoughtworks.xstream.converters.ErrorReporter;

public class ExtentManager {

	static AutomationCore AutoCore;

	private static com.aventstack.extentreports.ExtentReports extent;
	public static ExtentHtmlReporter htmlReporter;

	public static com.aventstack.extentreports.ExtentReports getInstance() {
		AutoCore = new AutomationCore();

		if (extent == null)
			createInstance(AutoCore.Environment("extentReportPath"));

		return extent;
	}

	public static com.aventstack.extentreports.ExtentReports createInstance(String fileName) {
		System.out.println("extent report path in manager is" + fileName);
		htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setEncoding("utf-8");

		extent = new com.aventstack.extentreports.ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.setAppendExisting(true);

		System.out.println("extent report created in ext manager");

		return extent;
	}

	public static void setExtentReportName() {
		htmlReporter.config().setReportName("PrimusBank Automation Test Results  ");
		htmlReporter.config().setDocumentTitle("PrimusBank Automation Test Results  ");
	}

}