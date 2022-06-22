package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateContact extends BaseForAll{
	@Test
	public void CreContact(){
	
		//5. Click on Contacts button
		//driver.findElement(By.linkText("Contacts")).click(); 
		//driver.findElement(By.xpath("//li[@class='sectionTabButtonSelected']//a")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//6. Click on Create Contact
		driver.findElement(By.linkText("Create Contact")).click();

		//7. Enter FirstName Field Using id Locator
		driver.findElement(By.id("firstNameField")).sendKeys("FVVikram");

		// 8. Enter LastName Field Using id Locator
		driver.findElement(By.id("lastNameField")).sendKeys("LVVikram");

		// 9. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Jenita");

		// 10. Enter LastName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("PJJ");

		// 11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Testing");

		// 12. Enter Description Field Using any Locator of your choice
		driver.findElement(By.id("createContactForm_description")).sendKeys("CCCreating new contact for me");

		// 13. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("vvip@gmail.com");

		// 14. Select State/Province as NewYork Using Visible Textiver.
		WebElement eleSta = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select statePro = new Select(eleSta);
		statePro.selectByVisibleText("New York");

		// 15. Click on Create Contact
		driver.findElement(By.name("submitButton")).click();  

		// 16. Click on edit button 
		driver.findElement(By.linkText("Edit")).click(); 

		// 17. Clear the Description Field using .clear
		driver.findElement(By.id("updateContactForm_description")).clear();

		//18. Fill ImportantNote Field with Any text
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Adding important information");

		// 19. Click on update button using Xpath locator
		driver.findElement(By.xpath("//input [@value='Update']")).click(); 

		// 20. Get the Title of Resulting Page.
		System.out.println("Page Title :" +driver.getTitle());
	
	}

}
