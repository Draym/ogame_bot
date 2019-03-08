package core.webcontrol.directives;

import core.webcontrol.actions.Action;
import core.webcontrol.actions.ActionFactory;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directive {
    private List<DirectiveAction> actions;

    public void run(WebDriver driver) {
        Map<String, Object> saveResult = new HashMap<String, Object>();

        for(DirectiveAction params : actions) {
            Action action = ActionFactory.get(params.type);

            if (action == null)
                throw new InvalidArgumentException("[Directive] " + params.type + " is not a valid action");
            Object result = null;
            if (params.parentId != null) {
                if (saveResult.containsKey(params.parentId)){
                    result = action.run(saveResult.get(params.parentId), params);
                } else {
                    throw new InvalidArgumentException("[Directive] " + params.parentId + " is requested but unsaved");
                }
            } else {
                result = action.run(driver, params);
            }
            if (result != null) {
                saveResult.put(params.id, result);
            }
        }
    }
}
