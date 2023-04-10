
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

/**
 * Displays and updates the logic for the top-down raymarcher.
 */
public class RaymarcherPanel extends JPanel { 
    
    /**
     * We need to keep a reference to the parent swing app for sizing and 
     * other bookkeeping.
     */

    private final RaymarcherRunner raymarcherRunner;

    private ArrayList<CollisionObject> collisionObjects;

    Camera camera1 = new Camera(getX(), getY());

    public RaymarcherPanel(RaymarcherRunner raymarcherRunner) {
        this.raymarcherRunner = raymarcherRunner;
        this.setPreferredSize(new Dimension(this.raymarcherRunner.getFrame().getWidth(), 
        this.raymarcherRunner.getFrame().getHeight())); 
        
        this.collisionObjects = new ArrayList<>();
        
        
        // Populate the list of objects.
        for (int i=0; i<20;i++) {
            Random rand = new Random();
            int type = rand.nextInt(2);
            double x = rand.nextDouble(1280);
            double y = rand.nextDouble(640);

            double width = rand.nextInt(101);
            double height = rand.nextInt(101);

            double radius = rand.nextInt(101);

            if (type == 0) {

                collisionObjects.add(new RectangleObject(width, height, x,y));
            }
            if (type == 1) {
                collisionObjects.add(new CircleObject(radius, x, y));
            }
        }

        this.addMouseMotionListener(camera1);
        this.addMouseListener(camera1);

        
    }
    protected ArrayList<March> march(){
        ArrayList<March> listOfMarch = new ArrayList<>();
        double currentX = this.camera1.getX();
        double currentY = this.camera1.getY();
        double x2;
        double y2;
        
        do {
            double minDist = Double.MAX_VALUE;
            // Compute the minimum distance.
            for (CollisionObject obj : this.collisionObjects) {
                minDist = Math.min(minDist, obj.computeDistance(currentX, currentY));
            }

            if (minDist < 0.01) {
                break;
            }
            x2 = currentX + (minDist * Math.cos(Math.toRadians(camera1.getAngle())));
            y2 = currentY + (minDist * Math.sin(Math.toRadians(camera1.getAngle())));
            // Create the march object
            listOfMarch.add(new March( new Point2D.Double(currentX, currentY), new Point2D.Double(x2, y2)));
            
            
            // Advance the currentX out minDist units
            currentX += minDist;
            
            
        }
        while (currentX >= 0 && currentY >= 0 && currentX <= this.getPreferredSize().getWidth() && currentY <= this.getPreferredSize().getHeight());

        return listOfMarch;
    }
    

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        
        for (int i = 0; i < collisionObjects.size(); i++) {
            
            CollisionObject obj = collisionObjects.get(i);
            obj.drawObject(g2d);
            
        }

        camera1.drawObject(g2d);

        for (March m: march()){
            m.drawObject(g2d);
        }
        
        

    }

    

}
