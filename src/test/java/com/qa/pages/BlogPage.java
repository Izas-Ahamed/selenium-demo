package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BlogPage {
	
	@FindBy(xpath="//*[@id=\"cookie_stop\"]")
	WebElement cookie;
	@FindBy(xpath="/html/body/header/div[2]/div/div/div/div/div[2]/nav/ul/li[6]/a")
	WebElement blog;
	@FindBy(xpath="/html/body/section[2]/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/div/a")
	WebElement specialFares;
	@FindBy(xpath="/html/body/header/div[2]/div/div/div/div/div[2]/nav/ul/li[7]/a")
	WebElement offers;
	@FindBy(xpath="/html/body/section[2]/div/div/div[1]/div/div[2]/div[1]/div/a")
	WebElement lunchCoupon;
	@FindBy(xpath="/html/body/section[10]/div[1]/div[1]/div[1]/div/ul/li[3]/a/strong")
	WebElement contactUs;
	@FindBy(xpath="/html/body/section[2]/div/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div/input")
	WebElement name;
	@FindBy(xpath="/html/body/section[2]/div/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div/input")
	WebElement email;
	@FindBy(xpath="/html/body/section[2]/div/div/div[1]/div/div[2]/div[2]/form/div[3]/div/div/textarea")
	WebElement message;
	@FindBy(xpath="//*[@id=\"recaptcha-anchor\"]/div[1]")
	WebElement captcha;
	@FindBy(xpath="//*[@id=\"button\"]")
	WebElement send;
	@FindBy(xpath="/html/body/section[10]/div[1]/div[1]/div[2]/ul/li[1]/ul/li[1]/a")
	WebElement aboutUs ;
	@FindBy(xpath="/html/body/section[10]/div[1]/div[1]/div[2]/ul/li[1]/ul/li[2]/a")
	WebElement termsOfUse ;
	@FindBy(xpath="/html/body/section[10]/div[1]/div[1]/div[2]/ul/li[1]/ul/li[3]/a")
	WebElement cookiesPolicy ;
	@FindBy(xpath="/html/body/section[10]/div[1]/div[1]/div[2]/ul/li[1]/ul/li[4]/a")
	WebElement privacyPolicy ;
	@FindBy(xpath="/html/body/section[5]/div[1]/div[1]/div[2]/ul/li[2]/ul/li[1]/a")
	WebElement becomeSupplier  ;
	@FindBy(xpath="/html/body/section[3]/div[1]/div[1]/div[2]/ul/li[2]/ul/li[2]/a")
	WebElement faq ;
	@FindBy(xpath="/html/body/section[3]/div[1]/div[1]/div[2]/ul/li[2]/ul/li[3]/a")
	WebElement bookingTips ;
	@FindBy(xpath="/html/body/section[3]/div[1]/div[1]/div[2]/ul/li[2]/ul/li[4]/a")
	WebElement howToBook ;
	@FindBy(xpath="/html/body/section[10]/div[1]/div[1]/div[2]/ul/li[3]/ul/li[1]/a")
	WebElement fileAClaim ;
	@FindBy(xpath="/html/body/section[10]/div[1]/div[1]/div[2]/ul/li[3]/ul/li[2]/a")
	WebElement lastMinuteDeals ;
	@FindBy(xpath="/html/body/section[10]/div[1]/div[1]/div[2]/ul/li[3]/ul/li[3]/a")
	WebElement addYourBusiness ;
	@FindBy(xpath="/html/body/section[10]/div[1]/div[1]/div[2]/ul/li[3]/ul/li[4]/a")
	WebElement careersAndJobs ;
	@FindBy(xpath="/html/body/section[1]/div/div/div/div/div[2]/p[3]")
	List<WebElement> blogContent;
	@FindBy(xpath="/html/body/section[1]/div/div/div/div/div[2]/p[2]")
	List<WebElement> offerContent;
	@FindBy(xpath="//*[@id=\"languages\"]")
	WebElement langu; 
@FindBy(xpath="/html/body/header/div[1]/div/div/div[2]/div/div/div[1]/div/ul/li[1]/a")
WebElement languages;
	WebDriver driver;
	public WebElement getCookie() {
		return cookie;
	}
	public WebElement getBlog() {
		return blog;
	}
	public WebElement getOffers() {
		return offers;
	}
	public WebElement getSpecialFares() {
		return specialFares;
	}
	public WebElement getLunchCoupon() {
		return lunchCoupon;
	}
	public WebElement getContactUs() {
		return contactUs;
	}
	public WebElement getName() {
		return name;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getCaptcha() {
		return captcha;
	}
	public WebElement getSend() {
		return send;
	}
	public WebElement getMessage() {
		return message;
	}
	public WebElement getAboutUs() {
		return aboutUs;
	}
	public WebElement getTermsOfUse() {
		return termsOfUse;
	}
	public WebElement getCookiesPolicy() {
		return cookiesPolicy;
	}
	public WebElement getPrivacyPolicy() {
		return privacyPolicy;
	}
	public WebElement getBecomeSupplier() {
		return becomeSupplier;
	}
	public WebElement getFAQ() {
		return faq;
	}
	public WebElement getBookingTips() {
		return bookingTips;
	}
	public WebElement getHowToBook() {
		return howToBook;
	}
	public WebElement getFileAClaim() {
		return fileAClaim;
	}
	public WebElement getLastMinuteDeals() {
		return lastMinuteDeals;
	}
	
	public List<WebElement> getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(List<WebElement> blogContent) {
		this.blogContent = blogContent;
	}
	public WebElement getAddYourBusiness() {
		return addYourBusiness;
	}
	public WebElement getCareersAndJobs() {
		return careersAndJobs;
	}
//	public WebElement getContactUs() {
//		return offers;
//	}
//	public void getDropbox(String lang) {
//		Select dropdown=new Select(languages);
//		dropdown.selectByVisibleText(lang);
//		
//	}
	public WebElement getLanguage() {
		return languages;
	}
	
	public List<WebElement> getOfferContent() {
		return offerContent;
	}
	public void setOfferContent(List<WebElement> offerContent) {
		this.offerContent = offerContent;
	}
	public WebElement getLangu() {
		return langu;
	}
	public void setLanguage(WebElement languages) {
		this.languages=languages;
	}
	
	
	public BlogPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
}
