package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ScreenShot {
    //Base64 = String

    public static String takeScreenshot(WebDriver driver){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = new byte[0];

        try{
            fileContent = FileUtils.readFileToByteArray(scrFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent));
        return "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
    }
}
