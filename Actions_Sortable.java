package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Actions_Sortable extends ParentClass {
	
	@Test
	public void sort() {
		driver.findElement(By.xpath("//h5[text()='Sortable']")).click();
		//Locate item 3 and item6
		WebElement eleItem3 = driver.findElement(By.xpath("//ul[@id='sortable']/li[3]"));
		WebElement eleItem6 = driver.findElement(By.xpath("//ul[@id='sortable']/li[6]"));
		//Move item 6 to item 3 from bottom to top
		Actions builder = new Actions(driver);
		//builder.dragAndDrop(eleItem6, eleItem3).perform(); This also works fine.
		builder.clickAndHold(eleItem6).moveToElement(eleItem3).release().perform();

	}

}
