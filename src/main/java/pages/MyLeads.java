package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificMethods;

public class MyLeads extends ProjectSpecificMethods {
	public MyLeads(WebDriver driver){
		this.driver=driver;
	}
	
	public CreateLead clickCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLead(driver);
	}
	
	public FindLead clickFindLead() {
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		return new FindLead(driver);
	}
}
