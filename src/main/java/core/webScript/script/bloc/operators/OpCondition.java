package core.webScript.script.bloc.operators;

import core.webScript.script.Script;
import core.webScript.script.bloc.Directive;
import core.webScript.script.bloc.ScriptBloc;
import org.openqa.selenium.WebDriver;
import utils.storage.Pair;

import java.util.List;
import java.util.Map;

public class OpCondition extends ScriptBloc {
    private List<Pair<Condition, ScriptBloc>> opIf;
    private Pair<Condition, ScriptBloc> opElse;

    private final String web_condition1 = "web_condition1";
    private final String web_operator = "web_operator";
    private final String web_condition2 = "web_condition2";

    public OpCondition() {
        super();
    }
    public OpCondition(String id) {
        super(id);
    }

    private boolean checkCondition(Map<String, Object> globalParams) {

        return false;
    }

    @Override
    public void run(WebDriver driver, Map<String, Object> globalParams) {
        if (this.checkCondition(globalParams)) {
            for (Directive task : this.tasks) {
                task.run(driver, globalParams);
            }
            globalParams.put(this.id, "true");
        }
    }

    @Override
    protected void createParams() {
        this.blocParams.put(this.web_condition1, "");
        this.blocParams.put(this.web_operator, "");
        this.blocParams.put(this.web_condition2, "");
    }
    @Override
    public List<String> getResultIds() {
        List<String> result = super.getResultIds();

        result.add(this.id);
        return result;
    }
}
