package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import extentReport.AmazonExtentReport;
import junit.framework.Assert;

public class RegisterAmazon {
	
WebDriver driver=null;

static String searchQuery=null;
static String applicationUrl=null;
static String product = null;
static String register_page_url=null;
static String phone = null;
static String username = null;
static String password = null;
static String browser=null;
static ExtentReports extent;
static ExtentTest test;
static String projectPath=System.getProperty("user.dir");

	
	//locators for search box and button

public RegisterAmazon(WebDriver driver) {
	
	this.driver=driver;
}


public void setUp() throws FileNotFoundException, IOException {
	
	Properties prop = new Properties();
	prop.load(new FileInputStream(projectPath+"/src/test/java/config/config.properties"));
	browser=prop.getProperty("browser");
	
	// Load config.properties file
	

	// Read searchQuery property
	searchQuery = prop.getProperty("searchQuery");

	applicationUrl=prop.getProperty("applicationUrl");


	product=prop.getProperty("product");

	username=prop.getProperty("username");
	
	phone=prop.getProperty("phone");
	
	password=prop.getProperty("password");
	
	register_page_url=prop.getProperty("register_page_url");

	extent = AmazonExtentReport.getInstance();

}
public void signUPCredential() throws InterruptedException {
		
		
		WebElement signup = driver.findElement(By.id("createAccountSubmit"));
		signup.click();

		
		WebElement usernameInput = driver.findElement(By.id("ap_customer_name"));
		usernameInput.sendKeys(username);
		WebElement phoneInput = driver.findElement(By.id("ap_phone_number"));
		phoneInput.sendKeys(phone);
		
		WebElement passwordInput = driver.findElement(By.id("ap_password"));
		passwordInput.sendKeys(password);
		WebElement register = driver.findElement(By.id("continue"));



		
		
	
		register.click();
		Thread.sleep(2000);
		//logger.info("signUPCredentials");
		// Verify login successful
		String dashboardTitle = driver.getTitle();
		Assert.assertEquals(dashboardTitle, "Dashboard");
	}
}
