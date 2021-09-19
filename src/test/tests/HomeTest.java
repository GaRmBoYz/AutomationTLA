package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import java.util.List;

public class HomeTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void setUp(){
        homePage = new HomePage(driver);
    }

    @Test(testName = "Verify 7 links are visible at the bottom of the page")
    public void test01(){
        extentTest.assignAuthor("Jack");
        extentTest.assignDevice("Mac OS");

        List<WebElement> bottomLinks = homePage.allLinks;

        for (WebElement eachLink : bottomLinks){
            Assert.assertTrue(eachLink.isDisplayed());
        }

        homePage.scroll("1000");

        logScreeenshot("HomePage-BottomLinks");
    }
}
