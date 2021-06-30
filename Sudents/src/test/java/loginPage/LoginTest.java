package loginPage;
import loginPage.loginPage;
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
    private loginPage loginPage;

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
        loginPage = new loginPage(driver);
        loginPage
                .openLanguageList()
                .ChooseLanguage(number)
                .checkLanguage(text);
    }

    @Test(description = "Авторизация на форме")
    @Parameters({"login", "password", "test"})
    public void loginTest(String login, String password, String test) {
        loginPage = new loginPage(driver);
        loginPage
                .setLogin(login)
                .setPassword(password)
                .clickEnter()
                .errorMessages(test);
    }


    @AfterMethod(description = "Закрытие драйвера", alwaysRun = true)
    private void closeDriver() {
        driver.close();
    }
}