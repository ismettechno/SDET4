package Gun12;

/*
   Senaryo :
   https://chercher.tech/practice/frames sitesine gidiniz
   Ekranda gözüken ilk kutucuğa Türkiye yazınız.
   Daha sonra animals dan seçeneklerinden avatar ı seçiniz.
 */


import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _02_IFramelerGecis extends BaseDriver {

    @Test
    public void Test1()
    {
        driver.get("https://chercher.tech/practice/frames");

        driver.switchTo().frame(0);  //"frame1"  id ve name ve webelement geçişi çok yavaş
        WebElement input=driver.findElement(By.cssSelector("#topic + input"));
        input.sendKeys("Türkiye");

        //driver.switchTo().parentFrame();  // 1 kademe içerde olduğumdan yine default page e ulaşıyor.
        driver.switchTo().defaultContent(); // default page yani asıl giris sayfasına ulaştım, aynı şekilde

        // driver.switchTo().defaultContent().switchTo().frame(1);  // bu şekilde direk de kullanılabilir 2 geçiş birleştirildi
        driver.switchTo().frame(1);  // ana sayfadaki 2.frame(index olarak 1) ulaşıldı.Burası select in olduğu yer

        WebElement menu=driver.findElement(By.id("animals"));
        Select ddMenu=new Select(menu);
        ddMenu.selectByVisibleText("Avatar");

        driverBekleKapat();
    }


}

//    frame 0
//        -> subframe 0
//    frame 1


