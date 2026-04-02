package pac2;

import org.testng.annotations.Test;

public class OrgTest {
  
	@Test
    public void createOrgTest() {
	  System.out.println("execute createOrgTest");
	  
	  String URL=System.getProperty("url");
	    String BROWSER=System.getProperty("browser","chrome");
	    String USERNAME=System.getProperty("username");
	    String PASSWORD=System.getProperty("password");
	    
	    System.out.println(URL);
	    System.out.println(BROWSER);
	    System.out.println(USERNAME);
	    System.out.println(PASSWORD);
    }
	
	@Test
    public void modifyOrgTest() {
	  System.out.println("execute modifyOrgTest");
    }
}