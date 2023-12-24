package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class VisaPage {
	
	WebDriver driver;
	
	@FindBy(linkText = "Home")
	WebElement HomeButton;
		
	@FindBy(linkText = "Visa")
	WebElement VisaButton;
	
	@FindBy(xpath = "//select[@id='from_country']")
	WebElement FromCountry;
	
	@FindBy(xpath = "//select[@id='to_country']")
	WebElement ToCountry;
	
	@FindBy(xpath = "//input[@id='date']")
	WebElement VisaDate;
	
	@FindBy(xpath = "//button[@id='submit']")
	WebElement submitButton;
	
	@FindBy(name = "first_name")
	WebElement formFirstName;
	
	@FindBy(name = "last_name")
	WebElement formLastName;
	
	@FindBy(name = "email")
	WebElement formEmail;
	
	@FindBy(name = "phone")
	WebElement formPhone;
	
	@FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/input[1]")
	WebElement formDate;
	
	@FindBy(name = "notes")
	WebElement formNotes;
	
	@FindBy(xpath = "//button[@id='submit']")
	WebElement formSubmit;
	
	@FindBy(className="next")
	WebElement DatePickerForward;
		
	@FindBy(className="switch")
	WebElement DatePickerMid;
	
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h5[1]")
	WebElement UpperDate;
	
	@FindBy(className = "day")
	List<WebElement> day;
	
	public List<WebElement> getFromCountryOptions(){
		return getFromCountry().getOptions();
	}
	
	public List<WebElement> getToCountryOptions(){
		return getToCountry().getOptions();
	}
	
	public WebElement getDatePickerForward() {
		return DatePickerForward;
	}
	
	public WebElement getUpperDate() {
		return UpperDate;
	}

	public WebElement getDatePickerMid() {
		return DatePickerMid;
	}

	public List<WebElement> getDay() {
		return day;
	}



	public List<WebElement> getMonth() {
		return month;
	}



	@FindBy(className = "month")
	List<WebElement> month;
	
	
	public WebElement getHomeButton() {
		return HomeButton;
	}



	public WebElement getVisaButton() {
		return VisaButton;
	}



	public Select getFromCountry() {
		Select fcountry = new Select(FromCountry);
		return fcountry;
	}



	public Select getToCountry() {
		Select tcountry = new Select(ToCountry);
		return tcountry;
	}



	public WebElement getVisaDate() {
		return VisaDate;
	}



	public WebElement getSubmitButton() {
		return submitButton;
	}



	public WebElement getFormFirstName() {
		return formFirstName;
	}



	public WebElement getFormLastName() {
		return formLastName;
	}



	public WebElement getFormEmail() {
		return formEmail;
	}



	public WebElement getFormPhone() {
		return formPhone;
	}



	public WebElement getFormDate() {
		return formDate;
	}



	public WebElement getFormNotes() {
		return formNotes;
	}



	public WebElement getFormSubmit() {
		return formSubmit;
	}



	public VisaPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
