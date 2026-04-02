package practice.testng;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventFiringWebDriver {

	WebDriver driver;
	public EventFiringWebDriver(WebDriver driver) {
		this.driver=driver;

	}
	
	@FindBy(className="screenshotAs")
	private File ScreenShotAs;
	
	
	public File getScreenShotAs(OutputType<File> file)
	{
		return ScreenShotAs;
	}
}
