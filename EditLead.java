package week6.day1;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditLead extends BaseForAll {
	@BeforeClass
	public void getfile() {
		fileName="EditLeadData";
	}

	@Test(dataProvider = "fetchdata", dependsOnMethods = {"week6.day1.CreateLead.CLead"})
	public void EdiLead(String FName, String UpdateCo) throws InterruptedException {
		Thread.sleep(2000);
		//6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();

		//7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		//8 Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(FName);


		//9	Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);

		//10 Click on first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		Thread.sleep(3000);

		//11 Verify title of the page
		System.out.println("Page Title: " +driver.getTitle());

		//12 Click Edit
		driver.findElement(By.linkText("Edit")).click();

		//13 Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(UpdateCo);

		//14 Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		//15 Confirm the changed name appears
		String editedCoName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Updated Co. Name: " +editedCoName);

	}

}
