package practice.datadriventesting;
import java.io.FileInputStream;
import java.io.FileReader;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class CreateOrgTest {
	
	@Test

	public void createOrgtest(XmlTest test) throws Throwable {
		
		//read common data from JSon file
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("C:\\Users\\s\\Desktop\\data\\appCommanData.json"));
		
		JSONObject map=(JSONObject)obj;
				
		String URL=test.getParameter("url");
		String BROWSER=test.getParameter("browser");
		String USERNAME=test.getParameter("username");
		String PASSWORD=test.getParameter("password");
		
		//generate the random number
		Random random=new Random();
		int randomInt=random.nextInt(1000);
		
		//read testScript data from excel file
		FileInputStream fisl=new FileInputStream("C:\\Users\\s\\Desktop\\data\\testScriptdata.xlsx‪‪‪");
		Workbook wb=WorkbookFactory.create(fisl);
		Sheet sh=wb.getSheet("org");
		Row row=sh.getRow(1);
		String orgName=row.getCell(2).toString()+randomInt;
		wb.close();
		
		WebDriver driver=null;
		
		if(BROWSER.equals("firefox")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge")) {
			driver=new FirefoxDriver();
		}else {
			driver=new ChromeDriver();
		}
		
		//step 1:Login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
				  
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
        //step 2:Navigate to Organization module				  
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 3:Click on "create Organization" Button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step 4:Enter all the details & create new Organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='save [Alt+S]']")).click();
		
		//step5:Logout
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG]'"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	    driver.quit();
	}
}

