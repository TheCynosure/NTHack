import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Jack on 6/9/2016.
 */
public class Manager {
    private Rectangle letterArea;
    private Robot robot;
    String url = "WWW.NITROTYPE.COM/RACE";

    public Manager(Rectangle letterArea) {
        this.letterArea = new Rectangle(letterArea.x, letterArea.y, 1, 1);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    public void start() {
        try {
            Robot robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        InputFake in = new InputFake();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Starting a new game at " + (System.currentTimeMillis() / 1000) + " after the start of the program.");
            robot.keyPress(KeyEvent.VK_META);
            in.pressKey(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_META);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < url.length(); i++) {
                in.pressKey((int) url.charAt(i));
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            in.pressKey(KeyEvent.VK_ENTER);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < 600; j++) {
                in.emulateKeys(this);
            }
        }
    }

    @Deprecated
    public boolean isLetterCorrect() {
        BufferedImage img = robot.createScreenCapture(letterArea);
        int g = (img.getRGB(0, 0) >> 16) & 0xFF;
        if (g == 234) {
            return true;
        }
        return false;
    }
}