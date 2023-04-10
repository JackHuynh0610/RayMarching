import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Camera  implements Drawable, MouseMotionListener, MouseListener{
    private double x, y;
    final double radius = 10;
    private double angle;

    public Camera(double xPos, double yPos){
        this.y = yPos;
        this.x = xPos;
    }

    public double getRadius() {
        return radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAngle() {
        return angle;
    }

    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.fillOval((int)(this.getX() - radius/2), (int)(this.getY() - radius/2), (int)this.getRadius(),(int)this.getRadius());
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            angle += 10;
        }
        else if (e.getButton() == MouseEvent.BUTTON3) {
            angle -= 10;
        }
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
