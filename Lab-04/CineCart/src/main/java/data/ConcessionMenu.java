package data;

import model.ConcessionItem;

public class ConcessionMenu {
    private static final int MAX = 30;
    private int count = 0;
    private ConcessionItem[] items = new ConcessionItem[MAX];

    public void add(ConcessionItem c) {
        if (count < MAX) {
            items[count] = c;
            count++;
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

    public void displayAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}
