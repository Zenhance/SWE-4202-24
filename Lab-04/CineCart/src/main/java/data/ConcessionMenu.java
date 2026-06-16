package data;

import model.ConcessionItem;

public class ConcessionMenu {
    public ConcessionItem[] items=new ConcessionItem[MAX];
    public int count=0;
    private static final int MAX=30;


    public void add(ConcessionItem c){
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
