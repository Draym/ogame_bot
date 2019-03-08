package core.webcontrol_deprecated.directives.navigate;

import core.webcontrol_deprecated.actions.Click;
import core.webcontrol_deprecated.directives.Directive;
import core.webcontrol_deprecated.directives.DirectiveParameters;
import org.openqa.selenium.WebDriver;

public class NavigateTo implements Directive {

    private void goTo(WebDriver driver, ENavigateType searchType, String searchName) {
        Click.byCssAndValue(driver, searchType.webId, searchName);
    }

    public void run(WebDriver driver, DirectiveParameters parameters) {
        if (!(parameters instanceof NavigateToDirectiveParameters))
            throw new ClassCastException("NavigateToDirectiveParameters is mandatory.");
        NavigateToDirectiveParameters params = (NavigateToDirectiveParameters) parameters;
        goTo(driver, params.searchType, params.searchName);
    }
}
