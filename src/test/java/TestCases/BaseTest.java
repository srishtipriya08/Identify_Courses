package TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import PageObjects.LearningLanguage;
import PageObjects.WebDevelopment;
import TestBase.BaseClass;
import PageObjects.Enterprise;
import Utilities.ExcelUtility;
import Utilities.Screenshots;

public class BaseTest extends BaseClass{
	
	static JavascriptExecutor js = (JavascriptExecutor)driver;
	public static String path;
	List<WebElement> count;
	List<String> count1=new ArrayList<String>();
	List<String> level1=new ArrayList<String>();
	public String oldwindow;
	public WebDevelopment WD;
	public LearningLanguage LL;
	public Enterprise EP;
	
	
	@Test(priority=0 , groups = {"smoke","regression","master"})
	public void SearchWebDevelopment() throws InterruptedException, IOException {
		
//		Search the web development courses
		WD = new WebDevelopment(driver);
		WD.Search();
		path= Screenshots.takeScreenshot(driver, "SearchWebDev");
		WD.clickButton();	
	} 

	@Test(priority=1 , groups = {"regression","master"})
	public void SelectLevel() throws InterruptedException, IOException {
		
//		Select Beginner level option
		driver.findElement(By.xpath("//span[contains(text(),'Beginner')]")).click();
		path= Screenshots.takeScreenshot(driver, "BeginnerLevel");
	}
	
	@Test(priority=2 , groups = {"regression","master"})
	public void SelectLanguage() throws InterruptedException, IOException {
		
//		Select English language option

		Thread.sleep(3000);
		WD.getSeeMore();
		
		Thread.sleep(3000);
		WD.LanguageTxt();
		
		Thread.sleep(3000);
		WD.English();
		
		path= Screenshots.takeScreenshot(driver, "EnglishLang");
		Thread.sleep(3000);
		WD.Apply();
		
		
	}
	
	@Test(priority=3 , groups = {"regression","master"})
	public void CourseList() throws InterruptedException, IOException {
//		Display first two courses with name, total learning hours and rating.
		
		System.out.println("Display first two courses with name, total learning hours and rating.\n");

		WD.Course();
		oldwindow=driver.getWindowHandle();
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
		driver.close();
		driver.switchTo().window(oldwindow);
		System.out.println("");
		Thread.sleep(3000);
 
		//Second course details
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
		driver.close();
		driver.switchTo().window(oldwindow);
	}
	
	@Test(priority=4 , groups = {"smoke","regression","master"})
	public void SearchlearningLanguage() throws InterruptedException, IOException{
	
		Thread.sleep(4000);
		WD = new WebDevelopment(driver);
		LL = new LearningLanguage(driver);
		
		LL.getHomePage();
		LL.Search();
		WD.clickButton();
		
		Thread.sleep(4000);
		WD.getSeeMore();
		
		path= Screenshots.takeScreenshot(driver, "Language");
		
	}
	
	@Test(priority=5 , groups = {"regression","master"})
	public void LanguageCount() throws InterruptedException, IOException{
		
//		All language name and its count
		System.out.println("\nAll language name and its count\n");
		
		List<WebElement> Count = LL.LanguageCount();
		
		for(int i=0;i<Count.size();i++) {
			String getLanguage = Count.get(i).getText();
			count1.add(getLanguage);
			System.out.println((i+1)+". "+getLanguage+"\n");
		}
		
//		close language box
		
		LL.Close();
	}
	
	@Test(priority=6 , groups = {"regression","master"})
	public void LevelCount() throws InterruptedException, IOException{
		
		//Different level count
		
		System.out.println("Different level count\n");
		List<WebElement> level = LL.LevelCount();
		for(int i=0;i<level.size();i++) {
			String getLevel = level.get(i).getText();
			level1.add(getLevel);
			System.out.println((i+1)+". "+getLevel+"\n");
		}
		
		//navigate to main page
		LL.getHomePage();
		
		String successMessage = ExcelUtility.LearningData(count1, level1);
		System.out.println(successMessage);
		ExcelUtility.closeExcel();
	}
	
	@Test(priority=7 , groups = {"smoke","regression","master"})
	public void ForEnterprise() throws InterruptedException, IOException{
		
				EP = new Enterprise(driver);
				//scroll down For Enterprise
				EP.ForEnterprise();
				
				path= Screenshots.takeScreenshot(driver, "Enterprise");
				
				EP.clickEnterprise();
				Thread.sleep(2000);
				
				EP.Solution();
				path= Screenshots.takeScreenshot(driver, "Solution");
				
				Thread.sleep(2000);
				EP.ForCampus();
				path= Screenshots.takeScreenshot(driver, "CoursersForCampus");
					
	}
	
	@Test(priority=8 , groups = {"regression","master"})
	public void ReadyToTransform() throws InterruptedException, IOException{
		
		Thread.sleep(2000);
		
		//scroll down Ready to transform
		EP.Form();
		
		EP.Fname();
		EP.Lname();
		EP.Email();
		EP.PhoneNo();
		EP.Institution();
		
		path= Screenshots.takeScreenshot(driver, "Form");
	}
	
	@Test(priority=9 , groups = {"regression","master"})
	public void DropDowns() throws InterruptedException, IOException{
		
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
		path= Screenshots.takeScreenshot(driver, "Form2");
		EP.Submit();
	}
	
	@Test(priority=10 , groups = {"regression","master"})
	public void ErrorMessage() throws InterruptedException, IOException{
		
		Thread.sleep(4000);
		WebElement errormsg=driver.findElement(By.xpath("//*[@id='ValidMsgEmail']"));
		System.out.println("");
		System.out.println("Error Message : "+errormsg.getText()+"\n");
	}
	
}