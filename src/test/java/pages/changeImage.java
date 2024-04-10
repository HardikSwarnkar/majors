package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class changeImage {
WebDriver driver=null;
	
	//locators for search box and button

public changeImage(WebDriver driver) {
	
	this.driver=driver;
}

  
    static String projectPath=System.getProperty("user.dir");
    static String product=null;
	 public void changeImage() throws FileNotFoundException, IOException{
    	 Properties prop = new Properties();
         prop.load(new FileInputStream(projectPath+"/src/test/java/config/config.properties"));
         
         // Read searchQuery property
         
         product=prop.getProperty("product");
         
        driver.get(product);
        WebElement list=driver.findElement(By.id("a-autoid-4"));
        list.click();
        WebElement list1=driver.findElement(By.id("a-autoid-7"));
        list1.click();
        WebElement list2=driver.findElement(By.id("a-autoid-8"));
        list2.click();
    }
}
