package kenakata.addon;

import kenakata.catalog.CatalogItem;

import kenakata.money.Money;

public class WarrantyPlan implements chargeable{
    private static final long CHARGE_PERMILLE= 100;
    private static final long VAT_PERMILLE= 150;

    private final CatalogItem coveredItem;

    public WarrantyPlan(CatalogItem coveredItem){
        if (coveredItem == null){
            throw new IllegalArgumentException("coveredItem must not be null");
        }
        this.coveredItem=coveredItem;
    }



    @Override
    public long unitCharge() {
        return Money.ceilPerMl(coveredItem.unitPrice(), CHARGE_PERMILLE);
    }

    @Override
    public long unitVat() {
        return Money.ceilPerMl(unitCharge(), VAT_PERMILLE);
    }
    @Override
    public String label() {
        return "Extended warranty for " + CatalogItem.title();
    }
}
