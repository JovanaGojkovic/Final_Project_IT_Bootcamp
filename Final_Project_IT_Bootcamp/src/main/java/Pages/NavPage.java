package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {
    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getHomeButton(){
        return driver.findElement(By.xpath("//i[contains(@class, 'mdi-home')]"));
    }
    public WebElement getAboutButton(){
        return driver.findElement(By.xpath("//i[contains(@class, 'mdi-help')]"));
    }
    public WebElement getMyProfileButton(){
        return driver.findElement(By.xpath("//i[contains(@class, 'mdi-face')]"));
    }
    public WebElement getAdminButton(){
        return driver.findElement(By.xpath("//i[contains(@class, 'mdi-lock')]"));
    }
    public WebElement getCitiesLinkFromDropdown(){
        return driver.findElement(By.xpath("//a[contains(@href, '/admin/cities')]"));
    }

    public WebElement getUsersLinkFromDropdown(){
        return driver.findElement(By.xpath("//a[contains(@href, '/admin/users')]"));
    }
    public WebElement getLogoutButton(){
        return driver.findElement(By.xpath("//i[contains(@class, 'mdi-exit')]"));
    }
    public WebElement getChangeLanguageButton(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__content')]/div[3]/button"));
    }
    public WebElement getENGButonFromDropdown(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu')]/div/div"));
    }
    public WebElement getESPButonFromDropdown(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu')]/div/div[2]"));
    }
    public WebElement getFRButonFromDropdown(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu')]/div/div[3]"));
    }
    public WebElement getCHButonFromDropdown(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu')]/div/div[4]"));
    }
    public WebElement getHeaderFromChangedLanguage(){
        return driver.findElement(By.xpath("//div[contains(@class, 'container')]/div/div/h1"));
    }

}
