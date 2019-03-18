package core.webScript.bloc;

import org.openqa.selenium.WebDriver;
import utils.storage.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Directive {
    public String id;
    /**
     * blocParams can only contains String or Integer
     */
    public Map<String, String> blocParams;

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
    public abstract List<Pair<String, Class>> getResultIds();
}
