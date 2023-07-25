import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

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

}
