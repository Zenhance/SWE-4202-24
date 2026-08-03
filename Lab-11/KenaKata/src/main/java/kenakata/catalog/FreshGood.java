package kenakata.catalog;

public class FreshGood extends CatalogItem implements Weighable, ColdChain, Insurable, Returnable{
    private final double weight;
    
    public FreshGood(String sku, String title, long price, int count, Seller seller, double weight){
        super(sku, title, price, count, seller);
        requirePositive((long)weight);
        
        this.weight = weight;
    }
    
    @Override
    public double commissionOn(long price) {
        return Math.ceil((double)price*0.05);
    }
    @Override
    public long unitVat(){
        return 0;
    }
    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public int returnWindow(){
        return 2;
    }
    @Override
    public long coldChainSubcharge(){
        return 50;
    }
    @Override
    public long insurableValue(int quantity){
        requirePositive(quantity);
        return quantity*unitCharge();
    }
    
}
