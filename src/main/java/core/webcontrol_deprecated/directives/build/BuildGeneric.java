package core.webcontrol_deprecated.directives.build;

import core.webcontrol_deprecated.actions.Click;
import core.webcontrol_deprecated.actions.Input;
import core.webcontrol_deprecated.directives.Directive;
import core.webcontrol_deprecated.directives.DirectiveFactory;
import core.webcontrol_deprecated.directives.DirectiveParameters;
import core.webcontrol_deprecated.directives.EDirective;
import core.webcontrol_deprecated.directives.navigate.ENavigateType;
import core.webcontrol_deprecated.directives.navigate.NavigateToDirectiveParameters;
import org.openqa.selenium.WebDriver;
import utils.storage.Pair;
import utils.storage.WebIdsData;

public class BuildGeneric implements Directive {
    private void build(WebDriver driver, Pair<String, String> target, boolean hasQuantity, int targetQuantity) {

        if (target == null)
            throw new NullPointerException("[BuildGeneric]: target is null");

        Click.byCss(driver, target.value);
        if (hasQuantity)
            Input.byCss(driver, WebIdsData.get().input_buildQuantity, String.valueOf(targetQuantity));
        Click.byCss(driver, WebIdsData.get().btn_buildLaunch);
    }

    public void run(WebDriver driver, DirectiveParameters parameters) throws Exception {
        if (!(parameters instanceof BuildGenericDirectiveParameters))
            throw new ClassCastException("BuildGenericDirectiveParameters is mandatory.");
        BuildGenericDirectiveParameters params = (BuildGenericDirectiveParameters) parameters;

        // MOVE TO MENU
        DirectiveFactory.get(EDirective.NAVIGATE).run(driver, new NavigateToDirectiveParameters(params.type.location, ENavigateType.MENU));

        // BUILD TARGET
        this.build(driver, params.type.getTarget(params.targetBuild), params.type.hasQuantity, params.targetQuantity);
    }
}
