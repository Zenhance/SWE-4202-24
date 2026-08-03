package kenakata.catalog;

public class FreshGood extends CatalogItem  {
    private final double weight;

    public FreshGood(String sku, String title, long unitPrice, int remaining, Seller seller, double weight) {
        super(sku, title, unitPrice, remaining, seller);
        this.weight = weight;
    }

    public long unitVat() {
        return 0;
    }

    @Override
    public boolean returnable() {
        return true;
    }

    @Override
    public boolean insurable() {
        return true;
    }

    @Override
    public long commissionOn(long i) {
        return (long) (i * .05);
    }

    @Override
    public int returnDays() {
        return 2;
    }

    @Override
    public String label() {
        return "";
    }

    @Override
    public boolean isWeighable() {
        return true;

    }

    @Override
    public double weight() {
        return weight;
    }
    public boolean isColdchain(){
        return true;
    }
}