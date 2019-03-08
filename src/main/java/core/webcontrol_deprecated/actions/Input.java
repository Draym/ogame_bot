package core.webcontrol_deprecated.actions;

import org.openqa.selenium.SearchContext;

public class Input {

    public static void byId(SearchContext container, String id, String value) {
        Search.firstById(container, id).sendKeys(value);
    }
    public static void byCss(SearchContext container, String css, String value) {
        Search.firstByCss(container, css).sendKeys(value);
    }
}
