package core.webScript.actions.methods;

import core.webScript.bloc.Directive;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import utils.storage.WebIdsData;

import java.util.Map;

public abstract class ActionMethod extends Directive {

    public ActionMethod() {
        super();
    }

    protected SearchContext getNewContext(WebDriver driver, Map<String, String> blocParams, Map<String, Object> globalParams) {
        if (!blocParams.containsKey(WebIdsData.get().web_driver))
            return driver;
        String id = blocParams.get(WebIdsData.get().web_driver);
        return (SearchContext) globalParams.get(id);
    }
}
