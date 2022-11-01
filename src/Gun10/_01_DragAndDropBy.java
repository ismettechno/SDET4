package Gun10;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _01_DragAndDropBy extends BaseDriver {
    public static void main(String[] args) {

        driver.get("http://talkerscode.com/webtricks/demo/demo_price-range-slider-using-jquery-css-and-php.php");

        WebElement solSurgu=driver.findElement(By.xpath("//*[@id='slider-range']/span[1]"));
        // solSurgu.getSize().width;
        //2.sürgü   div[id='slider-range']>:nth-child(3)
        MyFunc.Bekle(2);

        Actions aksiyonlar= new Actions(driver);
        Action aksiyon= aksiyonlar.dragAndDropBy(solSurgu,100, 0).build();
        MyFunc.Bekle(2);

        aksiyon.perform();

        driverBekleKapat();
    }
}

//    sürgünü boyutu 500$
//
//
//        sürgünün boyutunu / 500 => her 1 dolar için
//        sürgügünün ilerletilmesi gereken uzunluğu verir
//        birim uzunluğu verir
//
//        150$ için => birim uzunluk*150