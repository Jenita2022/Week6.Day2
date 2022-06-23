package week6.day2;

import org.testng.annotations.Test;

public class DependsOnMethods_WithinClass {
  @Test(dependsOnMethods = {"testTwo"})
  public void testOne() {
	  System.out.println("Testing One");
  }
  
  @Test
  public void testTwo() {
	  System.out.println("Testing Two");
  }
  
  @Test(dependsOnMethods = {"testOne"})
  public void testThree() {
	  System.out.println("Testing Three");
  }
  
  @Test
  public void testFour() {
	  System.out.println("Testing Four");
  }
  
  
  
}
  
