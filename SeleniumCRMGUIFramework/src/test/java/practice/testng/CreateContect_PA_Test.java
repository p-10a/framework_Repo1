package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContect_PA_Test {

	@Test(dataProvider = "getData")
	public void createContectTest(String firstName,String lastName) {
		System.out.println("FirstName :"+firstName + ", LastName:" + lastName);
	}
	
	@DataProvider
	public Object[][]getData(){
		Object[][] objArr=new Object[3][2];
		objArr[0][0]="pinki";
		objArr[0][1]="hr";
		
		objArr[1][0]="sam";
		objArr[1][1]="smith";
		
		objArr[2][0]="rani";
		objArr[2][1]="anu";
		
		return objArr;
	}
	
}
