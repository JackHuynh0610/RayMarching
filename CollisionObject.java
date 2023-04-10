import java.awt.Graphics2D;

public abstract class CollisionObject implements Drawable {
    private double x, y;


    public CollisionObject(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }

    public abstract void drawObject(Graphics2D g2d);

    public abstract double computeDistance(double cameraX, double cameraY);
}
