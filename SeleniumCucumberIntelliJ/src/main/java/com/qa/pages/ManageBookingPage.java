package com.qa.pages;

import gherkin.ast.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

import java.util.Map;

public class ManageBookingPage extends TestBase{
    WebDriver driver;
    @FindBy(xpath = "//button[@id = 'find-a-booking']")
    WebElement manageBooking;
    @FindBy(xpath = "//input[@id = 'booking-reference-input']")
    WebElement bookingReferenceTextField;
    @FindBy(xpath = "//input[@id = 'booking-surname-input']")
    WebElement bookingSurName;
    @FindBy(xpath = "//div[contains(text(),'Arrival date *')]")
    WebElement arrivalDate;
    @FindBy(xpath = "//button[contains(text(), 'Search')]")
    WebElement searchButton;
    public ManageBookingPage()
    {
        PageFactory.initElements(driver, this);
    }
    public void userClicksOnManageBookingButton()
    {
        manageBooking.click();
    }

}
