package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class EditLead extends ProjectSpecificMethods{
	

@Test(dataProvider = "fetchData")
public void runEditLead(String username,String password) throws InterruptedException, IOException {
	LoginPage lp=new LoginPage(driver);
	lp.enterUsername(username).enterPassword(password).clickLogin()
	.clickLink().clickLeads().clickFindLead().enterFirstName()
	.clickFindLeadbutton().clickFirstRecord().clickEditButton()
	.enterCompanyName().clickUpdatebutton().verifyLeadname();
}

}
