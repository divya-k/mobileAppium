package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

public class basics extends base{
    
    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = Capabalities();
        driver.findElementByXPath("//android.widget.TextView[@text()='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@text()='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();

        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
        driver.findElementsByClassName("android.widget.Button").get(1).click();

    }
}
