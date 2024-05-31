package com.crm.listenersCode;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateExtentReport implements ITestListener{
	
	public ExtentReports report;
	  public ExtentSparkReporter spark;
	   public ExtentTest test;
	  
		@Override
		public void onTestStart(ITestResult result) {
			String name= result.getMethod().getMethodName();
			test=report.createTest(name);
			System.out.println("OnTestStart");
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
		
			String name = result.getMethod().getMethodName();
			test.log(Status.PASS, name+"is Passed");
		}

		@Override
		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub
			String name = result.getMethod().getMethodName();
			
			
			test.log(Status.FAIL, name+"is failed");
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			String name = result.getMethod().getMethodName();
			
			test.log(Status.SKIP, name+"is Skipped");
		}

		@Override
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			File path =  new File("./ExtentReport/testcase.html");
			spark = new  ExtentSparkReporter(path);
			spark.config().setDocumentTitle("selenium");
			spark.config().setReportName("Desul");
			spark.config().setTheme(Theme.STANDARD);
			//attach the test case
			report=new ExtentReports();
			report.setSystemInfo("os", "Windows10");
			report.setSystemInfo("Browser", "chrome");
			report.attachReporter(spark);
			//create the test case
			
			
		}

		@Override
		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			report.flush();
		}

}
