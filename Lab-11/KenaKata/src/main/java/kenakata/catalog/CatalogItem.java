package kenakata.catalog;

public abstract class CatalogItem implements Chargeable {
    private final long unitPrice;

    protected CatalogItem(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public long unitCharge() {
        return unitPrice;
    }
}
