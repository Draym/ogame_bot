package core.webcontrol.actions.methods.input;

import core.webcontrol.actions.Action;
import core.webcontrol.actions.methods.ActionMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class Input extends Action {

    @Override
    protected void createMethods() {
        this.methods.put("FirstByCss", new FirstByCss());
    }

    public static class FirstByCss extends ActionMethod {
        private final String web_inputCSS = "css_selector";
        private final String web_inputValue = "value";

        private void firstByCss(SearchContext container, String css, String value) {
            container.findElement(By.cssSelector(css)).sendKeys(value);
        }

        @Override
        protected void createRequiredParameters() {
            this.params.put(this.web_inputCSS, "");
            this.params.put(this.web_inputValue, "");
        }

        @Override
        public void run(WebDriver driver, Map<String, Object> currentParams) {
            SearchContext target = this.getNewContext(driver, this.params, currentParams);
            this.firstByCss(target, (String) this.params.get(this.web_inputCSS), (String) this.params.get(this.web_inputValue));
        }
    }
}
