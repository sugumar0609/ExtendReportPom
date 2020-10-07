package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificMethods;

public class ViewLead extends ProjectSpecificMethods {
	public ViewLead(WebDriver driver){
		this.driver=driver;
	}
	
	public ViewLead verifyLeadname() {
		String companyName=driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(companyName);
		return this;
	}
	public EditLead clickEditButton() {
		driver.findElement(By.xpath("//*[text()='Edit']")).click();
		return new EditLead(driver);
	}
	
}
