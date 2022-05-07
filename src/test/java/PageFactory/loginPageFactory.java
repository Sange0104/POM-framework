package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageFactory {
	WebDriver driver;
	@FindBy (className="btn")
	WebElement btn_getStarted;
	
	@FindBy(xpath=("//a[@href = 'queue']"))
	WebElement btn_Queue;
	
	@FindBy(linkText = "Sign in")
	WebElement link_signIn;
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = ("//input[@type='submit']"))
	WebElement btn_submit;
	
	public loginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		}

	public void clickGetStartedButton() {
		btn_getStarted.click();
	}
	
	public void clickQueueButton() {
		btn_Queue.click();
	}
	
	public void clickSignIn() {
		link_signIn.click();
	}
	
	public void setUserName(String uname) {
		username.sendKeys(uname);
	}
	
	public void setPassword(String pword) {
		password.sendKeys(pword);
	}
	
	public void clickSubmit() {
		btn_submit.click();
	}
	public void loginDsAlgo(String uname ,String pword ) {
		this.setUserName(uname);
		this.setPassword(pword);
		this.clickSubmit();
	}

	
}
