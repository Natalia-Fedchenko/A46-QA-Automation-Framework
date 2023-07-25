import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException {
        validLogin();
        clickPlaySong();
        assertSongIsPlaying();
    }

    void clickPlaySong() throws InterruptedException {
        driver.findElement(By.cssSelector("[data-test-id='play-next-btn']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[data-test-id='play-btn']")).click();
        Thread.sleep(3000);
    }
    void assertSongIsPlaying() {
       Assert.assertTrue( driver.findElement(By.cssSelector("[data-test-id='sound-bar-play']")).isDisplayed());
        }
}
