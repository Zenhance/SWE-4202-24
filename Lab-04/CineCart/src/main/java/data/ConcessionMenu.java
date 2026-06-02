package data;

import model.ConcessionItem;

public class ConcessionMenu {
    private ConcessionItem[] items;
    private int count;
    private static final int MAX = 30;

    public ConcessionMenu(ConcessionItem[] items, int count) {
        this.items = new ConcessionItem[MAX];
        this.count = 0;
    }

    public void add(ConcessionItem c) {
        if (count < MAX) {
            items[count] = c;
            count++;
        }
    }

    public ConcessionItem findByCode(String code) {
        for (ConcessionItem c : items) {
            if (c != null) {
                if (code.equals(c.getCode())) return c;
            }
        }
        return null;
    }
}