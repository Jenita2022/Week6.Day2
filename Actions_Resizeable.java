package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions_Resizeable {
@Test
	public void Resize() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://jqueryui.com/resizable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//switch to iframe
		WebElement eleFrame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(eleFrame);
		
		//locate the webelement inside iframe and change height and width
		WebElement eleResize = driver.findElement(By.xpath("//h3[@class='ui-widget-header']/parent::div"));
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(eleResize,100,70).perform();
		driver.close();
		
	}

}
