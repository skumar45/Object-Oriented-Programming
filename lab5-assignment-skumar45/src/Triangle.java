import java.awt.Color;
import java.awt.Point;
public class Triangle implements Shape {
    private Point vertexA;
    private Point vertexB;
    private Point vertexC;
    private Color color;

    Triangle(Point a, Point b, Point c, Color color) {
        this.vertexA = a;
        this.vertexB = b;
        this.vertexC = c;
        this.color = color;
    }

    public Point getVertexA() {
        return vertexA;
    }

    public Point getVertexB() {
        return vertexB;
    }

    public Point getVertexC() {
        return vertexC;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color c) {
        this.color = c;
    }

    @Override
    public double getArea() {
        double sideA = vertexA.distance(vertexB);
        double sideB = vertexB.distance(vertexC);
        double sideC = vertexC.distance(vertexA);
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double getPerimeter() {
        double sideA = vertexA.distance(vertexB);
        double sideB = vertexB.distance(vertexC);
        double sideC = vertexC.distance(vertexA);
        return sideA + sideB + sideC;
    }

    @Override
    public void translate(Point p) {
        vertexA.translate(p.x, p.y);
        vertexB.translate(p.x, p.y);
        vertexC.translate(p.x, p.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Triangle triangle = (Triangle) obj;
        return vertexA.equals(triangle.vertexA) &&
                vertexB.equals(triangle.vertexB) &&
                vertexC.equals(triangle.vertexC) &&
                color.equals(triangle.color);
    }
}
