package testngpractice;

import org.testng.annotations.*;

public class C1 {
	
	@BeforeTest
	public void testBefore() {
		
		System.out.println("This is BeforeTest from c1 class");
		
	}
	
	
	@Test
	public void test1()
	{
		System.out.println("This is test1 from c1  class");
	}

	@AfterTest
	public void testAfter() {
		
		System.out.println("This is AfterTest from  c1 class");
		
	}
	
}
