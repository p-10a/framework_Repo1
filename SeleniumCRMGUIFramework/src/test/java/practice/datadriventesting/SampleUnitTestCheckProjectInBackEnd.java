package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleUnitTestCheckProjectInBackEnd {
	
     private Object expectedProjectName;

	 @Test
     public void projectCheckTest() throws SQLException {
    	 
    	 String expectedProjectNmae="FB_01";
    	 boolean flag=false;		
    	//step1:Load/register the database driver
		   Driver driverRef=new Driver();
		   DriverManager.registerDriver(driverRef);
		   	
		//step2:connect to database
		   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		   System.out.println("======Done======");
		   
		//step3:create sql statements
		  Statement stat=conn.createStatement();
		  
		//step4:execute select query & get result
		 ResultSet resultset=stat.executeQuery("select * from project");
		 while (resultset.next()) {
		 String actProjectName= resultset.getString(4);
		 System.out.println(actProjectName);
		 if(expectedProjectName.equals(actProjectName)) {
			 flag=true;
			 System.out.println(expectedProjectName+"is available==PASS");
		 }
	 }
	    if (flag==false) {
			System.out.println(expectedProjectName+"is not available==FALL");
		}       
		//step5:close the connection
     conn.close();
     }
}
