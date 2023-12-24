package com.qa.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.BlogPage;
import com.qa.pages.FlightPage;
import com.qa.pages.HotelPage;
import com.qa.pages.LoginAndLogoutPages;
import com.qa.pages.SignUpPages;
import com.qa.pages.ToursPages;
import com.qa.pages.VisaPage;
import com.qa.utility.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	WebDriver driver;
	JavascriptExecutor js;
	ExcelUtility excel;
	Properties properties;
	FileInputStream file;
	
	
	LoginAndLogoutPages login_and_logout_pages;
	FlightPage flight_page;
	SignUpPages signup_pages;
	VisaPage visa_page;
	HotelPage hotel_page;
	BlogPage blog_page;
	ToursPages tours_page;
	
	
	@BeforeClass
	@Parameters({ "Browser", "URL" })
	public void setUp(String browser, String URL) {

		switch (browser) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		}
		
		login_and_logout_pages = new LoginAndLogoutPages(driver);
		signup_pages = new SignUpPages(driver);
		flight_page = new FlightPage(driver);
		visa_page = new VisaPage(driver);
		hotel_page = new HotelPage(driver);
		blog_page = new BlogPage(driver);
		tours_page = new ToursPages(driver);
		
		js = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
	}

	@AfterClass
	public void tearDown() {

		driver.quit();

	}
	
	public void captureScreenShot(String className) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshots/" + className + ".png";
		File des = new File(path);
		FileUtils.copyFile(source,des);
	}

}
