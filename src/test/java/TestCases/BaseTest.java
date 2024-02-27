package TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.LearningLanguage;
import PageObjects.WebDevelopment;
import TestBase.BaseClass;
import PageObjects.Enterprise;
import Utilities.ExcelUtility;
import Utilities.Screenshots;

public class BaseTest extends BaseClass{
	
	//static WebDriver driver;
	static ChromeOptions option = new ChromeOptions();
	static JavascriptExecutor js = (JavascriptExecutor)driver;
	public static String path;
	List<WebElement> count;
	List<String> count1=new ArrayList<String>();
	List<String> level1=new ArrayList<String>();
	List<String> name1=new ArrayList<String>();
	List<String> Duration1=new ArrayList<String>();
	List<String> rating1=new ArrayList<String>();
	public WebDevelopment WD;
	public LearningLanguage LL;
	public Enterprise EP;
	
	@BeforeClass
	public void navigate() throws IOException , InterruptedException{
		if(driver == null) {
		driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String Url = "https://www.coursera.org/";
		driver.get(Url);
		driver.manage().window().maximize();
		path= Screenshots.takeScreenshot(driver, "Home page");
		
	}
	
	@Test(priority=0 , groups = {"sanity", "regression"})
	public void WebDevelopment() throws InterruptedException, IOException {

//		String oldwindow=driver.getWindowHandle();
		
//		Search the web development courses
		WD = new WebDevelopment(driver);
		WD.Search();
		WD.clickButton();

//		Select Beginner level option
		driver.findElement(By.xpath("//span[contains(text(),'Beginner')]")).click();
		

//		Select English language option

		Thread.sleep(3000);
		WD.getSeeMore();
		
		Thread.sleep(3000);
		WD.LanguageTxt();
		
		Thread.sleep(3000);
		WD.English();
		
		Thread.sleep(3000);
		WD.Apply();
		
		path= Screenshots.takeScreenshot(driver, "WebDev");
	
//		Display first two courses with name, total learning hours and rating.
		
		System.out.println("Display first two courses with name, total learning hours and rating.\n");

		/*WD.Course();
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
		driver.switchTo().window(oldwindow);*/
		
		List<WebElement> name = driver.findElements(By.xpath("//h3[@class='cds-CommonCard-title css-1sktkql']"));
		List<WebElement> learningHrs = driver.findElements(By.xpath("//p[@class=' css-10r3ar9']"));
		List<WebElement> rating = driver.findElements(By.xpath("//p[@class='cds-119 css-11uuo4b cds-121']"));
		for(int i=0;i<2;i++) {
			System.out.println("Course "+i+"\n");
			System.out.println("Course name - " +name.get(i).getText()+"\n");
			System.out.println("Total learning hours - " +learningHrs.get(i).getText()+"\n");
			System.out.println("Rating - " +rating.get(i).getText()+"\n");
		}
//		ExcelUtility.saveDataToExcel(name, learningHrs, rating);
	} 

	
	@Test(priority=1 , groups = {"sanity", "regression"})
	public void learningLanguage() throws InterruptedException, IOException{
	
		Thread.sleep(4000);
		WD = new WebDevelopment(driver);
		LL = new LearningLanguage(driver);
		
		LL.getHomePage();
		LL.Search();
		WD.clickButton();
		
		Thread.sleep(4000);
		WD.getSeeMore();
		
		path= Screenshots.takeScreenshot(driver, "Language");
		
//		All language name and its count
		System.out.println("All language name and its count\n");
		
		List<WebElement> Count = LL.LanguageCount();
		
		for(int i=0;i<Count.size();i++) {
			String getLanguage = Count.get(i).getText();
			count1.add(getLanguage);
			System.out.println((i+1)+". "+getLanguage+"\n");
		}
		
//		close language box
		
		LL.Close();
		
//		Different level count
		
		System.out.println("Different level count\n");
		List<WebElement> level = LL.LevelCount();
		for(int i=0;i<level.size();i++) {
			String getLevel = level.get(i).getText();
			level1.add(getLevel);
			System.out.println((i+1)+". "+getLevel+"\n");
		}
		
//		navigate to main page
		LL.getHomePage();
		
		String successMessage = ExcelUtility.LearningData(count1, level1);
		System.out.println(successMessage);
		ExcelUtility.closeExcel();
	}
	
	@Test(priority=2 , groups = {"sanity", "regression"})
	public void Enterprise() throws InterruptedException, IOException{
		
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
				
				//scroll down Ready to transform
				EP.Form();
				
				EP.Fname();
				EP.Lname();
				EP.Email();
				EP.PhoneNo();
				EP.Institution();
				
				path= Screenshots.takeScreenshot(driver, "Form");
				
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
				
	}
	
	/*@Test(priority=0)
	public void WebDevelopment() throws InterruptedException, IOException {

		String oldwindow=driver.getWindowHandle();
		
//		Search the web development courses
		
		driver.findElement(By.xpath("//input[@class='react-autosuggest__input']"));
		driver.findElement(By.xpath("//input[@class='react-autosuggest__input']")).sendKeys("Web Development");

		WebElement button = driver.findElement(By.xpath("//button[@class='nostyle search-button']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);


//		Select Beginner level option
		driver.findElement(By.xpath("//span[contains(text(),'Beginner')]")).click();
		

//		Select English language option

		Thread.sleep(3000);
		WebElement languageshowmore=driver.findElement(By.xpath("//*[@id=\"search-results-header-wrapper\"]/div/div[1]/div/div[3]/div[2]/button"));
		JavascriptExecutor js6=(JavascriptExecutor)driver;
		js6.executeScript("arguments[0].click();",languageshowmore);
		
		Thread.sleep(3000);
		WebElement selectlanguagetxt=driver.findElement(By.xpath("//*[@aria-label=\"Search by keyword\"]"));
		JavascriptExecutor js7=(JavascriptExecutor)driver;
		js7.executeScript("arguments[0].click();",selectlanguagetxt);
		selectlanguagetxt.sendKeys("English");
		
		Thread.sleep(3000);
		WebElement selectEnglish=driver.findElement(By.xpath("//*[@id='checkbox-group']/div/label/span"));
		JavascriptExecutor js8=(JavascriptExecutor)driver;
		js8.executeScript("arguments[0].click();",selectEnglish);
		
		Thread.sleep(3000);
		WebElement apply=driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div/div[2]/div[3]/button[1]/span"));
		JavascriptExecutor js9=(JavascriptExecutor)driver;
		js9.executeScript("arguments[0].click();",apply);
		path= Screenshots.takeScreenshot(driver, "WebDev");
	
//		Display first two courses with name, total learning hours and rating.
		
		System.out.println("Display first two courses with name, total learning hours and rating.\n");

		WebElement course1 = driver.findElement(By.xpath("//h3[@class='cds-CommonCard-title css-1sktkql']"));
//		course1.click();
		JavascriptExecutor c1 = (JavascriptExecutor) driver;
		c1.executeScript("arguments[0].click();", course1);
		Set<String>handle=driver.getWindowHandles();
		for(String newwindow1:handle)
		{	
			driver.switchTo().window(newwindow1);
		}
		
		System.out.println("Course-1");
		Thread.sleep(2000);
		WebElement name=driver.findElement(By.xpath("//*[@id='rendered-content']/div/main/section[2]/div/div/div[1]/div[1]/section/h1"));
		System.out.println("Course Name :"+name.getText());
		WebElement learningHrs=driver.findElement(By.xpath("//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[3]/div[1]"));
		System.out.println("Course Duration :"+learningHrs.getText());
		WebElement rating=driver.findElement(By.xpath("//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[1]/div[1]"));
		System.out.println("Course Rating :"+rating.getText());
		path= Screenshots.takeScreenshot(driver, "CoursePage1");
		driver.close();
		driver.switchTo().window(oldwindow);
		System.out.println("");
		Thread.sleep(6000);
 
		//second course details
//		driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/main/div[1]/div/div/div/div/div[2]/ul[1]/li[2]/div/div/div/div"));
		WebElement course2=driver.findElement(By.xpath("/html/body/div[2]/div/div/main/div[1]/div/div/div/div/div[2]/ul[1]/li[2]/div/div/div/div/div/div[2]/div[1]/div[2]/a/h3"));
		JavascriptExecutor c2 = (JavascriptExecutor) driver;
		c2.executeScript("arguments[0].click();", course2);
		Set<String>handles1=driver.getWindowHandles();
		for(String newwindow2:handles1)
		{
			driver.switchTo().window(newwindow2);
		}
		
		System.out.println("Course-2");
		WebElement name2=driver.findElement(By.xpath("//h3[@class='cds-CommonCard-title css-1sktkql']"));
		System.out.println("Course Name :"+name2.getText());
		WebElement learningHrs2=driver.findElement(By.xpath("//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[3]/div[1]"));
		System.out.println("Course Duration :"+learningHrs2.getText());
		WebElement rating2=driver.findElement(By.xpath("//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[1]/div[1]"));
		System.out.println("Course Rating :"+rating2.getText());
		path= Screenshots.takeScreenshot(driver, "CoursePage2");
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
		}
//		ExcelUtility.saveDataToExcel(name, learningHrs, rating);
	} 

	
	@Test(priority=1)
	public void learningLanguage() throws InterruptedException, IOException{
	
//		Thread.sleep(4000);

		/*WebElement inputBoxs = driver.findElement(By.xpath("//input[@class='react-autosuggest__input']"));
		inputBoxs.sendKeys(Keys.CONTROL + "a"); // Select all text
		inputBoxs.sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@class='react-autosuggest__input']")).sendKeys("Language Learning");

		WebElement button = driver.findElement(By.xpath("//button[@class='nostyle search-button']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);
		
		Thread.sleep(4000);
		WebElement languageshowmore=driver.findElement(By.xpath("//*[@id=\"search-results-header-wrapper\"]/div/div[1]/div/div[3]/div[2]/button/span"));
		JavascriptExecutor js6=(JavascriptExecutor)driver;
		js6.executeScript("arguments[0].click();",languageshowmore);
		
		path= Screenshots.takeScreenshot(driver, "Language");
		
//		All language name and its count
		System.out.println("All language name and its count\n");
		count = driver.findElements(By.xpath("//*[@id=\"checkbox-group\"]/div/label/div"));
		for(int i=0;i<count.size();i++) {
			count1.add(count.get(i).getText());
			System.out.println((i+1)+". "+count.get(i).getText()+"\n");
		}
		
		WebElement close = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div/div[1]/button"));
		JavascriptExecutor js11=(JavascriptExecutor)driver;
		js11.executeScript("arguments[0].click();",close);
		
		
//		Different level count
		
		System.out.println("Different level count\n");
		List<WebElement> level = driver.findElements(By.xpath("//*[@id=\"search-results-header-wrapper\"]/div/div[1]/div/div[5]/div/div/div/label/div"));
		for(int i=0;i<level.size();i++) {
			level1.add(level.get(i).getText());
			System.out.println((i+1)+". "+level.get(i).getText()+"\n");
		}
		
//		navigate to main page
		
		WebElement Homepage=driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/span/div[1]/header/div[1]/div/div/div[1]/div[2]/div/div[2]/div/div/a/div/img"));
		Homepage.click();
		
		String successMessage = ExcelUtility.LearningData(count1, level1);
		System.out.println(successMessage);
		ExcelUtility.closeExcel();
	}
	
	@Test(priority=2)
	public void Enterprise() throws InterruptedException, IOException{
		
		//scroll down For Enterprise
				WebElement ForEnterprise=driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div[1]/footer/div/div/div/div[5]/p"));
				JavascriptExecutor js3=(JavascriptExecutor)driver;
				js3.executeScript("arguments[0].scrollIntoView();",ForEnterprise);
				
				path= Screenshots.takeScreenshot(driver, "Enterprise");
				
				WebElement clickEnterprise=driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div[1]/footer/div/div/div/div[5]/ul/li[10]/a"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", clickEnterprise);
				Thread.sleep(2000);
				
				WebElement clicksolution = driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/div[1]/div/header/div[2]/div[1]/div/div/div/div[2]/div[2]/a"));
				JavascriptExecutor js2 = (JavascriptExecutor) driver;
				js2.executeScript("arguments[0].click();", clicksolution);
				
				Thread.sleep(2000);
				WebElement CourseraforCampus=driver.findElement(By.xpath("//*[@id='rendered-content']/div/div/div[1]/div/header/div[2]/div[1]/div/div/div/div[2]/div[3]/div/div/div/div/div/div[2]/div/div[2]/a/p"));
				JavascriptExecutor jsE3 = (JavascriptExecutor) driver;
				jsE3.executeScript("arguments[0].click();", CourseraforCampus);
				Thread.sleep(2000);
				
				//scroll down Ready to transform
				WebElement Filltheform=driver.findElement(By.xpath("//*[@id='rendered-content']/div/div/main/div/div[7]/div/div[2]/div/div/div/div/div/div[2]/div[3]"));
				JavascriptExecutor js4=(JavascriptExecutor)driver;
				js4.executeScript("arguments[0].scrollIntoView();",Filltheform);
				
				WebElement FirstName=driver.findElement(By.xpath("//*[@id='FirstName']"));
				FirstName.sendKeys("Srishti");
				WebElement LastName=driver.findElement(By.xpath("//*[@id='LastName']"));
				LastName.sendKeys("Priya");
				WebElement Email=driver.findElement(By.xpath("//*[@id='Email']"));
				Email.sendKeys("srishtipriyassp@gmail.com");
				WebElement PhoneNumber=driver.findElement(By.xpath("//*[@id='Phone']"));
				PhoneNumber.sendKeys("7254087603");
				WebElement InstitutionName=driver.findElement(By.xpath("//*[@id='Company']"));
				InstitutionName.sendKeys("Heritage Institute of Technology");
				
				path= Screenshots.takeScreenshot(driver, "Form");
				
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
				WebElement submitbutton=driver.findElement(By.xpath("//*[@id='mktoForm_1512']/div[50]/span/button"));
//				submitbutton.click();
				JavascriptExecutor js5 = (JavascriptExecutor) driver;
				js5.executeScript("arguments[0].click();", submitbutton);
				Thread.sleep(4000);
				WebElement errormsg=driver.findElement(By.xpath("//*[@id='ValidMsgEmail']"));
				System.out.println("");
				System.out.println("Error Message : "+errormsg.getText()+"\n");
				
	}*/
	
	@AfterClass
	public void close() throws IOException , InterruptedException {
		driver.quit();
	}
	
	
}