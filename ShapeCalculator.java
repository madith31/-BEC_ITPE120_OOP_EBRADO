public class ShapeCalculator {
    public static void main(String[] args) {

        for (Shape shape : Shape.values()) {
            double area = shape.calculateArea();
            double perimeter = shape.calculatePerimeter();
            
            System.out.println("Shape: " + shape);
            System.out.println("Area: " + area);
            System.out.println("Perimeter: " + perimeter);
            System.out.println();
        }
    }
}
