package core.webcontrol.actions.methods.browser;

import core.webcontrol.actions.Action;
import core.webcontrol.actions.methods.ActionMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import utils.storage.WebIdsData;
import utils.tools.TString;

import java.util.ArrayList;
import java.util.Map;

public class Browser extends Action {

    @Override
    protected void createMethods() {
        this.methods.add(WebIdsData.get().browser_closeTab);
    }

    @Override
    public ActionMethod getMethod(String id) {
        if (TString.isEqual(id, WebIdsData.get().browser_closeTab))
            return new CloseTab();
        return null;
    }

    /**
     * CloseTab
     ***/
    public static class CloseTab extends ActionMethod {
        private final String tabOpen_index = "open tabIndex";
        private final String tabClose_index = "close tabIndex";

        private void closeTab(WebDriver driver, Integer open, Integer close) {
            ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(close));
            driver.close();
            driver.switchTo().window(tabs2.get(open));
        }

        @Override
        public void createParams() {
            this.blocParams.put(this.tabOpen_index, "");
            this.blocParams.put(this.tabClose_index, "");
        }

        @Override
        public void run(WebDriver driver, Map<String, Object> globalParams) {
            this.closeTab(driver, Integer.parseInt((String) this.blocParams.get(this.tabOpen_index)), Integer.parseInt((String) this.blocParams.get(this.tabClose_index)));
        }
    }
}
