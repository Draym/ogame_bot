package core.webScript.actions.methods.input;

import core.webScript.actions.Action;
import core.webScript.actions.methods.ActionMethod;
import org.openqa.selenium.*;
import utils.storage.Pair;
import utils.storage.WebIdsData;
import utils.tools.StringTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Input extends Action {

    @Override
    protected void createMethods() {
        this.methods.add(WebIdsData.get().input_firstByCss);
    }

    @Override
    public ActionMethod getMethod(String id) {
        if (StringTools.isEqual(id, WebIdsData.get().input_firstByCss))
            return new FirstByCss();
        return null;
    }

    /**
     * FirstByCss
     ***/
    public static class FirstByCss extends ActionMethod {
        private final String web_inputCSS = "css_selector";
        private final String web_inputValue = "value";

        private void firstByCss(SearchContext container, String css, String value) {
            WebElement element = container.findElement(By.cssSelector(css));

            if (element == null)
                throw new NotFoundException("[Input.FirstByCss] element {" + css + "} has not been found in " + container.toString());
            element.sendKeys(value);
        }

        @Override
        protected void createParams() {
            this.blocParams.put(this.web_inputCSS, "");
            this.blocParams.put(this.web_inputValue, "");
        }

        @Override
        public void run(WebDriver driver, Map<String, Object> globalParams) {
            SearchContext target = this.getNewContext(driver, this.blocParams, globalParams);
            this.firstByCss(target, this.blocParams.get(this.web_inputCSS), this.blocParams.get(this.web_inputValue));
        }

        @Override
        public List<Pair<String, Class>> getResultIds() {
            return new ArrayList<>();
        }
    }
}
