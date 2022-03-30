package mathspacebot.schedulling;

import java.util.Timer;
import java.util.TimerTask;

public class Scheduler {

    public Scheduler() {

    }

    public void runTaskLater(TimerTask task, long millis) {
        Timer t = new Timer();
        t.schedule(task, millis);
    }

    public void runRepeatingTask(TimerTask task, long start, long millis) {
        Timer t = new Timer();
        t.scheduleAtFixedRate(task, start, millis);
    }


}
