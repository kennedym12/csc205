
import java.awt.*;

public class Triangle extends Shape {
  // Instance variable
  private int size;

  // Constructor
  public Triangle(int x, int y, Color color, int size)
  {
    super(x, y, color);
    this.size = size;
  }

  // Instance methods
  public void draw(Graphics g) {
    g.setColor(getColor());
    int height = getHeight();
    int[] xCoordinates = {getX(), getX() + size / 2, getX() + size};
    int[] yCoordinates = {getY() + height, getY(), getY() + height};
    g.fillPolygon(xCoordinates, yCoordinates, 3);
  }

  public int getHeight() {
    return (int) (Math.sqrt((3.0 * size * size) / 4));
  }

  public int getWidth() {
    return size;
  }
  
  //override abstract methods
  public void scale(double factor){
    size*=factor;
  } 

  public double area(){
    return (double)(1.73/4)*size*size;
  }
}
