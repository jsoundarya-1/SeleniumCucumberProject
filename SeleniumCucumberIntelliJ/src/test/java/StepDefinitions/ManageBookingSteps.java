package StepDefinitions;

import com.qa.pages.BookingPageInformation;
import com.qa.pages.ManageBookingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.TestBase;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ManageBookingSteps {
    WebDriver driver;
    ManageBookingPage manageBookingPage;
    BookingPageInformation bookingPageInformation;

//    @Given("User is already on HomePage of Premier Inn")
//    public void user_is_already_on_HomePage_of_Premier_Inn() {
//        System.setProperty("webdriver.chrome.driver","src/test/java/ChromeDriver/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.get("https://www.premierinn.com");
//        boolean flag = driver.findElement(By.xpath("//img[@src = '/etc/clientlibs/pi-header/resources/images/pi-refresh-logo.svg']")).isDisplayed();
//        Assert.assertTrue(flag);
//    }




    @Then("user will be landing on the Booking Information Page")
    public BookingPageInformation user_will_be_landing_on_the_Booking_Information_Page() {

      driver.findElement(By.xpath("//button[contains(text(), 'Search')]")).click();
      driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
      return new BookingPageInformation();
    }


}
