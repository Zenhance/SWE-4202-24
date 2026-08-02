package kenakata.catalog;

public abstract class CatalogItem implements Chargeable {

    private String sku;
    private String name;
    private long price;
    private Seller seller;

    public CatalogItem(String sku, String name, long price, Seller seller) {

        if(sku == null || sku.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid sku");
        }
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }
        if(price < 0) {
            throw new IllegalArgumentException("Invalid price");
        }
        if(seller == null) {
            throw new IllegalArgumentException("Invalid seller");
        }
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.seller = seller;
    }
    public String sku() {
        return sku;
    }
    public String name() {
        return name;
    }
    public Seller seller() {
        return seller;
    }
    public long unitCharge() {
        return price;
    }
    public String label() {
        return name;
    }
    public abstract long commissionOn(long amount);
}