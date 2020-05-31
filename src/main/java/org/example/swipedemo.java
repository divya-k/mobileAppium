package org.example;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class swipedemo extends base{
    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = Capabalities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        driver.findElementByXPath("//android.widget.TextView[@text()='Date Widgets']").click();
     //   driver.findElementByXPath("//android.widget.TextView[@text()='2. Inline']").click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
        driver.findElementByXPath("//*[@content-desc='9']").click();

        TouchAction t = new TouchAction(driver);
        //We need to longpress on the element for 2 Second, Mpve to another element and you release

        WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
        WebElement second = driver.findElementByXPath("//*[@content-desc='45']");
        t.longPress(LongPressOptions.longPressOptions().withElement(element(first)).withDuration(Duration.ofSeconds(2))).moveTo(element(second)).release().perform();
    }
}
