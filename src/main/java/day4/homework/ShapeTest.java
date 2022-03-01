package day4.homework;

public class ShapeTest {
    public static void main(String[] args) {
        Circle circle = new Circle(2);
        Rectangle rectangle = new Rectangle(4, 8);
        Square square = new Square(4);
        System.out.println(circle.getArea());
        System.out.println(rectangle.getArea());
        System.out.println(square.getArea());

        System.out.println(circle.compareTo(square));

    }
}
