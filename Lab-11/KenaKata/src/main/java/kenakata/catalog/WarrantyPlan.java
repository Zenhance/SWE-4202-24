package kenakata.catalog;

public class WarrantyPlan implements OrderableLine{
    private static final double vat=0.15;
    private static final double charge= 0.1;
    private final CatalogItem item;

    public WarrantyPlan(CatalogItem item) {
        if(item==null)
            throw new IllegalArgumentException("It is invalid");
        this.item = item;
    }

    @Override
    public long unitVat() {
        return (long)Math.ceil(unitCharge()*vat);
    }

    @Override
    public String label() {
        return "Warranty for "+ item.label();
    }

    @Override
    public long unitCharge() {
        return (long)Math.ceil(item.unitCharge()*charge);
    }
}
