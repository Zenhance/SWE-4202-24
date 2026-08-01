package kenakata.catalog;

public abstract class CatalogItem implements Chargeable{
    protected final String sku;
    protected final String label;
    protected final long unitPrice;
    protected final Seller seller;

    public CatalogItem(String sku, String label, long unitPrice, Seller seller) {
        if(sku == null || sku.isBlank() || label == null || label.isBlank() || seller == null || unitPrice < 0){
            throw new IllegalArgumentException("Invalid catalog item");
        }
        this.sku = sku;
        this.label = label;
        this.unitPrice = unitPrice;
        this.seller = seller;
    }

    @Override
    public long unitCharge() {
        return unitPrice;
    }

    @Override
    public String label() {
        return label;
    }

    public Seller seller() {
        return seller;
    }
    public abstract long unitVat();

    public abstract long commissionOn(long lineValue);
}
