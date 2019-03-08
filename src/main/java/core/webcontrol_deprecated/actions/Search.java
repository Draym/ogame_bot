package core.webcontrol_deprecated.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Search {
    public static WebElement firstById(SearchContext container, String id) {
        return container.findElement(By.id(id));
    }

    public static WebElement firstByCss(SearchContext container, String css) {
        return container.findElement(By.cssSelector(css));
    }

    public static List<WebElement> allById(SearchContext container, String id) {
        return container.findElements(By.id(id));
    }
    public static List<WebElement> allByCss(SearchContext container, String css) {
        return container.findElements(By.cssSelector(css));
    }
}
