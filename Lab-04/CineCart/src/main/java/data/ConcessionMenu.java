package data;

import model.ConcessionItem;

public class ConcessionMenu {
    int count;
    private static final int MAX=30;
    ConcessionItem[] items = new ConcessionItem[MAX];
    public void add(ConcessionItem c) {
        if(count<MAX){
        items[count]=c;
           count++ ;}

    }
    public ConcessionItem findByCode(String code){
        ConcessionItem res = null;
        for (int i=0;i<count;i++){
            if (items[i].getCode().equals(code))
                res= items[i];
            break;
        }
        return null;

    }
    public void displayAll(){
        for (int i = 0; i < count; i++){
        System.out.println(toString());
    }
    }

}

