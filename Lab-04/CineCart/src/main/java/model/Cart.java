package model;

public class Cart {
    //constants
    //public static final int MAX_TICKETS=20;
    //public static final int MAX_ITEMS=20;
    //fields
    private Customer owner;
    private LineItem[] lines;
    public Cart(Customer owner) {
        this.owner = owner;
       lines= new LineItem[100];
       count= 0;
    }

    //methods
