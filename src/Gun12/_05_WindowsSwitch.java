package Gun12;

/*
    Senaryo:
    https://www.selenium.dev/ adresindeki ayrı tab da açılan linklere tıklatınız.
    Açılan bütün yeni tablardaki sayfaların title ve url lerini yazdırınız.
    Daha sonra ana sayfa ya dönününüz.
    ipucu : driver.switchTo().window(id) ile istenilen tab a geçiş yapılır
 */


import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class _05_WindowsSwitch extends BaseDriver {

    @Test
    public void Test1()
    {
        driver.get("https://www.selenium.dev/");

        String anaSayfaWindowID= driver.getWindowHandle(); // bulunduğum sayfanın/window/tab ID sini aldım.
        System.out.println("anaSayfaWindowID = " + anaSayfaWindowID);

        List<WebElement> linkler=driver.findElements(By.cssSelector("a[target='_blank']"));

        for(WebElement link: linkler)
            if (!link.getAttribute("href").contains("mailto"))
                link.click();

        // driver.getWindowHandle() -> aktif olan tab (window) un id sinin verir
        Set<String> windowIdler=driver.getWindowHandles(); // açık olan tüm sayfaların win id leri

        for(String id : windowIdler)
        {
            driver.switchTo().window(id); // diğer tab a (windowa) geçiş yaptık
            System.out.println(id+ " -Title ="+driver.getTitle()+" - URL: "+driver.getCurrentUrl());
        }

        // TODO:
        //burada önce ana sayfaya geçelim.
        driver.switchTo().window(anaSayfaWindowID);

        //sonra ana sayfa harici diğerlerini kapatalım.
        for(String id : windowIdler)
        {
            if (id.equals(anaSayfaWindowID))
                continue; // sadece bu adımı pass geçti, kendin sonra gelenleri çalıştırmadı

            driver.switchTo().window(id);
            driver.close(); // sadece bulunduğum wındw u kapatır
        }

        MyFunc.Bekle(10);
        driverBekleKapat();
    }
}
