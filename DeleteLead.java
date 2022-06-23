package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class DeleteLead extends BaseForAll{
	@BeforeClass
	public void getfile() {
		fileName = "DeleteLeadData";
	}
	
	@Test(dataProvider = "fetchdata",dependsOnMethods = "week6.day1.DuplicateLead.DupLead")
	public void DelLead(String phoneNo) throws InterruptedException {
		Thread.sleep(2000);
		//6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();

		//7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		//8	Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();

		//9	Enter phone number
		//driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNo);

		//10	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);

		//11	Capture lead ID of First Resulting lead
		/*WebElement eleLeadID = driver.findElement(By.xpath("//table//tr/td/div/a"));
		String LeadID = eleLeadID.getText();
		System.out.println(LeadID);	
		Thread.sleep(2000);*/

		WebElement eleLeadID = driver.findElement(By.xpath("(//td[@tabindex='0'])[1]//a"));
		String LeadID = eleLeadID.getText();
		System.out.println(LeadID);
		
		//12	Click First Resulting lead
		//driver.findElement(By.xpath("//table//tr/td/div/a")).click();
		eleLeadID.click();

		//13	Click Delete
		//driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.xpath("//a[@class=\"subMenuButtonDangerous\"]")).click();
		//14	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		//15	Enter captured lead ID
		driver.findElement(By.name("id")).sendKeys(LeadID);

		//16	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		//17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		WebElement eleNoRec = driver.findElement(By.xpath("//div[text()='No records to display']"));
		String noRecMsg = eleNoRec.getText();
		if(noRecMsg.contains("No records"))
		{
			System.out.println("The record Deleted");
		}
		else {
			System.out.println("No Record Deleted");
		}


	}

}
