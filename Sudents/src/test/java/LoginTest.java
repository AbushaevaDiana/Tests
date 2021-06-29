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
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            System.setProperty("webdriver.ie.driver", "C:\\driver\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.ie.driver", "C:\\driver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.qatl.ru/secure/");
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
        if (test.equals("-")) {
            WebElement alert = driver.findElement(By.xpath("//tl-alert[@text='Неверный логин или пароль.']"));
            Assert.assertTrue(alert.isDisplayed(), "Алерт о неправельном вводе логина или пароля не отобразился");
        } else {
            String url = driver.getCurrentUrl();
            Assert.assertEquals(url, "https://www.qatl.ru/secure/Extranet/#/Proxy/RoomTypeAvailability.aspx", "Вход неосуществлен");
        }
    }

    @Test
    public void LanguageTest(){
        WebElement LanguageTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div"));
        LanguageTest.click();

        WebElement EngButtonTest = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div/div/ul/li[2]"));
        EngButtonTest.click();

        WebElement alert = driver.findElement(By.xpath("//*[@id='login-form']//tl-button[@text='Log in']"));
        Assert.assertTrue(alert.isDisplayed(), "Вход в личный кабинет ");

        WebElement Language2Test = driver.findElement(By.xpath("//*[@id=\"lang-dropdown\"]/div"));
        Language2Test.click();
    }

    @Test(description = "Проверка перехода на страницу AppStore по ссылке")
    public void AppStoreTest(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.qatl.ru/secure/");

        WebElement AppStoreTest = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]"));
        AppStoreTest.click();
    }

    @AfterMethod(description = "Закрытие драйвера", alwaysRun = true)
    private void closeDriver() {
        driver.close();
    }
}