import java.awt.event.KeyEvent;

/**
 * Created by Jack on 6/9/2016.
 */
public class KeyListener implements java.awt.event.KeyListener {

    private Window parentWindow;

    public KeyListener(Window parentWindow) {
        this.parentWindow = parentWindow;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_U) {
            parentWindow.updateScreen();
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            parentWindow.startTyping();
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
