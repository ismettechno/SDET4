package Gun13;

/*
     İnterview Soruları :
     1- Windows popupları nasıl kontrol edersiniz ? Robot class la
     2- Dosya yükleme işlemini ne ile yaparsınız ? Robot class la
 */

import Utility.BaseDriver;
import Utility.MyFunc;

import java.awt.*;
import java.awt.event.KeyEvent;

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
        rbt.keyRelease(KeyEvent.VK_ENTER);

        for(int i=0;i<4;i++) {
            rbt.keyPress(KeyEvent.VK_TAB);
            rbt.keyRelease(KeyEvent.VK_TAB);
            MyFunc.Bekle(1);
        }

        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);

        driverBekleKapat();
    }
}
