package com.qa.testscripts;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_Visa_01 extends TestBase{
	
	@Test(dataProvider = "VisaInfos")
	public void VisaTestCase(String fromCountry,String toCountry,String VisaDate,String fName,String lName,String fdate,String email,String phone,String note) throws InterruptedException, IOException{
		
		// Click on Visa tab
		visa_page.getVisaButton().click();
		Thread.sleep(2000);
		
		if(driver.getTitle().contains("Submit Visa")) {
			Reporter.log("Title contains the word Submit Visa");
			assertTrue(true);
		}else {
			Reporter.log("Title doesnt contains the word Submit Visa");	
			captureScreenShot("VisaTestCase");
			assertTrue(false);
		}
		
		// Checking visa is available for both countries
		if(CheckCountryIsInOptions(visa_page.getFromCountryOptions(), fromCountry) && CheckCountryIsInOptions(visa_page.getToCountryOptions(), toCountry)) {
			Reporter.log("Visa available for both country");
			assertTrue(true);
		}else {
			Reporter.log("Visa is not availble for countrys");
			captureScreenShot("VisaTestCase");
			assertTrue(false);
		}
		
		Thread.sleep(1000);
		
		//Entering visa details
		visa_page.getFromCountry().selectByVisibleText(fromCountry);
		Thread.sleep(2000);
		
		visa_page.getToCountry().selectByVisibleText(toCountry);
		Thread.sleep(2000);
		
		String Date = FromatDate(VisaDate);
		
		js.executeScript("arguments[0].setAttribute('value','"+Date+"');",visa_page.getVisaDate());
		Thread.sleep(2000);
		
		//Submit
		visa_page.getSubmitButton().click();
		Thread.sleep(2000);
		
		String fullDate = FromatDate(VisaDate);
		Thread.sleep(2000);
		
		if(visa_page.getUpperDate().getText().equals(fullDate)) {
			Reporter.log("The dates are same for visa");
			assertTrue(true);
		}else {
			Reporter.log("The dates are Different for visa");	
			captureScreenShot("VisaTestCase");
			assertTrue(false);
		}
		
		
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		
		
		//Filling form details
		visa_page.getFormFirstName().sendKeys(fName);
		visa_page.getFormLastName().sendKeys(lName);
		Thread.sleep(1000);
		
		visa_page.getFormEmail().sendKeys(email);
		visa_page.getFormPhone().sendKeys(phone);
		
//		visa_page.getFormDate().clear();
//		Thread.sleep(2000);
//		String fd = FromatDate(fdate);
//		visa_page.getFormDate().sendKeys(fd);
//		Thread.sleep(2000);
//		visa_page.getFormDate().click();
//		Thread.sleep(1000);
		String fd = FromatDate(fdate);
		js.executeScript("arguments[0].setAttribute('value','"+fd+"');",visa_page.getFormDate());
		Thread.sleep(2000);
		
		
		visa_page.getFormNotes().sendKeys(note);
		visa_page.getFormSubmit().click();
		Thread.sleep(2000);
		
		visa_page.getHomeButton().click();
		Thread.sleep(2000);
	}	
	

	@DataProvider(name="VisaInfos")
	public Object[][] DataProvider() throws IOException {
		Object data[][] = excel.getData("PHP_Travels_TestData","Sheet6") ;
		return data;
	}
	
	public String FromatDate(String d) {
		String date[] = d.split("[/]");
		String date_check=date[1];
		String month_check=date[0];
		String year_check=String.valueOf(2000+Integer.parseInt(date[2]));
		
		if(date[1].length()!=2) {
			date_check = "0"+date[1]+"-";
		}else {
			date_check = date[1]+"-";
		}
		if(date[0].length()!=2) {
			month_check = "0"+date[0]+"-";
		}else {
			month_check = date[0]+"-";
		}
		return date_check+month_check+year_check;
		
	}
	
	public boolean CheckCountryIsInOptions(List<WebElement> list, String country ) {
		for( WebElement x : list) {
			if(x.getText().equals(country)) {
				return true;
			}
		}
		return false;
	}

}
