package core.webScript.actions;

import core.webScript.actions.methods.ActionMethod;

import java.util.ArrayList;
import java.util.List;

public abstract class Action {
    protected List<String> methods;

    protected abstract void createMethods();

    public Action() {
        this.methods = new ArrayList<>();
        this.createMethods();
    }

    public List<String> getMethods(){
        return this.methods;
    }

    public abstract ActionMethod getMethod(String id);
}
