package BookingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChoosingPage {

    private WebDriver driver;

    public ChoosingPage(WebDriver driver){

        this.driver = driver;
    }

    public void openRoomList() {
        WebElement roomList = driver.findElement(By.xpath("//*[@id=\"room-stay-id-rs-rt344751-rp320223-877896_adult_1___-\"]/div[1]/div[2]/div/div[1]"));
        roomList.click();
    }

    public void chooseRoom() {
        WebElement chooseRoom = driver.findElement(By.xpath("//*[@id=\"room-stay-id-rs-rt344751-rp320223-877896_adult_1___-\"]/div[1]/div[2]/div/div[2]/div[2]/div[2]"));
        chooseRoom.click();
    }

    public void clickBookingButton() {
        WebElement bookingButton = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[1]/header/div[2]/div[1]/div[2]/div"));
        bookingButton.click();
    }

    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[1]/header/div[2]/div[1]/div[3]/div"));
        continueButton.click();
    }


}
