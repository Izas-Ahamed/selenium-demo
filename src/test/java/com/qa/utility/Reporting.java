package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporting extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;

	public void onStart(ITestContext testContext) {
		String dateStamp = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss").format(new Date());
		String reportName = "Test-Report-" + dateStamp + ".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/" + reportName);
		extentReports = new ExtentReports();

		htmlReporter.config().setDocumentTitle("PHPTravels Test automation");
		htmlReporter.config().setAutoCreateRelativePathMedia(true);

		extentReports.attachReporter(htmlReporter);

	}

	public void onFinish(ITestContext testContext) {
		extentReports.flush();
	}

	public void onTestSuccess(ITestResult tr) {
		extentTest = extentReports.createTest(tr.getName());
		extentTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		extentTest.log(Status.PASS, "Test Passed");
//		extentTest.log(Status.PASS, tr.getThrowable());

	}

	public void onTestFailure(ITestResult tr) {
		extentTest = extentReports.createTest(tr.getName());
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		extentTest.log(Status.FAIL, "Test Failed");
		extentTest.log(Status.FAIL, tr.getThrowable());

		String screenShotName = System.getProperty("user.dir") + "/Screenshots/" + tr.getName() + ".png";
		File file = new File(screenShotName);
		if (file.exists()) {
			try {
				extentTest.fail("ScreeenShot " + extentTest.addScreenCaptureFromPath(screenShotName));
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

	public void onTestSkipped(ITestResult tr) {

		extentTest = extentReports.createTest(tr.getName());
		extentTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		extentTest.log(Status.SKIP, "Test Skipped");

	}

}
