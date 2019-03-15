package core.webScript.actions.methods.search;

import core.webScript.actions.Action;
import core.webScript.actions.methods.ActionMethod;
import org.openqa.selenium.*;
import utils.storage.WebIdsData;
import utils.tools.TString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Search extends Action {

    @Override
    protected void createMethods() {
        this.methods.add(WebIdsData.get().search_firstByCss);
    }

    @Override
    public ActionMethod getMethod(String id) {
        if (TString.isEqual(id, WebIdsData.get().search_firstByCss))
            return new FirstByCss();
        return null;
    }
    /**
     * FirstByCs
     ***/
    public static class FirstByCss extends ActionMethod {
        private final String web_inputCSS = "css_selector";

        private WebElement firstByCss(SearchContext container, String css) {
            WebElement element = container.findElement(By.cssSelector(css));

            if (element == null)
                throw new NotFoundException("[Search.FirstByCss] element {" + css + "} has not been found in " + container.toString());
            return element;
        }

        @Override
        protected void createParams() {
            this.blocParams.put(this.web_inputCSS, "");
        }

        @Override
        public void run(WebDriver driver, Map<String, Object> globalParams) {
            SearchContext target = this.getNewContext(driver, this.blocParams, globalParams);
            WebElement result = this.firstByCss(target, (String) this.blocParams.get(this.web_inputCSS));
            globalParams.put(this.id, result);
        }

        @Override
        public List<String> getResultIds() {
            List<String> result = new ArrayList<>();
            result.add(this.id);
            return result;
        }
    }
    /**
     * FirstByCssAndValue
     ***/
    public static class FirstByCssAndValue extends ActionMethod {
        private final String web_inputCSS = "css_selector";
        private final String web_inputValue = "value";

        private List<WebElement> allByCss(SearchContext container, String css) {
            return container.findElements(By.cssSelector(css));
        }

        private WebElement firstByValue(List<WebElement> elements, String value) {
            for (WebElement element : elements) {
                if (TString.contains(element.getText(), value)) {
                    return element;
                }
            }
            throw new NotFoundException("[Search.FirstByValue] element {" + value + "} has not been found");
        }

        @Override
        protected void createParams() {
            this.blocParams.put(this.web_inputCSS, "");
            this.blocParams.put(this.web_inputValue, "");
        }

        @Override
        public void run(WebDriver driver, Map<String, Object> globalParams) {
            SearchContext target = this.getNewContext(driver, this.blocParams, globalParams);

            List<WebElement> resultList = this.allByCss(target, (String) this.blocParams.get(this.web_inputCSS));
            WebElement result = this.firstByValue(resultList, (String) this.blocParams.get(this.web_inputValue));

            globalParams.put(this.id, result);
        }

        @Override
        public List<String> getResultIds() {
            List<String> result = new ArrayList<>();
            result.add(this.id);
            return result;
        }
    }

    /**
     * AllByCss
     ***/
    public class AllByCss extends ActionMethod {
        private final String web_inputCSS = "css_selector";

        private List<WebElement> allByCss(SearchContext container, String css) {
            return container.findElements(By.cssSelector(css));
        }

        @Override
        protected void createParams() {
            this.blocParams.put(this.web_inputCSS, "");
        }

        @Override
        public void run(WebDriver driver, Map<String, Object> globalParams) {
            SearchContext target = this.getNewContext(driver, this.blocParams, globalParams);
            List<WebElement> result = this.allByCss(target, (String) this.blocParams.get(this.web_inputCSS));
            globalParams.put(this.id, result);
        }

        @Override
        public List<String> getResultIds() {
            List<String> result = new ArrayList<>();
            result.add(this.id);
            return result;
        }
    }
}
