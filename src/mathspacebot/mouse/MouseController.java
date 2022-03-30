package mathspacebot.mouse;

import mathspacebot.Main;

import java.awt.*;
import java.util.TimerTask;

public class MouseController {

    private Robot robot;
    private MousePosition mousePosition;

    private boolean mousePressed;

    public MouseController() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        mousePosition = MousePosition.getCurrentPoint();
        mousePressed = false;
    }

    public void setPosition(int mouseX, int mouseY) {
        try {
            robot.mouseMove(mouseX, mouseY);
            mousePosition = new MousePosition(mouseX, mouseY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPosition(MousePosition mousePosition) {
        try {
            robot.mouseMove(mousePosition.getMouseX(), mousePosition.getMouseY());
            this.mousePosition = mousePosition;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pressMouse(MouseButton mouseButton) {
        robot.mousePress(MouseButton.getInputEvent(mouseButton));
        mousePressed = true;

    }

    public void releaseMouse(MouseButton mouseButton) {
        robot.mouseRelease(MouseButton.getInputEvent(mouseButton));
        mousePressed = false;
    }

    public void clickMouse(MouseButton mouseButton) {
        pressMouse(mouseButton);
        mousePressed = true;
        Main.getScheduler().runTaskLater(new TimerTask() {
            @Override
            public void run() {
                releaseMouse(mouseButton);
                mousePressed = false;
            }
        }, 5);
    }


    public boolean isMousePressed() {
        return mousePressed;
    }

    public MousePosition getPosition() {
        return mousePosition;
    }


}
