package Queue;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class GetStartedpage {
	
	WebDriver driver = null;
  @Test
  public void getStartedPage() {
	  driver.findElement(By.xpath("//button[@class='btn']")).click(); //Click on Get started button
	  driver.manage().window().maximize();
	  System.out.println("The dsPortal home page is opened");
	  Reporter.log("The current Url of the page is :" + driver.getCurrentUrl());
	  Reporter.log("The title of the page is :" + driver.getTitle());
	  Reporter.log("The page image is down below : " + driver.getPageSource());
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
