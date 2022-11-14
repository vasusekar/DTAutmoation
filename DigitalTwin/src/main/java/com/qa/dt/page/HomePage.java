package com.qa.dt.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.dt.base.BaseClass;

public class HomePage extends BaseClass {
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//div[@class='session-dropdown']")
	 private static WebElement SwitchProjectDd;
	
	
	@FindBy(xpath ="//div[@id='logo']")
	 private static WebElement invicaraLogo;

}
