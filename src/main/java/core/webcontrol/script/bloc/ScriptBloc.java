package core.webcontrol.script.bloc;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScriptBloc extends Directive {

    protected List<Directive> tasks;

    public ScriptBloc() {
        super();
    }
    public ScriptBloc(String id) {
        super(id);
    }

    @Override
    public void init() {
        super.init();
        this.tasks = new ArrayList<>();
    }

    @Override
    public void run(WebDriver driver, Map<String, Object> globalParams) {
        for (Directive task : this.tasks) {
            task.run(driver, globalParams);
        }
    }

    @Override
    protected void createParams() {
        // NO USAGE
    }

    public void addTask(Directive task) {
        this.tasks.add(task);
    }

    public void setTasks(List<Directive> tasks) {
        this.tasks = tasks;
    }

    public List<Directive> getTasks(){
        return this.tasks;
    }
}
