package Gun12;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _01_IFrameGiris extends BaseDriver {

    @Test
    public void Test1()
    {
        driver.get("https://chercher.tech/practice/frames");

        driver.switchTo().frame(0);  //"frame1"  id ve name ve webelement geçişi çok yavaş
        WebElement input=driver.findElement(By.cssSelector("#topic + input"));
        input.sendKeys("Türkiye");

        // şu anda frame1 ile gösterilen sayfadayız, diğer frame2 veya 3 veya ilk sayfamızdaki
        // locator ları bulamayız, çünkü driver şu anda frame1 isimli sayfayı DRİVE etmekte.

       // 1- driver.switchTo().frame(0); --> içteki frame3 e geçiş olur
       // 2- driver.switchTo().parentFrame(); --> bir önceki sayafaya geri dönerim
       // 3- driver.switchTo().defaultContent(); --> hangi sayafda olursan ol ilk sayafaya direk geçiş

        driverBekleKapat();
    }

}
