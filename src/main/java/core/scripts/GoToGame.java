package core.scripts;

import core.webcontrol_deprecated.directives.DirectiveFactory;
import core.webcontrol_deprecated.directives.EDirective;
import core.webcontrol_deprecated.directives.auth.login.LoginDirectiveParameters;
import core.webcontrol_deprecated.directives.auth.server.ServerDirectiveParameters;
import org.openqa.selenium.WebDriver;

public class GoToGame implements ScriptManager {

    private String email;
    private String password;
    private String serverName;

    public GoToGame(String email, String password, String serverName) {
        this.email = email;
        this.password = password;
        this.serverName = serverName;
    }

    public void run(WebDriver driver) throws Exception {
        DirectiveFactory.get(EDirective.LOGIN).run(driver, new LoginDirectiveParameters(this.email, this.password));
        DirectiveFactory.get(EDirective.SERVER).run(driver, new ServerDirectiveParameters(this.serverName));
    }
}
