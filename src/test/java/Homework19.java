import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlayList() throws InterruptedException {
        validLogin();
        openPlayilist();
        deletePlayilist();
        assertConfirmationIsDisplayed();
    }

    void openPlayilist() throws InterruptedException {
        driver.findElement(By.cssSelector(".playlist:nth-child(3)")).click();
        Thread.sleep(3000);
    }
    void deletePlayilist() throws InterruptedException {
        driver.findElement(By.cssSelector(".btn-delete-playlist")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".ok")).click();
    }
    void assertConfirmationIsDisplayed() {
       Assert.assertTrue( driver.findElement(By.cssSelector("div.success.show")).isDisplayed());
        }
}
