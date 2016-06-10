import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * Created by Jack on 6/9/2016.
 */
public class MouseEventsListener implements MouseMotionListener, java.awt.event.MouseListener {

    private ArrayList<Point> rectCoord = new ArrayList<Point>();
    private Window parentWindow;

    public MouseEventsListener(Window parentWindow) {
        this.parentWindow = parentWindow;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(rectCoord.size() >= 2) {
            rectCoord.clear();
        }
        rectCoord.add(new Point(e.getX() - parentWindow.frame.getInsets().left, e.getY() - parentWindow.frame.getInsets().top));
        parentWindow.updateSelectionRect(rectCoord);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
