package com.qa.pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToursPages {
	WebDriver driver;
	public ToursPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="/html/body/header/div[2]/div/div/div/div/div[2]/nav/ul/li[4]/a")
	WebElement clicktours;
	public WebElement getclicktours() {
		return clicktours;
	}
    @FindBy(xpath="/html/body/section[1]/section/div/h2")
    WebElement title;
    public WebElement gettitle() {
    	return title;
    }
    @FindBy(id="select2-tours_city-container")
    WebElement clickheading;
    public WebElement getclickheading() {
    	return clickheading;
    }
    @FindBy(xpath="//body/span[1]/span[1]/span[1]/input[1]")
    WebElement destinationheading;
    public WebElement getdestinationheading() {
    	return destinationheading;
    }
    public void destname(String Destination) {
    	destinationheading.sendKeys(Destination);
		
	}
    @FindBy(xpath = "//body/span[1]/span[1]/span[2]/ul[1]/li[1]")
	WebElement destinationoption;
	public WebElement getdestinationoption() {
		return destinationoption;
	}
	@FindBy(xpath = "//input[@id='date']")
	WebElement TourDate;
	public WebElement getTourDate() {
		return TourDate;
	}
	
	@FindBy(xpath="//body[1]/section[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]/p[1]")
	WebElement travellers;
	public WebElement gettravellers() {
		return travellers;
	}
	@FindBy(xpath="//input[@id='tours_adults']")
	WebElement adultcount;
	public WebElement getadultcount() {
		return adultcount;
	}
	public void AdultCount(String Adult) {
		adultcount.clear();
		adultcount.sendKeys(Adult);
	}
	@FindBy(xpath="//input[@id='tours_child']")
	WebElement childcount;
	public WebElement getchildcount() {
		return childcount;
	}
	public void ChildCount(String Child) {
		childcount.clear();
		childcount.sendKeys(Child);
	}
	@FindBy(id="submit")
	WebElement search;
	public WebElement getsearch() {
		return search;
	}
	@FindBy(xpath="//body/section[3]/div[1]/div[1]/div[1]/a[1]/div[2]")
	WebElement needhelp;
	public WebElement getneedhelp() {
		return needhelp;
	}
	@FindBy(xpath="/html/body/section[2]/div/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div/input")
	WebElement firstname;
	public WebElement getfirstname() {
		return firstname;
	}
	@FindBy(xpath="/html/body/section[2]/div/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div/input")
	WebElement email;
	public WebElement getemail() {
		return email;
	}
	@FindBy(xpath="/html/body/section[2]/div/div/div[1]/div/div[2]/div[2]/form/div[3]/div/div/textarea")
	WebElement message;
	public WebElement getmessage() {
		return message;
	}
	public void contactus(String Firstname,String Email,String Message) {
		firstname.sendKeys(Firstname);
		email.sendKeys(Email);
		message.sendKeys(Message);
	}
	
	@FindBy(id="button")
	WebElement send;
	public WebElement getsend() {
		return send;
	}
	@FindAll
	({ @FindBy(className = "card-title")})
	public List<WebElement> cardtitles;
	
	public List<WebElement> getcardtitles()
	{
		return cardtitles;
	}
	@FindAll
	({ @FindBy(className = "select2-results__option")})
	public List<WebElement> destinationlist;
	
	public List<WebElement> getdestinationlist()
	{
		return destinationlist;
	}
	
	@FindBy(xpath="//span[contains(text(),'Destination')]")
	WebElement destname;
	public WebElement getdestname() {
		return destname;
	}

}