package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificMethods;

public class EditLead extends ProjectSpecificMethods{
	public EditLead(WebDriver driver) {
		this.driver=driver;
	}
	
	public EditLead enterCompanyName() {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Infoview");
		return this;
	}
	
	public ViewLead clickUpdatebutton() {
		driver.findElement(By.xpath("//*[@value='Update']")).click();
		return new ViewLead(driver);
	}
}
