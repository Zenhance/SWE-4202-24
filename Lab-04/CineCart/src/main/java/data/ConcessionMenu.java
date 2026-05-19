package data;
import model.ConcessionItem;

public class ConcessionMenu {
    private static final int MAX = 30;
    private ConcessionItem[] items;
    private int count;

    public ConcessionMenu(){
        items=  new ConcessionItem[30];
        count =0;
    }

    public void add(ConcessionItem c){
        if(count<MAX){
            items[count]=c;
            count++;
        }
    }

    public Con
}
