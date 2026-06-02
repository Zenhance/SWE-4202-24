package data;
import model.ConcessionItem;
public class ConcessionMenu {
    ConcessionItem[] items;
    int count;
    private static final int MAX=30;


    public void add(ConcessionItem c){
        if(count<MAX){
            items[count++]=c;
        }
    }
    public ConcessionItem findByCode(String code){
        for (int i=0;i<count;i++) {
            if (items[i].getCode().equals(code)) {
                return items[i];
            }
        }
        return null;
    }
    public void dsiplayALl(){
        for (int i=0;i<count;i++) {
            System.out.println(items[i].toString());
        }
    }
}
