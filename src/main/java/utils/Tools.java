package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Tools {
    public static void screenshot(WebDriver driver) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:\\Users\\keandres\\Pictures\\test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
