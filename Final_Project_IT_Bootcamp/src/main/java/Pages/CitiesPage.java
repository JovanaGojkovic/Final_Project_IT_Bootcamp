package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitiesPage {
    private WebDriver driver;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getNewItemButton(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnNewItem')]"));
    }
    public WebElement getNameFieldOnNewItemDialog(){
        return driver.findElement(By.xpath("//input[contains(@id, 'name')]"));
    }
    public WebElement getSearchField(){
        return driver.findElement(By.id("search"));
    }
    public WebElement newItemField(){
        return driver.findElement(By.xpath("//input[contains(@name, 'name')]"));
    }
    public void waitForEditDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'dlgNewEdit')]")));
    }
    public void waitForDeleteDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[contains(@class, 'warning')]")));
    }
    public WebElement getSaveButtonFromEditDialog(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnSave')]"));
    }
    public WebElement getDeleteButtonFromDeleteDialog(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-dialog__content--active')]/div/div/div/button[2]"));
    }
    public void waitForNumberOfProductRowsToBe(int numberOfRows) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table/tbody/tr"), numberOfRows));
    }
    public WebElement getProductRows(int row, int cell) {
        return driver
                .findElement(By.xpath("//table/tbody/tr[" + row + "]/td[" + cell + "]"));
    }
    public WebElement getEditButtonForTheRow(int row){
        return driver.findElement(By.xpath("//button[contains(@id, 'edit')][" + row + "]"));
    }
    public WebElement getDeleteButtonForTheRow(int row){
        return driver.findElement(By.xpath("//button[contains(@id, 'delete')][" + row + "]"));
    }
    public WebElement getEditNameFieldInDialog(){
        return driver.findElement(By.xpath("//input[contains(@id, 'name')]"));
    }



}
