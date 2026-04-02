package practice.testng;

import org.testng.annotations.Test;

public class contactTest {

	@Test
	public void createContectTest() {
	  System.out.println("execute createContectTest with -->HDFC");
	 }
	
	@Test(dependsOnMethods="createContectTest")
	public void modifyContactTest() {
	  System.out.println("execute modifyContactTes --> HDFC=>ICICI");
	 }
	
	@Test(dependsOnMethods="modifyContactTest")
	public void deleteContectTest() {
	  System.out.println("execute deleteContectTest -->ICICI");	
	}
}
