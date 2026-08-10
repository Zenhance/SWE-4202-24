package kenakata.catalog;

public class StockedGood extends CatalogItem {

    private final int weightGrams;

    public StockedGood(
            String sku,
            String title,
            long price,
            int stock,
            Seller seller,
            int weightGrams
    ) {
        super(sku, title, price, stock, seller);
        this.weightGrams = weightGrams;
    }

    // Keep your other methods below
}