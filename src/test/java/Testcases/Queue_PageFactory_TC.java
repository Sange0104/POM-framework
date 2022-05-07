package Testcases;

import org.testng.annotations.Test;

import PageFactory.QueuePageFactory;
import ParallelTests.CrossBrowserTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Queue_PageFactory_TC extends CrossBrowserTests {		//Login_PageFactory_TC
	//WebDriver driver;
	QueuePageFactory objQueuePF; 
	
  @Test
  public void Queuemodule() {
	  objQueuePF = new QueuePageFactory(driver);
	  objQueuePF.clickQueue();
	  Reporter.log("You are logged into Queue module");
	  
	  //link ImplementationArray
	  objQueuePF.clickImplementationarray();
	  Reporter.log("The Implementation Array page is displayed");
	  objQueuePF.clicktryEditor();
	  objQueuePF.PrintText("print 'hello';"); //sending valid data to print
	  objQueuePF.ClickRun();
	  driver.navigate().refresh();
	  objQueuePF.PrintText("Invalid data"); //sending invalid data to print
	  objQueuePF.ClickRun();
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
	  Reporter.log("Alert OK button is selected using the Accept method successsfully");
	  
	  driver.navigate().back();
	  driver.navigate().back();
	 
	  //link QueueOp
	  objQueuePF.clickQueueOp();
	  Reporter.log("The Queue Operations page is displayed");
	  objQueuePF.clicktryEditor();
	  objQueuePF.PrintText("print 'hello';");
	  objQueuePF.ClickRun();
	  
	  driver.navigate().back();
	  driver.navigate().back();
	  
	  //ImplementationLists
	  objQueuePF.clickImplementLists();
	  Reporter.log("The Implementation lists page is displayed");
	  objQueuePF.clicktryEditor();
	  objQueuePF.PrintText("print 'hello';");
	  objQueuePF.ClickRun();
	  driver.navigate().back();
	  driver.navigate().back();
	  
	  //ImplementationCollections
	  objQueuePF.clickImplementCollections();
	  Reporter.log("The Implementation collections page is displayed");
	  objQueuePF.clicktryEditor();
	  objQueuePF.PrintText("print 'hello';");
	  objQueuePF.ClickRun();
	  driver.navigate().back();
	  driver.navigate().back();
	  
	  
  }
  
  @AfterTest
  public void afterTest() {
	  driver.close();
	  driver.quit();
  }

}
