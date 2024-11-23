package testngpractice;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {

	/*
	 * @Test public void test_HardAssertion()
	 * 
	 * { System.out.println("Hello"); System.out.println("Hello");
	 * 
	 * Assert.assertEquals(false, true); System.out.println("Hello");
	 * System.out.println("Hello"); }
	 */

	@Test
	public void test_SoftAssertions() {

		System.out.println("Hello");
		System.out.println("Hello");

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(false, true);

		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		
		sa.assertAll(); //mandatory

	}

}
