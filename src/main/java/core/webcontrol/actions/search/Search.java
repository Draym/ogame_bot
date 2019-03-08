package core.webcontrol.actions.search;

import core.webcontrol.actions.Action;
import core.webcontrol.directives.DirectiveAction;
import org.openqa.selenium.*;
import utils.TString;

import java.util.List;

public class Search extends Action {
    private WebElement firstById(SearchContext container, String id) {
        return container.findElement(By.id(id));
    }

    private WebElement firstByCss(SearchContext container, String css) {
        return container.findElement(By.cssSelector(css));
    }

    private List<WebElement> allById(SearchContext container, String id) {
        return container.findElements(By.id(id));
    }

    private List<WebElement> allByCss(SearchContext container, String css) {
        return container.findElements(By.cssSelector(css));
    }

    private WebElement firstByValue(List<WebElement> elements, String value) {
        for (WebElement element : elements) {
            System.out.println(element.getText());
            if (TString.isEqual(element.getText(), value)) {
                return element;
            }
        }
        throw new NotFoundException("[Search][firstByValue] element [" + value + "] not found.");
    }

    public boolean isValid(DirectiveAction params) {
        return (params.func != null && params.localisation != null);
    }

    public Object run(Object targetContainer, DirectiveAction params) {
        if (this.isValid(params))
            throw new InvalidArgumentException("[Search] invalid argument DirectiveAction");

        if (targetContainer instanceof SearchContext) {
            SearchContext container = (SearchContext) targetContainer;

            if (TString.isEqual(params.func, "firstById")) {
                return this.firstById(container, params.localisation);
            } else if (TString.isEqual(params.func, "firstByCss")) {
                return this.firstByCss(container, params.localisation);
            } else if (TString.isEqual(params.func, "allById")) {
                return this.allById(container, params.localisation);
            } else if (TString.isEqual(params.func, "allByCss")) {
                return this.allByCss(container, params.localisation);
            }
        } else if (targetContainer instanceof List && !(((List) targetContainer).size() > 0 && ((List) targetContainer).get(0) instanceof WebElement)) {
            if (TString.isEqual(params.func, "firstByValue")) {
                return this.firstByValue((List<WebElement>)targetContainer, params.localisation);
            }
        } else {
            throw new InvalidArgumentException("[Search][firstByValue] invalid elements type, it should be List<WebElements>");
        }
        return null;
    }
}
