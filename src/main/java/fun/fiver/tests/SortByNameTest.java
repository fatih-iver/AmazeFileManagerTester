package fun.fiver.tests;

import fun.fiver.SortByName;
import fun.fiver.context.AmazeFileManagerContext;
import fun.fiver.utils.ThreadUtils;
import fun.fiver.utils.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class SortByNameTest extends AmazeFileManagerContext implements SortByName {

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
    public void e_ClickOptionsMenu() {
        targetElement = androidDriver.findElementByXPath("//android.widget.ImageView[@content-desc=\"More options\"]");
        targetElement.click();
    }

    @Override
    public void v_OptionsMenu() {
        ThreadUtils.sleep(1000);
    }

    @Override
    public void e_ClickSortOption() {
        targetElement = androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        targetElement.click();
    }

    @Override
    public void v_SubOptionsMenu() {
        ThreadUtils.sleep(1000);
    }

    @Override
    public void e_ClickSortByOption() {
        targetElement = androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        targetElement.click();
    }

    @Override
    public void v_SortByDialog() {
        ThreadUtils.sleep(1000);
    }

    @Override
    public void e_ChooseSortByName() {
        targetElement = androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView");
        targetElement.click();
    }

    @Override
    public void v_SortByNameChosen() {
        ThreadUtils.sleep(1000);
    }

    @Override
    public void e_ClickAscending() {
        targetElement = androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]");
        targetElement.click();
    }

    @Override
    public void v_VerifySortOrder() {

        ThreadUtils.sleep(1000);

        List<String> fileNames = new ArrayList<>();

        WebElement recyclerView = androidDriver.findElement(By.id("com.amaze.filemanager:id/listView"));

        List<WebElement> candidateElements = recyclerView.findElements(By.className("android.widget.RelativeLayout"));

        for (WebElement candidateElement : candidateElements) {

            List<WebElement> textViews = candidateElement.findElements(By.id("com.amaze.filemanager:id/firstline"));

            for (WebElement textView : textViews) {
                fileNames.add(textView.getText().toLowerCase());
            }
        }

        boolean isSortedInAscendingOrder = fileNames.stream().sorted().collect(Collectors.toList()).equals(fileNames);

        Assert.isTrue(isSortedInAscendingOrder, "File names are not sorted in ascending order!");

        ThreadUtils.sleep(1000);

    }


}
