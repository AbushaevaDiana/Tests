package BookingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Booking {
    private WebDriver driver;
    private BookingPage BookingPage;
    private ChoosingPage ChoosingPage;

    @Test(description = "Авторизация на форме")
    @Parameters()
    public void bookTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://bf.qatl.ru/?hotel=7748&date=2021-08-01&nights=1&adults=1");

        Thread.sleep(20000);
        driver.switchTo().frame(5);

        ChoosingPage = new ChoosingPage(driver);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ChoosingPage.openRoomList();
        ChoosingPage.chooseRoom();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ChoosingPage.clickBookingButton();
        Thread.sleep(20000);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ChoosingPage.clickContinueButton();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        BookingPage = new BookingPage(driver);
        BookingPage
                .setLastname()
                .setFirstname()
                .setMiddlename()
                .setEmail()
                .setPhone()
                .setCustomerComment()
                .clickBooking();

    }

    @Test
    public void editBooking() throws InterruptedException {






    }
}