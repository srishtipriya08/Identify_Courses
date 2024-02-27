package PageObjects;
 
import java.util.Set;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
 
public class BasePage
{
 
	public static void main(String[] args) throws InterruptedException
	{
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.coursera.org/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String oldwindow=driver.getWindowHandle();
		
		//searching
		WebElement inputBox = driver.findElement(By.xpath("//*[@id='rendered-content']/div/header/div/div/div[2]/div[1]/div[3]/div/form/div/div[1]/input"));
		inputBox.sendKeys("Web Development courses");
		Thread.sleep(6000);
		WebElement searchresult=driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-1-item-0']/div/div/div[2]/span"));
		searchresult.click();
		
		//filtering level
		Thread.sleep(6000);
		WebElement level=driver.findElement(By.xpath("/html/body/div[2]/div/div/main/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[4]/div/div/div[5]/label/div/span/span"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",level);
		Thread.sleep(3000);
		WebElement levelcheckbox=driver.findElement(By.xpath("/html/body/div[2]/div/div/main/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[5]/div/div/div[1]/label/span/span"));
		levelcheckbox.click();
		
		//filtering languages
		Thread.sleep(3000);
		WebElement languages=driver.findElement(By.xpath("/html/body/div[2]/div/div/main/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[2]/button/span"));
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("arguments[0].scrollIntoView();",languages);
		Thread.sleep(3000);
		WebElement languageshowmore=driver.findElement(By.xpath("/html/body/div[2]/div/div/main/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[3]/div[2]/button"));
		languageshowmore.click();
		
		//mini-window
		Thread.sleep(3000);
		WebElement selectlanguagetxt=driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div/div[2]/div[2]/div[1]/div[2]/input"));
		selectlanguagetxt.click();
		selectlanguagetxt.sendKeys("English");
		Thread.sleep(3000);
		WebElement selectEnglish=driver.findElement(By.xpath("//*[@id='checkbox-group']/div/label/span"));
		selectEnglish.click();
		Thread.sleep(3000);
		WebElement apply=driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div/div[2]/div[3]/button[1]/span"));
		apply.click();
		
		//scroll up
		WebElement gotoresult=driver.findElement(By.xpath("//*[@id='search-results-header-wrapper']/div/div[1]/div/h3"));
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].scrollIntoView();",gotoresult);
		
		
		//first course details
		Thread.sleep(3000);
		WebElement course1=driver.findElement(By.xpath("/html/body/div[2]/div/div/main/div[1]/div/div/div/div/div[2]/ul/li[1]/div/div/div/div/div"));
		course1.click();
		Set<String>handle=driver.getWindowHandles();
		for(String newwindow1:handle)
		{	
			driver.switchTo().window(newwindow1);
		}
		System.out.println("Course-1");
		Thread.sleep(2000);
		WebElement c101=driver.findElement(By.xpath("//*[@id='rendered-content']/div/main/section[2]/div/div/div[1]/div[1]/section/h1"));
		System.out.println("Course Name :"+c101.getText());
		WebElement c102=driver.findElement(By.xpath("//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[3]/div[1]"));
		System.out.println("Course Duration :"+c102.getText());
		WebElement c103=driver.findElement(By.xpath("//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[1]/div[1]"));
		System.out.println("Course Rating :"+c103.getText());
		driver.close();
		driver.switchTo().window(oldwindow);
		System.out.println("");
		Thread.sleep(6000);
 
		//second course details
		WebElement course2=driver.findElement(By.xpath("/html/body/div[2]/div/div/main/div[1]/div/div/div/div/div[2]/ul/li[2]/div/div/div/div/div/div[2]"));
		course2.click();
		Set<String>handles1=driver.getWindowHandles();
		for(String newwindow2:handles1)
		{
			driver.switchTo().window(newwindow2);
		}
		
		System.out.println("Course-2");
		WebElement c201=driver.findElement(By.xpath("//*[@id='rendered-content']/div/main/section[2]/div/div/div[1]/div[1]/section/div/div[1]/h1"));
		System.out.println("Course Name :"+c201.getText());
		WebElement c202=driver.findElement(By.xpath("//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/section/div/div[3]/div/div/div[2]"));
		System.out.println("Course Duration :"+c202.getText());
		WebElement c203=driver.findElement(By.xpath("//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/section/div/div[1]/div/div/div[1]"));
		System.out.println("Course Rating :"+c203.getText());
		driver.close();
		driver.switchTo().window(oldwindow);
	
		//Language Learning
		//System.out.println("");
		Thread.sleep(4000);
		WebElement inputBoxs=driver.findElement(By.xpath("//*[@id='rendered-content']/div/div/span/div[1]/header/div[1]/div/div/div[1]/div[2]/div/div[3]/div/div[2]/form/div/div[1]/input"));
		Thread.sleep(4000);
		inputBoxs.sendKeys(Keys.CONTROL + "a"); // Select all text
		inputBoxs.sendKeys(Keys.BACK_SPACE);
		inputBoxs.sendKeys("Language Learning");
		Thread.sleep(4000);
		WebElement LLresult=driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-1-item-0']/div/div/div[2]/span"));
		LLresult.click();
		
		Thread.sleep(4000);
		WebElement Homepage=driver.findElement(By.xpath("//*[@id='rendered-content']/div/div/span/div[1]/header/div[1]/div/div/div[1]/div[2]/div/div[2]/div/div/a/div/img"));
		Homepage.click();
		
		//scroll down For Enterprise
		WebElement ForEnterprise=driver.findElement(By.xpath("//*[@id='rendered-content']/div/div[1]/footer/div/div/div/div[5]/p"));
		JavascriptExecutor js3=(JavascriptExecutor)driver;
		js3.executeScript("arguments[0].scrollIntoView();",ForEnterprise);
		
		WebElement clickEnterprise=driver.findElement(By.xpath("//*[@id='rendered-content']/div/div[1]/footer/div/div/div/div[5]/ul/li[10]/a"));
		clickEnterprise.click();
		Thread.sleep(2000);
		WebElement clicksolution=driver.findElement(By.xpath("//*[@id='rendered-content']/div/div/div[1]/div/header/div[2]/div[1]/div/div/div/div[2]/div[2]/a"));
		clicksolution.click();
		Thread.sleep(2000);
		WebElement CourseraforCampus=driver.findElement(By.xpath("//*[@id='rendered-content']/div/div/div[1]/div/header/div[2]/div[1]/div/div/div/div[2]/div[3]/div/div/div/div/div/div[2]/div/div[2]/a/p"));
		CourseraforCampus.click();
		Thread.sleep(2000);
		
		//scroll down Ready to transform
		WebElement Filltheform=driver.findElement(By.xpath("//*[@id='rendered-content']/div/div/main/div/div[7]/div/div[2]/div/div/div/div/div/div[2]/div[3]"));
		JavascriptExecutor js4=(JavascriptExecutor)driver;
		js4.executeScript("arguments[0].scrollIntoView();",Filltheform);
		
		WebElement FirstName=driver.findElement(By.xpath("//*[@id='FirstName']"));
		FirstName.sendKeys("Rajesh");
		WebElement LastName=driver.findElement(By.xpath("//*[@id='LastName']"));
		LastName.sendKeys("C R");
		WebElement Email=driver.findElement(By.xpath("//*[@id='Email']"));
		Email.sendKeys("rajesh123@gmail.com");
		WebElement PhoneNumber=driver.findElement(By.xpath("//*[@id='Phone']"));
		PhoneNumber.sendKeys("654378998");
		WebElement InstitutionName=driver.findElement(By.xpath("//*[@id='Company']"));
		InstitutionName.sendKeys("Summa collage of Technology");
		
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
		submitbutton.click();
		Thread.sleep(4000);
		WebElement errormsg=driver.findElement(By.xpath("//*[@id='ValidMsgEmail']"));
		System.out.println("");
		System.out.println("Error Message :"+errormsg.getText());
		driver.close();
		
		
	}
 
}