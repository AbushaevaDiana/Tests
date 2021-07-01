package BookingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class DeletePage {
    private WebDriver driver;

    public DeletePage(WebDriver driver){

        this.driver = driver;
    }

    public DeletePage clickDeleteBooking() {
        WebElement deleteBooking = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[2]/div[1]/div/div/div/section[2]/div[4]/div/span"));
        deleteBooking.click();
        return this;
    }

    public DeletePage clickContinueDelete() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement continueDelete = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[2]/div[1]/div/div/div/section/div[2]/div/div/span/span"));
        continueDelete.click();
        return this;
    }

    public DeletePage chooseDeleteReason() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement deleteReason = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[2]/div[1]/div/div/div/section/div[2]/div/div[1]/div[3]/span"));
        deleteReason.click();
        return this;
    }

    public DeletePage deleteBooking() {
        WebElement deleteBooking = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[2]/div[1]/div/div/div/section/div[2]/div/div[2]/span/span"));
        deleteBooking.click();
        return this;
    }
}
