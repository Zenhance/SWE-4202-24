package kenakata.catalog;

public class FreshGood extends CatalogueItem {
    private final int weight;
    public FreshGood(String sku,String title,long price,int stock,Seller seller,int weight){
        super(sku,title,price,stock,seller);
        if(weight<0){
            throw new IllegalArgumentException("Weight cannot be negative.");
        }
        this.weight=weight;
    }
    // Weight of one unit in grams
    public int weight(){
        return weight;
    }
    // Fresh goods need refrigerated delivery
    public int coldchainCharge(){
        return 50;
    }
    // Fresh goods can be insured
    public boolean insurable(){
        return true;
    }
    //Fresh goods can be returned
    public boolean returnable(){
        return true;
    }
    @Override
    public long vatPerUnit(){
        return 0;
    }
    @Override
    public double commissionRate(){
        return 0.05;
    }
}
