package data;

import model.ConcessionItem;

public class ConcessionMenu {
    private ConcessionItem[] items;
    private int count;
    private static final int MAX = 30;


    public ConcessionMenu() {
        items = new ConcessionItem[MAX];
        this.count = 0;
    }

    void add(ConcessionItem c){
        if(count<MAX){
            items[count]=c;
            count++;
        }
    }

   public  ConcessionItem findByCode(String code){
         for(int i=0; i<count; i++){
             if(items[i].getCode().equals(code)){
                 return items[i];
             }
         }
         return null;
    }


    void displayAll(){
        String concession;
        for(int i=0; i<count; i++){
           System.out.println(items[i].toString());
        }
    }
}
