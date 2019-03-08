import core.scripts.BuildMetalMine;
import core.scripts.GoToFleet;
import core.scripts.GoToGame;
import core.scripts.Script;
import org.openqa.selenium.WebDriver;
import utils.Console;
import utils.PlayerStaticData;
import driver.WebDriverFactory;
import driver.EDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.get(EDriver.CHROME);

        driver.get(PlayerStaticData.url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

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
}
