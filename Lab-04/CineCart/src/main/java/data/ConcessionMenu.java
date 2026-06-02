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
            System.out.println(items[i].toString());
        }
    }
    public static void main(String[] args) {
        ConcessionMenu menu = new ConcessionMenu();
        menu.add(new ConcessionItem("POP", "Popcorn", 220));
        System.out.println("Testing ConcessionMenu:");
        menu.displayAll();
        System.out.println("Find POP: " + menu.findByCode("POP").getName());
    }
}