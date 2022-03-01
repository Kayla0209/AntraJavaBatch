package day4.homework;

public abstract class Shape implements Comparable<Shape> {
    protected double area;

    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Shape s) {
        if (area == s.area) {
            return 0;
        }
        return area > s.area ? 1 : -1;
    }
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        this.area = radius * radius * Math.PI;
        return area;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        this.area = length * width;
        return area;
    }
}

class Square extends Shape {
    private double length;

    public Square(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        this.area = length * length;
        return area;
    }
}