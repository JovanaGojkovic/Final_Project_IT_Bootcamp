package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage {
    private WebDriver driver;

    public MessagePopUpPage(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForPopUpToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//div[contains(@class, 'v-snack__content')]")));
    }
    public void waitForPopUpAddNewCityToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//div[contains(@class, 'v-snack')]/div[contains(@class, 'success')]")));
    }
    public void waitForPopUpDeleteCityToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//div[contains(@class, 'v-snack')]/div[contains(@class, 'success')]")));

    }
    public WebElement getElementsWithVisibleMessagesForCities(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-snack')]/div[contains(@class, 'success')]"));
    }

    public WebElement getElementsWithVisibleMessages(){
        return driver.findElement(By.xpath("//div[contains(@class, 'container')]/div/div/div/div/div/div/div/ul/li"));
    }
    public WebElement getCloseButtonFromPopUpDialog(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-snack__wrapper')]/div/button"));
    }
    public void waitForDialogForVerificationAccountIsShown(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait
                .until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[contains(@class, 'dialog__content ')]/div/div/div/i")));
    }
    public WebElement getHeadlineFromVerificationDialog(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-card__title')]"));
    }
    public WebElement getCloseButtonFromVerificationDialog(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnClose')]"));
    }





}
