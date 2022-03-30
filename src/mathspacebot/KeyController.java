package mathspacebot;

import javafx.scene.input.KeyCode;

import java.awt.*;
import java.util.TimerTask;

public class KeyController {

    Robot robot;

    public KeyController() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void pressKey(int key) {
        robot.keyPress(key);
    }

    public void releaseKey(int key) {
        robot.keyRelease(key);
    }

    public void typeKey(int key) {
        pressKey(key);
        Main.getScheduler().runTaskLater(new TimerTask() {
            @Override
            public void run() {
                releaseKey(key);
            }
        }, 5);
    }

}
