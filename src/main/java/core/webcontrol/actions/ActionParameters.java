package core.webcontrol.actions;

import java.util.HashMap;
import java.util.Map;

public abstract class ActionParameters {
    public final Map<String, ActionParameter> parameters;

    protected ActionParameters() {
        this.parameters = new HashMap<String, ActionParameter>();
    }
}
