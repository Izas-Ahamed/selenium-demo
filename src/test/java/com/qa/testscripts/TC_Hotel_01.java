package com.qa.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.batik.css.parser.ParseException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.qa.utility.ExcelUtility;

public class TC_Hotel_01 extends TestBase{

	@Test(dataProvider="excelsheet")
	public void HotelBooking(String City,String CheckinDate,String CheckoutDate,String Rooms,String Adults,String Children,String Email)throws InterruptedException, java.text.ParseException, IOException {
		hotel_page.getHotelsLink().click();
		Thread.sleep(2000);
		if(driver.getTitle().contains("Search Hotels")) {
			Reporter.log("User is on Hotels Page");
			assertTrue(true);
		}else {
			captureScreenShot("HotelBooking");
			Reporter.log("User is not on the hotels page");	
			assertTrue(false);
		}
		hotel_page.getSearchByCity().click();
		hotel_page.setCityName(City);
		Thread.sleep(3000);
		List<WebElement> elements = hotel_page.getDropDownList();
		elements.get(0).click();
		
		String date[]=CheckinDate.split("[/]");
		String Checkin=date[1]+"-"+date[0]+"-"+date[2];
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+Checkin+"');", hotel_page.getCheckin());
		
		String date1[]=CheckoutDate.split("[/]");
		String Checkout=date1[1]+"-"+date1[0]+"-"+date1[2];
		js.executeScript("arguments[0].setAttribute('value','"+Checkout+"');", hotel_page.getCheckOut());
		
		hotel_page.getTravellers().click();
		int NoofRooms=Integer.parseInt(Rooms);
		for(int i=1;i<=NoofRooms;i++) {
			hotel_page.getRooms().click();
		}
		Thread.sleep(3000);
		int NoofAdults=Integer.parseInt(Adults);
		for(int i=1;i<=NoofAdults;i++) {
			hotel_page.getAdults().click();
			}
		int NoofChildren=Integer.parseInt(Children);
		for(int i=1;i<=NoofChildren;i++) {
			hotel_page.getChildren().click();
			}
		hotel_page.getSubmitButton().click();
		if(driver.getTitle().contains("Hotels in hyderabad - PHPTRAVELS")) {
			Reporter.log("User is on Hotels suggestion page");
			assertTrue(true);
		}else {
			captureScreenShot("Hotels suggestion");
			Reporter.log("User is not on the hotels suggestion page");	
			assertTrue(false);
		}
		
		WebElement ele=hotel_page.getemailBox();
		js.executeScript("arguments[0].scrollIntoView()", ele);
		ele.sendKeys(Email);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",hotel_page.getsubscribeButton());
	}	
	
	@DataProvider(name="excelsheet")
	public Object[][] data() throws IOException, InterruptedException{
		Object obj[][]= excel.getData("PHP_Travels_TestData","Sheet4");
		return obj;
	}
	
}