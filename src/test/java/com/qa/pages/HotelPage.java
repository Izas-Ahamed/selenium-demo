package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelPage {
WebDriver driver;
	
	public HotelPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Hotels")
	WebElement HotelsLink;
	public WebElement getHotelsLink() {
		return HotelsLink;
	}
	
	@FindBy(id="exampleInputEmail1")
	WebElement emailBox;
	public WebElement getemailBox() {
		return emailBox;
	}
	
	@FindBy(id="select2-hotels_city-container")
	WebElement SearchByCity;
	public WebElement getSearchByCity() {
		return SearchByCity;
	}
	@FindBy(xpath="/html/body/span/span/span[1]/input")
	WebElement CityName;
	public void setCityName(String City) {
		 CityName.sendKeys(City);
	}
	@FindBy(xpath="//body/span[1]/span[1]/span[2]/ul[1]/li")
	List<WebElement> DropdownList;
	public List<WebElement> getDropDownList() {
		return DropdownList;
	}
	
	@FindBy(id="checkin")
	WebElement Checkin;
	public WebElement getCheckin() {
		return Checkin;
	}
	@FindBy(xpath="/html/body/div[4]/div[1]/table/thead/tr[1]/th[2]")
	WebElement MonthandYear;
	public WebElement getMonthandYear() {
		return MonthandYear;
	}
	@FindBy(xpath="/html/body/div[4]/div[2]/table/tbody/tr/td/span[10]")
	WebElement Month;
	public WebElement getMonth() {
		return Month;
	}
	@FindBy(xpath="//body[1]/div[4]/div[1]/table[1]/tbody[1]/tr[2]/td[6]")
	WebElement CheckinDate;
	public WebElement getCheckinDate() {
		return CheckinDate;
	}
	@FindBy(id="checkout")
	WebElement CheckOut;
	public WebElement getCheckOut() {
		return CheckOut;
	}
	@FindBy(xpath="/html/body/div[5]/div[1]/table/thead/tr[1]/th[2]")
	WebElement CheckOutMandY;
	public WebElement getCheckOutMandY() {
		return CheckOutMandY;
	}
	@FindBy(xpath="/html/body/div[5]/div[2]/table/tbody/tr/td/span[10]")
	WebElement CheckOutMonth;
	public WebElement getCheckOutMonth() {
		return CheckOutMonth;
	}
	@FindBy(xpath="//body[1]/div[4]/div[1]/table[1]/tbody[1]/tr[2]/td[2]")
	WebElement CheckoutDate;
	public WebElement setCheckoutDate() {
		return CheckoutDate;
	}
	@FindBy(xpath="//body/section[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]")
	WebElement Travellers;
	public WebElement getTravellers() {
		return Travellers;
	}
	@FindBy(xpath="//*[@id=\"hotels-search\"]/div/div/div[3]/div/div/div/div/div[1]/div/div/div[3]")
	WebElement Room;
	public WebElement getRooms() {
		 return Room;
	}
	@FindBy(xpath="//body/section[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")
	WebElement Adults;
	public WebElement getAdults() {
		return Adults;
	}
	@FindBy(xpath="//body/section[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/i[1]")
	WebElement Children;
	public WebElement getChildren() {
		 return Children;
	}
	@FindBy(id="submit")
	WebElement SubmitButton;
	public WebElement getSubmitButton() {
		return SubmitButton;
	}
	
	@FindBy(className="logo")
	WebElement Logo;
	public WebElement getLogo() {
		return Logo;
	}
	@FindBy(id="email_subscribe")
	WebElement subscribeButton;
	public WebElement getsubscribeButton() {
		 return subscribeButton;
	}
	
	
}