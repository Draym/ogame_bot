package core.scripts;

import core.webcontrol_deprecated.directives.DirectiveFactory;
import core.webcontrol_deprecated.directives.EDirective;
import core.webcontrol_deprecated.directives.build.BuildGenericDirectiveParameters;
import core.webcontrol_deprecated.directives.build.EBuildType;
import org.openqa.selenium.WebDriver;

public class BuildMetalMine implements ScriptManager {
    public void run(WebDriver driver) throws Exception {
        DirectiveFactory.get(EDirective.BUILD).run(driver, new BuildGenericDirectiveParameters(EBuildType.ECONOMY, "Mine de métal", 0));
    }
}
