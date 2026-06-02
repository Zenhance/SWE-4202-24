package data;

import model.ConcessionItem;

public class ConcessionMenu {
    public static final int MAX=30;
    private ConcessionItem[] items;
    private int count;
    public ConcessionMenu(){
        items=new ConcessionItem[MAX];
        count=0;
    }
    public void add(ConcessionItem c){
        if(count<MAX){
            items[count]=c;
            count++;
        }
    }
public ConcessionItem findByCode(String code){
        for(int i=0;i<count;i++){
            if(items[i].getCode().equals(code)){
                return items[i];
            }
        }
        return null;
}





