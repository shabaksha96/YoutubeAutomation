package testCase;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.io.File;

public class BaseTest {
	public WebDriver driver;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{
		String profilePath = "/Users/shabeerbaksha/Library/Application Support/Firefox/Profiles/9nwed4ac.default-release";
        FirefoxProfile profile = new FirefoxProfile(new File(profilePath));
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

		switch (br) {
        case "chrome" -> driver = new ChromeDriver();
        case "firefox" -> driver = new FirefoxDriver(options);
        case "edge" -> driver = new EdgeDriver();
        default -> throw new IllegalArgumentException("Unsupported browser: " + br);
    }
		driver.get("https://www.youtube.com/");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@AfterClass
	public void teardown() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.quit();
	}
	

}
