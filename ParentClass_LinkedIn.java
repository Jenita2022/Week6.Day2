package week6.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParentClass_LinkedIn {
	public ChromeDriver driver;
	public String sheetName;

	@Parameters("url")

	@BeforeMethod
	public void preconditions(String url) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterMethod
	public void postcondition() {
		driver.close();
	}

	@DataProvider
	public String[][] fetchData() throws IOException {
		String[][] Data = ReadExcelData.readData(sheetName);
		return Data;
	}
}
