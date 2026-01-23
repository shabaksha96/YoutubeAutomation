package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import pageObject.HomePage;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.io.File;

public class WorkClass {
	
	@Test
	public void workClass() throws InterruptedException {
		
		String profilePath = "/Users/shabeerbaksha/Library/Application Support/Firefox/Profiles/9nwed4ac.default-release";
        FirefoxProfile profile = new FirefoxProfile(new File(profilePath));
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

		WebDriver drivers = new FirefoxDriver(options);
		drivers.get("https://www.youtube.com/");
		drivers.manage().window().maximize();
		drivers.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//Test 1
		Thread.sleep(3000);
		String title =drivers.getTitle();
		if(title.equals("YouTube"))
		{
			System.out.println("Page title is: "+title);
		}
		else
		{
			System.out.println("Page title mismatch");
		}
		
		//Test2
		Thread.sleep(3000);
		drivers.findElement(By.xpath("//button[@aria-label='Account menu']")).click();
		Boolean status = drivers.findElement(By.xpath("//yt-formatted-string[text()='Sign out']")).isDisplayed();
		if(status==true)
		{
			System.out.println("ready with sign-in");
		}
		else
		{
			System.out.println("Not signed in");
		}
		
		//Test3
		Thread.sleep(3000);
		drivers.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("vj siddhu vlogs kodaikanal series"+Keys.ENTER);
		System.out.println("Content search success");
		Thread.sleep(3000);
		
		
		//Test4
		Thread.sleep(3000);
		drivers.findElement(By.xpath("//a[@id='video-title' and contains(@href, 'YrXAUN3p1IM')]")).click();
		System.out.println("Playback started");
		Thread.sleep(3000);
		String txt = drivers.getTitle();
		Assert.assertEquals("Kodaikanal Series Re-release Full Movie 🔥 | 4K | Vj siddhu vlogs - YouTube", txt);
		
		//Test5
		Thread.sleep(3000);
		drivers.findElement(By.xpath("//div[@id='actions']//like-button-view-model/toggle-button-view-model/button-view-model/button/yt-touch-feedback-shape[@class='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response']/div[@class='yt-spec-touch-feedback-shape__fill']")).click();
		drivers.findElement(By.xpath("//ytd-watch-metadata//dislike-button-view-model//div[@class='yt-spec-touch-feedback-shape__fill']")).click();
		
		
		JavascriptExecutor js = (JavascriptExecutor) drivers;
		js.executeScript("window.scrollTo(0, 770);");
		System.out.println("reached Add comment");
		Thread.sleep(3000);
		drivers.findElement(By.xpath("//*[@id='simplebox-placeholder']")).sendKeys("full entertainment");
		drivers.findElement(By.xpath("//ytd-button-renderer[@id='cancel-button']//button")).click();
		System.out.println("cmd cancel");
		drivers.findElement(By.xpath("//*[@id='simplebox-placeholder']")).sendKeys("full entertainment.... Awesome!!");
		drivers.findElement(By.xpath("//ytd-button-renderer[@id='submit-button']//button")).click();
		System.out.println("cmd submit");
		drivers.findElement(By.xpath("//ytd-comments[@id='comments']//ytd-comment-thread-renderer[1]//div[1]//ytd-comment-view-model[1]//div[3]//div[3]//ytd-menu-renderer[1]//yt-icon-button[1]//button")).click();
		drivers.findElement(By.xpath("//ytd-menu-navigation-item-renderer[@class='style-scope ytd-menu-popup-renderer']")).click();
		Thread.sleep(3000);
		drivers.findElement(By.xpath("//yt-button-renderer[@id='confirm-button']//button")).click();
		System.out.println("cmd dlt");
		
	}

}
