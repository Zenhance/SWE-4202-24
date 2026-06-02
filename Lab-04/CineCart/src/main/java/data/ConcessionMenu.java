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

    public ConcessionItem findByCode(String Code){
        for(int i=0;i<count;i++){
            if(items[i].getCode().equals(Code)){
                return items[i];
            }
        }
        return null;
    }
    public void displayAll(){
        for(int i=0;i<count;i++) {
            System.out.println(items[i]);
        }
    }
}
