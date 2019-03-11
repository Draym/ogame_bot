import core.scripts.*;
import org.openqa.selenium.WebDriver;
import utils.Console;
import utils.PlayerStaticData;
import driver.WebDriverFactory;
import driver.EDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void version1(WebDriver driver) {
        Script auth = new GoToGame(PlayerStaticData.email, PlayerStaticData.password, PlayerStaticData.serverName);
        Script navigate = new GoToFleet();
        Script build = new BuildMetalMine();
        try {
            Console.print("Script1--");
            auth.run(driver);
            Console.print("> DONE");
            Console.print("Script2--");
            navigate.run(driver);
            Console.print("> DONE");
            Console.print("Script2--");
            //build.run(driver);
            Console.print("> DONE");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void version2(WebDriver driver) {
        Script script1 = new GoToGame_v2();

        try {
            script1.run(driver);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.get(EDriver.CHROME);

        driver.get(PlayerStaticData.url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //version1(driver);
        version2(driver);
    }
}
