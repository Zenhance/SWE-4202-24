package data;

import model.ConcessionItem;

public class ConcessionMenu {
    private ConcessionItem[] items;
    private int count;
    private static final int MAX = 30;

    public ConcessionMenu(){
        ConcessionItem[] items = new ConcessionItem[MAX];
        this.count = 0;
    }

    public void add(ConcessionItem c){
        if(count < MAX){
            items[count] = c;
            count++;
        }
    }
    public ConcessionItem findByCode(String code){
        ConcessionItem result = null;

        for(int i = 0; i < MAX; i++){
            if((items[i].getCode()).equals(code)){
                result = items[i];

                return result;
            }


        }
        return null;
    }
}
