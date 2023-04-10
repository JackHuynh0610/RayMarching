import java.awt.Color;
import java.awt.Graphics2D;

public class CircleObject extends CollisionObject{
    private double radius;
    

    public CircleObject(double radius, double xPos, double yPos)
    {
        super(xPos, yPos);
        this.setRadius(radius);
        
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    public double getRadius()
    {
        return this.radius;
    }

    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.setColor(Color.GREEN);
        g2d.fillOval((int)(super.getX() - this.radius), (int)(super.getY() - this.radius), (int)this.getRadius() * 2,(int)this.getRadius()*2);
    }

    @Override
    public double computeDistance(double cameraX, double cameraY) {
       return Math.sqrt(Math.pow(cameraX - super.getX(),2) + Math.pow(cameraY - super.getY(), 2)) - radius;

    }

    

    



    
}
