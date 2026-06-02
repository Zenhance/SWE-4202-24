package data;

import model.ConcessionItem;

public class ConcessionMenu {
    private ConcessionItem[] items;
    private int count;
    private static final int MAX = 30;

    public ConcessionMenu() {
        this.items = new ConcessionItem[MAX];
        this.count = 0;
    }

    public void add(ConcessionItem c) {
        if (count<MAX) {
            items[count] = c;
            count++;
        }
    }

    public ConcessionItem findByCode(String code) {
        for (int i=0; i<count; i++) {
            if (code.equals(items[i].getCode())) return items[i];
        }

        return null;
    }
}
