package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class changeColor {
	
WebDriver driver=null;
	
	//locators for search box and button

public changeColor(WebDriver driver) {
	
	this.driver=driver;
}

	  public void changeColors() {
	        WebElement color=driver.findElement(By.id("a-autoid-15"));
	        color.click();
	        WebElement color2=driver.findElement(By.id("a-autoid-14"));
	        color2.click();
	    }

}
