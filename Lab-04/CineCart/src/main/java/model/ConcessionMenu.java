package data;

import model.ConcessionItem;

public class ConcessionMenu {

    private ConcessionItem[] items;
    private int count;

    public ConcessionMenu() {
        items = new ConcessionItem[50];
        count = 0;

        add(new ConcessionItem("POP", "Popcorn (Large)", 220.00));
        add(new ConcessionItem("SODA", "Soda (Large)", 120.00));
        add(new ConcessionItem("NACHO", "Nachos", 180.00));
    }

    public void add(ConcessionItem item) {
        if (count < items.length) {
            items[count++] = item;
        }
    }

    public ConcessionItem findByCode(String code) {
        for (int i = 0; i < count; i++) {
            if (items[i].getCode().equals(code)) {
                return items[i];
            }
        }
        return null;
    }

    public ConcessionItem[] getItems() {
        ConcessionItem[] copy = new ConcessionItem[count];

        for (int i = 0; i < count; i++) {
            copy[i] = items[i];
        }

        return copy;
    }
}