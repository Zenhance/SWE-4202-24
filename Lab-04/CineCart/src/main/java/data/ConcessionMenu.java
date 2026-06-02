package data;

import model.ConcessionItem;

public class ConcessionMenu {
    private ConcessionItem[] items;
    private int count;
    private static final int MAX=30;

    public ConcessionItem[] getItems() {
        return items;
    }

    public int getCount() {
        return count;
    }

    public static int getMAX() {
        return MAX;
    }
}
