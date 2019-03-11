package core.webcontrol.directives;

import core.webcontrol.actions.methods.ActionMethod;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directive {
    public String name;
    private List<ActionMethod> actions;

    public Directive() {
        this.name = "unknown";
        this.actions = new ArrayList<>();
    }

    public Directive(String name) {
        this.actions = new ArrayList<>();
        this.name = name;
    }

    public void run(WebDriver driver) {
        Map<String, Object> saveResult = new HashMap<>();

        for(ActionMethod action : this.actions) {
            action.run(driver, saveResult);
        }
    }

    public void addAction(ActionMethod action) {
        this.actions.add(action);
    }
    public void setActions(List<ActionMethod> actions) {
        this.actions = actions;
    }
}
