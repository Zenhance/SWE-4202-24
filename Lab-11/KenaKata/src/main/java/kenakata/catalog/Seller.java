package kenakata.catalog;

public class Seller {
    String item;
    public Seller(String item){
        if(item==null|| item.isBlank()){
            throw new IllegalArgumentException("Item name is empty!");
        }
this.item=item;
    }
    public String item(){
        return item;
    }
}
