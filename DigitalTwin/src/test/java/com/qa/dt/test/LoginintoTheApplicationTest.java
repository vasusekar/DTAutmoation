package com.qa.dt.test;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;

import com.qa.dt.base.BaseClass;
import com.qa.dt.page.LoginPage;
import com.qa.dt.util.EncryptAndDecrypt;




public class LoginintoTheApplicationTest extends BaseClass{
	static LoginPage lp;
	static Logger logger;
	
	
	
	public void browserLaunch() throws IOException, Exception {
		browser_LaunchIgnoreCase(loadProperties().getProperty("Browser"));
		Properties loadProperties = loadProperties();
		System.out.println(loadProperties.getProperty("DtUrl"));
		launchURL(loadProperties.getProperty("DtUrl"));
	}
	@BeforeClass
	public void loginTheApplication() throws Exception {
		browserLaunch();
		lp= new LoginPage();
		lp.enterUserName(loadProperties().getProperty("DtUser"));
		lp.enterPassword(EncryptAndDecrypt.passwordEncryptAndDecrypt());
	}
//	@AfterClass
	public void tearDown() {
		driverQuit();
	}
	

}
