package data;

import model.ConcessionItem;



public class ConcessionMenu {

    private int count;
    private static final int MAX = 30;
    private ConcessionItem[] items = new ConcessionItem[MAX];

public void add(ConcessionItem c){
    if (count<MAX){
        items[count] = c;
        count++;
    }
}


public ConcessionItem findByCode(String code){

    ConcessionItem res = null;
    for(int i=0;i<count;i++){

        if(code.equals(items[i].getCode())){
            res=items[];
        break;
        }
    } return res;
}

public void displayAll(){
    for(int i=0;i<count;i++){ System.out.println(items[i].toString());
    }


} }




}
