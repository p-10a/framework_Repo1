package practice.datadriventesting;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class CreateProjectAndVerifyDataINDBWithGUI {

	private static final String Distributor = null;

	public static void main(String[] args) throws Throwable {
		
		//Create a project in GUI using Selenium code[WebDriver code]
		
		String AddDistributor=Distributor;
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://49.249.28.218:8081/TestServer/Build/Supply_Management_System/");
        
        driver.findElement(By.id("login:username")).sendKeys("admin");
        driver.findElement(By.id("login:password")).sendKeys("admin123");
        driver.findElement(By.id("login:type")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        
        driver.findElement(By.linkText("Add Distributor")).click();
        
        driver.findElement(By.id("distributor:name")).sendKeys("Anu");
        driver.findElement(By.id("distributor:email")).sendKeys("anu1012@gmail.com");
        driver.findElement(By.id("distributor:phone")).sendKeys("9087654321");
        driver.findElement(By.id("distributor:address")).sendKeys("Rajajinagar");
        
        driver.findElement(By.xpath("//input[@value='Add Distributor']")).click();
        
        //Verify the project in BackEnd [DB] using JDBC
        
//       boolean flag=false;
//       Driver driverRef=new Driver();
//		DriverManager.registerDriver(driverRef);
//   	
//		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
//		System.out.println("======Done======");
//	
//		Statement stat=conn.createStatement();
//	
//	ResultSet resultset=stat.executeQuery("select * from project");
//		while (resultset.next()) {
//		String actProjectName= resultset.getString(4);
//		System.out.println(actProjectName);
//		if(AddDistributor.equals(actProjectName)) {
//		   flag=true;
//		   System.out.println(AddDistributor+"is available DB==PASS");
//		   }
//	     }
//	    if (flag==false) 
//	    	System.out.println(AddDistributor+"is not available DB==FALL");
//      }       
//         //step5:Close the connection
//	     conn.close();
	}
}