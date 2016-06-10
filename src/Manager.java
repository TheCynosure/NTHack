import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Jack on 6/9/2016.
 */
public class Manager {
    private Rectangle letterArea;
    private Robot robot;

    public Manager(Rectangle letterArea) {
        this.letterArea = letterArea;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    public void start() {
        InputFake in = new InputFake();
        while(true) {
            in.emulateKeys(this);
        }
    }

    public boolean isLetterCorrect() {
        BufferedImage img = robot.createScreenCapture(letterArea);
        int g = (img.getRGB(0, 0) >> 16) & 0xFF;
        if (g == 234) {
            return false;
        }
        return false;
    }
}
