package Queue;

import org.testng.annotations.Test;

import Utils.DataUtils;
import Utils.XLUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class logintoQueue {
	static WebDriver driver = null;
		

  @Test(dataProviderClass = DataUtils.class,dataProvider = "LoginData",priority =1)
  public void loginQueue(String uName,String pWord) throws InterruptedException, IOException {
	  
	  driver.findElement(By.xpath("//button[@class='btn']")).click(); //Click on Get started button
		 
	  	System.out.println("The dsPortal home page is opened");
	  	driver.findElement(By.xpath("//a[@href = 'queue']")).click();
	  	System.out.println("You are not logged in");
		 
	  	//Capture screen shot for the message
	  	TakesScreenshot ts = (TakesScreenshot)driver; //Typecasting to TakesScreenshot interface
		  File sourcepath = ts.getScreenshotAs(OutputType.FILE); //Temporary Location

		  ts.getScreenshotAs(OutputType.FILE);

		  File targetpath = new File(".\\screenshots\\pages34.png"); //Specifying the file path to save
		  FileUtils.copyFile(sourcepath, targetpath); //Copying the file
		  Reporter.log("Taken the Screenshot successfully");
		  
	  	driver.findElement(By.linkText("Sign in")).click();
	  	 //Enter valid user name and password
		  WebElement usersign = driver.findElement(By.name("username"));
		  usersign.click();
		  usersign.sendKeys(uName);
		  WebElement pwdsign = driver.findElement(By.name("password"));
		  pwdsign.click();
		  pwdsign.sendKeys(pWord);
		  WebElement loginbutton = driver.findElement(By.xpath("//input[@type='submit']")); 
		  loginbutton.click();
		  Reporter.log("You are logged in Numpy Ninja home page");	
	
		  driver.findElement(By.xpath("//a[@href='queue']")).click();
		  Reporter.log("You are logged into Queue page");
  
  }
		
  
	  @BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ranjith\\chromedriver\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("http://dsportalapp.herokuapp.com/");
		  driver.manage().window().maximize();
	  }
	
	 @AfterTest
	  public void afterTest() {
		  driver.close();
		  driver.quit();
	  }
	
	}
