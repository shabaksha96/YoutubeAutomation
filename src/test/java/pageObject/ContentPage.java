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
		
		
	//Methods
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
		
		public void addcmd()
		{
			addCmd.sendKeys("full entertainment..");
			cancel.click();
			addCmd.sendKeys("full entertainment.... Awesome!!");
			submit.click();
		}
		
		public void dltCmd() throws InterruptedException
		{
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
