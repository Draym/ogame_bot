package core.scripts;


import core.webScript.actions.methods.ActionMethod;
import core.webScript.actions.methods.browser.Browser;
import core.webScript.actions.methods.click.Click;
import core.webScript.actions.methods.input.Input;
import core.webScript.actions.methods.jquery.Jquery;
import core.webScript.actions.methods.search.Search;
import core.webScript.script.Script;
import core.webScript.script.bloc.ScriptBloc;
import org.openqa.selenium.WebDriver;
import utils.tools.FileTools;
import utils.tools.JsonTools;
import utils.storage.PlayerStaticData;
import utils.storage.WebIdsData;

public class GoToGame_v2 implements ScriptManager {

    public ScriptBloc createBloc1() {
        ScriptBloc container = new ScriptBloc("Login");

        ActionMethod method0 = new Jquery.Script();
        method0.blocParams.put("jquery_script", "$('.openX_interstitial').remove();");
        container.addTask(method0);

        ActionMethod method1 = new Click.FirstByCss();
        method1.blocParams.put("css_selector", WebIdsData.get().btn_loginTab);
        container.addTask(method1);

        ActionMethod method2 = new Input.FirstByCss();
        method2.blocParams.put("css_selector", WebIdsData.get().input_loginUsername);
        method2.blocParams.put("value", PlayerStaticData.email);
        container.addTask(method2);

        ActionMethod method3 = new Input.FirstByCss();
        method3.blocParams.put("css_selector", WebIdsData.get().input_loginPassword);
        method3.blocParams.put("value", PlayerStaticData.password);
        container.addTask(method3);

        ActionMethod method4 = new Click.FirstByCss();
        method4.blocParams.put("css_selector", WebIdsData.get().btn_loginSubmit);
        container.addTask(method4);
        return container;
    }

    public ScriptBloc createBloc2() {
        ScriptBloc container = new ScriptBloc("Server");

        ActionMethod method0 = new Click.FirstByCss();
        method0.blocParams.put("css_selector", WebIdsData.get().btn_authPlay);
        container.addTask(method0);

        ActionMethod method1 = new Search.FirstByCss();
        method1.id = WebIdsData.get().search_serverAccountsContainer;
        method1.blocParams.put("css_selector", WebIdsData.get().search_serverAccountsContainer);
        container.addTask(method1);

        ActionMethod method2 = new Search.FirstByCssAndValue();
        method2.id = "Line#server";
        method2.blocParams.put("css_selector", WebIdsData.get().search_serverAccounts);
        method2.blocParams.put("value", "Fenrir");
        method2.blocParams.put(WebIdsData.get().web_driver, WebIdsData.get().search_serverAccountsContainer);
        container.addTask(method2);

        ActionMethod method3 = new Click.FirstByCss();
        method3.blocParams.put(WebIdsData.get().web_driver, "Line#server");
        method3.blocParams.put("css_selector", WebIdsData.get().btn_launchServerAccount);
        container.addTask(method3);

        ActionMethod method4 = new Browser.CloseTab();
        method4.blocParams.put("open tabIndex", "1");
        method4.blocParams.put("close tabIndex", "0");
        container.addTask(method4);
        return container;
    }

    @Override
    public void run(WebDriver driver) throws Exception {


        Script script = new Script();
        script.name = "GoToGame";

        script.addBloc(this.createBloc1());
        script.addBloc(this.createBloc2());


        String value = JsonTools.toString(script);
        FileTools.writeInFile("container.json", value);

        Script script2 = JsonTools.toObject(value, Script.class);
        script2.run(driver);
    }
}
