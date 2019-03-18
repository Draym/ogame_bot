import core.scripts.*;
import org.openqa.selenium.WebDriver;
import utils.Console;
import utils.storage.PlayerStaticData;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void version1(WebDriver driver) {
        ScriptManager auth = new GoToGame(PlayerStaticData.email, PlayerStaticData.password, PlayerStaticData.serverName);
        ScriptManager navigate = new GoToFleet();
        ScriptManager build = new BuildMetalMine();
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
        ScriptManager scriptManager1 = new GoToGame_v2();

        try {
            scriptManager1.run(driver);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void version3(WebDriver driver) {
        ScriptManager scriptManager1 = new InspectElement();

        try {
            scriptManager1.run(driver);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {

        Map<String, Object> params = new HashMap<>();
        params.put("a", 5);
        params.put("b", 5);
        boolean result = Test.executeCondition("a == b", params);

        Console.print("Result: " + result);
        return;
        /*
        WebDriver driver = WebDriverFactory.get(EDriver.CHROME);

        driver.get(PlayerStaticData.url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //version1(driver);
        //version2(driver);
        version3(driver);*/
    }
}
