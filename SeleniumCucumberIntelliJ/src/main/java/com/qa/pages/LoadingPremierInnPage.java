package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

public class LoadingPremierInnPage extends TestBase {
   WebDriver driver;
   @FindBy(xpath = "//img[@src = '/etc/clientlibs/pi-header/resources/images/pi-refresh-logo.svg']")
   WebElement premierInnLogo;
    public LoadingPremierInnPage()
    {
        PageFactory.initElements(driver, this);
    }
    public boolean isPremierInnLogoDisplayed()
    {
        return premierInnLogo.isDisplayed();
    }

}
