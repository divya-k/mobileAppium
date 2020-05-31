package org.ecommerce;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class ecommerce_tc_3 extends baseEcommerce {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        AndroidDriver<AndroidElement> driver = Capabalities();
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("hello");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@text='Female']")).click();

        driver.findElement(By.id("android:id/text1")).click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");

        //New way to scroll
        //  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));

        driver.findElement(By.xpath("//*[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();


        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));

        System.out.println(driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size());
        int count=    driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for(int i=0;i<count;i++)

        {

            String text=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();



            if(text.equalsIgnoreCase("Jordan 6 Rings"))
            {

System.out.println(text);

                System.out.println(driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).getText());
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();

                break;

            }}

            Thread.sleep(3000);

            driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
            Thread.sleep(3000);

         String lastpageText=    driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();

            Assert.assertEquals("Jordan 6 Rings", lastpageText);

        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        int count1=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();

        double sum=0;

        for(int i=0;i<count1;i++)

        {

            String amount1= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();

            double amount=getAmount(amount1);

            sum=sum+amount;//280.97+116.97

        }

        System.out.println(sum+"sum of products");
        String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();



        total= total.substring(1);

        double totalValue=Double.parseDouble(total);

        System.out.println(totalValue+"Total value of products");

        Assert.assertEquals(sum, totalValue);


//Mobile Gestures

        WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));

        TouchAction t=new TouchAction(driver);

        t.tap(tapOptions().withElement(element(checkbox))).perform();



        WebElement tc=driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));

        t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();

        driver.findElement(By.id("android:id/button1")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();






    }
    public static double getAmount(String value)

    {

        value= value.substring(1);

        double amount2value=Double.parseDouble(value);

        return amount2value;

    }




    }
