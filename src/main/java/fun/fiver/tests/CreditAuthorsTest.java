package fun.fiver.tests;

import fun.fiver.CreditAuthors;
import fun.fiver.context.AmazeFileManagerContext;
import fun.fiver.utils.ThreadUtils;
import org.openqa.selenium.By;


public class CreditAuthorsTest extends AmazeFileManagerContext implements CreditAuthors {

    @Override
    public void v_StartState() {
    }

    @Override
    public void e_ActionGrantPermission() {
        targetElement = androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]\n"));

        while (!targetElement.isDisplayed()) {
            ThreadUtils.sleep(100);
        }

        targetElement.click();
    }

    @Override
    public void v_HomeState() {
        ThreadUtils.sleep(10000);
    }

}
