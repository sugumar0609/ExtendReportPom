package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificMethods;

public class CreateLead extends ProjectSpecificMethods {
	public CreateLead(WebDriver driver){
		this.driver=driver;
	}
	
	public CreateLead enterCompanyName() {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Ivtl");
		return this;
	}
	public CreateLead enterFirstName() {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("sugumar");
		return this;
	}
	public CreateLead enterLastName() {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("sugumar");
		return this;
	}
	
	public ViewLead clickCreateLeadButton() {
		driver.findElement(By.className("smallSubmit")).click();
		return new ViewLead(driver);
	}
	
	
	
		
}
