package Data;

import model.concessionItem;

public class concessionMenu {
    concessionItem[] items;
    int count;
    static final int MAX=30;
    public concessionMenu(){
        this.items=new concessionItem[MAX];
        this.count=0;
    }

    public void add(concessionItem c){
        if(count<MAX) {
            items[count] = c;
            count++;
        }
    }

    public concessionItem findByCode(String code){
        for(int i=0;i<count;i++){
            if(items[i].getCode().equals(code)){
                return items[i];
            }
        }
        return null;
    }

    public void displayAll(){
        for(int i=0;i<count;i++){
            System.out.println(items[i]);
        }
    }
}
