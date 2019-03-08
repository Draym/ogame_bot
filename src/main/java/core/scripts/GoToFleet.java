package core.scripts;

import core.webcontrol_deprecated.directives.DirectiveFactory;
import core.webcontrol_deprecated.directives.EDirective;
import core.webcontrol_deprecated.directives.navigate.ENavigateType;
import core.webcontrol_deprecated.directives.navigate.NavigateToDirectiveParameters;
import org.openqa.selenium.WebDriver;

public class GoToFleet implements Script {
    public void run(WebDriver driver) throws Exception {
        DirectiveFactory.get(EDirective.NAVIGATE).run(driver, new NavigateToDirectiveParameters("marchand", ENavigateType.MENU));
    }
}
