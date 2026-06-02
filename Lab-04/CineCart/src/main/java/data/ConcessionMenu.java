package data;
import model.ConcessionItem;
public class ConcessionMenu {
    public static final int MAX = 30;
    private ConcessionItem[] items;
    private int count;
    public ConcessionMenu(){
        items = new ConcessionItem[MAX];
        count = 0;
    }
    public void add(ConcessionItem c){
        if (count>=MAX){return;}
        items[count]=c;
        count++;
    }
    public ConcessionItem findByCode(String code){
        for(int s=0; s<count; s++){
            if(items[s].getCode().equals(code)){
                return items[s];
            }
        }
        return null;
    }
}
