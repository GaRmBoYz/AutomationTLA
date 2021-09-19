package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utils.ConfigReader;
import utils.ScreenShot;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    protected ExtentReports extentReports;
    protected ExtentTest extentTest;
    String configFilePath = "src/test/data/config/config.properties";

    @BeforeMethod()
    public void SetUp(Method method) {
        initializeDriver(ConfigReader.readProperty(configFilePath, "browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        extentTest = extentReports.createTest("Verify New User Test");


        driver.get(ConfigReader.readProperty(configFilePath, "url"));
    }

    @AfterMethod(groups = "smokeTest")
    public void tearDown() {
        driver.close();
    }

    @BeforeSuite
    public void startReporter() {
        //initiating extent report
        extentReports = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("reports.html");

        //adding some configurations

        spark.config().setDocumentTitle("My Report");
        spark.config().setReportName("AutomationTLA Tests");
        extentReports.attachReporter(spark);
    }

    @AfterSuite
    public void closeReporter() {
        //closing the extent reporter
        extentReports.flush();
    }

    public void initializeDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
    }

    public void logScreeenshot(String titlte) {
        extentTest.info(titlte, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot.takeScreenshot(driver)).build());
    }
}

