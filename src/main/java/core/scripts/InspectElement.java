package core.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Console;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class InspectElement implements ScriptManager {

    @Override
    public void run(WebDriver driver) throws Exception {

        while(1 == 1) {
            Point p = MouseInfo.getPointerInfo().getLocation();

            WebElement ele = driver.switchTo().activeElement();
            //WebElement ele = (WebElement) ((JavascriptExecutor)driver).executeScript(
            //        "return document.elementFromPoint(arguments[0], arguments[1])",
             //       p.x, p.y);
            if (ele != null) {
                String className = ele.getAttribute("class");
                String id = ele.getAttribute("id");
                String type = ele.getTagName();
                Console.print("x: " + p.x + "; y: " + p.y + " --> " + type + (id != null? "#" + id : "." + className));
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
