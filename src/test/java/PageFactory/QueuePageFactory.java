package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QueuePageFactory {
	WebDriver driver;
	
	@FindBy(xpath=("//a[@href = 'queue']"))
	WebElement btn_Queue;
	
	@FindBy (xpath=("//a[@href='Implementation-array']"))
	WebElement link_Implementationarray;
	
	@FindBy (xpath=("//a[@href='/tryEditor']"))
	WebElement btn_tryEditor;
	
	@FindBy (xpath=("//form[@id='answer_form']/div/div/div/textarea"))
	WebElement text_printArea;
	
	@FindBy (xpath=("//*[@id=\"answer_form\"]/button"))
	WebElement btn_Run;
	
	
	@FindBy (xpath=("//a[@href='implementation-lists']"))
	WebElement link_implementLists;
			
			
	@FindBy (xpath=("//a[@href='implementation-collections']"))
	WebElement link_implementCollections;
	
	@FindBy (xpath=("//a[@href='QueueOp']"))
	WebElement link_QueueOp;
	
	public QueuePageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickQueue() {
		btn_Queue.click();
	}
	
	public void clickImplementationarray() {
		link_Implementationarray.click();
	}

	public void clicktryEditor() {
		btn_tryEditor.click();
	}
	
	public void PrintText(String text) {
		text_printArea.sendKeys(text);
	}
	
	public void ClickRun() {
		btn_Run.click();
	}
	
	public void clickAlert(WebDriver driver) {
		driver.switchTo().alert();
	}
	
	public void clickImplementLists() {
		link_implementLists.click();
	}
	
	public void clickImplementCollections() {
		link_implementCollections.click();
	}
	
	public void clickQueueOp() {
		link_QueueOp.click();
	}
}


