package core.webScript.actions.methods.click;

import core.webScript.actions.Action;
import core.webScript.actions.methods.ActionMethod;
import org.openqa.selenium.*;
import utils.storage.WebIdsData;
import utils.tools.TString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Click extends Action {

    @Override
    public void createMethods() {
        this.methods.add(WebIdsData.get().click_firstByCss);
        this.methods.add(WebIdsData.get().click_firstByCssAndValue);
    }

    @Override
    public ActionMethod getMethod(String id) {
        if (TString.isEqual(id, WebIdsData.get().click_firstByCss))
            return new FirstByCss();
        else if (TString.isEqual(id, WebIdsData.get().click_firstByCssAndValue))
            return new FirstByCss();
        return null;
    }

    /**
     * FirstByCss
     ***/
    public static class FirstByCss extends ActionMethod {
        private final String web_inputCSS = "css_selector";

        private void firstByCss(SearchContext container, String css) {
            WebElement element = container.findElement(By.cssSelector(css));

            if (element == null)
                throw new NotFoundException("[Click.FirstByCss] element {" + css + "} has not been found in " + container.toString());
            element.click();
        }

        @Override
        public void createParams() {
            this.blocParams.put(this.web_inputCSS, "");
        }

        @Override
        public void run(WebDriver driver, Map<String, Object> globalParams) {
            SearchContext target = this.getNewContext(driver, this.blocParams, globalParams);

            this.firstByCss(target, (String) this.blocParams.get(this.web_inputCSS));
        }

        @Override
        public List<String> getResultIds() {
            return new ArrayList<>();
        }
    }

    /**
     * FirstByCssAndValue
     ***/
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
            throw new NotFoundException("[Click.FirstByCssAndValue] element {" + value + "} not found.");
        }

        @Override
        public void createParams() {
            this.blocParams.put(this.web_inputCSS, "");
            this.blocParams.put(this.web_inputValue, "");
        }

        @Override
        public void run(WebDriver driver, Map<String, Object> globalParams) {
            SearchContext target = this.getNewContext(driver, this.blocParams, globalParams);
            this.firstByCssAndValue(target, (String) this.blocParams.get(this.web_inputCSS), (String) this.blocParams.get(this.web_inputValue));
        }

        @Override
        public List<String> getResultIds() {
            return new ArrayList<>();
        }
    }
}