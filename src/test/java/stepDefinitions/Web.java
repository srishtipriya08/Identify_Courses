/*package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.WebDevelopment;
import TestBase.BaseClass;
import Utilities.Screenshots;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Web extends BaseClass{
	
	WebDriver driver;
//	String oldwindow=driver.getWindowHandle();
	
@Given("the user navigate to the homepage")
public void the_user_navigate_to_the_homepage() {
	driver = new ChromeDriver();
//	driver = new EdgeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	String Url = "https://www.coursera.org/";
	driver.get(Url);
	driver.manage().window().maximize();
}

@When("the user enter the Web development course")
public void the_user_enter_the_web_development_course() {
//	Search the web development courses
	WD = new WebDevelopment(driver);
	WD.Search();
}

@When("user click on search button")
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
	
	List<WebElement> name = driver.findElements(By.xpath("//h3[@class='cds-CommonCard-title css-1sktkql']"));
	List<WebElement> learningHrs = driver.findElements(By.xpath("//p[@class=' css-10r3ar9']"));
	List<WebElement> rating = driver.findElements(By.xpath("//p[@class='cds-119 css-11uuo4b cds-121']"));
	for(int i=1;i<3;i++) {
		System.out.println("Course "+i+"\n");
		System.out.println("Course name - " +name.get(i).getText()+"\n");
		System.out.println("Total learning hours - " +learningHrs.get(i).getText()+"\n");
		System.out.println("Rating - " +rating.get(i).getText()+"\n");
	}
}
}
*/