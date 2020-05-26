package fun.fiver.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class SetupUtils {

    public static DesiredCapabilities getDefaultDesiredCapabilities() {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("app", PathUtils.getAndroidPackage().getAbsolutePath());
        capabilities.setCapability("appPackage", "com.amaze.filemanager");
        capabilities.setCapability("appActivity", ".activities.MainActivity");

        return capabilities;
    }

    public static URL getDefaultRemoteAddress() {

        URL remoteAddress = null;

        try {
            remoteAddress = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        assert remoteAddress != null;

        return remoteAddress;
    }
}
