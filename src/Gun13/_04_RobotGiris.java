package Gun13;

/*
     İnterview Soruları :
     1- Windows popupları nasıl kontrol edersiniz ? Robot class la
     2- Dosya yükleme işlemini ne ile yaparsınız ? Robot class la
 */

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.time.Duration;

public class _04_RobotGiris extends BaseDriver {
    public static void main(String[] args) throws AWTException {

        driver.get("http://demo.guru99.com/test/upload/");
        MyFunc.Bekle(2);

        Robot rbt=new Robot();

        /*   Accept All için */
        for(int i=0;i<6;i++) {
            rbt.keyPress(KeyEvent.VK_TAB);
            rbt.keyRelease(KeyEvent.VK_TAB);
            MyFunc.Bekle(1);
        }

        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);
        /*****************************/

        for(int i=0;i<22;i++) {
            rbt.keyPress(KeyEvent.VK_TAB);
            rbt.keyRelease(KeyEvent.VK_TAB);
            MyFunc.Bekle(1);
        }

        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER); // şu anda windows popup açıldı


        /*  popup ı kapatma bölümü
        for(int i=0;i<4;i++) {
            rbt.keyPress(KeyEvent.VK_TAB);
            rbt.keyRelease(KeyEvent.VK_TAB);
            MyFunc.Bekle(1);
        }

        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);
        */

        // bilgisayarımızdaki dosyanın path ini, dosya adının olduğu yere yapıştırmamız gerekiyor bunun için
        // önce dosyanın path , yolunu hafızaya kopyalayıp, sonra ctrl+v ile açılan windows popup ın
        // dosya adı bölümüne yapıştırmamız gerekiyor.

        // hafızaya path i kopyaladık
        StringSelection selection = new StringSelection("C:\\Users\\TechnoStudy\\IdeaProjects\\SDET4\\src\\Gun13\\ornek.txt");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);

        MyFunc.Bekle(1);
        // ctrl+v bastım
        rbt.keyPress(KeyEvent.VK_CONTROL);
        rbt.keyPress(KeyEvent.VK_V);

        MyFunc.Bekle(1);
        // ctrl+v bıraktım
        rbt.keyRelease(KeyEvent.VK_CONTROL);
        rbt.keyRelease(KeyEvent.VK_V);

        // Entera basarak popup ı kapattım
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);

        WebElement chcBox = driver.findElement(By.xpath("//*[@id='terms']"));
        chcBox.click();

        WebElement submit=driver.findElement(By.id("submitbutton"));
        submit.click();

        // butona basıldıktan sonra yazının çıkması süre alıyor, bu beklendi
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement uploadMesaj=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("res")));

        Assert.assertTrue(uploadMesaj.getText().contains("has been successfully uploaded.")); // beklentiyi yazıyoruz


        driverBekleKapat();
    }
}
