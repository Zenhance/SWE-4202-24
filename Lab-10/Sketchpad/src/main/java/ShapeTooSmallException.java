package main.java;

public class ShapeTooSmallException extends Exception{
    public ShapeTooSmallException(){
        super("Too small for one cell");
    }
}
