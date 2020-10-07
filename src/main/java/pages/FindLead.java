package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificMethods;

public class FindLead extends ProjectSpecificMethods{
	public FindLead(WebDriver driver) {
		this.driver=driver;
	}
	
	public FindLead enterFirstName() {
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("sugumar");
		return this;
	}
	
	public FindLead clickFindLeadbutton() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		return this;
	}

	
	public ViewLead clickFirstRecord() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/child::a)[1]")).click();
		Thread.sleep(2000);
		return new ViewLead(driver);
	}
}
