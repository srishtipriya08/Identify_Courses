package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import PageObjects.LearningLanguage;
import PageObjects.WebDevelopment;
import PageObjects.Enterprise;
import TestBase.BaseClass;
import Utilities.Screenshots;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Coursera extends BaseClass{
	
	static WebDriver driver;
	public String oldwindow;
	
@BeforeAll	
//@Given("the user navigate to the homepage")
public static void SetUp() throws InterruptedException, IOException {
	BaseClass setupdriver = new BaseClass();
	setupdriver.setUp("os", "chrome");
	driver = BaseClass.getDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	String Url = "https://www.coursera.org/";
	driver.get(Url);
	driver.manage().window().maximize();
}

@Given("the user enter the Web development course")
public void the_user_enter_the_web_development_course() {
//	Search the web development courses
	WD = new WebDevelopment(driver);
	WD.Search();
}

@Given("user click on search button")
public void user_click_on_search_button() {
	WD.clickButton();
}

@When("user select beginner level")
public void user_select_beginner_level() {
//	Select Beginner level option
	driver.findElement(By.xpath("//span[contains(text(),'Beginner')]")).click();
}

@When("user select English language")
public void user_select_english_language() throws InterruptedException {
//	Select English language option

	Thread.sleep(3000);
	WD.getSeeMore();
	
	Thread.sleep(3000);
	WD.LanguageTxt();
	
	Thread.sleep(3000);
	WD.English();
	
	Thread.sleep(3000);
	WD.Apply();
}

@Then("Display first two courses")
public void display_first_two_courses() throws InterruptedException {
//	Display first two courses with name, total learning hours and rating.
	
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
	
	driver.close();
	driver.switchTo().window(oldwindow);
	
}

@Given("the user again navigate back to the homepage")
public void the_user_again_navigate_back_to_the_homepage() throws InterruptedException {
	Thread.sleep(4000);
	WD = new WebDevelopment(driver);
	LL = new LearningLanguage(driver);
	
	LL.getHomePage();
	
}

@When("user enter the learning language course")
public void user_enter_the_learning_language_course() {
	LL.Search();
	WD.clickButton();
}

@When("Click on language See more link")
public void click_on_language_see_more_link() throws InterruptedException {
	Thread.sleep(4000);
	WD.getSeeMore();
	
//	All language name and its count
	System.out.println("All language name and its count\n");
	
	List<WebElement> Count = LL.LanguageCount();
	
	for(int i=0;i<Count.size();i++) {
		String getLanguage = Count.get(i).getText();
		count1.add(getLanguage);
		System.out.println((i+1)+". "+getLanguage+"\n");
	}
	
//	close language box
	
	LL.Close();
}

@When("Go to Level option")
public void go_to_level_option() {
  
	System.out.println("Different level count\n");
	List<WebElement> level = LL.LevelCount();
	for(int i=0;i<level.size();i++) {
		String getLevel = level.get(i).getText();
		level1.add(getLevel);
		System.out.println((i+1)+". "+getLevel+"\n");
	}
}

@Then("User Navigate to the main page")
public void user_navigate_to_the_main_page() {
	LL.getHomePage();
}

@Given("User scroll to the for Enterprise")
public void user_scroll_to_the_for_enterprise() {
	EP = new Enterprise(driver);
	//scroll down For Enterprise
	EP.ForEnterprise();
}

@Given("click the enterprise link")
public void click_the_enterprise_link() {
	EP.clickEnterprise();
}

@When("Go to solution button")
public void go_to_solution_button() {
	EP.Solution();
   }

@When("select the course for campus")
public void select_the_course_for_campus() {
	EP.ForCampus();
}

@When("user fill the ready to transform form")
public void user_fill_the_ready_to_transform_form() throws InterruptedException {
	EP.Form();
	
	EP.Fname();
	EP.Lname();
	EP.Email();
	EP.PhoneNo();
	EP.Institution();
	
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
}

@Then("Submit the filled form")
public void submit_the_filled_form() throws InterruptedException {
	Thread.sleep(4000);
	EP.Submit();
}

@Then("Capture the error message")
public void capture_the_error_message() throws InterruptedException {
	Thread.sleep(4000);
	WebElement errormsg=driver.findElement(By.xpath("//*[@id='ValidMsgEmail']"));
	System.out.println("");
	System.out.println("Error Message : "+errormsg.getText()+"\n");
}

@AfterAll
//@Then("close the browser")
public static  void tearDown() {
	driver.quit();
}
}

