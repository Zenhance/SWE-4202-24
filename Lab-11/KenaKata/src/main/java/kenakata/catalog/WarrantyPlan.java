package kenakata.catalog;

public class WarrantyPlan extends AddOn{
    private CatalogItem item;

    public WarrantyPlan(CatalogItem product) {
        if (product == null)
            throw new IllegalArgumentException("Product to be insured cannot be null");
        this.item = product;
        product.insure();
    }

    @Override
    public int unitCharge() {
        return (int) Math.ceil(item.unitCharge() * 0.10);
    }

    @Override
    public int unitVat() {
        return (int) Math.ceil(unitCharge() * 0.15);
    }

    @Override
    public int commissionOn(int something) {
        return 0;
    }

    public String label() {
        return item.getTitle();
    }
}