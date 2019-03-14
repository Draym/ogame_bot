package core.webcontrol.actions.methods.input;

import core.webcontrol.actions.Action;
import core.webcontrol.actions.methods.ActionMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import utils.storage.WebIdsData;
import utils.tools.TString;

import java.util.Map;

public class Input extends Action {

    @Override
    protected void createMethods() {
        this.methods.add(WebIdsData.get().input_firstByCss);
    }

    @Override
    public ActionMethod getMethod(String id) {
        if (TString.isEqual(id, WebIdsData.get().input_firstByCss))
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
            container.findElement(By.cssSelector(css)).sendKeys(value);
        }

        @Override
        protected void createParams() {
            this.blocParams.put(this.web_inputCSS, "");
            this.blocParams.put(this.web_inputValue, "");
        }

        @Override
        public void run(WebDriver driver, Map<String, Object> globalParams) {
            SearchContext target = this.getNewContext(driver, this.blocParams, globalParams);
            this.firstByCss(target, (String) this.blocParams.get(this.web_inputCSS), (String) this.blocParams.get(this.web_inputValue));
        }
    }
}
