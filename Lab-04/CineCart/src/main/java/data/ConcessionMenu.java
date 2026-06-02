package data;

import model.ConcessionItem;

public class ConcessionMenu {
    private static final int MAX = 30;
    private ConcessionItem[] items;
    private int count;
    private static final int MAX = 30;

    public ConcessionMenu(){
        items = new ConcessionItem[MAX];
        count = 0;
    }
}

