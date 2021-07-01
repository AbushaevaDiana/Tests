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
    private  EditPage EditPage;
    private  DeletePage DeletePage;

    @Test(description = "Бронирование номера")
    @Parameters()
    public void booking() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://bf.qatl.ru/?hotel=7748&date=2021-08-01&nights=1&adults=1");

        Thread.sleep(20000);
        driver.switchTo().frame(5);

        ChoosingPage = new ChoosingPage(driver);
        ChoosingPage
                .openRoomList()
                .chooseRoom()
                .clickBookingButton()
                .clickContinueButton();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        BookingPage = new BookingPage(driver);
        BookingPage
                .setLastname()
                .setFirstname("Яна")
                .setMiddlename()
                .setEmail()
                .setPhone()
                .setCustomerComment()
                .clickBooking();

    }

    @Test(description = "Изменение брони")
    public void changeBooking() throws InterruptedException {
        Thread.sleep(5000);
        EditPage = new EditPage(driver);
        EditPage
                .clickEditContacts()
                .clickEditContactData();

        BookingPage = new BookingPage(driver);
        BookingPage
                .setFirstname("Дианa");

        EditPage
                .deleteCheckMark()
                .saveChanges()
                .clickReturn();
    }

    @Test(description = "Отмена брони")
    public void deleteBooking() throws InterruptedException {
        Thread.sleep(5000);
        DeletePage = new DeletePage(driver);
        DeletePage
                .clickDeleteBooking()
                .clickContinueDelete()
                .chooseDeleteReason()
                .deleteBooking();

        Thread.sleep(5000);
        driver.close();
    }
}