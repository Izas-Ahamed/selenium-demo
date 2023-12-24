package com.qa.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;





public class TC_Blogs_01 extends TestBase{
	
	@Test(dataProvider="excelData")
	public void blogElement(String name,String email, String message ) throws InterruptedException, IOException{
		
		
		//blog
		blog_page.getCookie().click();
		blog_page.getBlog().click();
		Thread.sleep(3000);
		
		if(driver.getTitle().contains("Blog")) {
			Reporter.log("Contains the title blog");
			assertTrue(true);
		}else {
			Reporter.log("Title doesn't contains the keyword blog");	
			captureScreenShot("blogElement");
			assertTrue(false);
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(3000);
		blog_page.getSpecialFares().click();
		Thread.sleep(3000);
		
		if(driver.getCurrentUrl().contains("virgin-gorda-beaches-and-lobste")) {
			Reporter.log("redirected to the virgin gorda beaches and lobste page");
			assertTrue(true);
		}
		else {
			Reporter.log("Doesn't redirected to the virgin gorda beaches and lobste page");	
			captureScreenShot("blogElement");
			assertTrue(false);
		}
		
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		List<WebElement> we =blog_page.getBlogContent();

       // System.out.println(we.size());
		System.out.println("The Blog Contents are:");
        for (WebElement webElement : we) {
            String bContent = webElement.getText();
//            SpellChecker checker = new SpellChecker();
//            SpellResponse spellResponse = checker.check( "helloo worlrd" );
//            for( SpellCorrection sc : spellResponse.getCorrections() )
//            System.out.println( sc.getValue() );
            System.out.println(bContent);
        }
        
        if(we.isEmpty()) {
        	Reporter.log("Blog Elements were not present");	
			captureScreenShot("blogElement");
			assertTrue(false);
        }
        else {
        	System.out.println("Blog elements available");
        	Reporter.log("Blog Elements were present");
			assertTrue(true);
        }
        
        //Offers
        driver.navigate().to("https://www.phptravels.net/");
		Thread.sleep(3000);
		blog_page.getCookie().click();
		blog_page.getOffers().click();
		Thread.sleep(3000);
		
		if(driver.getTitle().contains("Offers")) {
			Reporter.log("Contains the title offers");
			assertTrue(true);
		}else {
			Reporter.log("Title doesn't contains the keyword offers");	
			captureScreenShot("blogElement");
			assertTrue(false);
		}
		
		
		blog_page.getLunchCoupon().click();
		Thread.sleep(3000);
		String URL=driver.getCurrentUrl();
		if(URL.contains("lunch-discount")) {
			Reporter.log("redirected to the lunch discount page");
			Assert.assertTrue(true);
		}
		else {
			Reporter.log("Doesn't redirected to the lunch discount page");
			captureScreenShot("blogElement");
			Assert.assertTrue(false);
		}
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
		List<WebElement> web =blog_page.getOfferContent();
		 System.out.println("The Offer Contents are:");
		 for (WebElement webElement : web) {
		  String ocontent = webElement.getText();
		  System.out.println(ocontent);
		 }
		 
		 if(web.isEmpty()) {
	        	Reporter.log("Offer Elements were not present");	
				captureScreenShot("blogElement");
				assertTrue(false);
	        }
	        else {
	        	System.out.println("Offer elements available");
	        	Reporter.log("Offer Elements were present");
				assertTrue(true);
	        }
		
		//ContactUs
		driver.navigate().to("https://www.phptravels.net/");
		js.executeScript("arguments[0].scrollIntoView()", blog_page.getContactUs());
		js.executeScript("arguments[0].scrollIntoView()", blog_page.getContactUs());
//		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		blog_page.getContactUs().click();
		Thread.sleep(3000);
		
		if(driver.getTitle().contains("Contact")) {
			Reporter.log("Contains the title contact");
			assertTrue(true);
		}else {
			Reporter.log("Title doesn't contains the keyword contact");	
			captureScreenShot("blogElement");
			assertTrue(false);
		}
		
		js.executeScript("window.scrollBy(0,200)");
		blog_page.getName().sendKeys(name);
		blog_page.getEmail().sendKeys(email);
		blog_page.getMessage().sendKeys(message);
		
	}
	@DataProvider(name="excelData")
	public Object[][] getExcelDetails() throws IOException
	{
		Object obj[][]=ExcelUtility.getData("PHP_Travels_TestData","Sheet2");
		return obj;
	}
			
}
