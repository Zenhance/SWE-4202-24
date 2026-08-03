package kenakata.catalog;

public class StockedGood extends LineItem implements Weighable, Insurable, Returnable{
    private final double weight;
    
    public StockedGood(String sku, String title, long price, int count, Seller seller, double weight) {
        super(sku, title, price, count, seller);
        requirePositive((long) weight);
        
        this.weight = weight;
    }
    
    public double getWeight() {
        return weight;
    }
    
    @Override
    public long unitVat() {
        return (long) Math.ceil((double)unitCharge()*0.075);
    }
    
    @Override
    public double commissionOn(long price) {
        return Math.ceil((double)price*0.08);
    }
    
    @Override
    public int returnWindow() {
        return 7;
    }
    
    @Override
    public long insurableValue(int quantity) {
        requirePositive(quantity);
        return quantity*unitCharge();
    }
}
