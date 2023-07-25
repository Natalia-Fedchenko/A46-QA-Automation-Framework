import com.github.hemanthsridhar.CSVUtils;
import com.github.hemanthsridhar.lib.ExtUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseUrl;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setUpTest() {
        //prereq
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        baseUrl = "https://qa.koel.app/";
        driver.get(baseUrl);
    }

    @AfterMethod
    void teardawn() {
        driver.quit();
    }

    protected void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("[type='submit']"));
        submit.click();
    }

    protected void enterEmail(String emailValue) {
        enterText(By.cssSelector("[type='email']"), emailValue);
    }

    protected void enterPassword(String passwordValue) {
        enterText(By.cssSelector("[type='password']"), passwordValue);
    }

    void enterText(By elementBy, String textToEnter) {
        WebElement email = driver.findElement(elementBy);
        email.click();
        email.clear();
        email.sendKeys(textToEnter);
    }

    String getRandomString() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public void validLogin()  {
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
    }


    @DataProvider(name = "invalidLoginProviders")
    public Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"notExisting@email.com", "notExistingPassword"},
                {"demo@class.com", ""},
                {"", ""}
        };
    }

    @DataProvider(name = "csvData")
    public Object[][] csvDataRead() throws Exception {
        String path ="src/test/resources/cred.csv";
        ExtUtils ext = new CSVUtils(path,false);
        return ext.parseData();
    }


}