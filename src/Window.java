
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Jack on 6/9/2016.
 */
public class Window {
    protected GlassPane panel;
    protected JFrame frame;
    private final Rectangle fullScreen = new Rectangle(0, 0, (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());

    public Window(String name) {
        frame = new JFrame(name);
        panel = new GlassPane(fullScreen, frame);
        setupFrame();
    }

    private void setupFrame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(fullScreen);
        frame.add(panel);

        MouseEventsListener ml = new MouseEventsListener(this);

        frame.addMouseMotionListener(ml);
        frame.addMouseListener(ml);
        frame.addKeyListener(new KeyListener(this));
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void updateScreen() {
        panel.updateScreenGrab(frame);
        panel.repaint();
    }

    public void updateSelectionRect(ArrayList<Point> points) {
        panel.updateSelectionRect(points);
        panel.repaint();
    }

    public void startTyping() {
        frame.setState(Frame.ICONIFIED);
        Manager manager = new Manager(panel.getSubImageRect());
        manager.start();
    }
}
