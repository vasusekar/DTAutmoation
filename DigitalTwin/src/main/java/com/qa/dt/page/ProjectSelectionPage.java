package com.qa.dt.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.qa.dt.base.BaseClass;
import com.qa.dt.util.ExtentManager;
import com.qa.dt.util.Log;
import com.qa.dt.util.Xls_Reader;

public class ProjectSelectionPage extends BaseClass{
	public ProjectSelectionPage() {
		PageFactory.initElements(driver, this);
	}
//	WebElements
	
	
	@FindBy(xpath = "//button[text()='Load Project']")
	private static WebElement loadProjectBtn;
	
	@FindBy(xpath = "//span[text()='Project Selection']")
	private static WebElement textProjectSelection;
	
	@FindBy(xpath = "//div[@class='select__value-container select__value-container--has-value css-1hwfws3']")
	private static WebElement ProjectSelectionDd;
	
	@FindBy(xpath = "//h4[text()='User Group']//following::div[@class='select__control css-yk16xz-control']")
	private static WebElement userGroupDd;
	
	
	
	
	
//	Action Methods
	
	public boolean verifyProjectSelectionText() throws Exception {
		try {
			boolean elementIsDisplayed = elementIsDisplayed(textProjectSelection);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			ExtentManager.test.log(Status.ERROR, "Unable To Login");
			return false;
		} 
		
	}
	
	public void selectProjectFromDd(String name) throws Exception {
		waitUntilElementClickableforsec(loadProjectBtn,150);
		try {
			elementClick(ProjectSelectionDd);
			WebElement findElement = driver.findElement(By.xpath("//div[text()='"+name+"']"));
			elementClick(findElement);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	public void selectUserGroupFromDd(String name) throws Exception {
		try {
			if (elementIsDisplayed(userGroupDd)) {
				elementClick(userGroupDd);
				WebElement findElement = driver.findElement(By.xpath("//div[text()='"+name+"']"));
				elementClick(findElement);
			}
			elementClick(loadProjectBtn);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
		
	}
//	public  void clickLoadProjectBtn() {
//		try {
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		
//		}
//
//	}
//	
}
