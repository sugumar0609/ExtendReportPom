package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilis.ReadExcelExampleDynamic;

public class ProjectSpecificMethods {
	public RemoteWebDriver d;
	public WebDriver driver;
	public String excelFileName;
	public static  ExtentHtmlReporter report;
	public  static ExtentReports extend;
	public static  ExtentTest test;
	public  static ExtentTest node;
	public String TCName;public String TCDes;public String Author;public String cate;

	@BeforeSuite
	public void startReport() {
		report=new ExtentHtmlReporter("./ExtendReport/report.html");
		report.setAppendExisting(true);
		extend=new ExtentReports();
		extend.attachReporter(report);
	}


	@AfterSuite
	public void endReport() {
		extend.flush();
	}

	@BeforeClass
	public void setDetails() {
		test = extend.createTest(TCName,TCDes);
		test.assignAuthor(Author);
		test.assignCategory(cate);

	}

	public long takeSnap() throws IOException {
		long number=(long)Math.floor(Math.random()*90000000l);
		
		//File src= ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		File screenshotAs = d.getScreenshotAs(OutputType.FILE);
		File des=new File("./snaps/"+number+".png");
		FileHandler.copy(screenshotAs, des);
		//FileUtils.copyFile(screenshotAs, des);
		
		return number;
		// TODO Auto-generated method stub
		
	}
	public void reportStep(String msg,String status) throws IOException  {
		if(status.equals("pass")) {
			node.pass(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/"+takeSnap()+".png").build());
		}else {
			node.fail(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/"+takeSnap()+".png").build());
			throw new RuntimeException();
		}
		//test.pass("enterUsername");
		//test.pass("enterPassword");
		//test.pass("ClickLogin",MediaEntityBuilder.createScreenCaptureFromPath(".././data/Screenshot (217).png").build());
	}

	@BeforeMethod
	public void preCondition() {
		
		 node = test.createNode(TCName,TCDes);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
	}

	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}

	@DataProvider(name="fetchData")
	public String [][] sendData() throws IOException {
		String [][] data=ReadExcelExampleDynamic.readData(excelFileName);

		return data;

	}
	
	

}
