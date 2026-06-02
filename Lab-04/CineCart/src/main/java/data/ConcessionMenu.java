package data;

import model.ConcessionItem;
import model.Showtime;

public class ConcessionMenu {
    public static final int MAX = 30;
    private ConcessionItem[] items;
    private int count;

    public ConcessionMenu(){
        this.items = new ConcessionItem[MAX];
        count =0;
    }

    public void add(ConcessionItem s){
        if ( count < MAX){
            items [count] = s;
            count++;
        }
    }

}
