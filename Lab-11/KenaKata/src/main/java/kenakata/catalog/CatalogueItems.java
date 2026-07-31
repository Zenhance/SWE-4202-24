package kenakata.catalog;

public abstract class CatalogueItems {
    public String sku;
    public String title;
    public int unit_price;
    public int stock_count;
    public Seller seller;

    public CatalogueItems(String sku, String title, int unit_price, int stock_count, Seller seller) {
        this.sku = sku;
        this.title = title;
        this.unit_price = unit_price;
        this.stock_count = stock_count;
        this.seller = seller;
    }

    //public abstract boolean isShippable();

    public abstract double unitVat();

    //public abstract boolean canBeReturned();

    public abstract double commissionOn();
}
