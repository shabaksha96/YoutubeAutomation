package testCase;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.AssertJUnit;
import pageObject.ContentPage;
import pageObject.HomePage;

public class TC_002_TestContentModule extends BaseTest{
	
	@Test(priority=1)
	public void Test_searchContent() throws InterruptedException
	{
		HomePage yt = new HomePage(driver);
		boolean status= true;
		yt.search();
		System.out.println("Content search success");
		Assert.assertEquals(status, true);
	}
	
	@Test(priority=2)
	public void Test_playContent() throws InterruptedException
	{
		HomePage yt = new HomePage(driver);
		boolean sta1 = true;
		yt.play();
		Thread.sleep(3000);
		String title = driver.getTitle();
		if(title.equals("Kodaikanal Series Re-release Full Movie 🔥 | 4K | Vj siddhu vlogs - YouTube"))
		{
			System.out.println("Video playing");
			sta1 = true;
		}
		else
		{
			System.out.println("Video not playing");
			sta1 = false;
		}
		AssertJUnit.assertEquals(sta1, true);
	}
	
	@Test(priority=3)
	public void Test_likeButton() throws InterruptedException
	{
		ContentPage cp = new ContentPage(driver);
		Thread.sleep(1000);
		cp.clickLike();
		cp.clickDislike();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 770);");
		System.out.println("reached Add comment");
		cp.addcmd();
		System.out.println("Added cmt");
		Thread.sleep(1000);
		cp.dltCmd();
		System.out.println("cmt deleted");
	}
	
	@Test (priority =4)
	public void Test_Movehome()
	{
		ContentPage cp = new ContentPage(driver);
		cp.youtube();
		System.out.println("moved to home");
		Assert.assertTrue(true);	
	}
	
	@Test (priority =5)
	public void Test_ClearSearch()
	{
		ContentPage cp = new ContentPage(driver);
		cp.searchClear();
		System.out.println("Search queue cleared");
		Assert.assertTrue(true);
	}
	
	@Test(priority =6)
	public void Test_Signout() throws InterruptedException
	{
		ContentPage cp = new ContentPage(driver);
		Thread.sleep(1000);
		cp.account();
		cp.signoutTest();
		Assert.assertEquals(cp.signInCheck(), "Sign in");
	}

}
