package org.example;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class gestures extends base{
    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = Capabalities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        WebElement expandList= driver.findElementByXPath("//android.widget.TextView[@text()='Expandable Lists']");

        TouchAction t = new TouchAction(driver);

        //Tap --End result is similar to click
        t.tap(TapOptions.tapOptions().withElement(element(expandList))).perform();
        driver.findElementByXPath("//android.widget.TextView[@text()='1. Custom Adapter']").click();

        //longpress
        WebElement peopleNames= driver.findElementByXPath("//android.widget.TextView[@text()='People Names']");


        t.longPress(LongPressOptions.longPressOptions().withElement(element(peopleNames)).withDuration(Duration.ofSeconds(2))).release().perform();
    //resource id --> id
        System.out.println(driver.findElementById("android:id/title").isDisplayed());
    }

}
