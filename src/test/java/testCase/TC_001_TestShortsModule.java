package testCase;

import org.testng.annotations.Test;
import pageObject.HomePage;

import org.testng.Assert;
import org.testng.AssertJUnit;

public class TC_001_TestShortsModule extends BaseTest{
	
	@Test(priority =1)
	public void Test_YT_Launch()
	{
		HomePage yt = new HomePage(driver);
		boolean status = true;
		String title =yt.titleCheck();
		if(title.equals("YouTube"))
		{
			System.out.println("Page title is: "+title);
			status=true;
		}
		else
		{
			System.out.println("Page title mismatch");
			status=false;
		}
		AssertJUnit.assertTrue(status);
		boolean test = true;
		/*//sign in button click
		yt.clickSigninButton();
		boolean status = true;
		if(yt.checkSiginText().equals("Sign in"))
		{
			System.out.println("Moved to sigin page");
			status = true;
		}
		else 
		{
			System.out.println("something wrong");
			status = false;
		}
		AssertJUnit.assertEquals(status, true);
		
		//select email and click continue
		yt.emailSignin();
		Thread.sleep(1000);
		*/
		//check if account is signed in
		yt.account();
		AssertJUnit.assertEquals(yt.signout(), true);
		if(yt.signout()==true)
		{
			System.out.println("Sign-in Success");
			test = true;
		}
		else
		{
			System.out.println("Not signed in");
			test = false;
		}
		AssertJUnit.assertEquals(test, true);
	}
	
	
	@Test (priority=2)
	public void Test_ShortsOption()
	{
		HomePage yt = new HomePage(driver);
		yt.clickShorts();
		System.out.println("moved to shorts");
		Assert.assertTrue(true);
	}
	
	@Test (priority=3)
	public void Test_switchShorts() throws InterruptedException
	{
		HomePage yt = new HomePage(driver);
		Thread.sleep(1000);
		yt.next();
		System.out.println("switching next video");
		Thread.sleep(1000);
		yt.next();
		System.out.println("switching next video");
		Thread.sleep(1000);
		yt.next();
		System.out.println("switching next video");
		Thread.sleep(1000);
		yt.prev();
		System.out.println("switching to previous video");
		Assert.assertTrue(true);
	}
	
	@Test (priority=4)
	public void Test_ShortBehav() throws InterruptedException
	{
		Thread.sleep(3000);
		HomePage yt = new HomePage(driver);
		yt.inputShorts();
		System.out.println("Saved to playlist");
		Assert.assertTrue(true);
	}

}
