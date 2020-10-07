package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class LoginAndLogout extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setFileName() {
		excelFileName="createlead";
		TCName="Login";
		TCDes="Login valid details";
		Author="sugumar";
		cate="smoke";
		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void loginlogout(String username,String password) throws IOException  {
		LoginPage lp=new LoginPage(driver);
		/*
		 * lp.enterUsername().enterPassword().clickLogin().clickLink().clickLeads()
		 * .clickCreateLead().enterCompanyName().enterFirstName().enterLastName()
		 * .clickCreateLeadButton().verifyLeadname();
		 */

		
		lp.enterUsername(username).enterPassword(password).clickLogin();
	}
	
	
	
}
