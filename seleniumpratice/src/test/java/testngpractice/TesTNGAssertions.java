package testngpractice;

import org.testng.Assert;
import org.testng.annotations.*;

public class TesTNGAssertions {

	@Test
	public void testTitle() {
		// TestNG considers the test as passed as long as it runs without throwing an
		// exception.
		// The output "passed" or "failed" is just printed to the console but does not
		// influence the test's pass/fail status.

		/*
		 * String exp_Title = "abc"; String act_Title = "abc";
		 */
		

		//Assert.assertEquals(act_Title, exp_Title);//true
		
		
		//Assert.assertNotEquals(act_Title, exp_Title);//fail
		
		
	   // Assert.assertTrue(true);
	    
	    //Assert.assertFalse(true);
	    
	    
	    
		
		//We can also mention like this
		
	    
		
		String exp_Title = "abc"; 
		String act_Title = "abc";
		if (exp_Title.equals(act_Title))

		{
			System.out.println("passed");
			Assert.assertTrue(true);

		} else {

			System.out.println("failed");
			Assert.assertTrue(false);
		}
		
		Assert.fail();
		
		//if we want to fail the test intensionally we have use Assert.fail() method
		 
		
		
	}

}
