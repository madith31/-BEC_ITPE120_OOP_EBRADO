enum Shape {
    RECTANGLE(4.0, 6.0), SQUARE(4.0), TRIANGLE(3.0);

    private final double side1;
    private final double side2; // Only used for RECTANGLE

    Shape(double side1) {
        this.side1 = side1;
        this.side2 = 0.0;
    }

    Shape(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public double calculateArea() {
        switch (this) {
            case RECTANGLE:
                return side1 * side2;
            case SQUARE:
                return Math.pow(side1, 2);
            case TRIANGLE:
                return (Math.sqrt(3) / 4) * Math.pow(side1, 2);
            default:
                return 0.0;
        }
    }

    public double calculatePerimeter() {
        return 2 * (side1 + side2);
    }
}
