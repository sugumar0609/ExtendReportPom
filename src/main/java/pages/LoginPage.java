package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.ProjectSpecificMethods;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage extends ProjectSpecificMethods {

	public LoginPage(WebDriver driver){
		this.driver=driver;
	}

	public LoginPage enterUsername(String username) throws IOException {
		try {
			driver.findElement(By.id("username")).sendKeys(username);
			reportStep(username+"entered successfully", "pass");
		} catch (Exception e) {
			reportStep(username+"not entered successfully", "fail");	
		}

		return this;
	}
	public LoginPage enterPassword(String password) throws IOException   {
		
		try {
			driver.findElement(By.id("password")).sendKeys(password);
			reportStep(password+"entered successfully", "pass");
		} catch (Exception e) {
			reportStep(password+"not entered successfully", "fail");	
		}
		return this;
	}
	public Home clickLogin() throws IOException {
		try {
			driver.findElement(By.className("decorativeSubmit")).click();
			reportStep("Login successfully", "pass");
		} catch (Exception e) {
			reportStep(" Login not  successfully", "fail");	
		}
		return new Home(driver);
	}

}
