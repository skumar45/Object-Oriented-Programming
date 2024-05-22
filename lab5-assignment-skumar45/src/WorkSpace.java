import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class WorkSpace {
        private List<Shape> shapes;

        public WorkSpace() {
            shapes = new ArrayList<>();
        }

        public void add(Shape shape) {
            shapes.add(shape);
        }

        public Shape get(int index) {
            return shapes.get(index);
        }

        public int size() {
            return shapes.size();
        }

        public List<Circle> getCircles() {
            List<Circle> circles = new ArrayList<>();
            for (Shape shape : shapes) {
                if (shape instanceof Circle) {
                    circles.add((Circle) shape);
                }
            }
            return circles;
        }

        public List<Rectangle> getRectangles() {
            List<Rectangle> rectangles = new ArrayList<>();
            for (Shape shape : shapes) {
                if (shape instanceof Rectangle) {
                    rectangles.add((Rectangle) shape);
                }
            }
            return rectangles;
        }

        public List<Triangle> getTriangles() {
            List<Triangle> triangles = new ArrayList<>();
            for (Shape shape : shapes) {
                if (shape instanceof Triangle) {
                    triangles.add((Triangle) shape);
                }
            }
            return triangles;
        }

        public List<Shape> getShapesByColor(Color color) {
            List<Shape> result = new ArrayList<>();
            for (Shape shape : shapes) {
                if (shape.getColor().equals(color)) {
                    result.add(shape);
                }
            }
            return result;
        }

        public double getAreaOfAllShapes() {
            double totalArea = 0;
            for (Shape shape : shapes) {
                totalArea += shape.getArea();
            }
            return totalArea;
        }

        public double getPerimeterOfAllShapes() {
            double totalPerimeter = 0;
            for (Shape shape : shapes) {
                totalPerimeter += shape.getPerimeter();
            }
            return totalPerimeter;
        }
}
