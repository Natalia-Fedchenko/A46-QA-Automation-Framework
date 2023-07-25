import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

//    @Test (description = "Test is checking happy path Login with correct details")
    public void validLoginTest()  {
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

//    @Test(dataProvider = "invalidLoginProviders")
//    public void inValidPasswordTest(String email, String password) throws InterruptedException {
////step2. Enter Email
//        enterEmail(email);
////step3. Enter Password
//        enterPassword(password);
////step4. Click submit
//        clickSubmit();
////Assertion - Compare expected and actual
//        Thread.sleep(2000);
//        Assert.assertEquals(driver.getCurrentUrl(), baseUrl);
//    }

//    @Test(dataProvider ="csvData")
}
