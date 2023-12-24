package com.qa.testscripts;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

public class TC_Flight_01 extends TestBase {

	@Test(dataProvider = "oneWayDataLoader")
	void searchFlights(String trip, String from, String to, String dDate, String rDate, String adult, String child,
			String infants, String fclass) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		js.executeScript("scroll(0,0);");
		Thread.sleep(2000);
		flight_page.getFlightsLink().click();

		if (trip.toLowerCase().contains("roundtrip")) {
			flight_page.getRoundTrip().click();
		} else {
			flight_page.getOneWay().click();
		}

		flight_page.setFromText(from);
		flight_page.setTo(to);
		flight_page.setDepartureDate(dDate);

		if (flight_page.getRoundTrip().isSelected()) {
			flight_page.setReturnDate(rDate);
		}

		flight_page.getPassengerCount().click();

		flight_page.setAdultCount(adult);
		flight_page.setChildCount(child);
		flight_page.setInfantsCount(infants);
		flight_page.setFlightType(fclass);
		flight_page.getSearchBtn().click();

		// Check Weather the flights available or not

		if (flight_page.isCatalogPanelPresenet()) {

			Assert.assertTrue(true);

			// click on booking button on random flight that displayed

			List<WebElement> flights = flight_page.getFlightList();
			int max = 0;
			if (flights.size() >= 25) {
				max = 25;
			} else {
				max = flights.size();
			}

			int random = (int) (Math.random() * max + 0);
			WebElement flight = flights.get(random).findElement(By.tagName("button"));
			js.executeScript("arguments[0].click();", flight);

			// Check weather the Booking page opens are not

			if (driver.getTitle().equalsIgnoreCase("Flight Booking - PHPTRAVELS")) {
				Assert.assertTrue(true);
				driver.navigate().back();
			} else {
				try {
					captureScreenShot("searchFlights");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Assert.assertTrue(false);
			}

		} else if (flight_page.isNoMatchimgPresent()) {
			Assert.assertTrue(true);
		} else {

			js.executeScript("scroll(0,800);");
			Thread.sleep(2000);
			try {
				captureScreenShot("searchFlights");
			} catch (IOException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
		}

	}

	@DataProvider
	public Object[][] oneWayDataLoader() throws IOException {
		String FileName = "PHP_Travels_TestData";
		String sheet = "Sheet3";
		return ExcelUtility.getData(FileName, sheet);
	}
}
