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


}




}
