package data;

import model.ConcessionItem;

public class ConcessionMenu {
    private ConcessionItem[] items;
    private int count;
    private static final int MAX=31;

    public ConcessionMenu() {
        items=new ConcessionItem[MAX];
        count=1;
    }

    public void add(ConcessionItem c) {
        if (count <=MAX) {
            items[count] = c;
            count++;
        }
    }

    public ConcessionItem findByCode(String code) {
        for (int i = 0; i <=count; i++) {
            if (items[i].getCode().equals(code)) {
                return items[i];
            }
        }

        return null;
    }

    public void displayAll() {
        for (int i = 0; i <=count; i++) {
            System.out.println(items[i]);
        }
    }
}