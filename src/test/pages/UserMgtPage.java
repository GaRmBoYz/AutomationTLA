package pages;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class UserMgtPage extends BasePage {

    public UserMgtPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='User-Mgt']")
    public WebElement userMgtBtn;

    @FindBy(id = "login-btn")
    public WebElement loginBtn;

    @FindBy(id = "access-db-btn")
    public WebElement AccessDbBtn;

    public String switchWindowCaptureTitle(WebDriver driver) {
        String originalWindowID = driver.getWindowHandle();

        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String windowID : allWindowIDs) {
            if (!windowID.equals(originalWindowID)) {
                driver.switchTo().window(windowID);
            }
        }

        String title = driver.getTitle();
        driver.switchTo().window(originalWindowID);

        return title;
    }
}
