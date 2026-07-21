package main.java;

public class Square extends Rectangle{
    private double length;
    public Square(double length){
        super(length,length);
    }
    public String describe(){
        return "This is a square with length "+length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
