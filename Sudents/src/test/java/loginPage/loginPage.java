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


    public loginPage openLanguageList(){
        WebElement languageTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div"));
        languageTest.click();
        return this;
    }

    public loginPage сhooseLanguage(String number){
        WebElement lanButtonTest = driver.findElement(By.xpath("//*[@id='lang-dropdown']/div/div/ul/li["+number+"]"));
        lanButtonTest.click();
        return this;
    }

}
