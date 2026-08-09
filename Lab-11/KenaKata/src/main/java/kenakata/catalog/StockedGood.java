package kenakata.catalog;


public class StockedGood extends Item{
    private final int weight;

    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller,int weight){
        super(sku, title, unitPrice, stock, seller);

        if (weight <= 0) {
            throw new IllegalArgumentException();
        }

        this.weight = weight;
    }

    @Override
    public long unitCharge() {
        return super.unitCharge();
    }

    @Override
    public long unitVat() {
        return (long) Math.ceil(unitCharge() * 0.075);
    }

    @Override
    public long commissionOn(long n) {
        return (long) Math.ceil(n * 0.08);
    }


    public long weightGrams() {
        return weight;
    }

    @Override
    public String label() {
        return title();
    }

    public long insurableValue(int quantity) {
        return unitCharge() * quantity;
    }

    public int returnWindow() {
        return 7;
    }

}
