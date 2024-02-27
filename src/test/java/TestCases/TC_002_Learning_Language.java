package TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LearningLanguage;
import PageObjects.WebDevelopment;
import TestBase.BaseClass;
import Utilities.ExcelUtility;
import Utilities.Screenshots;

public class TC_002_Learning_Language extends BaseClass {
	
	@Test(priority = 2)
	public void Learning_Language() throws InterruptedException, IOException {
		
		logger.info("****** Starting TC_002_Learning_Language ******");
		
		try {
			
			WD = new WebDevelopment(driver);
			LL = new LearningLanguage(driver);
			
//			LL.getHomePage();
			LL.Search();
			WD.clickButton();
			
			Thread.sleep(4000);
			WD.getSeeMore();
			
			path= Screenshots.takeScreenshot(driver, "Language");
			
//			All language name and its count
			
//			logger.info("Printing different language count");
			
			System.out.println("All language name and its count\n");
			
			List<WebElement> Count = LL.LanguageCount();
			
			for(int i=0;i<Count.size();i++) {
				String getLanguage = Count.get(i).getText();
				count1.add(getLanguage);
				System.out.println((i+1)+". "+getLanguage+"\n");
			}
			
//			close language box
			
			LL.Close();
			
			
//			Different level count
//			logger.info("Printing different level count");
			
			System.out.println("Different level count\n");
			List<WebElement> level = LL.LevelCount();
			for(int i=0;i<level.size();i++) {
				String getLevel = level.get(i).getText();
				level1.add(getLevel);
				System.out.println((i+1)+". "+getLevel+"\n");
			}
			
//			navigate to main page
			LL.getHomePage();
			
			String successMessage = ExcelUtility.LearningData(count1, level1);
			System.out.println(successMessage);
			ExcelUtility.closeExcel();
//			logger.info("Data is saved in Excel");
			

		}
		catch (Exception e) {
			// TODO: handle exception
			logger.error("Test failed...");
			Assert.fail();
		}
		
		logger.info("****** Finished TC_002_Learning_Language ****** ");
	}
	
	

}
