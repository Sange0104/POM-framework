package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QueuemodPage {
	

	
	public static WebElement clickImplementArray(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@href='Implementation-array']"));
	}
	
	public static WebElement clickTryEditor(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@href='/tryEditor']"));
	}
	
	public static WebElement printArea(WebDriver driver) {
		return driver.findElement(By.xpath("//form[@id='answer_form']/div/div/div/textarea"));
	}
	
	public static WebElement clickPrint(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"answer_form\"]/button"));
	}
	
	public void clickAlert(WebDriver driver) {
		driver.switchTo().alert();
	}
	
	public static WebElement clickImplementLists(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@href='implementation-lists']"));
	}
	
	public static WebElement clickImplementcollectiondeque(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@href='implementation-collections']"));
	}

	public static WebElement clickQueueOp(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@href='QueueOp']"));
	}
}
