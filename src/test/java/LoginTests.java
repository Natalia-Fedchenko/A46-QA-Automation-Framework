import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest() {
//prereq
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//step1
        String url = "https://qa.koel.app/";
        driver.get(url);
//Assertion
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.koel.app/registration.php");
        driver.quit();
    }
    @Test
    public void ValidLoginTest() throws InterruptedException {
//prereq
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
//step1. Get URL
        String url = "https://qa.koel.app/";
        driver.get(url);
//step2. Enter Email
        WebElement email= driver.findElement(By.cssSelector("[type='email']"))   ;
        email.click();
        email.clear();
        email.sendKeys("demo@class.com");
//step3. Enter Password
        WebElement password= driver.findElement(By.cssSelector("[type='password']"))   ;
        password.click();
        password.clear();
        password.sendKeys("te$t$tudent");
//step4. Click submit
        WebElement submit = driver.findElement(By.cssSelector("[type='submit']"))      ;
        submit.click();
//Assertion - Compare expect and actual
//        Assert.assertEquals(driver.getCurrentUrl(), url );
        WebElement avatar= driver.findElement(By.className("[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed());
        driver.quit();
    }

    @Test
    public void InValidPasswordTest() throws InterruptedException {
//prereq
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
//step1. Get URL
        String url = "https://qa.koel.app/";
        driver.get(url);
//step2. Enter Email
        WebElement email= driver.findElement(By.cssSelector("[type='email']"))   ;
        email.click();
        email.clear();
        email.sendKeys("demo@class.com");
//step3. Enter Password
        WebElement password= driver.findElement(By.cssSelector("[type='password']"))   ;
        password.click();
        password.clear();
        password.sendKeys("");
//step4. Click submit
        WebElement submit = driver.findElement(By.cssSelector("[type='submit']"))      ;
        submit.click();
//Assertion - Compare expected and actual
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url );
        driver.quit();
    }
}
