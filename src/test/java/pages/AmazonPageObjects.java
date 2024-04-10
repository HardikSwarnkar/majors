package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonPageObjects {
	
	WebDriver driver=null;
	
	//locators for search box and button

	By textbox_search = By.id("twotabsearchtextbox");
	
	By button_seaarch=By.id("nav-search-submit-button");
    By button_wishlist = By.id("wishListMainButton");
    By button_addToCart = By.xpath("(//input[@id='add-to-cart-button'])[2]");
    By link_proceedToCheckout = By.id("attach-sidesheet-checkout-button");
    By link_signUp = By.id("createAccountSubmit");
    By input_username = By.id("ap_customer_name");
    By input_phone = By.id("ap_phone_number");
    By input_password = By.id("ap_password");
    static String projectPath=System.getProperty("user.dir");
    static String product=null;

	
	//constructor to get the driver from other class
    
	
	public AmazonPageObjects(WebDriver driver) {
		
		this.driver=driver;
	}
	
	//ACTIONS
	public void setTextInsearchBox(String text) {
		
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	public void clickSearchButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.findElement(button_seaarch).sendKeys(Keys.RETURN);
	}
	
	 

    public void changeColor() {
        WebElement color=driver.findElement(By.id("a-autoid-15"));
        color.click();
        WebElement color2=driver.findElement(By.id("a-autoid-14"));
        color2.click();
    }


    public void clickWishlistButton() {
        driver.findElement(button_wishlist).click();
    }

    public void clickAddToCartButton() {
        driver.findElement(button_addToCart).click();
    }

    public void clickProceedToCheckoutLink() {
        driver.findElement(link_proceedToCheckout).click();
    }

    public void clickSignUpLink() {
        driver.findElement(link_signUp).click();
    }

    public void setUsername(String username) {
        driver.findElement(input_username).sendKeys(username);
    }

    public void setPhone(String phone) {
        driver.findElement(input_phone).sendKeys(phone);
    }

    public void setPassword(String password) {
        driver.findElement(input_password).sendKeys(password);
    }

   
    public void addToWishlist() {
        driver.get(product);
        WebElement list=driver.findElement(By.id("wishListMainButton"));
        list.click();
    }

   

	
	
}

