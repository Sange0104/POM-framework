package Testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import PageObjects.QueuemodPage;
import PageObjects.loginPage;
import Utils.DataUtils;

public class Queuemod_PageObjects_TC {
	@Test(dataProviderClass = DataUtils.class,dataProvider = "LoginData")
	public void login(String uName, String pWord) throws IOException {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ranjith\\chromedriver\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		  driver.get("http://dsportalapp.herokuapp.com/");
		  driver.manage().window().maximize();
		 
		//login into Queue module
		  //loginPage loginpage = new loginPage();
		  loginPage.clickGetStarted(driver).click();
		  loginPage.clickQueue(driver).click();
		  Reporter.log("You are not logged in");
		  
		  //Capture screen shot for the message
		  	TakesScreenshot ts = (TakesScreenshot)driver; //Typecasting to TakesScreenshot interface
			File sourcepath = ts.getScreenshotAs(OutputType.FILE); //Temporary Location
			ts.getScreenshotAs(OutputType.FILE);
			File targetpath = new File(".\\screenshots\\pages34.png"); //Specifying the file path to save
			FileUtils.copyFile(sourcepath, targetpath); //Copying the file
			Reporter.log("Taken the Screenshot successfully");
			  
		  loginPage.clickSignIn(driver).click();
		  loginPage.enterUser(driver).sendKeys(uName);
		  loginPage.enterPassword(driver).sendKeys(pWord);
		  loginPage.clickSignin(driver).click();
		  Reporter.log("You are logged in Numpy Ninja home page"); 
		   //QueuemodPage queuemodpage = new QueuemodPage();
		  loginPage.clickQueue(driver).click();
		  Reporter.log("You are logged into Queue module");
		  
	 //Click Implement Array link
		  QueuemodPage.clickImplementArray(driver).click();
		  Reporter.log("The Implementation Array page is displayed");
		  QueuemodPage.clickTryEditor(driver).click();
		  QueuemodPage.printArea(driver).sendKeys("print 'hello';"); //Sending Valid data in editor
		  QueuemodPage.clickPrint(driver).click();
		  
		  driver.navigate().refresh();
		  QueuemodPage.printArea(driver).sendKeys("rtef';"); //Sending InValid data in editor
		  QueuemodPage.clickPrint(driver).click();
		 
		  Alert alert = driver.switchTo().alert();
		  alert.accept();
		  
		  Reporter.log("Alert OK button is selected using the Accept method successsfully");
		  driver.navigate().back();
		  driver.navigate().refresh();
		  driver.navigate().back();
		  
	//Click Implementation-lists link
		  QueuemodPage.clickImplementLists(driver).click();
		  Reporter.log("The Implementation lists page is displayed");
		  QueuemodPage.clickTryEditor(driver).click();
		  QueuemodPage.printArea(driver).sendKeys("print 'hello';");
		  QueuemodPage.clickPrint(driver).click();
		  driver.navigate().back();
		  driver.navigate().refresh();
		  driver.navigate().back();
		  
	//Click Implementation collections link
		  QueuemodPage.clickImplementcollectiondeque(driver).click();
		  Reporter.log("The Implementation collections page is displayed");
		  QueuemodPage.clickTryEditor(driver).click();
		  QueuemodPage.printArea(driver).sendKeys("print 'hello';");
		  QueuemodPage.clickPrint(driver).click();
		  driver.navigate().back();
		  driver.navigate().refresh();
		  driver.navigate().back();
		  
	//Click QueueOperations link
		  QueuemodPage.clickQueueOp(driver).click();
		  Reporter.log("The Queue Operations page is displayed");
		  QueuemodPage.clickTryEditor(driver).click();
		  QueuemodPage.printArea(driver).sendKeys("print 'hello';");
		  QueuemodPage.clickPrint(driver).click();
		  driver.navigate().back();
		  driver.navigate().refresh();
		  driver.navigate().back(); 
		  
		  driver.close();
		  driver.quit();
	}

}
