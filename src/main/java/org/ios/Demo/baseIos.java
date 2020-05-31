package org.ios.Demo;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class baseIos {

    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 11");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"IOS");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        capabilities.setCapability("useNewWDA", true);

       capabilities.setCapability("derivedDataPath", " /Users/shridharvenkatesh/Library/Developer/Xcode/DerivedData/WebDriverAgent-ciegwgvxzxdrqthilmrmczmqvrgu");
     //   capabilities.setCapability(MobileCapabilityType.APP,"/Users/shridharvenkatesh/Library/Developer/Xcode/DerivedData/UICatalog-fcyyuipkrcqvswevscugwphdpcms/Build/Products/Debug-iphonesimulator/UICatalog.app");
       capabilities.setCapability(MobileCapabilityType.APP,"/Users/shridharvenkatesh/Desktop/AppiumD/UICatalog.app");

        IOSDriver<IOSElement> driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }
}
