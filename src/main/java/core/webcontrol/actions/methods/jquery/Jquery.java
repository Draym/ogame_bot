package core.webcontrol.actions.methods.jquery;

import core.webcontrol.actions.Action;
import core.webcontrol.actions.methods.ActionMethod;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import utils.storage.WebIdsData;
import utils.tools.TString;

import java.util.Map;

public class Jquery extends Action {
    @Override
    protected void createMethods() {
        this.methods.add(WebIdsData.get().jquery_script);
    }

    @Override
    public ActionMethod getMethod(String id) {
        if (TString.isEqual(id, WebIdsData.get().jquery_script))
            return new Script();
        return null;
    }

    /**
     * Script
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

            this.executeScript(target, (String) this.blocParams.get(this.web_inputScript));
        }
    }
}
