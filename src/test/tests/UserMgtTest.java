package tests;

import base.BasePage;
import base.BaseTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UserMgtPage;

public class UserMgtTest extends BaseTest {

    UserMgtPage userMgtPage;

    @BeforeMethod
    public void setUp() {
        userMgtPage = new UserMgtPage(driver);
    }

    @Test(testName = "Click Login and verify title is \"Login Page\"")
    public void test01() {
        extentTest.assignAuthor("Jack");
        extentTest.assignDevice("OS: Mac");

        userMgtPage.click(userMgtPage.userMgtBtn);

        String expectedTitle = "Login Page";
        String actualTitle = userMgtPage.switchWindowCaptureTitle(driver);

        if (actualTitle.equals(expectedTitle)) {
            extentTest.pass(MarkupHelper.createLabel("Test PASSED - Title is: " + actualTitle, ExtentColor.GREEN));
        } else {
            extentTest.fail(MarkupHelper.createLabel("Test FAILED - Title is: " + actualTitle, ExtentColor.RED));
        }

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(testName = "Click Access DB and verify title is \"User DB\"")
    public void test02() {
        extentTest.assignAuthor("Jack");
        extentTest.assignDevice("OS: Mac");

        userMgtPage.click(userMgtPage.userMgtBtn);
        userMgtPage.click(userMgtPage.AccessDbBtn);

        String expectedTitle = "User DB";
        String actualTitle = userMgtPage.getTitleMethod();

        if (actualTitle.equals(expectedTitle)) {
            extentTest.pass(MarkupHelper.createLabel("Test PASSED - Title is: " + actualTitle, ExtentColor.GREEN));
        } else {
            extentTest.fail(MarkupHelper.createLabel("Test FAILED - Title is: " + actualTitle, ExtentColor.RED));
        }

        Assert.assertEquals(actualTitle, expectedTitle);
    }
}