package Gun07;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _02_SenaryoXPath extends BaseDriver {

    @Test
    public void Test1()
    {
//        (//*[@class='input_error form_input'])[1]
//         //*[@placeholder='Username']
//        //*[text()='Accepted usernames are:']
//
//        //*[text()='Accepted usernames are:']/..

        //WebElement element=driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div[1]/input"));
        //uzun path oldugundan kullanışsız hem yazım zorluğu ve hem de yolun bozulma ihtimali çok yüksek : ABSOLUTE XPATH

        //WebElement element=driver.findElement(By.xpath("//input[@id='user-name']" )); // Relative XPath

        driver.get("https://www.saucedemo.com/");


        WebElement username=driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        MyFunc.Bekle(1);

        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        MyFunc.Bekle(1);

        WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        MyFunc.Bekle(1);

        //1.ürün
        WebElement BackpackElement=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        BackpackElement.click();
        //MyFunc.Bekle(1);

        WebElement addToCart=driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCart.click();
        //MyFunc.Bekle(1);

        WebElement buttonBack=driver.findElement(By.xpath("//button[text()='Back to products']"));
        buttonBack.click();
        //MyFunc.Bekle(1);


        //2.ürün
        WebElement boltTshirtTextElement=driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
        boltTshirtTextElement.click();
        MyFunc.Bekle(1);

        WebElement addToCart2=driver.findElement(By.xpath("//button[text()='Add to cart']"));
        addToCart2.click();
        MyFunc.Bekle(1);

        //sepete tıklattık
        WebElement sepet=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        sepet.click();
        //MyFunc.Bekle(1);

        WebElement buttonCheckOut=driver.findElement(By.xpath("//button[@id='checkout']"));
        buttonCheckOut.click();
        //MyFunc.Bekle(1);

        // bilgi girişi
        WebElement firstname=driver.findElement(By.xpath("//input[@name='firstName']"));
        firstname.sendKeys("ismet");
        //MyFunc.Bekle(1);

        WebElement lastname=driver.findElement(By.xpath("//input[@id='last-name']"));
        lastname.sendKeys("temur");
        //MyFunc.Bekle(1);

        WebElement zipcode=driver.findElement(By.xpath("//input[@id='postal-code']"));
        zipcode.sendKeys("232333");
        //MyFunc.Bekle(1);

        WebElement btnContinue=driver.findElement(By.xpath("//input[@id='continue']"));
        btnContinue.click();
        //MyFunc.Bekle(1);

         // ürünlerin ücretleri
       List<WebElement> ucretler=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

       double toplam=0;
       for(WebElement e: ucretler)
       {
           //System.out.println(e.getText());  //$29.99
           toplam += Double.parseDouble(e.getText().substring(1));  // [$].""  veya  replace("$","")
       }
        System.out.println("toplam = " + toplam);

        WebElement webAltToplam=driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        //System.out.println("webAltToplam = " + webAltToplam.getText());
        double altToplam= Double.parseDouble(webAltToplam.getText().substring(13));
        System.out.println("altToplam = " + altToplam);

        Assert.assertTrue("Değerler eşit değil = ", (toplam==altToplam));

        driverBekleKapat();
    }

}
