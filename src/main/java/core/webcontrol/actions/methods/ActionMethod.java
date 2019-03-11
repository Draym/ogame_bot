package core.webcontrol.actions.methods;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import utils.WebIdsData;

import java.util.HashMap;
import java.util.Map;

public abstract class ActionMethod {
    public String id;
    public String type;
    public Map<String, Object> params;

    protected SearchContext getNewContext(WebDriver driver, Map<String, Object> params, Map<String, Object> currentParams) {
        if (!params.containsKey(WebIdsData.get().web_driver))
            return driver;
        String id = (String) params.get(WebIdsData.get().web_driver);
        return (SearchContext) currentParams.get(id);
    }

    protected abstract void createRequiredParameters();
    public abstract void run(WebDriver driver, Map<String, Object> currentParams);

    public ActionMethod(){
        this.params = new HashMap<>();
        this.createRequiredParameters();
    }
}
