package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQueryTest {
	public static void main(String[] args) throws SQLException {
		//step1:Load/register the database driver
		   Driver driverRef=new Driver();
		   DriverManager.registerDriver(driverRef);
		   	
		//step2:connect to database
		   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		   System.out.println("======Done======");
		   
		//step3:create sql statements
		  Statement stat=conn.createStatement();
		  
		//step4:execute select query & get result
		 int result=stat.executeUpdate("insert into project values('TY_PROJ_2000','PINKI','10/11/2025','FB_01','On Going','100');");
		 System.out.println(result);                                                 //resultset.next();[want to see result set object that time we can use this]
	                                                                                 // String data=resultset.getString(1);[all the data ]
                                                                                     //String data=resultset.getString(2);
		//step5:close the connection
         conn.close();
	}

}
