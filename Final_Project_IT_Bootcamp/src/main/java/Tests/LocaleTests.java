package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest{
    @Test (priority = 10)
    public void setLocaleToES(){
        navPage.getChangeLanguageButton().click();
        navPage.getESPButonFromDropdown().click();
        Assert.assertTrue(navPage.getHeaderFromChangedLanguage().getText().contains("de aterrizaje"),
                "[ERROR] Header does not contains that text");
    }
    @Test (priority = 20)
    public void setLocaleToEN(){
        navPage.getChangeLanguageButton().click();
        navPage.getENGButonFromDropdown().click();
        Assert.assertTrue(navPage.getHeaderFromChangedLanguage().getText().contains("Landing"),
                "[ERROR] Header does not contains that text");
    }
    @Test (priority = 30)
    public void setLocaleToCN(){
        navPage.getChangeLanguageButton().click();
        navPage.getCHButonFromDropdown().click();
        Assert.assertTrue(navPage.getHeaderFromChangedLanguage().getText().contains("首页"),
                "[ERROR] Header does not contains that text");
    }
    @Test (priority = 40)
    public void setLocaleToFR(){
        navPage.getChangeLanguageButton().click();
        navPage.getFRButonFromDropdown().click();
        Assert.assertTrue(navPage.getHeaderFromChangedLanguage().getText().contains("Page d'atterrissage"),
                "[ERROR] Header does not contains that text");
    }
}
