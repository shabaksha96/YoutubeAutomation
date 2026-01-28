package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContentPage extends BasePage{
	
	//Constructor
		public ContentPage(WebDriver driver) 
		{
			super(driver);
		}
		
	//locators
		
		
		@FindBy(xpath="//div[@id='actions']//like-button-view-model/toggle-button-view-model/button-view-model/button/yt-touch-feedback-shape[@class='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response']/div[@class='yt-spec-touch-feedback-shape__fill']")
		WebElement likeButton;
		
		@FindBy(xpath="//ytd-watch-metadata//dislike-button-view-model//div[@class='yt-spec-touch-feedback-shape__fill']")
		WebElement dislikeButton;
		
		@FindBy(xpath="//*[@id='simplebox-placeholder']")
		WebElement addCmd;
		
		@FindBy(xpath="//ytd-button-renderer[@id='submit-button']//button")
		WebElement submit;
		
		@FindBy(xpath="//ytd-button-renderer[@id='cancel-button']//button")
		WebElement cancel;
		
		@FindBy(xpath="//ytd-comments[@id='comments']//ytd-comment-thread-renderer[1]//div[1]//ytd-comment-view-model[1]//div[3]//div[3]//ytd-menu-renderer[1]//yt-icon-button[1]//button")
		WebElement menu;
		
		@FindBy(xpath="//ytd-menu-navigation-item-renderer[@class='style-scope ytd-menu-popup-renderer']")
		WebElement dltOption;
		
		@FindBy(xpath="//yt-button-renderer[@id='confirm-button']//button")
		WebElement confirmDlt;
		
		@FindBy(xpath="//yt-formatted-string[text()='Sign out']")
		WebElement signout;
		
		@FindBy(xpath="//ytd-masthead//a[@title='YouTube Home']")
		WebElement logo;
		
		@FindBy(xpath="//button[@aria-label='Clear search query']")
		WebElement clear;
		
		@FindBy(xpath="//button[@id='avatar-btn']")
		WebElement accountMenu;
		
		@FindBy(xpath="//ytd-button-renderer[@class='style-scope ytd-masthead']//a[@aria-label='Sign in']")
		WebElement signIn;
		
		@FindBy(xpath="//button[@class='ytp-play-button ytp-button']")
		WebElement playback;
		
		@FindBy(xpath="//button[@data-title-no-tooltip='Play']")
		WebElement playButto;
		
		@FindBy(xpath="//button[@data-title-no-tooltip='Pause']")
		WebElement pauseButton;
		
		@FindBy(xpath="//button[@class='ytp-volume-icon ytp-button']")
		WebElement volButton;
		
		@FindBy(xpath="//button[contains(@aria-label, 'Subtitles')]")
		WebElement sub;
		
		@FindBy(xpath="//button[@data-tooltip-title='Settings']")
		WebElement setting;
		
		@FindBy(xpath="//div[contains(text(), 'Quality')]//parent::div[@class='ytp-menuitem']")
		WebElement qualityOption;
		
		
	//Methods
		public void interuptSetting()
		{
			setting.click();
			System.out.println("Setting selected");
		}
		
		public void interuptVideo() throws InterruptedException
		{
			Thread.sleep(1000);
			String playback_status = playback.getAttribute("data-tooltip-title");
			if(playback_status.contains("Play"))
			{
				playButto.click();
				System.out.println("Video is playing");
			}
			else if(playback_status.contains("Pause"))
			{
				pauseButton.click();
				System.out.println("Video is paused");
			}
		}
		
		public void volume() throws InterruptedException
		{
			Thread.sleep(1000);
			String vol_status = volButton.getAttribute("aria-label");
			if(vol_status.contains("Unmute"))
			{
				System.out.println("Volume button click");
				volButton.click();
				System.out.println("Video playing with audio");
			}
			else if(vol_status.contains("Mute"))
			{
				System.out.println("Volume button click");
				volButton.click();
				System.out.println("Video palying in Mute");
			}
		}
		
		public void captions() throws InterruptedException
		{
			Thread.sleep(1000);
			String sub_status = sub.getAttribute("aria-pressed");
			if(sub_status == "true")
			{
				System.out.println("Caption is ON");
				sub.click();
			}
			else if(sub_status == "false")
			{
				System.out.println("Caption is ON");
				sub.click();
			}
		}
		
		public void clickLike()
		{
			likeButton.click();
		}
		
		public String signInCheck()
		{
			String label = signIn.getAttribute("aria-label");
			System.out.println("Signin option is found, so existing account is signed out");
			return label;
		}
		
		public void searchClear()
		{
			clear.click();
		}
		
		public void clickDislike()
		{
			dislikeButton.click();
		}
		
		public void addcmd() throws InterruptedException
		{
			addCmd.sendKeys("full entertainment..");
			cancel.click();
			Thread.sleep(1000);
			addCmd.sendKeys("full entertainment.... Awesome!!");
			submit.click();
		}
		
		public void dltCmd() throws InterruptedException
		{
			Thread.sleep(1000);
			menu.click();
			dltOption.click();
			Thread.sleep(1000);
			confirmDlt.click();
		}
		
		public void account()
		{
			accountMenu.click();
		}
		
		public void signoutTest()
		{
			signout.click();
		}
		
		public void youtube()
		{
			logo.click();
		}
}
