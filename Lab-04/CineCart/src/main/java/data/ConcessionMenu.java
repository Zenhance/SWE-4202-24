package data;

import model.ConcessionItem;

public class ConcessionMenu {
    public ConcessionItem[] items;
    public int count;
    private static final int MAX=30;
    void add(ConcessionItem c){
        items[count++]=c;
    }
}
