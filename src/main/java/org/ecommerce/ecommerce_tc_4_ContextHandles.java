package org.ecommerce;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.Set;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class ecommerce_tc_4_ContextHandles extends baseEcommerce {
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

  //          Assert.assertEquals("Jordan 6 Rings", lastpageText);





//Mobile Gestures

        WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));

        TouchAction t=new TouchAction(driver);

        t.tap(tapOptions().withElement(element(checkbox))).perform();


driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
Thread.sleep(10000);
        Set<String> contexts = driver.getContextHandles();

        for(String contextName:contexts){

            System.out.println(contextName);
        }

        driver.context("WEBVIEW_com.androidsample.generalstore");

        //Chrome Driver Executable Path
        //  /Users/shridharvenkatesh/Downloads/Multimedia/appammu/src/driver/chromedriver

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("vtu", Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        driver.context("NATIVE_APP");
    }
    }
