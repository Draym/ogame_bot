package core.webcontrol.actions;

import core.webcontrol.directives.DirectiveAction;

public abstract class Action {
    protected abstract boolean isValid(DirectiveAction params);
    public abstract Object run(Object target, DirectiveAction params);
}
