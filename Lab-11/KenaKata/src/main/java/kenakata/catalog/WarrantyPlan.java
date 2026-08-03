package kenakata.catalog;

public final class WarrantyPlan implements Chargeable {

    private final CatalogItem coveredItem;
    private final long charge;

    public WarrantyPlan(CatalogItem coveredItem) {
        if (coveredItem == null) {
            throw new IllegalArgumentException(
                    "Covered item cannot be null"
            );
        }

        this.coveredItem = coveredItem;
        this.charge = Money.ceilFraction(
                coveredItem.unitPrice(),
                10,
                100
        );
    }

    public CatalogItem coveredItem() {
        return coveredItem;
    }

    @Override
    public long unitCharge() {
        return charge;
    }

    @Override
    public long unitVat() {
        return Money.ceilFraction(
                charge,
                15,
                100
        );
    }

    @Override
    public String label() {
        return "Extended warranty for "
                + coveredItem.title();
    }
}