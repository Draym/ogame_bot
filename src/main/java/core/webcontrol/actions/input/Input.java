package core.webcontrol.actions.input;

import core.webcontrol.actions.Action;
import core.webcontrol.directives.DirectiveAction;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.SearchContext;
import utils.TString;

public class Input extends Action {

    private void firstById(SearchContext container, String id, String value) {
        container.findElement(By.id(id)).sendKeys(value);
    }
    private void firstByCss(SearchContext container, String css, String value) {
        container.findElement(By.cssSelector(css)).sendKeys(value);
    }

    public boolean isValid(DirectiveAction params) {
        return (params.func != null && params.localisation != null && params.value != null);
    }

    public Object run(Object targetContainer, DirectiveAction params) {
        if (this.isValid(params))
            throw new InvalidArgumentException("[Input] invalid argument DirectiveAction");
        if (!(targetContainer instanceof SearchContext))
            throw new InvalidArgumentException("[Input] invalid argument targetContainer");
        SearchContext container = (SearchContext)targetContainer;

        if (TString.isEqual(params.func, "byId")) {
            this.firstById(container, params.localisation, params.value);
        } else if (TString.isEqual(params.func, "byCss")) {
            this.firstByCss(container, params.localisation, params.value);
        }
        return null;
    }
}
