package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	
	public static ExtentReports generateExtentReport() {
		
		//Create an Object for ExtentReport class
		
		ExtentReports extentReport = new ExtentReports();
		
		//To find different type of reporters
		/*
		 * visit extentreports.com
		 * click on docs
		 * select version 5, java ,Geeting started, Reporters
		 * use ExtentSparkReporter
		 * */
		File extentReportFile= new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);//in this constructor we have to provide file path where we want to generate extent report
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialsNinja Test Automation Result");
		sparkReporter.config().setDocumentTitle("TN Automation Report");
		sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter); //For attaching sparkReporter to extent report
		
		//In generated report add some additional information regarding automation test use below script
		
		//To read data from properties file
		Properties configProp = new Properties();
		File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		FileInputStream fisConfigprop;
		try {
			fisConfigprop = new FileInputStream(configPropFile);
			configProp.load(fisConfigprop);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentReport.setSystemInfo("browser Name", configProp.getProperty("browserName"));
		extentReport.setSystemInfo("Email",configProp.getProperty("ValidEmail"));
		extentReport.setSystemInfo("Password",configProp.getProperty("ValidPassword"));
		
		//Refer experiment package - demo class
		extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentReport.setSystemInfo("UserName",System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version",System.getProperty("java.version"));
		
		return extentReport;
	}
}
