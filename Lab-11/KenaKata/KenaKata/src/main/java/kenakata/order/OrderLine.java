package kenakata.order;

import kenakata.catalog.*;

public final class OrderLine {
    private final Chargeable unit;
    private final int quantity;
    private boolean insured;
    private boolean returned;

    public OrderLine(Chargeable unit, int quantity) {
        if (unit == null) {
            throw new IllegalArgumentException("Line item is required");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.unit = unit;
        this.quantity = quantity;
    }

    public Chargeable unit() {
        return unit;
    }

    public Chargeable chargeable() {
        return unit;
    }

    public int quantity() {
        return quantity;
    }

    public String label() {
        return unit.label();
    }

    public long charge() {
        return Math.multiplyExact(unit.unitCharge(), quantity);
    }

    public long vat() {
        return Math.multiplyExact(unit.unitVat(), quantity);
    }

    public boolean productLine() {
        return unit instanceof CatalogItem;
    }

    public CatalogItem item() {
        return unit instanceof CatalogItem item ? item : null;
    }

    public boolean insured() {
        return insured;
    }

    void markInsured() {
        insured = true;
    }

    public long insuranceFee() {
        if (!insured || !(unit instanceof Insurable insurable)) {
            return 0;
        }
        long value = Math.multiplyExact(insurable.insurableValue(), quantity);
        return Math.max(20, MoneyMath.ceilRate(value, 1, 100));
    }

    public long totalWeightGrams() {
        if (!(unit instanceof Weighable weighable)) {
            return 0;
        }
        return Math.multiplyExact((long) weighable.unitWeightGrams(), quantity);
    }

    public long coldChainFee() {
        return unit instanceof ColdChain coldChain ? coldChain.coldChainSurcharge() : 0;
    }

    public boolean returned() {
        return returned;
    }

    void markReturned() {
        returned = true;
    }
}
