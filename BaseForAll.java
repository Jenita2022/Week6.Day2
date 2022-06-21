package week6.day1;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseForAll {

	public ChromeDriver driver;
	public String fileName;
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void precondition(String url,String uname,String pwd) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[contains(@class,'decorati')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
	}

	@AfterMethod
	public void postcondition() {
		driver.close();
	}

	@DataProvider
	public String[][] fetchdata() throws IOException{
		String[][] readData = ReadExcel.readData(fileName);
		return readData;

	}
}