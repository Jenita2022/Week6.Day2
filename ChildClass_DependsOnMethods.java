package week6.day2;

import org.testng.annotations.Test;

public class ChildClass_DependsOnMethods extends ParentClass_DependsOnMethods {
	@Test(dependsOnMethods = {"one"})
	  public void three() {
		  System.out.println("Testing three");
	  }
	  
	  @Test
	  public void four() {
		  System.out.println("Testing four");
	  }
}
