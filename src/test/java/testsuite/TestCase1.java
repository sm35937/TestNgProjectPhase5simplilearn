package testsuite;

import org.testng.annotations.Test;

public class TestCase1 {
	
	@Test
	public void test1() {
		System.out.println("Inside test case 1");
	}
	
	@Test(description = "I am testing test case 2")
	public void test2() {
		System.out.println("Inside test case 2");
	}
	
	@Test(dependsOnMethods = "test2")
	public void otherTest() {
		System.out.println("Inside OtherTest");
	}
}
