package PageObjects;
 
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class LearningLanguage  {
	public WebDriver driver;

	   //constructor
	   public LearningLanguage(WebDriver driver){
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
	   }
	   
	   @FindBy(xpath="//input[@class='react-autosuggest__input']")
	   WebElement inputBoxs;
	   public void Input() {
		   inputBoxs.clear();
	   }
	   
	   @FindBy(xpath="//input[@class='react-autosuggest__input']")
	   WebElement search;
	   public void Search() {
		   search.sendKeys("Learning Language");
	   }
	   
	   @FindBy(xpath="//*[@id=\"search-results-header-wrapper\"]/div/div[1]/div/div[3]/div[2]/button/span")
	   WebElement LanguageSeeMore1;
	   public void getSeeMore() {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", LanguageSeeMore1);
	   }
	   
	   By Count = By.xpath("//*[@id=\"checkbox-group\"]/div/label/div");
	   public List<WebElement> LanguageCount(){
		   return driver.findElements(Count);
	   }
	   
	   By Level = By.xpath("//*[@id=\"search-results-header-wrapper\"]/div/div[1]/div/div[5]/div/div/div/label/div");
	   public List<WebElement> LevelCount(){
		   return driver.findElements(Level);
	   }
	   
	   @FindBy(xpath="/html/body/div[7]/div[3]/div/div/div[1]/button")
	   WebElement close;
	   public void Close() {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", close);
	   }
	   
	   @FindBy(xpath="//*[@id=\"rendered-content\"]/div/div/span/div[1]/header/div[1]/div/div/div[1]/div[2]/div/div[2]/div/div/a/div/img")
	   WebElement HomePage;
	   public void getHomePage() {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", HomePage);
	   }
	   
	   
}