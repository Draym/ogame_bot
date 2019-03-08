package core.webcontrol.actions.click;

import core.webcontrol.actions.Action;
import core.webcontrol.directives.DirectiveAction;
import org.openqa.selenium.*;
import utils.TString;

import java.util.List;

public class Click extends Action {
    private void firstById(SearchContext container, String id) {
        container.findElement(By.id(id)).click();
    }

    private void firstByCss(SearchContext container, String css) {
        container.findElement(By.cssSelector(css)).click();
    }

    private void firstByCssAndValue(SearchContext container, String css, String value) {
        List<WebElement> elements = container.findElements(By.cssSelector(css));

        for (WebElement element : elements) {
            if (TString.isEqual(element.getText(), value)) {
                element.click();
                return;
            }
        }
        throw new NotFoundException("[Click][firstByCssAndValue] element [" + value + "] not found.");
    }

    public boolean isValid(DirectiveAction params) {
        return (params.func != null && params.localisation != null && (!TString.isEqual(params.func, "byCssAndValue") || params.value != null));
    }

    public Object run(Object targetContainer, DirectiveAction params) {
        if (this.isValid(params))
            throw new InvalidArgumentException("[Click] invalid argument DirectiveAction");
        if (!(targetContainer instanceof SearchContext))
            throw new InvalidArgumentException("[Input] invalid argument targetContainer");
        SearchContext container = (SearchContext)targetContainer;

        if (TString.isEqual(params.func, "byId")) {
            this.firstById(container, params.localisation);
        } else if (TString.isEqual(params.func, "byCss")) {
            this.firstByCss(container, params.localisation);
        } else if (TString.isEqual(params.func, "byCssAndValue")) {
            this.firstByCssAndValue(container, params.localisation, params.value);
        }
        return null;
    }
}
