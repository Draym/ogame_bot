package core.webcontrol_deprecated.directives.auth.login;

import core.webcontrol_deprecated.directives.DirectiveParameters;

public class LoginDirectiveParameters extends DirectiveParameters {
    public String email;
    public String password;

    public LoginDirectiveParameters(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
