import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;


public class RectangleObject extends CollisionObject{
    private double width, height;


    public RectangleObject(double width, double height, double xPos, double yPos)
    {
        super(xPos, yPos);
        this.setHeight(height);
        this.setWidth(width);
        
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public double getWidth()
    {
        return this.width;
    }

    public double getHeight()
    {
        return this.height;
    }

    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        g2d.fillRect((int)(this.getX() - this.getWidth()/2), (int)(this.getY() - this.getHeight() / 2), (int)this.getWidth(), (int)this.getHeight());
    }

    @Override
    public double computeDistance(double cameraX, double cameraY) {
        

        Line2D.Double L1 = new 
        Line2D.Double(
        this.getX() - this.getWidth() / 2, this.getY() - this.getHeight() / 2, 
        this.getX() + this.getWidth() / 2, this.getY() - this.getHeight() / 2
        );
        

        Line2D.Double L2 = new 
        Line2D.Double( 
        this.getX() - this.getWidth() / 2, this.getY() - this.getHeight() / 2, 
        this.getX() - this.getWidth() / 2, this.getY() + this.getHeight() / 2);

        Line2D.Double L3 = new 
        Line2D.Double( 
        this.getX() - this.getWidth() / 2, this.getY() + this.getHeight() / 2, 
        this.getX() + this.getWidth() / 2, this.getY() + this.getHeight() / 2);

        Line2D.Double L4 = new 
        Line2D.Double( 
        this.getX() + this.getWidth() / 2, this.getY() + this.getHeight() / 2, 
        this.getX() + this.getWidth() / 2, this.getY() - this.getHeight() / 2);


        double minDist = Double.MAX_VALUE;
        ArrayList<Line2D.Double> ls = new ArrayList<Line2D.Double>();
        ls.add(L1);
        ls.add(L2);
        ls.add(L3);
        ls.add(L4);
        for (Line2D line : ls){
            minDist = Math.min(minDist, line.ptSegDist(cameraX, cameraY));
        }

        return minDist;

        
    }

    
}
