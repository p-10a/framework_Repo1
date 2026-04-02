package practice.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class CreateOrganizationWithIndstriesTest {

	public static void main(String[] args) throws Throwable {
		//read common data from JSon file
		FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
				
		String BROWSER=pObj.getProperty("browser");
		String URL=pObj.getProperty("url");
		String USERNAME=pObj.getProperty("username");
		String PASSWORD=pObj.getProperty("password");
				
		//generate the random number
		Random random=new Random();
		int randomInt=random.nextInt(1000);
						
		//read testScript data from excel file
		FileInputStream fisl=new FileInputStream("./src/test/resources/testScriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fisl);
		Sheet sh=wb.getSheet("org");
		Row row=sh.getRow(7);
	    String orgName=row.getCell(2).toString()+randomInt;
	    String ShippingAddress=row.getCell(3).toString();
		String phonenumber=row.getCell(4).getStringCellValue();
		wb.close();
						
		WebDriver driver=null;
			
		if(BROWSER.equals("chrome")) {
		driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
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
		driver.findElement(By.id("phone")).sendKeys(phonenumber);
		driver.findElement(By.name("ship_street")).sendKeys(ShippingAddress);			


		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//verify the industries and type info
		String actphonenumber= driver.findElement(By.id("dtlview_Phone")).getText();
		if(actphonenumber.equals(phonenumber)) {
			System.out.println(phonenumber + "information is veriied==PASS");
		}else {
			System.out.println(phonenumber + "information is not verified==FAIL");
		}
			
		
		//step5:Logout			
		driver.quit();					
	}
			
	}

