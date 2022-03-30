package mathspacebot.mouse;

import java.awt.event.InputEvent;

public enum MouseButton {

    LEFT_CLICK,
    RIGHT_CLICK,
    MIDDLE_CLICK,
    NONE;

    public static int getInputEvent(MouseButton mouseButton) {
        if (mouseButton == LEFT_CLICK) {
            return InputEvent.BUTTON1_MASK;
        } else if (mouseButton == RIGHT_CLICK) {
            return InputEvent.BUTTON2_MASK;
        } else if (mouseButton == MIDDLE_CLICK) {
            return InputEvent.BUTTON3_MASK;
        }
        return 0;
    }
}
