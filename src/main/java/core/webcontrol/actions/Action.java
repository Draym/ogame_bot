package core.webcontrol.actions;

import core.webcontrol.actions.methods.ActionMethod;

import java.util.HashMap;
import java.util.Map;

public abstract class Action {
    protected Map<String, ActionMethod> methods;

    protected abstract void createMethods();

    public Action() {
        this.methods = new HashMap<>();
        this.createMethods();
    }

    public Map<String, ActionMethod> getMethods(){
        return this.methods;
    }
}
