package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseForAll{
	@BeforeClass
	public void getdata(){
		fileName = "DuplicateLeadData";
	}
	@Test(dataProvider = "fetchdata")
	public void DupLead(String email) throws InterruptedException {
		Thread.sleep(2000);
		//6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();

		//7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		//8 Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();

		//9	Enter Email
		driver.findElement(By.name("emailAddress")).sendKeys(email);

		//10 Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);

		//11	Capture name of First Resulting lead
		WebElement eleName = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//td[3]//a"));
		String name = eleName.getText();
		System.out.println("Captured Name: " +name);

		//12	Click First Resulting lead
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//td[3]//a")).click();

		//13	Click Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();

		//14	Verify the title as 'Duplicate Lead'
		System.out.println("Page Title: " +driver.getTitle());

		//15	Click Create Lead
		driver.findElement(By.name("submitButton")).click();

		//16	Confirm the duplicated lead name is same as captured name

		WebElement eleDupLead =driver.findElement(By.id("viewLead_firstName_sp"));
		String dupLead = eleDupLead.getText();
		System.out.println("Captured Duplicated Lead: " +dupLead);

		if (dupLead.equals(name)){
			System.out.println("Duplicate Lead is created successfully");
		}
		else {
			System.out.println("Not a Duplicate Lead");	
		}

	}

}
