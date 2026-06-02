package data;

import model.ConcessionItem;

public class ConcessionMenu {
    private static final int MAX = 30;
    private ConcessionItem[] items;
    private int count;

    public ConcessionMenu(){
        items = new ConcessionItem[MAX];
        count = 0;
    }

    public ConcessionItem[] getItems(){return items;}
    public int getCount(){return count;};
    
    public void add(ConcessionItem c){
        if(count < MAX){
            items[count++] = c;
        }
    }

    public ConcessionItem findByCode(String code){
        for(int i = 0; i < count; i++){
            if(items[i].getCode().equals(code)){
                return items[i];
            }
        }
            return null;
    }

    public void displayALL(){
        for(int i = 0; i < count; i++){
            System.out.println(items[i]);
        }
    }
}

