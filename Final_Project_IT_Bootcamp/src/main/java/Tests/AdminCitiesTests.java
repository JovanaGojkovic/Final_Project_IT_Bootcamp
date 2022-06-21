package Tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest{

    String oldCityName = "333";
    String newCityName = "444";

    @Test (priority = 10)
    public void  visitsTheAdminCitiesPageAndListCities(){
        loginPage.getLoginButton().click();
        loginPage.getEmailField().click();
        loginPage.getEmailField().sendKeys("admin@admin.com");
        loginPage.getPasswordField().click();
        loginPage.getPasswordField().sendKeys("12345");
        loginPage.getLoginButtonAfterAddingCredentials().click();
        navPage.getAdminButton().click();
        navPage.getCitiesLinkFromDropdown().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
                "[ERROR] Page url does not contains /admin/cities");
    }
    @Test (priority = 20)
    public void checksInputTypesForCreateOrEditNewCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLinkFromDropdown().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditDialogToBeVisible();
        Assert.assertTrue(citiesPage.newItemField().getAttribute("type").contains("text"),
                "[ERROR] Attribute type does not contains text");
    }
    @Test (priority = 30)
    public void createNewCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLinkFromDropdown().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditDialogToBeVisible();
        citiesPage.getNameFieldOnNewItemDialog().click();
        citiesPage.getNameFieldOnNewItemDialog().sendKeys(oldCityName);
        citiesPage.getSaveButtonFromEditDialog().click();
        messagePopUpPage.waitForPopUpAddNewCityToBeVisible();
        Assert.assertTrue(messagePopUpPage.getElementsWithVisibleMessagesForCities().getText().contains("Saved"),
                "[ERROR] City is not saved");
    }
    @Test (priority = 40)
    public void editCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLinkFromDropdown().click();
        citiesPage.getSearchField().click();
        citiesPage.getSearchField().sendKeys(oldCityName);
        citiesPage.waitForNumberOfProductRowsToBe(1);
        citiesPage.getEditButtonForTheRow(1).click();
        citiesPage.getEditNameFieldInDialog().click();
        citiesPage.waitForEditDialogToBeVisible();
        citiesPage.getEditNameFieldInDialog().sendKeys(Keys.CONTROL, "a");
        citiesPage.getEditNameFieldInDialog().sendKeys(newCityName);
        citiesPage.getSaveButtonFromEditDialog().click();
        messagePopUpPage.waitForPopUpAddNewCityToBeVisible();
        Assert.assertTrue(messagePopUpPage.getElementsWithVisibleMessagesForCities().getText().contains("Saved"),
                "[ERROR] City is not saved");
    }
    @Test (priority = 50)
    public void searchCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLinkFromDropdown().click();
        citiesPage.getSearchField().sendKeys(newCityName);
        citiesPage.waitForNumberOfProductRowsToBe(1);
        Assert.assertTrue(citiesPage.getProductRows(1,2).getText().contains(newCityName),
                "[ERROR] Text on this page is not what user has entered");
    }
    @Test (priority = 60)
    public void deleteCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLinkFromDropdown().click();
        citiesPage.getSearchField().sendKeys(newCityName);
        citiesPage.waitForNumberOfProductRowsToBe(1);
        Assert.assertTrue(citiesPage.getProductRows(1,2).getText().contains(newCityName),
                "[ERROR] There is no such text on this page");
        citiesPage.getDeleteButtonForTheRow(1).click();
        citiesPage.waitForDeleteDialogToBeVisible();
        citiesPage.getDeleteButtonFromDeleteDialog().click();
        messagePopUpPage.waitForPopUpDeleteCityToBeVisible();
        Assert.assertTrue(messagePopUpPage.getElementsWithVisibleMessagesForCities().getText().contains("Deleted"),
                "[ERROR] City is not deleted");
    }
}
