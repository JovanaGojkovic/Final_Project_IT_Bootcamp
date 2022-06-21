package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.xpath("//a[contains(@class, 'btnLogin')]"));
    }
    public WebElement getEmailField(){
        return driver.findElement(By.id("email"));
    }
    public WebElement getPasswordField(){
        return driver.findElement(By.id("password"));
    }
    public WebElement getLoginButtonAfterAddingCredentials(){
        return driver.findElement(By.xpath("//div[contains(@class, 'layout ')]/div[3]/button"));
    }


}
