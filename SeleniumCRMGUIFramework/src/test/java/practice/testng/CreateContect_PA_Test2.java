package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContect_PA_Test2 {

  @Test(dataProvider = "getData")
  public void createContectTest(String firstName,String lastName,long phoneNumber) {
  System.out.println("FirstName :"+firstName + ", LastName:" + lastName +",phoneNumber:"+ phoneNumber);
	}
	
	@DataProvider
	public Object[][]getData(){
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="pinki";
		objArr[0][1]="hr";
		objArr[0][2]=987654210l;
		
		objArr[1][0]="sam";
		objArr[1][1]="smith";
		objArr[1][2]=789654123l;
		
		objArr[2][0]="rani";
		objArr[2][1]="anu";
		objArr[2][2]=896574123l;
		
		return objArr;
	}
	
}
