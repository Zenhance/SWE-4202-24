package kenakata.order;

import kenakata.catalog.Chargeable;

/**
 * One line on an order -- a product with a quantity, or an add-on (always quantity one) -- plus
 * whatever state is particular to being on an order (whether it was insured, whether it has been
 * returned). The catalogue item or add-on itself only knows its own per-unit pricing; the line
 * is what ties that pricing to a quantity and an order.
 */
public final class OrderLine {

    private final Chargeable chargeable;
    private final int quantity;
    private boolean insured;
    private boolean returned;

    public OrderLine(Chargeable chargeable, int quantity) {
        if (chargeable == null) {
            throw new IllegalArgumentException("chargeable must not be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }
        this.chargeable = chargeable;
        this.quantity = quantity;
    }

    public Chargeable chargeable() {
        return chargeable;
    }

    public int quantity() {
        return quantity;
    }

    public boolean insured() {
        return insured;
    }

    void markInsured() {
        this.insured = true;
    }

    public boolean returned() {
        return returned;
    }

    void markReturned() {
        this.returned = true;
    }

    /** This line's total charge, before VAT: unit charge times quantity. */
    public long lineCharge() {
        return chargeable.unitCharge() * quantity;
    }

    /** This line's total VAT: per-unit VAT times quantity. */
    public long lineVat() {
        return chargeable.unitVat() * quantity;
    }
}
