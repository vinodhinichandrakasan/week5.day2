package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClass{
	@BeforeClass
	public void setData() {
		fileName = "DeleteLead";
	}
	@Test(dataProvider = "getData")
	public void createLead(String phoneNum,String expData) throws InterruptedException {
		 driver.findElement(By.linkText("Leads")).click();
		 //7	Click Find leads
		 driver.findElement(By.linkText("Find Leads")).click();
		 //Click on Phone
		 driver.findElement(By.xpath("//span[@class='x-tab-strip-inner']/span[contains(text(),'Phone')]")).click();
		 driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNum);
		 driver.findElement(By.xpath("//td[@class='x-btn-center']/em/button[@class='x-btn-text' and text()='Find Leads']")).click();
		 //
		 Thread.sleep(2000);
		 WebElement ele = driver.findElement(By.xpath("//*[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		 String leadnum=ele.getText();
		 System.out.println(leadnum);
		 ele.click();
		 driver.findElement(By.className("subMenuButtonDangerous")).click();
		 driver.findElement(By.linkText("Find Leads")).click();
		 driver.findElement(By.name("id")).sendKeys(leadnum);
		 driver.findElement(By.xpath("//td[@class='x-btn-center']/em/button[@class='x-btn-text' and text()='Find Leads']")).click();
		 Thread.sleep(2000);
		 WebElement ele2 = driver.findElement(By.xpath("//*[@class='x-paging-info' and text()='No records to display']"));
		 String data=ele2.getText();
		 System.out.println(data);
		 Assert.assertEquals(expData,data);
		
	}

}
