package Gun13;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

public class _02_ScrollToBottomOfThePage extends BaseDriver {

    @Test
    public void Test1() {
        driver.get("https://triplebyte.com/");

        JavascriptExecutor js=(JavascriptExecutor) driver;

        MyFunc.Bekle(2);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        // sayafa sonuna kadar kaydır

        MyFunc.Bekle(2);
        js.executeScript("window.scrollTo(0, 0);");
        // sayfa başına git

        driverBekleKapat();
    }
}
