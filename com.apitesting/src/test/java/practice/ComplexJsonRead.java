package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import file.PayLoad;

public class ComplexJsonRead {
	
	
	@Test
	public void coursesTest()
	{
		JsonPath js=new JsonPath(PayLoad.coursesResponse());
		
		//1.Print No.of courses returned by API
		
		int count=js.getInt("courses.size()");
		System.out.println("Courses count  :"+count);
		
		
		//2.Print Purchase Amount
		
		int purchaseAmount=js.getInt("dashboard.purchaseAmount");
		
		System.out.println("purchaseAmount: "+purchaseAmount);
		
		//3.Print Title of the First course
		
		
		String firstCourse=js.getString("courses[0].title");
		System.out.println("firstCourse :"+firstCourse);
		
		
		//4.Print All course titles and their respective Prices
		
		
		for(int i=0;i<count;i++)
		{
			String titles=js.get("courses["+i+"].title");
			int prices=js.getInt("courses["+i+"].price");
			System.out.println(titles);
			System.out.println(prices);
			
		}
		
		
		//5.Print no of copies sold by RPA Course
		
		for(int i=0;i<count;i++)
		{
			String title=js.get("courses["+i+"].title");
			if(title.equalsIgnoreCase("RPA"))
			{
				int rpaCopies=js.getInt("courses["+i+"].copies");
				System.out.println("RPA Copies"+rpaCopies);
				break;
				
			}
			
				
		}
		
		
		
		
		
		
		
	}

	

}
