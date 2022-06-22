package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass{
	@BeforeClass
	public void setData() {
		fileName = "DuplicateLead";
	}
	@Test(dataProvider = "getData")
	public void duplicateLead(String email_id,String expData) throws InterruptedException {
		
		driver.findElement(By.linkText("Leads")).click();
		 //7	Click Find leads
		 driver.findElement(By.linkText("Find Leads")).click();
		 driver.findElement(By.xpath("//span[@class='x-tab-strip-text ' and text()='Email']")).click();
		 driver.findElement(By.name("emailAddress")).sendKeys(email_id);
		 driver.findElement(By.xpath("//td[@class='x-btn-center']/em/button[@class='x-btn-text' and text()='Find Leads']")).click();
		 Thread.sleep(2000);
		 WebElement ele = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"));//x-grid3-cell-inner x-grid3-col-firstName
		 String leadnum=ele.getText();
		 System.out.println(leadnum);
		 ele.click();
		 driver.findElement(By.linkText("Duplicate Lead")).click();
		 String title = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		 System.out.println(title);
		 Assert.assertEquals(title,expData);//"Duplicate Lead"
		
	}

}
