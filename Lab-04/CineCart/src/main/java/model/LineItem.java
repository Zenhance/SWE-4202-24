package model;

public class  LineItem {
    private static int count = 0;
    int sum = 0;

    public int getLines(){
        return count;
    }

    public double subtotal(){
        return sum;
    }

    public String describe(){
        return "";
    }
}
