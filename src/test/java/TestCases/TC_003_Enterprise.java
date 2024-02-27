package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Enterprise;
import TestBase.BaseClass;

import Utilities.Screenshots;

public class TC_003_Enterprise extends BaseClass {
	
	@Test(priority = 3)
	public void Enterprise() throws InterruptedException, IOException {
		
		logger.info("****** Starting TC_003_Enterprise ******");
		
		try {
			
			EP = new Enterprise(driver);
			//scroll down For Enterprise
			EP.ForEnterprise();
			
			path= Screenshots.takeScreenshot(driver, "Enterprise");
			
			EP.clickEnterprise();
			Thread.sleep(2000);
			
			EP.Solution();
			
			Thread.sleep(2000);
			EP.ForCampus();
			Thread.sleep(2000);
			
			logger.info("Filling ready to transform form");
			
			
			//scroll down Ready to transform
			EP.Form();
			
			EP.Fname();
			EP.Lname();
			EP.Email();
			EP.PhoneNo();
			EP.Institution();
			
			path= Screenshots.takeScreenshot(driver, "Form");
			logger.info("Screenshot is taken");
			
			//Using Select
			Thread.sleep(2000);
			Select Institutiontype=new Select(driver.findElement(By.xpath("//*[@id='Institution_Type__c']")));
			Institutiontype.selectByVisibleText("Other");
			Thread.sleep(3000);
			
			Select Jobrole=new Select(driver.findElement(By.xpath("//*[@id='Title']")));
			Jobrole.selectByVisibleText("Student");
			Thread.sleep(2000);
			
			Select Department=new Select(driver.findElement(By.xpath("//*[@id='Department']")));
			Department.selectByVisibleText("Continuing Education");
			Thread.sleep(3000);
			
			Select bestdescribes=new Select(driver.findElement(By.xpath("//*[@id='What_the_lead_asked_for_on_the_website__c']")));
			bestdescribes.selectByVisibleText("Tech Support");
			Thread.sleep(4000);
			
			Select country=new Select(driver.findElement(By.xpath("//*[@id='Country']")));
			country.selectByVisibleText("India");
			Thread.sleep(3000);
			
			Select state=new Select(driver.findElement(By.xpath("//*[@id='State']")));
			state.selectByVisibleText("Tamil Nadu");
			Thread.sleep(4000);
			
			EP.Submit();
			
			Thread.sleep(4000);
			WebElement errormsg=driver.findElement(By.xpath("//*[@id='ValidMsgEmail']"));
			System.out.println("");
			System.out.println("Error Message : "+errormsg.getText()+"\n");
			
			logger.info("Error message got displayed");
			

		}
		catch (Exception e) {
			// TODO: handle exception
			logger.error("Test failed...");
			Assert.fail();
		}
		
		logger.info("****** Finished TC_003_Enterprise ****** ");
	}
	
	

}
