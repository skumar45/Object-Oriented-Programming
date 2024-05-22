import java.awt.Color;
import java.awt.Point;
public interface Shape {
    // returns java.awt.Color of the shape
    Color getColor();

    //Sets java Color of the shape
    void setColor(Color c);

    // Returns area of the shape
    double getArea();

    // Returns perimeter of the shape
    double getPerimeter();

    //Translates entire shape by the (x,y) coordinates of given java Point
    void translate(Point p);
}
