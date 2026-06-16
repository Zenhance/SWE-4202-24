package model;

import javax.sound.sampled.Line;

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
public void add(LineItem line){
    lines[count++]=line;
    }
    //overloading
    public void add(ConcessionItem item,int qty){
        add(new ConcessionLine(item,qty));
    }
    //overloading
    public void add(ConcessionItem item){
        add(new ConcessionLine(item,1));
    }
    public LineItem[] getLines(){}
    LineItem[] copy = new LineItem[count];
    for(int i=0;i<count;i++){
        copy[i]=lines[i];
    }
    return copy;
}


