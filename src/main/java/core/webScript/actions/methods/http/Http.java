package core.webScript.actions.methods.http;

import core.webScript.actions.Action;
import core.webScript.actions.methods.ActionMethod;
import core.webScript.actions.methods.browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.storage.Pair;
import utils.storage.WebIdsData;
import utils.tools.StringTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Http extends Action {
    @Override
    protected void createMethods() {
        this.methods.add(WebIdsData.get().http_get);
    }

    @Override
    public ActionMethod getMethod(String id) {
        if (StringTools.isEqual(id, WebIdsData.get().http_get))
            return new Browser.CloseTab();
        return null;
    }

    /**
     * GET
     */
    public static class Get extends ActionMethod {

        @Override
        public void run(WebDriver driver, Map<String, Object> globalParams) {

        }

        @Override
        protected void createParams() {

        }

        @Override
        public List<Pair<String, Class>> getResultIds() {
            List<Pair<String, Class>> result = new ArrayList<>();
            return result;
        }
    }
}
