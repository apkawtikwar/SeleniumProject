package Basic;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChronologicalOrder {
	@BeforeSuite
	public void beforeSuite()  //execute only one time
	{
		System.out.println("BeforeSuite");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("BeforeTest");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("AfterMethod");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("AfterClass");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("AfterTest");
	}
	
	
	@BeforeClass
	public void beforeClas()
	{
		System.out.println("BeforeClass");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("BeforeMethod");
	}
	
	@Test
	public void testCase1()
	{
		System.out.println("TestCase1");
	}
	
	@Test
	public void testCase2()
	{
		System.out.println("TestCase2");
	}
	
	@AfterSuite
	public void afterSuite()  //execute only one time
	{
		System.out.println("AfterSuite");
	}

}
