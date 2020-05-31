package org.ecommerce;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class baseEcommerce {

    public static AndroidDriver<AndroidElement> Capabalities() throws MalformedURLException {

        AndroidDriver<AndroidElement> driver;
        File f= new File("src");
        File fs=new File(f,"ecommerce.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"AndroidDeviceABC");

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);

        System.out.println(fs.getAbsolutePath());
        // capabilities.setCapability(MobileCapabilityType.APP,"/Users/shridharvenkatesh/Downloads/Multimedia/appammu/src/original.apk");

        capabilities.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;


    }
}
