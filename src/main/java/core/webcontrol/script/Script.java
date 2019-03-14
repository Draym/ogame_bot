package core.webcontrol.script;

import core.webcontrol.script.bloc.Directive;
import org.openqa.selenium.WebDriver;
import utils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Script {
    public String name;
    protected List<Directive> blocs;

    public Script() {
        this.blocs = new ArrayList<>();
    }

    public void run(WebDriver driver) {
        Map<String, Object> globalParams = new HashMap<>();

        for (Directive task : this.blocs) {
            try {
                task.run(driver, globalParams);
            } catch (Exception ex) {
                ex.printStackTrace();
                Console.print_err(ex.getMessage());
            }
        }
    }

    public void addBloc(Directive bloc) {
        this.blocs.add(bloc);
    }

    public void setBlocs(List<Directive> blocs) {
        this.blocs = blocs;
    }

    public List<Directive> getBlocs(){
        return this.blocs;
    }
}
