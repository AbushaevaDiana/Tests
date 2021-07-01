package BookingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ChoosingPage {

    private WebDriver driver;

    public ChoosingPage(WebDriver driver){

        this.driver = driver;
    }

    public ChoosingPage openRoomList() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement roomList = driver.findElement(By.xpath("//*[@id=\"room-stay-id-rs-rt344751-rp320223-877896_adult_1___-\"]/div[1]/div[2]/div/div[1]/div[2]"));
        roomList.click();
        return this;
    }

    public ChoosingPage chooseRoom() {
        WebElement chooseRoom = driver.findElement(By.xpath("//*[@id=\"room-stay-id-rs-rt344751-rp320223-877896_adult_1___-\"]/div[1]/div[2]/div/div[2]/div[2]/div[2]"));
        chooseRoom.click();
        return this;
    }

    public ChoosingPage clickBookingButton() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement bookingButton = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[1]/header/div[2]/div[1]/div[2]/div"));
        bookingButton.click();
        return this;
    }

    public void clickContinueButton() throws InterruptedException {
        Thread.sleep(20000);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[1]/header/div[2]/div[1]/div[3]/div"));
        continueButton.click();
    }


}
