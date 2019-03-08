package core.webcontrol_deprecated.directives.fleet;

import core.webcontrol_deprecated.directives.Directive;
import core.webcontrol_deprecated.directives.DirectiveParameters;
import org.openqa.selenium.WebDriver;

public class MoveFleet implements Directive {



    private void selectFleet(WebDriver driver) {

    }

    private void selectSpeed(WebDriver driver) {

    }

    private void selectDestination (WebDriver driver) {

    }

    private void selectMission(WebDriver driver) {

    }

    private void selectResources(WebDriver driver) {

    }

    private void launchFleet(WebDriver driver) {

    }

    public void run(WebDriver driver, DirectiveParameters parameters) throws Exception {
        if (!(parameters instanceof MoveFleetDirectiveParameters))
            throw new ClassCastException("MoveFleetDirectiveParameters is mandatory.");
        MoveFleetDirectiveParameters params = (MoveFleetDirectiveParameters) parameters;

        this.selectFleet(driver);
        this.selectSpeed(driver);
        this.selectDestination(driver);
        this.selectMission(driver);
        this.selectResources(driver);
        this.launchFleet(driver);
    }
}
