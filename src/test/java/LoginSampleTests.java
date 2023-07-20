import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

public class LoginSampleTests extends BaseTest {
    @Test
    public void SuccessfulLoginTest() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        //typing email
        WebElement loginInput=driver.findElement(cssSelector("[type='email']"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("demo@class.com");
        //typing password
        WebElement passwordInput=driver.findElement(cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("te$t$tudent");

        //clicking Login
        WebElement submitBtn=driver.findElement(cssSelector("[type='submit']"));
        submitBtn.click();

        //checking Avatar is displayed
        //typing password
        WebElement avatar=driver.findElement(cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed(),"Avatar is not displayed");
//        driver.quit();
    }
    @Test
    public void RegistrationTest() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        WebElement registrationLink=driver.findElement(id("hel"));
        registrationLink.click();
//        driver.quit();
    }

    @Test
    public void InvalidLoginTest() {

//        Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        //typing email
        WebElement loginInput=driver.findElement(cssSelector("[type='email']"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("doNotExist@class.com");
        //typing password
        WebElement passwordInput=driver.findElement(cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("te$t$tudent");

        //clicking Login
        WebElement submitBtn=driver.findElement(cssSelector("[type='submit']"));
        submitBtn.click();

        //checking Avatar is displayed
//
//        WebElement avatar=driver.findElement(cssSelector(".avatar"));
        Assert.assertTrue(submitBtn.isDisplayed(),"Logged in but not suppossed to");
//        driver.quit();
    }
}
