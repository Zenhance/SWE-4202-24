package data;

import model.ConcessionItem;

// ConcessionMenu holds all the snacks and drinks available at the counter.
// Same pattern as ShowtimeBoard: wraps the array + count + search into one place.
public class ConcessionMenu {

    // Maximum number of menu items
    private static final int MAX = 30;

    // --- Fields ---
    private ConcessionItem[] items;  // the array of available items
    private int count;               // how many items are currently loaded

    // --- Constructor ---
    public ConcessionMenu() {
        items = new ConcessionItem[MAX];
        count = 0;
    }

    // Adds an item to the menu
    public void add(ConcessionItem c) {
        if (count < MAX) {
            items[count] = c;
            count++;
        }
    }

    // Searches for an item by its short code (e.g. "POP", "SODA").
    // Returns null if that code doesn't exist on the menu.
    public ConcessionItem findByCode(String code) {
        for (int i = 0; i < count; i++) {
            if (items[i].getCode().equals(code)) {
                return items[i];
            }
        }
        return null;  // not on the menu
    }

    // Prints all menu items
    public void displayAll() {
        System.out.println("=== Concession Menu ===");
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    // Getters
    public ConcessionItem[] getItems() { return items; }
    public int getCount()              { return count; }
}
