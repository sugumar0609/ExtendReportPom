package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificMethods;

public class MyHome extends ProjectSpecificMethods {
	public MyHome(WebDriver driver){
		this.driver=driver;
	}
	
	public MyLeads clickLeads() {
		driver.findElement(By.linkText("Leads")).click();
		return new MyLeads(driver);
	}
}
