package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

public class UiAutomatorTest extends base {
    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = Capabalities();
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

     int  k= driver.findElementsByAndroidUIAutomator("new UiSelector.clickable(true)").size();
     System.out.println(k);
    }
}
