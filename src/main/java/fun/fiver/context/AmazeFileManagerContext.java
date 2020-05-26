package fun.fiver.context;

import fun.fiver.utils.DriverUtils;
import io.appium.java_client.android.AndroidDriver;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.openqa.selenium.WebElement;

public class AmazeFileManagerContext extends ExecutionContext {

    protected AndroidDriver<WebElement> androidDriver;
    protected WebElement targetElement;

    @BeforeExecution
    public void executeBeforeTest() {
        androidDriver = DriverUtils.getDefaultAndroidDriver();
    }

    @AfterExecution
    public void executeAfterTest() {
        androidDriver.quit();
    }


}
