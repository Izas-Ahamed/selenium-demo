	package com.qa.testscripts;
	import java.io.IOException;
	import java.util.List;
	
	import org.openqa.selenium.WebElement;
    import org.testng.Assert;
    import org.testng.Reporter;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	public class TC_Tours_01 extends TestBase{
	
		@Test(dataProvider = "excelsheet")
		public void tour(String Destination,String Firstname,String Email,String Message, String TourDate, String Adult,String Child) throws InterruptedException, IOException {
			//Open tours page
			tours_page.getclicktours().click();
			Thread.sleep(2000);
			String title = driver.getCurrentUrl();
			if(title.contains("tours")) {
				Assert.assertTrue(true);
			}
			else
			{
				Reporter.log("User didnot landed on tours page");
				captureScreenShot("tour");
				Assert.assertFalse(true);
				
			}
			//Give Destination
			tours_page.getclickheading().click();
			Thread.sleep(2000);
			tours_page.destname(Destination);
			Thread.sleep(2000);
			List<WebElement> list= tours_page.getdestinationlist();
			for(WebElement suggestions : list)
			{
				Reporter.log(suggestions.getText());
			}			
			Thread.sleep(2000);
			tours_page.getdestinationoption().click();
			Thread.sleep(2000);
			//Giving date
			
			tours_page.getTourDate().click();
			String date[] = TourDate.split("[/]");
			String Checkin=date[1]+"-"+date[0]+"-"+date[2];
			js.executeScript("arguments[0].setAttribute('value','"+Checkin+"');", tours_page.getTourDate());			
			Thread.sleep(2000);
			//Giving Travellers count
			tours_page.gettravellers().click();
			Thread.sleep(2000);
			tours_page.AdultCount(Adult);
			tours_page.ChildCount(Child);
			tours_page.getsearch().click();
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);		
	
			List<WebElement> li= tours_page.getcardtitles();
			for(WebElement cardtitles : li)
			{
				System.out.println(cardtitles.getText());
			}			
			js.executeScript("window.scrollBy(0,1100)");
			Thread.sleep(2000);
			tours_page.getneedhelp().click();
			tours_page.contactus(Firstname, Email, Message);
			Thread.sleep(2000);
			
			
		}
		@DataProvider(name="excelsheet")
		public Object[][] data() throws IOException, InterruptedException{
			Object obj[][]= excel.getData("PHP_Travels_TestData","Sheet5");
			return obj;
		}
	
	}
