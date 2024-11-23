package testngpractice;

import org.testng.annotations.*;

public class C2 {
	
	@AfterTest
	public void testAfterC2() {
		
		System.out.println("This is AfterTest from  c2 class");
		
	}
	
	
	@Test
	public void test1()
	{
		System.out.println("This is test1  method from c2 class");
	}
	

	@BeforeTest
	public void testBeforeC2() {
		
		System.out.println("This is AfterTest  from c2 class");
		
	}

}
