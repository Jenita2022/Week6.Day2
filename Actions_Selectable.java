package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Actions_Selectable extends ParentClass {
	
	@Test
	public void select() {
		driver.findElement(By.xpath("//h5[text()='Selectable']")).click();
		//MUltiple Item selection
		WebElement eleItem1 = driver.findElement(By.xpath("//ol/li[1]"));
		WebElement eleItem7 = driver.findElement(By.xpath("//ol/li[7]"));
		WebElement eleItem3 = driver.findElement(By.xpath("//ol/li[3]"));
		Actions builder=new Actions(driver);
		builder.keyDown(Keys.CONTROL)
		.click(eleItem1)
		.click(eleItem7)
		.click(eleItem3)
		.keyUp(Keys.CONTROL)
		.perform();

	}

}
