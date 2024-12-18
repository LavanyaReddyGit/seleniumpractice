package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import file.PayLoad;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	
	//6.Verify if sum of all course prices matches with purchase amount
			@Test
			public void sumValidation()
			
			{
				int sum=0;
				JsonPath js=new JsonPath(PayLoad.coursesResponse());
				
				//1.Print No.of courses returned by API
				
				int count=js.getInt("courses.size()");
				System.out.println("Courses count  :"+count);
				
					
					for(int i=0;i<count;i++)
					{
						int price=js.getInt("courses["+i+"].price");
						int copies=js.getInt("courses["+i+"].copies");
						int amount=price*copies;
						System.out.println(amount);
						sum=sum+amount;
					}
					  System.out.println(sum);
						
						int actualAmount=js.getInt("dashboard.purchaseAmount");
						Assert.assertEquals(actualAmount, sum);
						
						System.out.println("Test case passed successfully");
							
					
					
				}
			}
			


