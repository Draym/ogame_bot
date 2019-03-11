package core.webcontrol.actions.methods.jquery;

import core.webcontrol.actions.Action;
import core.webcontrol.actions.methods.ActionMethod;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class Jquery extends Action {
    @Override
    protected void createMethods() {
        this.methods.put("executeScript", new Script());
    }

    public static class Script extends ActionMethod {

        private final String web_inputScript = "jquery_script";

        private void executeScript(SearchContext container, String script) {
            ((JavascriptExecutor)container).executeScript(script);
        }

        @Override
        protected void createRequiredParameters() {
            this.params.put(this.web_inputScript, "");
        }

        @Override
        public void run(WebDriver driver, Map<String, Object> currentParams) {
            SearchContext target = this.getNewContext(driver, this.params, currentParams);

            this.executeScript(target, (String) this.params.get(this.web_inputScript));
        }
    }
}
