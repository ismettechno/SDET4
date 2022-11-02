package Gun11;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
    İnterview Sorusu :  Implicit ve Explicit

    Implicitli  : Bütün elemanlar için geçerli,Bir kere tanımlanır.
    Explicit    : Tek bir eleman özel Kriter olarak tanımlanır sadece ilgili elemanda geçerli olur

    Her ikisi tanımlı ise : önce Implicit kullanılır, ve üzerine Explicit in süresi eklenerek
                            toplam hata sınır süresi ortaya çıkmış olur.

                          ExpectedConditions
                                     .titleIs -> title bu olana kadar bekle
                                     .titleContains -> title ın da bu kelime geçene kadar bekle
                                     .urlToBe -> url bu olana kadar bekle
                                     .urlContains -> url de bu kelime geçene kadar bekle
                                     .visibilityOfElementLocated -> eleman DOM da var ve gözükür olana kadar bekle
                                     .visibilityOfTheElement -> eleman gözükene kadar bekle
                                     .InvisibilityOfTheElement -> eleman kaybolana kadar bekle
                                     .elementToBeClickable -> eleman tıklanabilir olana kadra bekle
                                     .elementToBeSelected -> eleman seçilebilir olana kadra bekle
                                     .textToBe -> elemanda verilen txt gözükene kadar bekle.
                                     .alertIsPresent()  -> alert çıkana kadar bekle.
                                     .visibilityOfAllElementsLocatedBy -> locator ile bütün elemanlari gözükene kadar bekle
                                     .visibilityOfAllElements -> Verilen elemanların listesindeki tüm elemanlar gözrünür olana kadar bekle
                                     .numberOfElementsToBe  -> verilen locatora sahip elemanların sayısı bu olana kadar bekle
                                     .numberOfElementsToBeLessThan -> verilen locatora sahip elemanların sayısı verilenden az olana kadar bekle
                                     .numberOfElementsToBeMoreThan -> verilen locatora sahip elemanların sayısı verilenden fazla olana kadar bekle

https://the-internet.herokuapp.com/
https://the-internet.herokuapp.com/dynamic_controls

 */

public class _02_ExplicitWait extends BaseDriver {

    @Test
    public void Test1()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");

        WebElement btn= driver.findElement(By.xpath("//*[text()='Click me to start timer']"));
        btn.click();

        WebDriverWait bekle=new WebDriverWait(driver, Duration.ofSeconds(13));
        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));
        // e kadar bekle
        // element hem html de olana kadar , hem de görünür olana kadar , her ikisi için bekle

    }

}
