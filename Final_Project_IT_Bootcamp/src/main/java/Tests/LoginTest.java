package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test (priority = 10)
    public void visitsTheLoginPage(){
        navPage.getChangeLanguageButton().click();
        loginPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "[ERROR] Page url does not contain /login");

    }
    @Test (priority = 20)
    public void checksInputTypes(){
        loginPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getEmailField()
                .getAttribute("type"), ("email")
                ,"[ERROR] Attribute type does not contains email");
        Assert.assertEquals(loginPage.getPasswordField()
                        .getAttribute("type"), ("password")
                ,"[ERROR] Attribute type does not contains email");
    }
    @Test (priority = 30)
    public void displaysErrorsWhenUserDoesNotExist(){
        loginPage.getLoginButton().click();
        loginPage.getEmailField().click();
        loginPage.getEmailField().sendKeys("non-existing-user@gmal.com");
        loginPage.getPasswordField().click();
        loginPage.getPasswordField().sendKeys("password123");
        loginPage.getLoginButtonAfterAddingCredentials().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getElementsWithVisibleMessages().getText(),
                "User does not exists",
                "[ERROR] There is no error message displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "[ERROR] Page url does not contain /login");
    }
    @Test (priority = 40)
    public void displaysErrorsWhenPasswordIsWrong(){
        loginPage.getLoginButton().click();
        loginPage.getEmailField().click();
        loginPage.getEmailField().sendKeys("admin@admin.com");
        loginPage.getPasswordField().click();
        loginPage.getPasswordField().sendKeys("password123");
        loginPage.getLoginButtonAfterAddingCredentials().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getElementsWithVisibleMessages().getText(),
                "Wrong password",
                "[ERROR] There is no error message displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "[ERROR] Page url does not contain /login");
    }
    @Test (priority = 50)
    public void login(){
        loginPage.getLoginButton().click();
        loginPage.getEmailField().click();
        loginPage.getEmailField().sendKeys("admin@admin.com");
        loginPage.getPasswordField().click();
        loginPage.getPasswordField().sendKeys("12345");
        loginPage.getLoginButtonAfterAddingCredentials().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
                "[ERROR] Page url does not contain /home");
    }
    @Test (priority = 60)
    public void logOut(){
        Assert.assertTrue(navPage.getLogoutButton().isDisplayed(),
                "[ERROR] This element is not visible");
        navPage.getLogoutButton().click();
    }
}
