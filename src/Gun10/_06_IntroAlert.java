package Gun10;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
      Interview sorusu
      - Alertleri nasıl kullanırsın ?

      driver.switchTo().alert() bunula kullanırım.

      komutları;
      accept -> OK, TAMAM butonuna basmamızı sağlıyor.
      dismiss -> CANCEL, HAYIR yani olumsuz butonuna basmamızı sağlıyor.
      gettext -> alertin mesajını alıyoruz.
      SendKeys -> prompt(Alertin giriş kutusu olan hali) , yazı gönderiyoruz.
 */

public class _06_IntroAlert extends BaseDriver {

    @Test
    public void Test1()
    {
       driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");

        WebElement clickMe1=driver.findElement(By.cssSelector("button[onclick='myAlertFunction()']"));
        clickMe1.click();

       // MyFunc.Bekle(2);
        driver.switchTo().alert().accept(); // Alert kutucuğuna geçildi ve (Accept)OK butonuna tıklandı.
        //OK bastığın anda asıl sayfaya dönmüş oluyorsun
        MyFunc.Bekle(2);

        driverBekleKapat();
    }



}
