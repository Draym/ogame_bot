package core.scripts;

import core.webScript.Job;
import core.webScript.bloc.JobBloc;
import org.openqa.selenium.WebDriver;
import utils.tools.FileTools;
import utils.tools.JsonTools;

public class SendExpe implements ScriptManager {

    public JobBloc createBloc1() {
        return null;
    }

    public JobBloc createBloc2() {
        return null;
    }

    @Override
    public void run(WebDriver driver) throws Exception {
        Job job = new Job();
        job.name = "sendExpe";

        job.addBloc(this.createBloc1());
        job.addBloc(this.createBloc2());


        String value = JsonTools.toString(job);
        FileTools.writeInFile("container2.json", value);

        Job job2 = JsonTools.toObject(value, Job.class);
        job2.run(driver);
    }
}
