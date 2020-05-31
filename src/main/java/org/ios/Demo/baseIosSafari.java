package org.ios.Demo;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class baseIosSafari {

    public static void main(String[] args) throws MalformedURLException {








        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");

                dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.5");

        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"IOS");
                 dc.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 11");

       dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);

        IOSDriver<IOSElement> driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://gmail.com");

        driver.findElementByName("Email").sendKeys("rahul");

        driver.findElementByName("Passwd").sendKeys("rahul");

        driver.findElementByName("signIn").click();

    }
}
