package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserVerifications {
@Test
	public void BV() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Get Current URL
		System.out.println("My current url is :" +driver.getCurrentUrl());
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Get Title
		System.out.println(driver.getTitle());
		
		//Get Page source
		System.out.println(driver.getPageSource());
		
		//get current url
		System.out.println("current url is: " +driver.getCurrentUrl());
		driver.close();
	

	}

}
