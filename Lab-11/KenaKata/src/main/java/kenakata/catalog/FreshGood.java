package kenakata.catalog;

public class FreshGood extends CatalogItem
        implements Weighable, Insurable, Returnable, ColdChain{

    private final long weightGrams;

    public FreshGood(
            String sku,
            String title,
            long unitPrice,
            int stock,
            Seller seller,
            long weightGrams) {

        super(sku, title, unitPrice, stock, seller);
        if (weightGrams <= 0){
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weightGrams = weightGrams;
    }
    @Override
    public long unitVat() {
        return 0;
    }
    @Override
    public long commissionOn(long value) {
        return (long) Math.ceil(value * 0.05);
    }
    @Override
    public long weightGrams() {
        return weightGrams;
    }
    @Override
    public long coldChainCharge() {
        return 50;
    }
    @Override
    public long insurableValue(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be positive"
            );
        }
        return unitCharge() * quantity;
    }
    @Override
    public int returnWindowDays() {
        return 2;
    }
}