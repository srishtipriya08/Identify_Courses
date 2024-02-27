package TestCases;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.WebDevelopment;
import TestBase.BaseClass;

import Utilities.Screenshots;

public class TC_001_Web_Development extends BaseClass {
	
	@Test(priority = 1)
	public void Web_Development() throws InterruptedException, IOException {
		
		logger.info("****** Starting TC_001_Web_Development ******");
		
		try {
			
			String oldwindow=driver.getWindowHandle();
			
//			Search the web development courses
			
			WD = new WebDevelopment(driver);
			WD.Search();
			WD.clickButton();

//			Select Beginner level option
			driver.findElement(By.xpath("//span[contains(text(),'Beginner')]")).click();
			

//			Select English language option

			Thread.sleep(3000);
			WD.getSeeMore();
			
			Thread.sleep(3000);
			WD.LanguageTxt();
			
			Thread.sleep(3000);
			WD.English();
			
			Thread.sleep(3000);
			WD.Apply();
			
			path= Screenshots.takeScreenshot(driver, "WebDev");
		
//			Display first two courses with name, total learning hours and rating.
			
			logger.info("Printing Courses Details");
			System.out.println("Display first two courses with name, total learning hours and rating.\n");

			WD.Course();
			Set<String>handle=driver.getWindowHandles();
			for(String newwindow1:handle)
			{	
				driver.switchTo().window(newwindow1);
			}
			
			System.out.println("Course-1");
			Thread.sleep(2000);
			WebElement name = WD.CourseName();
			String n = name.getText();
			System.out.println("Course Name :"+n);
			WebElement learningHrs = WD.Duration();
			String l = learningHrs.getText();
			System.out.println("Course Duration :"+l);
			WebElement rating = WD.Rating();
			String r = rating.getText();
			System.out.println("Course Rating :"+r);
			
			path= Screenshots.takeScreenshot(driver, "CoursePage1");
			logger.info("Course 1 screenshot is taken");
			
			driver.close();
			driver.switchTo().window(oldwindow);
			System.out.println("");
			Thread.sleep(6000);
	 
			//second course details
			WD.Course2();
			Set<String>handles1=driver.getWindowHandles();
			for(String newwindow2:handles1)
			{
				driver.switchTo().window(newwindow2);
			}
			
			System.out.println("Course-2");
			WebElement name2 = WD.CourseName();
			String n2 = name.getText();
			System.out.println("Course Name :"+n2);
			WebElement learningHrs2 = WD.Duration();
			String l2 = learningHrs.getText();
			System.out.println("Course Duration :"+l2);
			WebElement rating2 = WD.Rating();
			String r2 = rating.getText();
			System.out.println("Course Rating :"+r2);
			
			path= Screenshots.takeScreenshot(driver, "CoursePage2");
			logger.info("Course 1 screenshot is taken");
			
			driver.close();
			driver.switchTo().window(oldwindow);
				
			/*List<WebElement> name = driver.findElements(By.xpath("//h3[@class='cds-CommonCard-title css-1sktkql']"));
			List<WebElement> learningHrs = driver.findElements(By.xpath("//p[@class=' css-10r3ar9']"));
			List<WebElement> rating = driver.findElements(By.xpath("//p[@class='cds-119 css-11uuo4b cds-121']"));
			for(int i=0;i<2;i++) {
				System.out.println("Course "+i+"\n");
				System.out.println("Course name - " +name.get(i).getText()+"\n");
				System.out.println("Total learning hours - " +learningHrs.get(i).getText()+"\n");
				System.out.println("Rating - " +rating.get(i).getText()+"\n");
			}*/
//			ExcelUtility.saveDataToExcel(name, learningHrs, rating);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			logger.error("Test failed...");
			Assert.fail();
		}
		
		logger.info("****** Finished TC_001_Web_Development ****** ");
	}
	
	

}
