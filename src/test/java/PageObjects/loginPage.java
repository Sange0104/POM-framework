package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	public static WebElement clickGetStarted(WebDriver driver) {
		return driver.findElement(By.xpath("//button[@class='btn']"));
	}
	
	public static WebElement clickQueue(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@href = 'queue']"));
	}
	
	public static WebElement clickSignIn(WebDriver driver) {
		return driver.findElement(By.linkText("Sign in"));
	}
	
	public static WebElement enterUser(WebDriver driver) {
		return driver.findElement(By.name("username"));
		
	}
	
	public static WebElement enterPassword(WebDriver driver) {
		return driver.findElement(By.name("password"));
	}
	
	public static WebElement clickSignin(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@type='submit']")); 	
		}

}
