package fun.fiver.tests;

import fun.fiver.CreateFolder;
import fun.fiver.context.AmazeFileManagerContext;
import fun.fiver.utils.FileUtils;
import fun.fiver.utils.ThreadUtils;
import fun.fiver.utils.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.util.Assert;

import java.util.List;


public class CreateFolderTest extends AmazeFileManagerContext implements CreateFolder {

    private String folderName = FileUtils.generateFileName();

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
    public void e_ClickFloatingActionButton() {
        targetElement = androidDriver.findElement(By.id("com.amaze.filemanager:id/sd_main_fab"));
        targetElement.click();
    }

    @Override
    public void v_FloatingActionButtonMenu() {
        ThreadUtils.sleep(1000);
    }

    @Override
    public void e_ClickFolderMenuItem() {
        targetElement = androidDriver.findElement(By.id("com.amaze.filemanager:id/menu_new_folder"));
        targetElement.click();
    }

    @Override
    public void v_CreateNewFolderDialog() {
        ThreadUtils.sleep(1000);
    }

    @Override
    public void e_GiveFocusToInputBox() {
        targetElement = androidDriver.findElement(By.id("com.amaze.filemanager:id/singleedittext_input"));
        targetElement.click();
    }

    @Override
    public void v_ReadyToAcceptInput() {
        ThreadUtils.sleep(2500);
    }

    @Override
    public void e_InputNewFolderName() {
        targetElement.sendKeys(folderName);
    }

    @Override
    public void v_ReadyToCreateFolder() {
        ThreadUtils.sleep(1000);
    }

    @Override
    public void e_ClickOKToCreateFolder() {
        targetElement = androidDriver.findElement(By.id("com.amaze.filemanager:id/md_buttonDefaultPositive"));
        targetElement.click();
    }

    @Override
    public void v_VerifyFolderCreation() {

        ThreadUtils.sleep(2500);

        boolean isFolderFound = false;

        WebElementUtils.scrollToElementWithVisibleText(androidDriver, folderName);

        WebElement recyclerView = androidDriver.findElement(By.id("com.amaze.filemanager:id/listView"));

        List<WebElement> candidateElements = recyclerView.findElements(By.className("android.widget.RelativeLayout"));

        for (WebElement candidateElement : candidateElements) {

            List<WebElement> subCandidateElements = candidateElement.findElements(By.className("android.widget.RelativeLayout"));

            if (subCandidateElements.size() != 2) {
                continue;
            }

            WebElement subCandidateElement = subCandidateElements.get(1);

            WebElement textView = subCandidateElement.findElement(By.className("android.widget.TextView"));

            if (textView.getText().equals(folderName)) {
                isFolderFound = true;
                //targetElement = candidateElement.findElement(By.className("android.widget.ImageButton"));
                break;
            }
        }

        //targetElement.click();

        Assert.isTrue(isFolderFound, "Folder with name " + folderName + " couldn't be found!");

        ThreadUtils.sleep(1000);
    }

}
