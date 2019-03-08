package core.webcontrol_deprecated.directives.auth.server;

import core.webcontrol_deprecated.directives.DirectiveParameters;

public class ServerDirectiveParameters extends DirectiveParameters {
    public String serverName;

    public ServerDirectiveParameters(String serverName) {
        this.serverName = serverName;
    }
}
