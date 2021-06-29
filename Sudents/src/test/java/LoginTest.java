import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser){
        driver = getBrowser(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.qatl.ru/secure/");
    }
    public WebDriver getBrowser(String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
            return new ChromeDriver();
        }
        if (browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\driver\\msedgedriver.exe");
            return new EdgeDriver();
        }
        if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
            return new FirefoxDriver();
        }
        return null;
    }

    @Test(description = "Изменмение языка")
    @Parameters({"text", "number"})
    public void languageTest(String text, String number){

        WebElement languageTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div"));
        languageTest.click();

        WebElement lanButtonTest = driver.findElement(By.xpath("//*[@id='lang-dropdown']/div/div/ul/li["+number+"]"));
        lanButtonTest.click();

        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='"+text+"']"));
        Assert.assertTrue(loginButton.isDisplayed(), "Неверный язык");
    }


    @Test(description = "Авторизация на форме")
    @Parameters({"login", "password", "test"})
    public void loginTest(String login, String password, String test) {

        WebElement loginInput = driver.findElement(By.name("username"));
        loginInput.sendKeys(login);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='Войти']"));
        loginButton.click();

        errorMessagesForPositiveAndNegativeLoginTests(test);
    }
    private void errorMessagesForPositiveAndNegativeLoginTests(String test){
        if (test.equals("-")) {
            WebElement alert = driver.findElement(By.xpath("//tl-alert[@text='Неверный логин или пароль.']"));
            Assert.assertTrue(alert.isDisplayed(), "Алерт о неправельном вводе логина или пароля не отобразился");
        } else {
            String url = driver.getCurrentUrl();
            Assert.assertEquals(url, "https://www.qatl.ru/secure/Extranet/#/Proxy/RoomTypeAvailability.aspx", "Вход неосуществлен");
        }
    }

    @AfterMethod(description = "Закрытие драйвера", alwaysRun = true)
    private void closeDriver() {
        driver.close();
    }
}