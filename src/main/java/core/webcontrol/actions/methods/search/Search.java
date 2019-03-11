package core.webcontrol.actions.methods.search;

import core.webcontrol.actions.Action;
import core.webcontrol.actions.methods.ActionMethod;
import org.openqa.selenium.*;
import utils.TString;

import java.util.List;
import java.util.Map;

public class Search extends Action {

    @Override
    protected void createMethods() {
        this.methods.put("FirstByCss", new FirstByCss());
    }

    public static class FirstByCss extends ActionMethod {
        private final String web_inputCSS = "css_selector";

        private WebElement firstByCss(SearchContext container, String css) {
            return container.findElement(By.cssSelector(css));
        }

        @Override
        protected void createRequiredParameters() {
            this.params.put(this.web_inputCSS, "");
        }

        @Override
        public void run(WebDriver driver, Map<String, Object> currentParams) {
            SearchContext target = this.getNewContext(driver, this.params, currentParams);
            WebElement result = this.firstByCss(target, (String) this.params.get(this.web_inputCSS));
            currentParams.put(this.id, result);
        }
    }
    public static class FirstByCssAndValue extends ActionMethod {
        private final String web_inputCSS = "css_selector";
        private final String web_inputValue = "value";

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

        @Override
        protected void createRequiredParameters() {
            this.params.put(this.web_inputCSS, "");
            this.params.put(this.web_inputValue, "");
        }

        @Override
        public void run(WebDriver driver, Map<String, Object> currentParams) {
            SearchContext target = this.getNewContext(driver, this.params, currentParams);

            List<WebElement> resultList = this.allByCss(target, (String) this.params.get(this.web_inputCSS));
            WebElement result = this.firstByValue(resultList, (String) this.params.get(this.web_inputValue));

            currentParams.put(this.id, result);
        }
    }

    public class AllByCss extends ActionMethod {
        private final String web_inputCSS = "css_selector";

        private List<WebElement> allByCss(SearchContext container, String css) {
            return container.findElements(By.cssSelector(css));
        }

        @Override
        protected void createRequiredParameters() {
            this.params.put(this.web_inputCSS, "");
        }

        @Override
        public void run(WebDriver driver, Map<String, Object> currentParams) {
            SearchContext target = this.getNewContext(driver, this.params, currentParams);
            List<WebElement> result = this.allByCss(target, (String) this.params.get(this.web_inputCSS));
            currentParams.put(this.id, result);
        }
    }
}
