package com.qa.dt.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.dt.base.BaseClass;
import com.qa.dt.util.Xls_Reader;

/**
 * Login Page Elements
 * 
 * @author VasuSekar
 *
 */
public class LoginPage extends BaseClass {
	static Xls_Reader reader;
	
	public LoginPage() {
		reader	= new Xls_Reader();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div[@class='logo'])[1]")
	private WebElement invicaraLogo;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userName;

	@FindBy(xpath = "(//button[@class='primary'])[1]")
	private WebElement loginButton;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passWord;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-warning']")
	private WebElement invalidUserNameErrorMsg;
	
	@FindBy(xpath = "(//button[@class='secondary'])[1]")
	private static WebElement SignUpButton;
	
	@FindBy(xpath = "//h1[text()='Sign In']")
	private static WebElement SignInHeaderName;
	

	public boolean invicaroLogoIsDisplayed() throws Exception {
		boolean displayed = invicaraLogo.isDisplayed();
		return displayed;
	}
	public boolean SignInNameIsDisplayed() throws Exception {
		boolean displayed = SignInHeaderName.isDisplayed();
		return displayed;
	}
	/**
	 * Enter The User Name For Login
	 * 
	 * @param uName Login User Name
	 * @throws Exception
	 */
	public void enterUserName(String uName) throws Exception {
//		elementSendKeys(userName, uName);
		sendKeysJavascript(userName, uName);
		elementClick(loginButton);
	}
	/**
	 * To Enter The Password For Login To click The Login Button
	 * 
	 * @param upassWord Login Password
	 * @return 
	 * @return 
	 * @return Return To Home Page
	 * @throws Exception
	 */
	public ProjectSelectionPage enterPassword(String psw) throws Exception {
		waitUntilElementVisibility(passWord);
		elementSendKeys(passWord, psw);
		elementClick(loginButton);
		return new ProjectSelectionPage();
	}
	public void LoginTest(String uName,String psw ) throws Exception {
		sendKeysJavascript(userName, uName);
		elementClick(loginButton);
		Thread.sleep(5000);
		if (passWord.isDisplayed()) {
			elementSendKeys(passWord, psw);
			elementClick(loginButton);
			Thread.sleep(3000);
		}
		else if (invalidUserNameErrorMsg.isDisplayed()) {
			System.out.println("Invalide User Name");
		}
		
	}
	/**
	 * To Click The SignUp Button
	 * @return
	 * @throws Exception
	 */
	
	public void clickSignUp() throws Exception {
		elementClick(SignUpButton);
	}


}
