package test;



import java.io.IOException;
import java.time.Duration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import lombok.extern.log4j.Log4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


//import org.openqa.selenium.chrome.ChromeDriver;
import pages.AmazonPageObjects;
import pages.initializeDriver;
import pages.changeImage;
import pages.changeColor;
import pages.RegisterAmazon;
import util.Util;
import extentReport.AmazonExtentReport;


public class TestNG {
	static WebDriver driver=null;

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
	
	private static Logger logger=LogManager.getLogger(TestNG.class);


	



  
	@BeforeTest
	public void setUp() throws FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		prop.load(new FileInputStream(projectPath+"/src/test/java/config/config.properties"));
		browser=prop.getProperty("browser");
		initializeDriver driverObject = new initializeDriver();
		driver = driverObject.initializeDriver(browser);
		searchQuery = prop.getProperty("searchQuery");
		applicationUrl=prop.getProperty("applicationUrl");
		product=prop.getProperty("product");
		username=prop.getProperty("username");
		phone=prop.getProperty("phone");
		password=prop.getProperty("password");
		register_page_url=prop.getProperty("register_page_url");
		extent = AmazonExtentReport.getInstance();
		

	}
	
/*
	@BeforeTest
    @Parameters("browser")
    public void setUp(String browser) throws FileNotFoundException, IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(projectPath + "/src/test/java/config/config.properties"));
        applicationUrl = prop.getProperty("applicationUrl");
        product = prop.getProperty("product");
        username = prop.getProperty("username");
        phone = prop.getProperty("phone");
        password = prop.getProperty("password");
        register_page_url = prop.getProperty("register_page_url");
        extent = AmazonExtentReport.getInstance();
        initializeDriver driverObject = new initializeDriver();
        driver = driverObject.initializeDriver(browser);
    }

	*/
	

	@Test(priority = 1)
	public void amazonSearchTest() {
		test = extent.createTest("Amazon Search Test", "Verify search functionality on Amazon website");
		driver.get(applicationUrl);
		AmazonPageObjects searchPageObj = new AmazonPageObjects(driver);
		logger.info("Amazon SearchTest");
		searchPageObj.setTextInsearchBox(searchQuery);
		searchPageObj.clickSearchButton();
		Assert.assertTrue(driver.getTitle().contains(searchQuery), "Page title does not contain the search query");
		

	}

	@Test(priority = 2)
	public void openProductPage() {
		test = extent.createTest("Open Product", "Verify search functionality on Amazon Products");
		driver.get(product);
		logger.info("OPEN PRODUCT");
		Assert.assertTrue(driver.getCurrentUrl().contains(product), "Page URL does not contain the product identifier");
		


	}
	@Test(priority=3)
    public void changeImage() throws FileNotFoundException, IOException, InterruptedException {
        test = extent.createTest("Change Image", "Verify changing image functionality");
        changeImage amazonPage = new changeImage(driver);
        logger.info("IMAGE CHANGE");
        amazonPage.changeImage();
        Thread.sleep(1000);
    }

    @Test(priority = 4)
    public void changeColor() throws InterruptedException {
        test = extent.createTest("Change Color", "Verify changing color functionality");
        changeColor color = new changeColor(driver);
        logger.info("CHANGE COLOR");
        color.changeColors();
        Thread.sleep(2000);
        
    }


    @Test(priority=5)
    public void addToWishlist() {
        test = extent.createTest("Add To Wishlist", "Verify adding to wishlist functionality");
        AmazonPageObjects amazonPage = new AmazonPageObjects(driver);
        logger.info("Add to wish");
        amazonPage.addToWishlist();
    }
    
    
	@Test(priority = 6)
	public void addProductToCart() throws InterruptedException {
		test = extent.createTest("Add to cart", "Verify search functionality on Amazon Add to cart");
		driver.get(product);
		WebElement addToCartBtn = driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]"));
		addToCartBtn.click();
		logger.info("Add to product");
		//test.log(Status.PASS, "Product added to cart successfully");
		Thread.sleep(5000);
	}



	@Test(priority = 7)
	public void proceedToCheckout() {
		test = extent.createTest("Proceed To checkout", "Verify search functionality on Proceed to checkout");

	
		// Click on "Proceed to checkout" button
		WebElement proceedToCheckoutBtn = driver.findElement(By.id("attach-sidesheet-checkout-button"));
		proceedToCheckoutBtn.click();
		logger.info("ProceedToCheckout");
		
		test.log(Status.PASS, "Proceed to checkout successful");

	}


	@Test(priority = 8)
	public void signUPCredentials() throws InterruptedException, FileNotFoundException, IOException {
		
		RegisterAmazon register=new RegisterAmazon(driver);
		register.setUp();
		register.signUPCredential();
		
		logger.info("signUPCredentials");
		
	}

	
	@Test(priority = 9)
	public void verifyAmazonLogoPresence() {
	    test = extent.createTest("Verify Amazon Logo Presence", "Verify whether the Amazon logo is present on the homepage.");
	    // Navigate to the Amazon homepage
	    driver.get(applicationUrl);
	    // Check if the Amazon logo element is present
	    WebElement amazonLogo = driver.findElement(By.id("nav-logo"));
	    if (amazonLogo.isDisplayed()) {
	        test.log(Status.PASS, "Amazon logo is displayed on the homepage");
	    } else {
	        test.log(Status.FAIL, "Amazon logo is not displayed on the homepage");
	    }
	    logger.info("verifyAmazonLogoPresence");
	}

	@Test(priority = 10)
	public void verifyCartIconClickable() {
	    test = extent.createTest("Verify Cart Icon Clickable", "Verify whether the cart icon is clickable and redirects to the shopping cart page.");
	   
	    driver.get(applicationUrl);
	    
	    WebElement cartIcon = driver.findElement(By.id("nav-cart"));
	    cartIcon.click();
	   
	    String currentUrl = driver.getCurrentUrl();
	    if (currentUrl.contains("cart")) {
	        test.log(Status.PASS, "User is redirected to the shopping cart page after clicking on the cart icon");
	    } else {
	        test.log(Status.FAIL, "User is not redirected to the shopping cart page after clicking on the cart icon");
	    }
	    logger.info("verifyCartIconClickable");
	}




	

	@Test(priority=11)
	public void amazonSearchTest_Fail1() {
		test = extent.createTest("Amazon Fail", "Verify search functionality on Amazon fail");
		driver.get(applicationUrl);
		// searching for an invalid item
		AmazonPageObjects searchPageObj = new AmazonPageObjects(driver);
		searchPageObj.setTextInsearchBox("invalid_item");
		searchPageObj.clickSearchButton();
		test.log(Status.FAIL, "Search for invalid_item Failed");
		logger.info("AmazonSearchTest_Fail1");
	}

	
	@Test(priority = 12)
	public void searchForNonExistentItem() {
	    test = extent.createTest("Search for Non-Existent Item", "Verify that searching for a non-existent item fails");
	    // Enter a non-existent item in the search box
	    AmazonPageObjects searchPageObj = new AmazonPageObjects(driver);
	    searchPageObj.setTextInsearchBox("nonexistentitem123");
	    searchPageObj.clickSearchButton();
	    // Verify that the search results page does not contain any products
	  
	    test.log(Status.FAIL, "Failed to find non-existent item as expected");
	    logger.info("SearchForNonExistentItem");
	}


	@AfterMethod
	public void Aftermethod(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			Util.TakingScreenshot(driver,result.getName());
		}
	}


	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
		extent.flush();   
	}

}

