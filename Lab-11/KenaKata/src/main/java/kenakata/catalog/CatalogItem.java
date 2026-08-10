package kenakata.catalog;

public abstract class CatalogItem implements Chargeable {
    private final String sku;
    private final String title;
    private final long unitPrice;
    private int stock;
    private final Seller seller;

    public CatalogItem(int stock, String sku, String title, long unitPrice, Seller seller) {
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.seller = seller;
    }

    @Override
    public long unitCharge(){
        return unitPrice;
    }

    public int remaining() {
        return stock;
    }
}
