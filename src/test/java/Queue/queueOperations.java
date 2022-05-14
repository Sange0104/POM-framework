package Queue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.server.Response.OutputType;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import Utils.DataUtils;
import Utils.XLUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class queueOperations {
	WebDriver driver =null;

  @Test(dataProviderClass = DataUtils.class,dataProvider = "LoginData")
  public void QueueOPeration(String uName,String pWord) throws InterruptedException {
	  //Click on Get started button
		  driver.findElement(By.xpath("//button[@class='btn']")).click();
			 
		  System.out.println("The dsPortal home page is opened");
		  driver.findElement(By.xpath("//a[@href = 'queue']")).click();
		  System.out.println("You are not logged in");
	  	
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
	//Click Queue OPerations link 
	  driver.findElement(By.xpath("//a[@href='QueueOp']")).click();
	  Reporter.log("The  Queue OPeration page is displayed");
	 //Click TryEditor link
	  driver.findElement(By.xpath("//a[@href='/tryEditor']")).click();  //Click Tryhere button
	  Thread.sleep(2000);
	
	  //Enter valid python code
	  	driver.findElement(By.xpath("//form[@id='answer_form']/div/div/div/textarea")).sendKeys("print 'hello';");
  		Thread.sleep(3000);
  		driver.findElement(By.xpath("//*[@id=\"answer_form\"]/button")).click();
  		Thread.sleep(3000);
	 
  		driver.navigate().refresh();
  		driver.navigate().back();
  		driver.navigate().forward();
	//Enter invalid python code
	  driver.findElement(By.xpath("//form[@id='answer_form']/div/div/div/textarea")).sendKeys("rtef';");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"answer_form\"]/button")).click();
	  Thread.sleep(3000);
	  Alert alert = driver.switchTo().alert();
	  Thread.sleep(2000);
	  alert.accept(); //To select OK button
	  Thread.sleep(2000);

	  Reporter.log("Alert OK button is selected using the Accept method successsfully");

	  driver.switchTo().defaultContent();
	  driver.navigate().back();
	  driver.navigate().refresh();
	  driver.navigate().back();
	}
	
	  
  @BeforeTest
  public void beforeTest() {
	 // System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ranjith\\chromedriver\\chromedriver.exe");
	  WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	  driver.get("http://dsportalapp.herokuapp.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10,(TimeUnit.SECONDS));
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
	  driver.quit();
  }
  }

