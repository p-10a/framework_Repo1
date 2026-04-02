package com.crm.comcastcontecttest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;

public class CreateContectTest extends BaseClass {
	
    @Test
	public void createContect() {
	  System.out.println("execute createContect & verify");	
	}
	@Test
	public void createContectWithDate() {
		System.out.println("execute createContectWithDate & verify");
	}
	
	
}
