package fun.fiver.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class WebElementUtils {

    public static void waitUntilDisplayed(WebElement webElement) {
        while (!webElement.isDisplayed()) {
            ThreadUtils.sleep(100);
        }
    }

    public static void scrollToElementWithVisibleText(AndroidDriver<WebElement> androidDriver, String visibleText) {
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))");
    }
}
