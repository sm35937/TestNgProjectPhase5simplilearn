package testsuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase2 {
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Inside BeforeTest method");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Inside afterTest method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Inside After method");
	}
	
	@Test
	public void test3() {
		System.out.println("Inside test case 3");
	}
	
	@Test(groups = {"sanity"})
	public void test4() {
		System.out.println("Inside test case 4");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Inside Before method");
	}
}
