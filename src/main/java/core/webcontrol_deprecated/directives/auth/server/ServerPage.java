package core.webcontrol_deprecated.directives.auth.server;

import core.webcontrol_deprecated.actions.Click;
import core.webcontrol_deprecated.actions.Search;
import org.openqa.selenium.*;
import core.webcontrol_deprecated.directives.DirectiveParameters;
import core.webcontrol_deprecated.directives.Directive;
import utils.WebIdsData;

import java.util.ArrayList;
import java.util.List;

public class ServerPage implements Directive {

    private void clickPlay(WebDriver driver) {
        Click.byCss(driver, WebIdsData.get().btn_authPlay);
    }

    private void selectServer(WebDriver driver, String serverName) {
        WebElement account = Search.firstByCss(driver, WebIdsData.get().search_serverAccountsContainer);
        List<WebElement> servers = Search.allByCss(account, WebIdsData.get().search_serverAccounts);

        for (WebElement server : servers) {
            System.out.println(server.getText());
            if (server.getText().contains(serverName)) {
                Click.byCss(server, WebIdsData.get().btn_launchServerAccount);
                return;
            }
        }
        throw new NotFoundException("Server [" + serverName + "] not found.");
    }

    private void closeServerPage(WebDriver driver) {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
    }

    public void run(WebDriver driver, DirectiveParameters parameters) {
        if (!(parameters instanceof ServerDirectiveParameters))
            throw new ClassCastException("ServerDirectiveParameters is mandatory.");
        ServerDirectiveParameters params = (ServerDirectiveParameters)parameters;
        clickPlay(driver);
        selectServer(driver, params.serverName);
        closeServerPage(driver);
    }
}
