package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

	//Constructor
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	

	//locators
	@FindBy(xpath="//a[@aria-label='Sign in']//yt-touch-feedback-shape[@class='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--overlay-touch-response']//div[@class='yt-spec-touch-feedback-shape__fill']")
	WebElement signinbutton;
	
	@FindBy(xpath="//span[text()='Sign in']")
	WebElement signinPage;
	
	@FindBy(xpath="//input[@id='identifierId']")
	WebElement enterEmail;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement next;
	
	@FindBy(xpath="//button[@id='avatar-btn']")
	WebElement accountMenu;
	
	@FindBy(xpath="//yt-formatted-string[text()='Sign out']")
	WebElement signout;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchInput;
			
	@FindBy(xpath="//a[@id='video-title' and contains(@href, 'YrXAUN3p1IM')]")
	WebElement content;
	
	@FindBy(xpath="//button[@aria-label='Clear search query']")
	WebElement clear;
	
	@FindBy(xpath="//ytd-guide-section-renderer//a[@id='endpoint' and @title='Shorts']")
	WebElement shorts;
	
	@FindBy(xpath="//button[@aria-label='Next video']")
	WebElement nextVideo;
	
	@FindBy(xpath="//button[@aria-label='Previous video']")
	WebElement preVideo;
	
	@FindBy(xpath="//like-button-view-model//label//button")
	WebElement like;
	
	@FindBy(xpath="//ytd-menu-renderer//yt-button-shape//button[@aria-label='More actions']")
	WebElement shortsOption;
	
	@FindBy(xpath="//tp-yt-paper-item[not(contains(@aria-label,'Send feedback'))]//parent::a[@class='yt-simple-endpoint style-scope ytd-menu-navigation-item-renderer']")
	WebElement saveToPlaylist;
	
	@FindBy(xpath="//yt-list-item-view-model[@aria-label='Watch later, Private, Not selected']")
	WebElement watchLaterIcon;
	
	@FindBy(xpath="//button[@aria-label='Mute']")
	WebElement mute;
	
	
	//Methods
	public String titleCheck()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public void clickSigninButton()
	{
	signinbutton.click();
	}
	
	public String checkSiginText()
	{
		String txtSignin =signinPage.getText();
		return txtSignin;
	}
	
	public void emailSignin()
	{
		enterEmail.sendKeys("shabeerbaksha@gmail.com");
		next.click();
	}
	
	public void account()
	{
		accountMenu.click();
	}
	
	public boolean signout()
	{
		return signout.isDisplayed();
	}
	
	public void search()
	{
		searchInput.sendKeys("vj siddhu vlogs kodaikanal series"+Keys.ENTER);	
	}
	
	public void play()
	{
		content.click();
	}
	
	public void searchClear()
	{
		clear.click();
	}
	
	public void clickShorts()
	{
		shorts.click();
	}
	
	public void next()
	{
		nextVideo.click();
	}
	
	public void prev()
	{
		preVideo.click();
	}
	
	public void inputShorts() throws InterruptedException
	{
		like.click();
		shortsOption.click();
		Thread.sleep(1000);
		saveToPlaylist.click();
		Thread.sleep(1000);
		watchLaterIcon.click();
		mute.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
