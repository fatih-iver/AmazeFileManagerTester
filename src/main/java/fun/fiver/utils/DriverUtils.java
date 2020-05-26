package fun.fiver.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverUtils {

    public static AndroidDriver<WebElement> getDefaultAndroidDriver() {

        DesiredCapabilities desiredCapabilities = SetupUtils.getDefaultDesiredCapabilities();
        URL remoteAddress = SetupUtils.getDefaultRemoteAddress();

        return new AndroidDriver<>(remoteAddress, desiredCapabilities);

    }
}
