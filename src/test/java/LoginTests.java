import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void LoginEmptyEmailPasswordTest() {
       //Assertion
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.koel.app/");
    }

    @Test (description = "Test is checking happy path Login with correct details")
    public void ValidLoginTest()  {
//step2. Enter Email
        enterEmail("demo@class.com");
//step3. Enter Password
        enterPassword("te$t$tudent");
//step4. Click submit
       clickSubmit();
//Assertion - Compare expect and actual
        WebElement avatar= driver.findElement(By.className("avatar"));
        Assert.assertTrue(avatar.isDisplayed());
    }


    @Test
    public void inValidPasswordTest() throws InterruptedException {
//step2. Enter Email
        enterEmail("demo@class.com");
//step3. Enter Password
        enterPassword("");
//step4. Click submit
        clickSubmit();
//Assertion - Compare expected and actual
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl);
    }
    @Test
    public void changeUserName() throws InterruptedException {
//step2. Enter Email
        enterEmail("demo@class.com");
//step3. Enter Password
        enterPassword("te$t$tudent");
//step4. Click submit
        clickSubmit();
//step5. Click on Avatar
        Thread.sleep(3000);
        WebElement avatar = driver.findElement(By.cssSelector("span[class='name']"));
        avatar.click();
//Step6.Enter Name, Password, New Password, email
        enterText(By.id("inputProfileName"),getRandomString());
        enterText(By.id("inputProfileCurrentPassword"),"te$t$tudent");
        enterText(By.id("inputProfileNewPassword"),"te$t$tudent");
        enterText(By.id("inputProfileEmail"),"demo@class.com");
//Step7. Click Submit  - To be completed
//        clickSubmit();
//Step8. Assertion - verify the name  - To be completed

    }
}
