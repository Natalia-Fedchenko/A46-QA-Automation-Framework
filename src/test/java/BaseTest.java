import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.LoginPage;
import pages.SongsPage;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    BasePage basePage ;
    LoginPage loginPage;
    SongsPage songsPage ;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void initTest() {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        //instantiate Explicit wait
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        actions = new Actions(driver);
        basePage = new BasePage(driver,wait,actions);
        basePage.navigateToPage("https://qa.koel.app/");
        loginPage = new LoginPage(driver,wait,actions);
        songsPage = new SongsPage(driver,wait,actions);
    }

    @AfterClass
    public void teardown() {
        basePage.quitBrowser();
    }

}
