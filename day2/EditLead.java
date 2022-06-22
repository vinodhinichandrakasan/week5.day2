package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditLead extends BaseClass  {
	
	@BeforeClass
	public void setData() {
		fileName = "EditLead";
	}
	@Test(dataProvider = "getData")
	public void createLead(String cName, String fName, String lName,String LocalName
,String departName,String descr,String mail_id,String updateNotes) throws InterruptedException {
		
		 
		 driver.findElement(By.linkText("Leads")).click();
		 driver.findElement(By.linkText("Create Lead")).click();
		 driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		 driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		 driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		 driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(LocalName);
		 driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(departName);
		 driver.findElement(By.name("description")).sendKeys(descr);
		 driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(mail_id);
		 WebElement ele1 = driver.findElement(By.name("generalStateProvinceGeoId"));
		 Select city=new Select(ele1);
		 city.selectByVisibleText("New York");
		 driver.findElement(By.className("smallSubmit")).click();
		 driver.findElement(By.linkText("Edit")).click();
		 driver.findElement(By.id("updateLeadForm_description")).clear();
		 driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys(updateNotes);
		 Thread.sleep(2000);
		 driver.findElement(By.className("smallSubmit")).click();
		 System.out.println(driver.getTitle());
	}

}
