package kenakata.item;

public class CatalogueItem {
    protected String name;
    protected int price;
    protected int stock;


    public CatalogueItem(String name,int price,int stock){
        this.name=name;
        this.price=price;
        this.stock=stock;
    }

}
