package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class baseChrome {

    public static AndroidDriver<AndroidElement> Capabalities() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"AndroidDeviceABC");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");


    //    capabilities.setCapability("appPackage","com.android.chrome");
    //   capabilities.setCapability("appActivity","org.chromium.chrome.browser.document.ChromeLauncherActivity");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        return driver;

    }
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = Capabalities();
        driver.get("https://www.cricbuzz.com/");
      //  driver.findElementByXPath("//android.widget.TextView[@text()='Preference']").click();

    }
}
