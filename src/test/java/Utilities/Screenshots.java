package Utilities;

import java.io.File;
import java.io.IOException;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 
public class Screenshots {
 
		 
        public static String takeScreenshot(WebDriver driver, String Name) throws IOException{
        	File fileobj = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	File trg = new File("C:\\Users\\2304062\\eclipse-workspace\\Hackathon_Project\\ScreenShots\\"+Name+".png");
        	FileUtils.copyFile(fileobj, trg);
        	return trg.getAbsolutePath();
}
 
}