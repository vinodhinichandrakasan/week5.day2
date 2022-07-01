package week6.day2;

import org.testng.annotations.Test;

public class TestNGAttributes {
	
	
	
	@Test(enabled=true)
	public void Login()
	{
		System.out.println("students login");
	}
	@Test(enabled=false)
	public void DisabledTest()
	{
		System.out.println("Disabled login");
	}
	@Test(priority=0)
	public void PriorityHigh()
	{
		System.out.println("have set the priority value as 0");
	}
	
	//depends on method
	@Test(dependsOnMethods= {"Login"})
	public void depends()
	{
		System.out.println("depend on the another test method");
	}
	
	//multiple depends
	@Test(dependsOnMethods= {"Login","depends"})
	public void dependsOn()
	{
		System.out.println("depend on the two test method");
	}
	
	@Test(timeOut=200)  
	public void testcase1() {
		System.out.println("timeout attributes");
	}

}
