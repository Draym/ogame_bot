package core.webcontrol.actions.methods.click;

import core.webcontrol.actions.Action;
import core.webcontrol.actions.methods.ActionMethod;
import org.openqa.selenium.*;
import utils.TString;

import java.util.List;
import java.util.Map;

public class Click extends Action {


    public void createMethods() {
        this.methods.put("FirstByCss", new FirstByCss());
        this.methods.put("FirstByCssAndValue", new FirstByCssAndValue());
    }

    public static class FirstByCss extends ActionMethod {
        private final String web_inputCSS = "css_selector";

        private void firstByCss(SearchContext container, String css) {
            container.findElement(By.cssSelector(css)).click();
        }

        @Override
        public void createRequiredParameters() {
            this.params.put(this.web_inputCSS, "");
        }

        @Override
        public void run(WebDriver driver, Map<String, Object> currentParams) {
            SearchContext target = this.getNewContext(driver, this.params, currentParams);

            this.firstByCss(target, (String) this.params.get(this.web_inputCSS));
        }
    }

    public static class FirstByCssAndValue extends ActionMethod {

        private final String web_inputCSS = "css_selector";
        private final String web_inputValue = "value";

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

        @Override
        public void createRequiredParameters() {
            this.params.put(this.web_inputCSS, "");
            this.params.put(this.web_inputValue, "");
        }

        @Override
        public void run(WebDriver driver, Map<String, Object> currentParams) {
            SearchContext target = this.getNewContext(driver, this.params, currentParams);
            this.firstByCssAndValue(target, (String) this.params.get(this.web_inputCSS), (String) this.params.get(this.web_inputValue));
        }
    }
}