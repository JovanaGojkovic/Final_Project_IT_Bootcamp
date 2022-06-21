package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTest{
    @Test (priority = 10)
    public void visitsTheSignupPage(){
        signUpPage.getSignMeUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"),
                "[ERROR] Page url does not contain /signup");
    }
    @Test (priority = 20)
    public void checksInputTypes(){
        signUpPage.getSignMeUpButton().click();
        Assert.assertTrue(signUpPage.getEmailField().getAttribute("type").contains("email"),
                "[ERROR] Attribute type does not contains email");
        Assert.assertTrue(signUpPage.getPasswordField().getAttribute("type").contains("password"),
                "[ERROR] Attribute type does not contains password");
        Assert.assertTrue(signUpPage.getConfirmPasswordField().getAttribute("type").contains("password"),
                "[ERROR] Attribute type does not contains password");
    }
    @Test (priority = 30)
    public void displaysErrorsWhenUserAlreadyExists(){
        signUpPage.getSignMeUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Page url does not contain /signup");
        signUpPage.getNameField().sendKeys("Another User");
        signUpPage.getEmailField().sendKeys("admin@admin.com");
        signUpPage.getPasswordField().sendKeys("12345");
        signUpPage.getConfirmPasswordField().sendKeys("12345");
        signUpPage.getSignMeUpButtonAfterAddingCredentials().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getElementsWithVisibleMessages().getText(),
                "E-mail already exists",
                "[ERROR] Error message is not displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"),
                "[ERROR] Page url does not contain /signup");
    }
    @Test (priority = 40)
    public void signUp(){
        signUpPage.getSignMeUpButton().click();
        signUpPage.getNameField().sendKeys("Jovana Gojkovic");
        signUpPage.getEmailField().sendKeys("jovana.gojkovi@itbootcamp.rs");
        signUpPage.getPasswordField().sendKeys("12345");
        signUpPage.getConfirmPasswordField().sendKeys("12345");
        signUpPage.getSignMeUpButtonAfterAddingCredentials().click();
        messagePopUpPage.getCloseButtonFromVerificationDialog().click();
        navPage.getLogoutButton().click();
        loginPage.getEmailField().sendKeys("jovana.gojkovi@itbootcamp.rs");
        loginPage.getPasswordField().sendKeys("12345");
        loginPage.getLoginButtonAfterAddingCredentials().click();
        messagePopUpPage.waitForDialogForVerificationAccountIsShown();
        Assert.assertEquals(messagePopUpPage.getHeadlineFromVerificationDialog().getText(),
                "IMPORTANT: Verify your account",
                "[ERROR] There is no warning message");
        messagePopUpPage.getCloseButtonFromVerificationDialog().click();
        navPage.getLogoutButton().click();
    }

}
