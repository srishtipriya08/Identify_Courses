package PageObjects;
 
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class WebDevelopment{
	public WebDriver driver;

	   //constructor
	   public WebDevelopment(WebDriver driver){
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
	   }
	   
	   
	   @FindBy(xpath="//input[@class='react-autosuggest__input']")
	   WebElement SearchBox;
	   public void Search() {
		   SearchBox.sendKeys("Web Development");
	   }
	   
	   
	   @FindBy(xpath="//button[@class='nostyle search-button']")
	   WebElement Button;
	   public void clickButton() {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", Button);
	   }
	   
	   
	   @FindBy(xpath="//*[@id=\"search-results-header-wrapper\"]/div/div[1]/div/div[3]/div[2]/button")
	   WebElement LanguageSeeMore;
	   public void getSeeMore() {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", LanguageSeeMore);
	   }
	   
	   
	   @FindBy(xpath="//*[@aria-label=\"Search by keyword\"]")
	   public WebElement selectlanguagetxt;
	   public void LanguageTxt()
	   {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", selectlanguagetxt);
		   selectlanguagetxt.sendKeys("English");
	   }
	   
	   @FindBy(xpath="//*[@id='checkbox-group']/div/label/span")
	   public WebElement selectEnglish;
	   public void English() {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", selectEnglish);
	   }
	   
	   @FindBy(xpath="/html/body/div[7]/div[3]/div/div/div[2]/div[3]/button[1]/span")
	   public WebElement apply;
	   public void Apply() {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", apply);
	   }
	   
	   @FindBy(xpath="(//h3[@class='cds-CommonCard-title css-1sktkql'])[1]")
	   public WebElement Course1;
	   public void Course() {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", Course1);
	   }
	   
	   @FindBy(xpath="(//h3[@class='cds-CommonCard-title css-1sktkql'])[2]")
	   public WebElement Course2;
	   public void Course2() {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", Course2);
	   }
	   
	   @FindBy(xpath="//*[@id='rendered-content']/div/main/section[2]/div/div/div[1]/div[1]/section/h1")
	   public WebElement name;
	   public WebElement CourseName() {
		   return name;
	   }
	   
	   @FindBy(xpath="//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[3]/div[1]")
	   public WebElement learningHrs;
	   public WebElement Duration() {
		   return learningHrs;
	   }
	   
	   @FindBy(xpath="//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[1]/div[1]")
	   public WebElement rating;
	   public WebElement Rating() {
		   return rating;
	   }
	   

	   
	   

}