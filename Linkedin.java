package week6.day2;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Linkedin extends ParentClass_LinkedIn{
	@BeforeClass
	public void getSheetName(){
		sheetName = "SignUpData";
	}
	@Test(dataProvider = "fetchData")
	public void linkedinSignup(String Email, String pwd) throws InterruptedException {
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.findElement(By.linkText("Join now")).click();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("email-or-phone")).sendKeys(Email);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@id='join-form-submit']")).click();
			
	}

}
