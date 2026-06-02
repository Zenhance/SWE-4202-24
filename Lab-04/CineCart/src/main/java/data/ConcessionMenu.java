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
    public ConcessionItem findByCode(String code) {
        for (int i = 0; i < count; i++) {
            if (items[i].getCode() == code) {
                return items[i];
            }
        }
        return null;
    }
    public void displayAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}


