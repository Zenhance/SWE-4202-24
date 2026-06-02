package data;
import model.ConcessionItem;
public class ConcessionMenu {
    private static final int MAX=30;
    private int count=0;
    private ConcessionItem[] items;
    public void add(ConcessionItem c){
        items=new ConcessionItem[MAX];
        count=0;
    }
}
