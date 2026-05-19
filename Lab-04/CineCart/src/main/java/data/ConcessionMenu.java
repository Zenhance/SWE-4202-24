package data;

import model.ConcessionItem;

public class ConcessionMenu {
    ConcessionItem[] items;
    int count;
    private static final int MAX = 30;
    void add(ConcessionItem c){
        items[count++]=c;
    }
    public ConcessionItem findByCode(String code){
        for(int i=0;i<count;i++){
            if(items[i].getCode().equals(code)){
                return items[i];
            }
        }
        return null;
    }
    public void displayAll(){
        for(int i=0;i<count;i++){
            items[i].toString();
        }
    }
}
