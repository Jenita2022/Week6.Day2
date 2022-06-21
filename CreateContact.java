package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateContact extends ParentClass{
	@BeforeClass
	public void getfile() {
		fileName ="CreateContacts";
	}
	
	@Test(dataProvider="fetchData")
	public void CreContact(String FName, String LName,String FNLocal,String LNLocal,String Dept,String Desc,String Email,String State) throws InterruptedException{
		//5. Click on Contacts button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//6. Click on Create Contact
		driver.findElement(By.linkText("Create Contact")).click();

		//7. Enter FirstName Field Using id Locator
		driver.findElement(By.id("firstNameField")).sendKeys(FName);

		// 8. Enter LastName Field Using id Locator
		driver.findElement(By.id("lastNameField")).sendKeys(LName);

		// 9. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys(FNLocal);

		// 10. Enter LastName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys(LNLocal);

		// 11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys(Dept);

		// 12. Enter Description Field Using any Locator of your choice
		driver.findElement(By.id("createContactForm_description")).sendKeys(Desc);

		// 13. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys(Email);

		// 14. Select State/Province as NewYork Using Visible Textiver.
		WebElement eleSta = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select statePro = new Select(eleSta);
		statePro.selectByVisibleText(State);

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
