package BookingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BookingPage {
    private WebDriver driver;

    public BookingPage(WebDriver driver){
        this.driver = driver;
    }

    public BookingPage setLastname() {
        WebElement lastnameInput = driver.findElement(By.name("lastname"));
        lastnameInput.sendKeys("Абушаева");
        return this;
    }

    public BookingPage setFirstname() {
        WebElement firstnameInput = driver.findElement(By.name("firstname"));
        firstnameInput.sendKeys("Диана");
        return this;
    }

    public BookingPage setMiddlename() {
        WebElement middlenameInput = driver.findElement(By.name("middlename"));
        middlenameInput.sendKeys("Игоревна");
        return this;
    }

    public BookingPage setEmail() {
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("abu13.di@gmail.com");
        return this;
    }

    public BookingPage setPhone() {
        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.sendKeys("79877281352");
        return this;
    }

    public BookingPage setCustomerComment() {
        WebElement customerCommentInput = driver.findElement(By.name("customerComment"));
        customerCommentInput.sendKeys("Светлая комната");
        return this;
    }

    public void clickBooking() {
        WebElement booking = driver.findElement(By.xpath("//*[@id=\"paymentInformation\"]/div/div[2]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/span"));
        booking.click();
    }
}
