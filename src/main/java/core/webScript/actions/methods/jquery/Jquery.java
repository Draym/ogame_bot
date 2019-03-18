package core.webScript.actions.methods.jquery;

import core.webScript.actions.Action;
import core.webScript.actions.methods.ActionMethod;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import utils.storage.Pair;
import utils.storage.WebIdsData;
import utils.tools.StringTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Jquery extends Action {
    @Override
    protected void createMethods() {
        this.methods.add(WebIdsData.get().jquery_script);
    }

    @Override
    public ActionMethod getMethod(String id) {
        if (StringTools.isEqual(id, WebIdsData.get().jquery_script))
            return new Script();
        return null;
    }

    /**
     * Job
     ***/
    public static class Script extends ActionMethod {

        private final String web_inputScript = "jquery_script";

        private void executeScript(SearchContext container, String script) {
            ((JavascriptExecutor)container).executeScript(script);
        }

        @Override
        protected void createParams() {
            this.blocParams.put(this.web_inputScript, "");
        }

        @Override
        public void run(WebDriver driver, Map<String, Object> globalParams) {
            SearchContext target = this.getNewContext(driver, this.blocParams, globalParams);

            this.executeScript(target, this.blocParams.get(this.web_inputScript));
        }

        @Override
        public List<Pair<String, Class>> getResultIds() {
            return new ArrayList<>();
        }
    }
}
