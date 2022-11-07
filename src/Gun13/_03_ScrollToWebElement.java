package Gun13;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _03_ScrollToWebElement extends BaseDriver {

    @Test
    public void Test1() {
        driver.get("https://triplebyte.com/");
        MyFunc.Bekle(5);

        JavascriptExecutor js= (JavascriptExecutor) driver;

        WebElement element=driver.findElement(By.xpath("(//*[text()='Get a demo'])[5]"));
        //scroll u bir elemente kadar, yani o pencere içide gözükene kadar nasıl kaydırırım
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        MyFunc.Bekle(3);
        js.executeScript("arguments[0].click();", element);
        // TODO : element.click();

        MyFunc.Bekle(3);
        driverBekleKapat();
    }
}
