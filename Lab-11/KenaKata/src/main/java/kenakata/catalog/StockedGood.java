package kenakata.catalog;

public class StockedGood extends CatalogueItem {
    private final int weight;
    public StockedGood(String sku, String title,long price,int stock,Seller seller,int weight){
        super(sku,title,price,stock,seller);
        if(weight<0)
            throw new IllegalArgumentException();
        this.weight=weight;
    }
    public int weight(){
        return weight;
    }
    public boolean insurable(){
        return true;
    }
    public boolean returnable(){
        return true;
    }
    public int returnWindow(){
        return 7;
    }
    @Override
    public long vatPerUnit(){
        return (long) Math.ceil(unitPrice*0.075);
    }
    @Override
    public double commissionRate(){
        return 0.08;
    }
}
