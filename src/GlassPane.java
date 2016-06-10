import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Jack on 6/9/2016.
 */
public class GlassPane extends JPanel {
    private Rectangle fullScreen;
    private BufferedImage screenGrab = null;
    private ArrayList<Point> points = new ArrayList<Point>();

    public GlassPane(Rectangle screenSize, JFrame frame) {
        fullScreen = screenSize;
        updateScreenGrab(frame);
    }

    @Override
    public void paint(Graphics graphics) {
        //Update the screen every time is moved
        if (screenGrab != null)
            graphics.drawImage(screenGrab, 0, 0, null);
        else {
            graphics.setColor(Color.BLACK);
            graphics.fillRect(fullScreen.x, fullScreen.y, (int) fullScreen.getWidth(), (int) fullScreen.getHeight());
        }
        if(points.size() > 0) {
            graphics.setColor(new Color(255, 0, 0, 100));
            if (points.size() >= 2) {
                graphics.fillRect(points.get(0).x, points.get(0).y, points.get(1).x - points.get(0).x, points.get(1).y - points.get(0).y);
            } else {
                graphics.fillRect(points.get(0).x, points.get(0).y, 5, 5);
            }
        }
    }

    public void updateScreenGrab(JFrame frame) {
        frame.setState(Frame.ICONIFIED);
        try {
            screenGrab = new Robot().createScreenCapture(fullScreen);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        frame.setState(Frame.NORMAL);
    }

    public void updateSelectionRect(ArrayList<Point> points) {
        this.points = points;
    }

    public Rectangle getSubImageRect() {
        return new Rectangle(points.get(0).x, points.get(0).y, points.get(1).x - points.get(0).x, points.get(1).y - points.get(0).y);
    }
}
