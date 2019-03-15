package core.webInspector;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Console;

import java.util.concurrent.TimeUnit;

public class InspectElement {

    public void inspect(WebDriver driver) throws InterruptedException {
        while(1 == 1) {

            WebElement ele = driver.switchTo().activeElement();
            //WebElement ele = (WebElement) ((JavascriptExecutor)driver).executeScript(
            //        "return document.elementFromPoint(arguments[0], arguments[1])",
            //       p.x, p.y);
            if (ele != null) {
                String className = ele.getAttribute("class");
                String id = ele.getAttribute("id");
                String type = ele.getTagName();
                Console.print("--> " + type + (id != null? "#" + id : "." + className));
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
