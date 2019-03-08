package core.webcontrol_deprecated.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Click {
    public static void byId(SearchContext container, String id) {
        WebElement item = container.findElement(By.id(id));
        item.click();
    }

    public static void byCss(SearchContext container, String css) {
        WebElement item = container.findElement(By.cssSelector(css));
        item.click();
    }

    public static void byCssAndValue(SearchContext container, String css, String value) {
        List<WebElement> elements = Search.allByCss(container, css);

        byValue(elements, value);
    }

    public static void byValue(List<WebElement> elements, String value){
        for (WebElement element : elements) {
            if (element.getText().toLowerCase().equals(value.toLowerCase())) {
                element.click();
                return;
            }
        }
        throw new NotFoundException("element [" + value + "] not found.");
    }
}
