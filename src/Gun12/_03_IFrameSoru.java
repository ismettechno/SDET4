package Gun12;

/*
   1-driver.get("http://chercher.tech/practice/frames"); sayfasına gidiniz.
   2-Inputa ülke adı yazınız
   3-CheckBox ı çekleyiniz.
   4-Select in 4.elemanını seçiniz.
 */

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _03_IFrameSoru extends BaseDriver {

    @Test
    public void Test1()
    {
        driver.get("https://chercher.tech/practice/frames");

        driver.switchTo().frame(0);  //"frame1"  id ve name ve webelement geçişi çok yavaş
        WebElement input=driver.findElement(By.cssSelector("#topic + input"));
        input.sendKeys("Türkiye");

        driver.switchTo().frame(0); // frame1 içind eki ilk frame geçiş yaptık : frame3
        WebElement chkBox=driver.findElement(By.id("a"));  //  xpath ile //input[@id='a']
        chkBox.click();

//        driver.switchTo().parentFrame();  // frame 1 e geçiş
//        driver.switchTo().parentFrame();  // ilk sayfaya geçiş

        driver.switchTo().defaultContent();  // yukarıdaki 2 satırın yerine direk ilk sayfaya geçiş

        driver.switchTo().frame(1);  // select in olduğu frame(frame2), ilk sayafdaki 2. yani index olarak 1 olan frame

        WebElement menu=driver.findElement(By.id("animals"));
        Select ddMenu=new Select(menu);
        ddMenu.selectByIndex(3); // 4 nolu eleman seçildi: son eleman: ddMenu.getOptions().size()-1

        driverBekleKapat();
    }

}
