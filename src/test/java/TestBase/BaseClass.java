package TestBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import PageObjects.Enterprise;
import PageObjects.LearningLanguage;
import PageObjects.WebDevelopment;


public class BaseClass {
	
	public static WebDriver driver;
	public static Properties properties;
	public static String path;
	protected List<String> count1=new ArrayList<String>();
	protected List<String> level1=new ArrayList<String>();
	public WebDevelopment WD;
	public LearningLanguage LL;
	public static Enterprise EP;
	
	@BeforeTest (groups= {"smoke","regression","master"})
	@Parameters({"os","browser"})
	public void setUp(String os,String browser) throws InterruptedException, IOException {
		
		//loading properties file
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		properties=new Properties();
		properties.load(file);
 
		if(properties.getProperty("execution_env").equalsIgnoreCase("remote"))
		{	
			DesiredCapabilities capabilities=new DesiredCapabilities();
 
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os..");
				return;
			}
 
			//browser
			switch(browser.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser.."); return;
			}
 
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
 
		}
		else if(properties.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//launching browser based on condition - locally
			System.out.println("running local");
			switch(browser.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			default: System.out.println("No matching browser..");
			return;
			}
		}
		String baseURL = properties.getProperty("URL");
		
		driver.get(baseURL);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
	}
	
	@AfterTest (groups= {"smoke","regression","master"})
	public static void tearDown() {
		driver.quit();
	}
	

	public static WebDriver getDriver() {
		return driver;
	}
}
