package data;

import model.ConcessionItem;

public class ConcessionMenu {
    private ConcessionItem[] items;
    private int count;
    private static final int MAX = 30;

    public ConcessionMenu(){
        items = new ConcessionItem[MAX];
        count = 0;
    }

    public void add(ConcessionItem c){
        if (count < MAX){
            items [count] = c;
            count++;
        }
    }

}
