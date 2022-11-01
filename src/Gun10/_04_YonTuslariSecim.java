package Gun10;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class _04_YonTuslariSecim extends BaseDriver {

//    kutucuğa git, içine tıklat
//    b harfine bas, aşağı yön tuşuna bas
//    enter a bas.
    @Test
    public void Test1() {
        driver.get("https://demoqa.com/auto-complete");

        WebElement element = driver.findElement(By.id("autoCompleteSingleInput"));

        Actions aksiyonlar = new Actions(driver);

        Action aksiyon= aksiyonlar
                .moveToElement(element)
                .click()
                .sendKeys("b")
                .build();
        aksiyon.perform();

        MyFunc.Bekle(2);

        aksiyon = aksiyonlar
                .sendKeys(Keys.DOWN)  // keyDown-KeyUp olurdu
                .sendKeys(Keys.ENTER)
                .build();
        aksiyon.perform();

        driverBekleKapat();
    }
}
