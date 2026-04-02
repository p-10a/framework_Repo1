package practice.testng;

import org.testng.annotations.Test;

public class OrderTest {

	@Test(invocationCount = 5)
	public void createOrderTest() {
		System.out.println("Execute createOrderTest==>123");
	}
	
	@Test(enabled = false)
	public void billingOrderTes() {
		System.out.println("Execute billingOrderTes==>123");
	}
}
