package kenakata.catalog;

public abstract class CatalogItem implements Chargeable {
    private final String sku;
    private final String title;
    private final long unitPrice;
    private final int remaining;
    private final Seller seller;

    public CatalogItem(String sku, String title, long unitPrice, int remaining, Seller seller) {
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.remaining = remaining;
        this.seller = seller;
    }

    public String getSku() {
        return sku;
    }

    public String getTitle() {
        return title;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public int getRemaining() {
        return remaining;
    }

    public Seller getSeller() {
        return seller;
    }

    @Override
    public long unitCharge() {
        return 0;
    }

    @Override
    public long unitVat() {
        return 0;
    }
    public abstract int commissionOn(int i);
    public abstract boolean weightAble();
    public double weight(){
        return 0;
    }
}
