package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getNameField(){
        return driver.findElement(By.id("name"));
    }
    public WebElement getEmailField(){
        return driver.findElement(By.id("email"));
    }
    public WebElement getPasswordField(){
        return driver.findElement(By.id("password"));
    }
    public WebElement getConfirmPasswordField(){
        return driver.findElement(By.id("confirmPassword"));
    }
    public WebElement getSignMeUpButton(){
        return driver.findElement(By.xpath("//a[contains(@href, '/signup')]"));
    }
    public WebElement getSignMeUpButtonAfterAddingCredentials(){
        return driver.findElement(By.xpath("//button[contains(@type, 'submit')]"));
    }

}
