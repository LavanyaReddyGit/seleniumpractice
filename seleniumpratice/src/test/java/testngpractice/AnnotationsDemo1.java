package testngpractice;

import org.testng.annotations.Test;

public class AnnotationsDemo1 {
  @Test(priority=-1)
  public void openApplication() 
  {
	  System.out.println("open the application");
  }
  @Test(priority=1)
  public void serachProduct()
  {
	  System.out.println("search for a product");
  }
  @Test(priority=2)
  public void logoutFromApp()
  {
	  System.out.println("logout from the application");
  }
  @Test(priority=0)
  public void logintotheAPP()
  {
	  System.out.println("login to the application");
  }
}
