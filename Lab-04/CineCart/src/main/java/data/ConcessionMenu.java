package data;


import model.ConcessionItem;

public class ConcessionMenu {
    private ConcessionItem[] items;
    private int count;
    private static final int MAX = 30;

    public void add(ConcessionItem c){
        if (count < MAX){
            items[count] = c;
        }
    }

    public ConcessionItem findByCode(String code){
        ConcessionItem res = null;

        for (ConcessionItem c : items){
            if(code.equals(c.getCode())){
                res = c;
                break;
            }
        }

        return res;
    }


    public void displayAll(){
        for (int i = 0; i < count; i++){
            System.out.println(items[i].toString());
        }
    }
}
