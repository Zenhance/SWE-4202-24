package kenakata.catalog;

public class FreshGood extends CatalogItem{

    private final int weight;

    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller) {
        super(sku, title, unitPrice, stock, seller);
    }


    @Override
    public long unitVat() {
        return 0;
    }



    @Override
    public int commissionOn(int total) {
        return (int) Math.ceil(total * 0.05);
    }
}
