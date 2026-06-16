package model;

public class Cart {

    public static final int MAX_ITEMS = 2000;

    private LineItem[] lineItems;

    public LineItem[] getLines(){
        LineItem[] tempLines =  LineItem[MAX_ITEMS];
        System.arraycopy(lineItems, 0, tempLines, 0, MAX_ITEMS);
        return tempLines;
    }


    public double grandSubtotal(){
        double sum = 0;
        for(int i = 0; i < lineItems.getCount(); i++){
            sum += lineItems[i].getSubTotal();
        }
    }

}
