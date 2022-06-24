package week6.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import week6.day1.ReadExcel;

public class Facebook {
	
	public String fileName;
	@BeforeClass
	public void getfile() {
		fileName="FaceBookData";
	}

	@Test(dataProvider = "fetchData" )
	public void fb(String FName, String LName, String Mobile, String Pwd, String Day, String Month, String Year) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		// Step 2: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();

		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");

		// Step 4: Maximise the window
		driver.manage().window().maximize();

		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	

		// Step 6: Click on Create New Account button
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

		// Step 7: Enter the first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(FName);

		// Step 8: Enter the last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LName);

		// Step 9: Enter the mobile number
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(Mobile);

		// Step 10: Enter the password
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(Pwd);

		// Step 11: Handle all the three drop downs
		WebElement eleDay = driver.findElement(By.id("day"));
		Select day= new Select(eleDay);
		day.selectByVisibleText(Day);

		WebElement eleMon = driver.findElement(By.id("month"));
		Select month= new Select(eleMon);
		month.selectByVisibleText(Month);

		WebElement eleYr = driver.findElement(By.id("year"));
		Select year= new Select(eleYr);
		year.selectByValue(Year);

		Thread.sleep(2000);
		// Step 12: Select the radio button "Female" 
		//driver.findElement(By.xpath("//input[@value='1']")).click();
		//driver.findElement(By.xpath("//span[@data-name='gender_wrapper']//input[@value=Sex]")).click();
		//driver.findElement(By.xpath("//span[@data-name='gender_wrapper']//label[Sex]")).click();
		//driver.findElement(By.xpath("//span[@data-name='gender_wrapper']//label[text()=(Sex)])")).click();
		driver.findElement(By.xpath("//label[text()='Female']")).click();
	
		driver.quit();
}
		
	
@DataProvider
public String[][] fetchData() throws IOException {
	String[][] readData = ReadExcel.readData(fileName);
	return readData;
}
}

