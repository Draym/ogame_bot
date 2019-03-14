package core.webcontrol_deprecated.directives.auth.login;

import core.webcontrol_deprecated.actions.Click;
import core.webcontrol_deprecated.actions.Input;
import org.openqa.selenium.WebDriver;
import core.webcontrol_deprecated.directives.DirectiveParameters;
import core.webcontrol_deprecated.directives.Directive;
import utils.storage.WebIdsData;

public class LoginPage implements Directive {

    private void clickLogin(WebDriver driver) {
        Click.byCss(driver, WebIdsData.get().btn_loginTab);
    }

    private void setUserName(WebDriver driver, String userName) {
        Input.byCss(driver, WebIdsData.get().input_loginUsername, userName);
    }

    private void setPassword(WebDriver driver, String password) {
        Input.byCss(driver, WebIdsData.get().input_loginPassword, password);
    }

    private void submitButton(WebDriver driver) {
        Click.byCss(driver, WebIdsData.get().btn_loginSubmit);
    }

    public void run(WebDriver driver, DirectiveParameters parameters) {

        if (!(parameters instanceof LoginDirectiveParameters))
            throw new ClassCastException("LoginDirectiveParameters is mandatory.");
        LoginDirectiveParameters params = (LoginDirectiveParameters)parameters;

        this.clickLogin(driver);
        this.setUserName(driver, params.email);
        this.setPassword(driver, params.password);
        this.submitButton(driver);
    }
}
