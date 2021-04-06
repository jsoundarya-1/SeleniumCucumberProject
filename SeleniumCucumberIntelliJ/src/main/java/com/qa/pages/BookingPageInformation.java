package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPageInformation {
    WebDriver driver;
    @FindBy(xpath = "//h3[contains(text(), 'Booking information')]")
    WebElement BookingInformationTitle;
    @FindBy(xpath = "//button[contains(text(),'Cancel booking')]")
    WebElement cancelBookingButton;
    @FindBy(xpath = "//button[contains(text(),'Keep booking')]")
    WebElement cancelBookingPopupPage;
    @FindBy(xpath = "//button[@class = 'wb-btn print--remove wb-btn--primary wb-btn--small wb-btn--full-width wb-push--bottom']")
    WebElement popUpCancelBookingButton;
    public BookingPageInformation()
    {
        PageFactory.initElements(driver, this);
    }
    public boolean isBookingTitleDisplayed()
    {
        return BookingInformationTitle.isDisplayed();
    }
    public void userClicksOnCancelBookingButton()
    {
        cancelBookingButton.click();
    }
    public boolean isCancelBookingPopupPageDisplayed()
    {
        return cancelBookingPopupPage.isDisplayed();
    }
    public void userClicksOnPopupCancelBookingButton()
    {
        popUpCancelBookingButton.click();
    }
}
