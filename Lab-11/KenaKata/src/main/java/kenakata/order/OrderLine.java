package kenakata.order;
import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
public final class OrderLine {

    private final Chargeable unit;
    private final int quantity;

    private boolean insured;
    private boolean returned;

    OrderLine(Chargeable unit, int quantity) {
        if (unit == null) {
            throw new IllegalArgumentException(
                    "Line unit cannot be null"
            );
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be positive"
            );
        }

        this.unit = unit;
        this.quantity = quantity;
    }

    public Chargeable unit() {
        return unit;
    }

    public int quantity() {
        return quantity;
    }

    public String label() {
        return unit.label();
    }

    public long charge() {
        return Math.multiplyExact(
                unit.unitCharge(),
                quantity
        );
    }

    public long vat() {
        return Math.multiplyExact(
                unit.unitVat(),
                quantity
        );
    }

    public boolean productLine() {
        return unit instanceof CatalogItem;
    }

    public boolean insured() {
        return insured;
    }

    void markInsured() {
        insured = true;
    }

    public boolean returned() {
        return returned;
    }

    void markReturned() {
        returned = true;
    }
}