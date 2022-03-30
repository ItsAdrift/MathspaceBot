package mathspacebot;

import mathspacebot.mouse.MouseButton;
import mathspacebot.mouse.MouseController;
import mathspacebot.mouse.MousePosition;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.TimerTask;

public class TextReader {

    public TextReader() {

    }

    public void read(MousePosition pos1, MousePosition pos2) {
        MouseController mc = new MouseController();
        KeyController kc = new KeyController();
        mc.setPosition(pos1);
        mc.pressMouse(MouseButton.LEFT_CLICK);

        boolean waiting = true;

        Main.getScheduler().runTaskLater(new TimerTask() {
            @Override
            public void run() {
                mc.setPosition(pos2);

                kc.pressKey(KeyEvent.VK_CONTROL);
                kc.pressKey(KeyEvent.VK_C);

                Main.getScheduler().runTaskLater(new TimerTask() {
                    @Override
                    public void run() {
                        kc.releaseKey(KeyEvent.VK_CONTROL);
                        kc.releaseKey(KeyEvent.VK_C);
                        mc.releaseMouse(MouseButton.LEFT_CLICK);
                    }
                }, 5);
            }
        }, 10);
    }

    public String getText(){
        try {
            return (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (HeadlessException | UnsupportedFlavorException | IOException e) {

        }
        return "";
    }

}
