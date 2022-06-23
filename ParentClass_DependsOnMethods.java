package week6.day2;

import org.testng.annotations.Test;

public class ParentClass_DependsOnMethods {
  @Test(dependsOnMethods = { "two" })
  public void one() {
	  System.out.println("Testing One");
  }
  
  @Test
  public void two() {
	  System.out.println("Testing Two");
  }
  
}
