package core.webcontrol_deprecated.directives;

import org.openqa.selenium.WebDriver;

public interface Directive {
    void run(WebDriver driver, DirectiveParameters parameters) throws Exception;
}
