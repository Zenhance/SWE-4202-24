package data;

import model.ConcessionItem;

public class ConcessionMenu {
    ConcessionItem items[];
    int count;
    private static final int MAX = 30;

    public void add(ConcessionItem item){
        items[count] = item;
        count++;
    }

    public ConcessionItem findByCode(String code){
        for(int i = 0; i < MAX; i++){
            if(items[i].getCode().equals(code))
                return items[i];
        }
        return null;
    }

    public void displayAll(){
        for(int i = 0; i < MAX; i++){
            System.out.println(items[i].toString());
        }
    }





}
