package core.webScript.script.bloc;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Directive {
    public String id;
    public Map<String, Object> blocParams;

    public Directive() {
        this.init();
    }
    public Directive(String id) {
        this.id = id;
        this.init();
    }

    protected void init() {
        this.blocParams = new HashMap<>();
        this.createParams();
    }
    public abstract void run(WebDriver driver, Map<String, Object> globalParams);
    protected abstract void createParams();
    public abstract List<String> getResultIds();
}
