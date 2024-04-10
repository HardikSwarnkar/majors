package headless;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.initializeDriver;
import test.TestNG;

public class headlessmode {
    static WebDriver driver = null;
    static String browser = null;

    @BeforeTest
    public void setUp() throws FileNotFoundException, IOException {
        Properties prop = new Properties();
        String projectPath = System.getProperty("user.dir");
        prop.load(new FileInputStream(projectPath + "/src/test/java/config/config.properties"));
        browser = prop.getProperty("browser");
      
        initializeDriver driverObject = new initializeDriver();
        if (browser.equals("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            driver = new ChromeDriver(options);
        } else {
            driver = driverObject.initializeDriver(browser);
        }
        
        
    }
    
    @Test
    public void verifyamazon() throws FileNotFoundException, IOException {
    //WebDriverManager.chromedriver().setup();
    TestNG testNG = new TestNG();
    
    ChromeOptions options=new ChromeOptions();
    options.addArguments("headless");
    driver=new ChromeDriver(options);
    driver.get("https://www.amazon.in/");
    testNG.amazonSearchTest();
    Assert.assertEquals(driver.getTitle(), "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
    driver.quit();
    }

    @Test
    public void runTestsInHeadlessMode() throws InterruptedException, FileNotFoundException, IOException {
        TestNG testNG = new TestNG();
        
        // Run your tests
        
        testNG.amazonSearchTest_Fail1();
        testNG.amazonSearchTest();
        testNG.changeColor();
        testNG.changeImage();
        testNG.addProductToCart();
        // Perform teardown
        testNG.tearDown();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


