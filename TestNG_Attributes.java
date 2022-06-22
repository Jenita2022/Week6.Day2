package week6.day2;

import org.testng.annotations.Test;

public class TestNG_Attributes {

	@Test (priority = -1, timeOut = 6000)
	public void Test() {
	System.out.println("Testing");
	}
	
	@Test(priority = 3, invocationCount = 2)
	public void UnitTest() {
	System.out.println("Unit Testing");
	}

	@Test(priority = 1, dependsOnMethods = {"week6.day1.Actions_Selectable.select", "UnitTest"})
	public void IntegTest() {
	System.out.println("Integration Testing");
	}

	@Test(priority = -2, invocationCount = 2,  enabled=false )
	public void SystemTest() {
	System.out.println("System Testing");
	}

}
