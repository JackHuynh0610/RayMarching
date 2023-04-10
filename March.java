import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class March implements Drawable {
    private Point2D startCoor;
    private Point2D endCoor;
   
    private double distance;
    

    public March(Point2D startCoor, Point2D endCoor){
        this.startCoor = startCoor;
        this.endCoor = endCoor;
    }


    public Point2D getStartCoor() {
        return startCoor;
    }


    public Point2D getEndCoor() {
        return endCoor;
    }

    @Override
    public void drawObject(Graphics2D g2d) {

        g2d.drawLine((int) startCoor.getX(),(int) startCoor.getY(), (int) endCoor.getX(),(int) endCoor.getY());

        distance = Point2D.distance(startCoor.getX(), startCoor.getY(), endCoor.getX(), endCoor.getY());
        
        g2d.drawOval((int) (startCoor.getX() - distance), (int) (startCoor.getY() - distance), (int) (distance * 2), (int) (distance * 2));
    }


}
