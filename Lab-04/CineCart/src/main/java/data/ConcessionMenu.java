package data;

import model.ConcessionItem;
import model.Showtime;

public class ConcessionMenu {
    private static final int MAX = 30;
    private ConcessionItem[] items = new ConcessionItem[MAX];
    private int count;

    public void add(ConcessionItem c){
        if(count >= MAX)
            throw new IllegalArgumentException("MAX items exceeded");
        items[count] = c;
        count++;
    }

}
