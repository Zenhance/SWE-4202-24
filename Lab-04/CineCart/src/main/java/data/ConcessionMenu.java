package data;
import model.ConcessionItem;

public class ConcessionMenu {
    private static final int MAX=30;
    private ConcessionItem[] items;
    private int count;

    //constructor
    public ConcessionMenu() {
        items = new ConcessionItem[MAX];
        count = 0;
    }

}
