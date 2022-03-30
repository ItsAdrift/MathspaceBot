package mathspacebot;

import mathspacebot.mouse.MouseController;
import mathspacebot.mouse.MousePosition;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyList extends Main implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        MouseController mc = new MouseController();
        if (keyCode == KeyEvent.VK_SPACE) {
            if (!MathspaceBot.enabled) {
                Main.getMathspaceBot().start();
            } else {
                Main.getMathspaceBot().stop();
            }
            MathspaceBotUI.enabledLabel.setText("Enabled: " + MathspaceBot.enabled);

        } else if (keyCode == KeyEvent.VK_UP) {
            mc.setPosition(mc.getPosition().add(0, 1));

        } else if (keyCode == KeyEvent.VK_DOWN) {
            mc.setPosition(mc.getPosition().subtract(0, 1));
        } else if (keyCode == KeyEvent.VK_LEFT) {
            mc.setPosition(mc.getPosition().add(1, 0));
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            mc.setPosition(mc.getPosition().subtract(1, 0));
        } /*else if (keyCode == KeyEvent.VK_A) {
            TextReader reader = new TextReader();
            String s = reader.read(new MousePosition(102, 176), new MousePosition(176, 176));
            System.out.print(s);
        }*/

        MathspaceBotUI.mousePositionLabel.setText("Mouse Position: " + mc.getPosition().getMouseX() + ", " + mc.getPosition().getMouseY());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
