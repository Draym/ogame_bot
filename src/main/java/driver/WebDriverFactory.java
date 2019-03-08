package driver;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {

    public static WebDriver get(EDriver driver) {
        if (driver == EDriver.FIREFOX) {
            System.setProperty("webdriver.gecko.driver", "C:\\web_driver\\geckodriver\\geckodriver.exe");

            return new FirefoxDriver();
        } else if (driver == EDriver.CHROME) {
            System.setProperty("webdriver.chrome.driver", "C:\\web_driver\\chromedriver_win32\\chromedriver.exe");
            return new ChromeDriver();
        } else if (driver == EDriver.GHOST) {
            DesiredCapabilities DesireCaps = new DesiredCapabilities();
            DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\web_driver\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
            return new PhantomJSDriver(DesireCaps);
        }
        throw new NotFoundException();
    }
}
