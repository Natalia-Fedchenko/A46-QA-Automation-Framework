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
        driver.findElement(By.cssSelector("[data-testid='play-next-btn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[data-testid='play-btn']")).click();
        Thread.sleep(2000);
    }
    void assertSongIsPlaying() {
       Assert.assertTrue( driver.findElement(By.cssSelector("[data-testid='sound-bar-play']")).isDisplayed());
        }
}
