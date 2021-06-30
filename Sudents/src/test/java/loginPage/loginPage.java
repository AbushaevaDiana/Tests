package loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class loginPage {
    private WebDriver driver;

    public loginPage(WebDriver driver){
        this.driver = driver;
    }

    public loginPage setLogin(String login) {
        WebElement loginInput = driver.findElement(By.name("username"));
        loginInput.sendKeys(login);
        return this;
    }

    public loginPage setPassword(String password) {
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
        return this;
    }

    public loginPage clickEnter(){
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='Войти']"));
        loginButton.click();
        return this;
    }

    public void errorMessages(String test){
        if (test.equals("-")) {
            WebElement alert = driver.findElement(By.xpath("//tl-alert[@text='Неверный логин или пароль.']"));
            Assert.assertTrue(alert.isDisplayed(), "Алерт о неправельном вводе логина или пароля не отобразился");
        } else {
            String url = driver.getCurrentUrl();
            Assert.assertEquals(url, "https://www.qatl.ru/secure/Extranet/#/Proxy/RoomTypeAvailability.aspx", "Вход неосуществлен");
        }
    }

    public loginPage openLanguageList(){
        WebElement languageTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div"));
        languageTest.click();
        return this;
    }

    public loginPage ChooseLanguage(String number){
        WebElement lanButtonTest = driver.findElement(By.xpath("//*[@id='lang-dropdown']/div/div/ul/li["+number+"]"));
        lanButtonTest.click();
        return this;
    }

    public void checkLanguage(String text){
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='"+text+"']"));
        Assert.assertTrue(loginButton.isDisplayed(), "Неверный язык");
    }
}
