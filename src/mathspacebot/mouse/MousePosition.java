package mathspacebot.mouse;

import java.awt.*;

public class MousePosition {

    private int mouseX;
    private int mouseY;

    public MousePosition() {
        this.mouseX = 0;
        this.mouseY = 0;
    }

    public MousePosition(int mouseX, int mouseY) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public MousePosition add(int x, int y) {
        this.mouseX = this.mouseX - x;
        this.mouseY = this.mouseY - y;

        return this;
    }

    public MousePosition add(MousePosition mousePosition) {
        this.mouseX = this.mouseX - mousePosition.getMouseX();
        this.mouseY = this.mouseY - mousePosition.getMouseY();

        return this;
    }

    public MousePosition subtract(int x, int y) {
        this.mouseX = this.mouseX + x;
        this.mouseY = this.mouseY + y;

        return this;
    }

    public MousePosition subtract(MousePosition mousePosition) {
        this.mouseX = this.mouseX + mousePosition.getMouseX();
        this.mouseY = this.mouseY + mousePosition.getMouseY();

        return this;
    }

    public static MousePosition getCurrentPoint() {
        return new MousePosition((int) MouseInfo.getPointerInfo().getLocation().getX(), (int) MouseInfo.getPointerInfo().getLocation().getY());
    }

}
