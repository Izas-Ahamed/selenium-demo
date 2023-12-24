package com.qa.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightPage {

	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'flights')]")
	WebElement FlightsLink;

	@FindBy(id = "one-way")
	WebElement oneWay;

	@FindBy(id = "round-trip")
	WebElement roundTrip;

	@FindBy(className = "autocomplete-result")
	List<WebElement> autocomplete;

	@FindBy(id = "autocomplete")
	WebElement from;

	@FindBy(id = "autocomplete2")
	WebElement to;

	@FindBy(id = "departure")
	WebElement departureDate;

	@FindBy(id = "return")
	WebElement returnDate;

	@FindBy(xpath = "//a[@class='dropdown-toggle dropdown-btn waves-effect']")
	WebElement passengerCount;

	@FindBy(id = "fadults")
	WebElement adultCount;

	@FindBy(id = "fchilds")
	WebElement childCount;

	@FindBy(id = "finfant")
	WebElement infantsCount;

	@FindBy(id = "flight_type")
	WebElement flightType;

	@FindBy(id = "flights-search")
	WebElement searchBtn;

	@FindBy(className = "catalog-panel")
	WebElement catalogPanel;

	@FindBy(xpath = "//div[@Class='theme-search-results-item _mb-10 theme-search-results-item-rounded theme-search-results-item- waves-effect']")
	List<WebElement> flightList;

	@FindBy(xpath = "/html/body/div[2]/img")
	WebElement noMatchImg;



	public boolean isNoMatchimgPresent() {
	try {
	return this.noMatchImg.isDisplayed();
	} catch (NoSuchElementException e) {
	return false;
	}

	}
	
	public FlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Flights link
	public WebElement getFlightsLink() {
		return FlightsLink;
	}

	public void setFlightsLink(WebElement flightsLink) {
		FlightsLink = flightsLink;
	}

	// OneWay

	public WebElement getOneWay() {
		return oneWay;
	}

	public void setOneWay(WebElement oneWay) {
		this.oneWay = oneWay;
	}

	// Round trip

	public WebElement getRoundTrip() {
		return roundTrip;
	}

	public void setRoundTrip(WebElement roundTrip) {
		this.roundTrip = roundTrip;
	}

	// Auto complete

	public List<WebElement> getAutocomplete() {
		return autocomplete;
	}

	public void setAutocomplete(List<WebElement> autocomplete) {
		this.autocomplete = autocomplete;
	}

	// From

	public WebElement getFrom() {
		return from;
	}

	public void setFromText(String from) {
		this.from.clear();
		this.from.sendKeys(from);
		System.out.println("from");
		System.out.println(this.autocomplete.size());
		for (WebElement element : this.autocomplete) {
			if (element.getText().toUpperCase().contains(from.toUpperCase())) {
				element.click();
				return;
			}
		}

	}

	// To

	public WebElement getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to.clear();
		this.to.sendKeys(to);
		System.out.println("to");
		System.out.println(this.autocomplete.size());
		for (WebElement element : this.autocomplete) {
			if (element.getText().toUpperCase().contains(to.toUpperCase())) {
				element.click();
				return;
			}
		}
	}

	// Departure

	public WebElement getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String date) {
		this.departureDate.clear();
		this.departureDate.sendKeys(date, Keys.ENTER);
	}

	// return Date

	public WebElement getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(String date) {
		this.returnDate.clear();
		this.returnDate.sendKeys(date, Keys.ENTER);
	}

	// Passenger

	public WebElement getPassengerCount() {
		return this.passengerCount;
	}

	public WebElement getAdultCount() {
		return adultCount;
	}

	// AdultCount

	public void setAdultCount(String adultCount) {
		this.adultCount.clear();
		this.adultCount.sendKeys(adultCount);
	}

	// Child Count

	public WebElement getChildCount() {
		return childCount;
	}

	public void setChildCount(String childCount) {
		this.childCount.clear();
		this.childCount.sendKeys(childCount);
	}

	// InfantCount

	public WebElement getInfantsCount() {

		return infantsCount;
	}

	public void setInfantsCount(String infantsCount) {
		this.infantsCount.clear();
		this.infantsCount.sendKeys(infantsCount);
	}

	// searchButton
	public WebElement getSearchBtn() {
		return this.searchBtn;
	}

	// catalog
	public WebElement getCatalogPanel() {
		return this.catalogPanel;
	}

	public boolean isCatalogPanelPresenet() {
		try {
			this.catalogPanel.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// FlightType

	public void setFlightType(String type) {
		Select select = new Select(this.flightType);

		select.selectByVisibleText(type);
	}

	// FlightsList

	public List<WebElement> getFlightList() {
		return flightList;
	}

}
