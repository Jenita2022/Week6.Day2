package practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert_P{

@Test
public void Alert() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/home.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//h5[text()='Alert']")).click();

		//Alert box
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();

		//Confirm box
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Alert alt2 = driver.switchTo().alert();
		System.out.println(alt2.getText());
		alt2.dismiss();
		System.out.println(driver.findElement(By.xpath("//p[text()='You pressed Cancel!'] ")));

		//Prompt box
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		org.openqa.selenium.Alert alt3 = driver.switchTo().alert();
		System.out.println(alt3.getText());
		alt3.sendKeys("Pepperfry Institute");
		Thread.sleep(2000);
		alt3.accept();

		//Line Breaks?
		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		Alert alt4 = driver.switchTo().alert();
		System.out.println(alt4.getText());
		alt4.accept();

		driver.close();
	}	

}
