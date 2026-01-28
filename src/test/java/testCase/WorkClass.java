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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		
		WebDriverWait wait = new WebDriverWait(drivers, Duration.ofSeconds(3000));
		//Test 1
		Thread.sleep(3000);
		drivers.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("vj siddhu vlogs kodaikanal series"+Keys.ENTER);
		Thread.sleep(3000);
		drivers.findElement(By.xpath("//a[@id='video-title' and contains(@href, 'YrXAUN3p1IM')]")).click();
		Thread.sleep(3000);
		String txt = drivers.getTitle();
		Assert.assertEquals("Kodaikanal Series Re-release Full Movie 🔥 | 4K | Vj siddhu vlogs - YouTube", txt);
		WebElement play_pause = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-title-no-tooltip='Pause']")));
		play_pause.click();
		System.out.println("paused");
		WebElement setting = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ytp-settings-button')]")));
		setting.click();
		System.out.println("setting");
		WebElement quality = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Quality')]")));
		quality.click();
		System.out.println("quality click");
		
		
	
	}

}
