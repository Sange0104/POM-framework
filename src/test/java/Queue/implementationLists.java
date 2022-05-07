package Queue;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class implementationLists extends logintoQueue{
	//WebDriver driver = null;
  @Test(priority=2)
  public void implementlists() throws InterruptedException {
	  System.out.println("Parent class values accessed successfully");
	  //Click Implementation-lists link
	  driver.findElement(By.xpath("//a[@href='implementation-lists']")).click();
	 Reporter.log("The Implementation lists page is displayed");
	 	
	  driver.findElement(By.xpath("//a[@href='/tryEditor']")).click();  //Click try here button
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
	  driver.navigate().back();
	  driver.navigate().refresh();
	  driver.navigate().back(); 
	  System.out.println("main page");
  }
  /*@BeforeTest
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
*/
}
