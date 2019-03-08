package core.webcontrol.actions;

import core.webcontrol.actions.click.Click;
import core.webcontrol.actions.input.Input;
import core.webcontrol.actions.search.Search;

import java.util.HashMap;

public class ActionFactory {
    private final static HashMap<EAction, Action> actions = new HashMap<EAction, Action>(){
        {
            put(EAction.CLICK, new Click());
            put(EAction.SEARCH, new Search());
            put(EAction.INPUT, new Input());
        }
    };

    public static Action get(String action) {
        return actions.get(EAction.valueOf(action));
    }
}
