package practice.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTestForscreenshot {
	
	@Test
	public void amazonTest() throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		//step-1 : create an object to EventFiring webdriver		
        TakesScreenshot tks=(TakesScreenshot)driver;
	
		//step-2 :use getScreenshotAs method to get file type of screenshot
		File srcFile=tks.getScreenshotAs(OutputType.FILE);
		
		//steps-3 :Store screen on local driver
		FileUtils.copyFile(srcFile, new File("./screenshaat/shraddh.png"));
	}
}
