package core.webcontrol_deprecated.directives;

import core.webcontrol_deprecated.directives.auth.login.LoginPage;
import core.webcontrol_deprecated.directives.auth.server.ServerPage;
import core.webcontrol_deprecated.directives.build.BuildGeneric;
import core.webcontrol_deprecated.directives.navigate.NavigateTo;

import java.util.HashMap;

public class DirectiveFactory {

    private final static HashMap<EDirective, Directive> actions = new HashMap<EDirective, Directive>(){
        {
            put(EDirective.LOGIN, new LoginPage());
            put(EDirective.SERVER, new ServerPage());
            put(EDirective.NAVIGATE, new NavigateTo());
            put(EDirective.BUILD, new BuildGeneric());
        }
    };

    public static Directive get(EDirective action) {
        return actions.get(action);
    }
}
