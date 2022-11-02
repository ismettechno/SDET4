package Gun11;

/*
Senaryo
1-  https://www.demoblaze.com/index.html  siteyi açınız.
2- Samsung galaxy s6  linkine tıklayınız.
3- Sepete ekleyiniz.
4- Daha Sonra PRODUCT STORE yazısına tıklatarak ana ekrana geri dönününz
 */

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _04_WaitSoru extends BaseDriver {

    @Test
    public void Test1(){
        driver.get("https://www.demoblaze.com/index.html");

        WebElement btn=driver.findElement(By.linkText("Samsung galaxy s6"));
        btn.click();

        WebElement sepeteEkle=driver.findElement(By.linkText("Add to cart"));
        sepeteEkle.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();

        WebElement anaSayfa=driver.findElement(By.id("nava"));
        anaSayfa.click();
    }



}
