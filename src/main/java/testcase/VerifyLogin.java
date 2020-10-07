package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class VerifyLogin extends ProjectSpecificMethods{
	@Test(dataProvider = "fetchData")
	public void loginlogout(String username,String password) throws IOException {
		LoginPage lp=new LoginPage(driver);
		lp.enterUsername(username).enterPassword(password).clickLogin().clickLink().clickLeads()
		.clickCreateLead().enterCompanyName().enterFirstName().enterLastName()
		.clickCreateLeadButton().verifyLeadname();

	}
	
	
	
}
