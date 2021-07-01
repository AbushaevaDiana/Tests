package BookingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class EditPage {
    private WebDriver driver;

    public EditPage(WebDriver driver){

        this.driver = driver;
    }

    public EditPage clickEditContacts() {
        WebElement editContacts = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[2]/div[1]/div/div/div/section/div[3]/div/p[4]/a"));
        editContacts.click();
        return this;
    }

    public EditPage clickEditContactData() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement editContactData = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[2]/div[1]/div/div/div/section[3]/div[1]/div[2]/div/span[1]/span/span"));
        editContactData.click();
        return this;
    }
    public EditPage deleteCheckMark() {
        WebElement chekcMark = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[2]/div[1]/div/div/div/section[3]/div[1]/form/div/div[5]/div[1]"));
        chekcMark.click();
        return this;
    }

    public EditPage saveChanges() {
        WebElement saveChanges = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[3]/div[2]/div[2]/div[1]/div/div/div/section[3]/div[1]/div[2]/div/span[2]/span"));
        saveChanges.click();
        return this;
    }

    public EditPage clickReturn() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement clickReturn = driver.findElement(By.xpath("//*[@id=\"tl-app\"]/div[1]/div/div[1]/tl-status-modal/div/div[4]/div/span"));
        clickReturn.click();
        return this;
    }
}
