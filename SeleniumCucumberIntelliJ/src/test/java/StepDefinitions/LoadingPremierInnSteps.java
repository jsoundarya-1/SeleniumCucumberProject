package StepDefinitions;

import com.qa.pages.LoadingPremierInnPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoadingPremierInnSteps {
    WebDriver driver;
    LoadingPremierInnPage loadingPremierInnPage = new LoadingPremierInnPage();

    @Given("Browser has to be launched")
    public void browser_has_to_be_launched() {

      //TestBase.initialization();
        System.setProperty("webdriver.chrome.driver","src/test/java/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("user launches premier Inn Page")
    public void user_launches_premier_Inn_Page()
    {
        driver.get("https://www.premierinn.com");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Then("Premier Inn should be displayed")
    public void premier_Inn_should_be_displayed() {
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        //boolean flag = loadingPremierInnPage.isPremierInnLogoDisplayed();
        boolean flag = driver.findElement(By.xpath("//img[@src = '/etc/clientlibs/pi-header/resources/images/pi-refresh-logo.svg']")).isDisplayed();
        Assert.assertTrue(flag);

    }
    @Given("user opens premier Inn booking website")
    public void LoadingPremierInnWebsite()
    {
        System.setProperty("webdriver.chrome.driver","src/test/java/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.premierinn.com");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        //boolean flag = loadingPremierInnPage.isPremierInnLogoDisplayed();
        boolean flag = driver.findElement(By.xpath("//img[@src = '/etc/clientlibs/pi-header/resources/images/pi-refresh-logo.svg']")).isDisplayed();
        Assert.assertTrue(flag);
    }


    @When("User clicks on Manage Booking Button")
    public void user_clicks_on_Manage_Booking_Button() {
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        if(driver.findElement(By.xpath("//button[@id = 'find-a-booking']")).isDisplayed()) {
            System.out.println("Test message here");
            driver.findElement(By.xpath("//button[@id = 'find-a-booking']")).click();
        } else {
            System.out.println("Test message here - Web Element not displayed");
        }



    }


    @And("Filling the details of the Manage Booking Pop up Menu")
    public void filling_the_details_of_the_Manage_Booking_Pop_up_Menu(DataTable bookingTable) {
        List<List<String>> data = bookingTable.asLists();
        //Alert alert = driver.switchTo().alert();
        //String print = alert.getText();

        driver.findElement(By.xpath("//input[@id = 'booking-reference-input']")).click();
        driver.findElement(By.xpath("//input[@id = 'booking-reference-input']")).sendKeys(data.get(0).get(0));
        driver.findElement(By.xpath("//input[@id = 'booking-surname-input']")).click();
        driver.findElement(By.xpath("//input[@id = 'booking-surname-input']")).sendKeys(data.get(0).get(1));
        driver.findElement(By.xpath("//*[@id=\"find-booking-form\"]/div[3]/div[3]/drop-down-group/div[1]/div/input")).click();
        String flag = "False";
        while(flag == "False")
        {
            if (driver.findElements(By.xpath("//button[@id = 'date-picker-day-2152021'][contains (@aria-label, '21 May 2021') ]")).size() > 0 )
            {
                driver.findElements(By.xpath("//button[@class = 'calendar-chevron date-picker-right-arrow']")).get(1).click();
                driver.findElement(By.xpath("//button[@id = 'date-picker-day-2152021'][contains (@aria-label, '21 May 2021') ]")).click();
                flag = "True";
            }
            else
            {
                System.out.println("Checking loop here");
                driver.findElements(By.xpath("//button[@class = 'calendar-chevron date-picker-right-arrow']")).get(1).click();
            }
        }
        driver.findElement(By.xpath("//button[contains(text(), 'Search')]")).click();
    }

    @Then("User clicks on Cancel Booking button")
    public void user_clicks_on_Cancel_Booking_button() {
        driver.findElement(By.xpath("//button[contains(text(),'Cancel booking')]")).click();
    }
    @And("Cancel your booking pop up appears")
    public void cancel_your_booking_pop_up_appears() {
        boolean cancelPopUpWindow=driver.findElement(By.xpath("//button[contains(text(),'Keep booking')]")).isDisplayed();
        Assert.assertTrue(cancelPopUpWindow);
    }
    @And("User clicks on  Cancel booking button on the pop up")
    public void user_clicks_on_Cancel_booking_button_on_the_pop_up() {
        driver.findElement(By.xpath("//button[contains(text(),'Keep booking')]")).click();

    }
    @And("Verify whether the booking got cancelled")
    public void verify_whether_the_booking_got_cancelled() throws IOException {
        String cancellationNumber = driver.findElement(By.xpath("//h3[@data-test-id = 'booking-reference']")).getText();
        System.out.println(cancellationNumber);
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        FileWriter DestFile = new FileWriter(dir + "\\src\\main\\resources\\cancellationnumber.csv");
        DestFile.write(cancellationNumber);
        DestFile.close();
    }
}
