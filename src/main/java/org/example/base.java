package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class base {

    public static AndroidDriver<AndroidElement> Capabalities() throws MalformedURLException {
        File f= new File("src");
        File fs=new File(f,"original.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_XL");
        System.out.println(fs.getAbsolutePath());
        // capabilities.setCapability(MobileCapabilityType.APP,"/Users/shridharvenkatesh/Downloads/Multimedia/appammu/src/original.apk");

        capabilities.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        return driver;


    }
}
