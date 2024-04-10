package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;



public class initializeDriver {
	
	   static WebDriver driver;

	    public WebDriver initializeDriver(String browser) {
	        if (browser.equalsIgnoreCase("chrome")) {
	        	String projectPath = System.getProperty("user.dir");
	    		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
	    		driver = new ChromeDriver();
	    		
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            
	            FirefoxOptions options = new FirefoxOptions();
	            driver = new FirefoxDriver(options);
	        }else if (browser.equalsIgnoreCase("edge")) {
	          
	            driver = new EdgeDriver();
	        }

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        return driver;
	    }


	


}
