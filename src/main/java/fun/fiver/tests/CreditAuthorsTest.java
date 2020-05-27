package fun.fiver.tests;

import fun.fiver.CreditAuthors;
import fun.fiver.context.AmazeFileManagerContext;
import fun.fiver.utils.ThreadUtils;
import fun.fiver.utils.WebElementUtils;
import org.openqa.selenium.By;
import org.springframework.util.Assert;


public class CreditAuthorsTest extends AmazeFileManagerContext implements CreditAuthors {

    private static final String FIRST_AUTHOR = "Arpit Khurana";
    private static final String SECOND_AUTHOR = "Vishal Nehra";

    @Override
    public void v_StartState() {
        ThreadUtils.sleep(1000);
    }

    @Override
    public void e_GrantPermission() {
        targetElement = androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));

        WebElementUtils.waitUntilDisplayed(targetElement);

        targetElement.click();
    }

    @Override
    public void v_Home() {
        ThreadUtils.sleep(1000);
    }

    @Override
    public void e_OpenNavigationDrawer() {
        targetElement = androidDriver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));

        WebElementUtils.waitUntilDisplayed(targetElement);

        targetElement.click();
    }

    @Override
    public void v_NavigationDrawer() {
        ThreadUtils.sleep(1000);
    }

    @Override
    public void e_OpenSettings() {
        WebElementUtils.scrollToElementWithVisibleText(androidDriver, "Settings");

        targetElement = androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[8]"));

        WebElementUtils.waitUntilDisplayed(targetElement);

        targetElement.click();
    }

    @Override
    public void v_Settings() {
        ThreadUtils.sleep(1000);
    }

    @Override
    public void e_OpenAbout() {

        WebElementUtils.scrollToElementWithVisibleText(androidDriver, "About Amaze File Manager");

        targetElement = androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[7]/android.widget.RelativeLayout"));

        WebElementUtils.waitUntilDisplayed(targetElement);

        targetElement.click();
    }

    @Override
    public void v_About() {
        ThreadUtils.sleep(1000);
    }

    @Override
    public void e_CheckAuthors() {

        WebElementUtils.scrollToElementWithVisibleText(androidDriver, FIRST_AUTHOR);

        targetElement = androidDriver.findElement(By.id("com.amaze.filemanager:id/text_view_author_1_title"));

        Assert.isTrue(targetElement.getText().equals(FIRST_AUTHOR), "The first author's name must be: " + FIRST_AUTHOR);

        WebElementUtils.scrollToElementWithVisibleText(androidDriver, SECOND_AUTHOR);

        targetElement = androidDriver.findElement(By.id("com.amaze.filemanager:id/text_view_author_2_title"));

        Assert.isTrue(targetElement.getText().equals(SECOND_AUTHOR), "The seconds author's name must be: " + SECOND_AUTHOR);

    }

}
