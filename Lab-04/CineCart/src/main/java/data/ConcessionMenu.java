package data;

import model.ConcessionItem;

public class ConcessionMenu {
    private ConcessionItem[] items;
    private int count;
    private static final int MAX=30;

    public ConcessionItem[] getItems() {
        return items;
    }

    public int getCount() {
        return count;
    }

    public static int getMAX() {
        return MAX;
    }
    public void add(ConcessionItem c){
        if(count>=MAX){
            return;
        }
        items[count]=c;
        count++;



    }

    public ConcessionItem findByCode(String code){
        for (int i = 0; i < count; i++) {
            if (items[i].getCode().equals(code)) return items[i];
        }
        return null;
    }
    public void displayAll(){
        for(int i=0;i<count;i++){
            System.out.println(items[i]);
        }
    }



}
