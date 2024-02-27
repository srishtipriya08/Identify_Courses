package PageObjects;
 
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class Enterprise {
	public WebDriver driver;

	   //constructor
	   public Enterprise(WebDriver driver){
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
	   }
	   
	   @FindBy(xpath="//*[@id=\"rendered-content\"]/div/div[1]/footer/div/div/div/div[5]/p")
	   WebElement ForEnterprise;
	   public void ForEnterprise() {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].scrollIntoView();", ForEnterprise);
	   }
	   
	   @FindBy(xpath="//*[@id=\"rendered-content\"]/div/div[1]/footer/div/div/div/div[5]/ul/li[10]/a")
	   WebElement clickEnterprise;
	   public void clickEnterprise() {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", clickEnterprise);
	   }
	     
	   @FindBy(xpath="//*[@id=\"rendered-content\"]/div/div/div[1]/div/header/div[2]/div[1]/div/div/div/div[2]/div[2]/a")
	   WebElement clicksolution;
	   public void Solution() {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", clicksolution);
	   }
	   
	   @FindBy(xpath="//*[@id='rendered-content']/div/div/div[1]/div/header/div[2]/div[1]/div/div/div/div[2]/div[3]/div/div/div/div/div/div[2]/div/div[2]/a/p")
	   WebElement CourseraforCampus;
	   public void ForCampus() {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", CourseraforCampus);
	   }
	   
	   @FindBy(xpath="//*[@id='rendered-content']/div/div/main/div/div[7]/div/div[2]/div/div/div/div/div/div[2]/div[3]")
	   WebElement Filltheform;
	   public void Form() {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].scrollIntoView();", Filltheform);
	   }
	   
	   @FindBy(xpath="//*[@id='FirstName']")
	   public WebElement FirstName;
	   public void Fname()
	   {
		   FirstName.sendKeys("Srishti");
	   }
	   
	   @FindBy(xpath="//*[@id='LastName']")
	   public WebElement LastName;
	   public void Lname()
	   {
		   LastName.sendKeys("Priya");
	   }
	   
	   @FindBy(xpath="//*[@id='Email']")
	   public WebElement Email;
	   public void Email()
	   {
		   Email.sendKeys("srishtipriyassp@gmail.com");
	   }
	   
	   @FindBy(xpath="//*[@id='Phone']")
	   public WebElement PhoneNumber;
	   public void PhoneNo()
	   {
		   PhoneNumber.sendKeys("7254087603");
	   }
	   
	   @FindBy(xpath="//*[@id='Company']")
	   public WebElement InstitutionName;
	   public void Institution()
	   {
		   InstitutionName.sendKeys("Heritage Institute of Technology");
	   }
	   
	   @FindBy(xpath="//*[@id='mktoForm_1512']/div[50]/span/button")
	   public WebElement submitbutton;
	   public void Submit()
	   {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", submitbutton);
	   }
	   
}