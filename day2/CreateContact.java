package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateContact extends BaseClass {
	
	@BeforeClass
	public void setData() {
		fileName = "CreateContact";
	}
	@Test(dataProvider = "getData")
	public void createLead(String fName,String lName,String	firstNameLocal,String LastLocal,String	departName,String descr,String	mail_id,String	updateNotes
) throws InterruptedException {
	
	driver.findElement(By.linkText("Contacts")).click();
	 //6. Click on Create Contact
	 driver.findElement(By.linkText("Create Contact")).click();
	 //7. Enter FirstName Field Using id Locator
	 driver.findElement(By.id("firstNameField")).sendKeys(fName);
	 //8. Enter LastName Field Using id Locator
	 driver.findElement(By.id("lastNameField")).sendKeys(lName);
	 // 9. Enter FirstName(Local) Field Using id Locator
	 driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys(firstNameLocal);
	 //10. Enter LastName(Local) Field Locator
	 driver.findElement(By.name("lastNameLocal")).sendKeys(LastLocal);
	 //11. Enter Department Field Using any Locator of Your Choice
	 driver.findElement(By.id("createContactForm_departmentName")).sendKeys(departName);
	 //12. Enter Description Field Using any Locator of your choice 
	 driver.findElement(By.xpath("//*[@name='description']")).sendKeys(descr);
	 //13. Enter your email in the E-mail address Field using the locator of your choice
	 driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys(mail_id);
	 WebElement ele1 = driver.findElement(By.name("generalStateProvinceGeoId"));
	 Select city=new Select(ele1);
	 city.selectByVisibleText("New York");
	 driver.findElement(By.className("smallSubmit")).click();
	 driver.findElement(By.linkText("Edit")).click();
	 driver.findElement(By.id("updateContactForm_description")).clear();
	 driver.findElement(By.id("updateContactForm_importantNote")).sendKeys(updateNotes);
	 
	 driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
	 
	 //* 20. Get the Title of Resulting Page.
	   System.out.println(driver.getTitle());
	   
	}
}
