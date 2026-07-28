package main.java;

public class Square extends Rectangle{
    private double height;
    private double width;

    public Square(double height) {
        super(height, height);

    }

    @Override
    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
        this.height = width;
    }

    @Override
    public String describe() {
        return "This is a square with length of" +height+ "and area of " + area();
    }
}
