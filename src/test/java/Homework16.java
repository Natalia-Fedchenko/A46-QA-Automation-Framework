import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest{
    @Test
    public void NavigationRegistrationTest()  {
//prereq
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//step1. Get URL
        String url = "https://qa.koel.app/";
        driver.get(url);
//step2. Click Registartion
        WebElement regLink = ;
//Assertion
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.koel.app/registration.php");
        driver.quit();
    }

}
