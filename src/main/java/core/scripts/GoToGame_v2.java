package core.scripts;


import core.webcontrol.actions.methods.ActionMethod;
import core.webcontrol.actions.methods.click.Click;
import core.webcontrol.actions.methods.input.Input;
import core.webcontrol.actions.methods.jquery.Jquery;
import core.webcontrol.directives.Directive;
import org.openqa.selenium.WebDriver;
import utils.PlayerStaticData;
import utils.WebIdsData;

public class GoToGame_v2 implements Script {
    @Override
    public void run(WebDriver driver) throws Exception {
        Directive directive = new Directive("GoToGame");

        ActionMethod method0 = new Jquery.Script();
        method0.params.put("jquery_script", "$('.openX_interstitial').remove();");
        directive.addAction(method0);

        ActionMethod method1 = new Click.FirstByCss();
        method1.params.put("css_selector", WebIdsData.get().btn_loginTab);
        directive.addAction(method1);

        ActionMethod method2 = new Input.FirstByCss();
        method2.params.put("css_selector", WebIdsData.get().input_loginUsername);
        method2.params.put("value", PlayerStaticData.email);
        directive.addAction(method2);

        ActionMethod method3 = new Input.FirstByCss();
        method3.params.put("css_selector", WebIdsData.get().input_loginPassword);
        method3.params.put("value", PlayerStaticData.password);
        directive.addAction(method3);

        ActionMethod method4 = new Click.FirstByCss();
        method4.params.put("css_selector", WebIdsData.get().btn_loginSubmit);
        directive.addAction(method4);

        directive.run(driver);
    }
}
