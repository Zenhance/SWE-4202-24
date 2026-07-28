package kenakata.catalog;

public class WarrantyPlan implements Chargeable{
    private Good item;

    public WarrantyPlan(Good item) {
        this.item = item;
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
