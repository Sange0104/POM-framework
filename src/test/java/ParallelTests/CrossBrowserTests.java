package ParallelTests;

import org.testng.annotations.Test;

import PageFactory.loginPageFactory;
import Utils.DataUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class CrossBrowserTests {
	protected WebDriver driver;
	loginPageFactory objLogin;
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ranjith\\SeleniumDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Ranjith\\SeleniumDriver\\chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();
		}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://dsportalapp.herokuapp.com/home");
	}
	
	@Test(dataProviderClass = DataUtils.class,dataProvider = "LoginData")
	  public void loginintoQueue(String uname,String pword) throws InterruptedException, IOException {
		  objLogin = new loginPageFactory(driver);
		  objLogin.clickGetStartedButton();
		  objLogin.clickQueueButton();
		  Reporter.log("You are not logged in");
		  
		  //Capture screen shot for the above message
		  	TakesScreenshot ts = (TakesScreenshot)driver; //Typecasting to TakesScreenshot interface
			File sourcepath = ts.getScreenshotAs(OutputType.FILE); //Temporary Location
			ts.getScreenshotAs(OutputType.FILE);
			File targetpath = new File(".\\screenshots\\pages100.png"); //Specifying the file path to save
			FileUtils.copyFile(sourcepath, targetpath); //Copying the file
			Reporter.log("Taken the Screenshot successfully");
			
		  objLogin.clickSignIn();
		  objLogin.loginDsAlgo(uname, pword);
		 System.out.println("User logged in");
		 Reporter.log("You are logged in Numpy Ninja home page"); 
	  }

}
