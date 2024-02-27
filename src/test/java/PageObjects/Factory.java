package PageObjects;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
 
public class Factory {
   public WebDriver driver;
   //constructor
   public Factory(WebDriver driver){
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
}