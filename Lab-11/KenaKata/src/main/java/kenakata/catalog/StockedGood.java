package kenakata.catalog;

public class StockedGood extends CatalogItem{
    private final double weight;

    public StockedGood(String sku, String title, long unitPrice, int remaining, Seller seller, double weight) {
        super(sku, title, unitPrice, remaining, seller);
        if(weight<=0){
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weight = weight;
    }

    public long unitCharge() {
        return getUnitPrice();
    }

    public long unitVat() {
        return (long) Math.ceil(getUnitPrice() * 0.075);
    }

    @Override
    public long commissionOn(long i) {
        return (long) (i*.08);
    }

    @Override
    public int returnDays() {
        return 7;
    }



    @Override
    public String label() {
        return "";
    }

    @Override
    public boolean insurable() {
        return true;
    }

    @Override
    public boolean returnable() {
        return true;
    }

    @Override
    public boolean isWeighable() {
        return true;
    }

    @Override
    public double weight() {
        return weight;
    }
}
