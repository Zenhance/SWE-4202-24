package kenakata.order;
import kenakata.catalog.Chargeable;

public class OrderLine {
    private final Chargeable unit;
    private final int quantity;
    private boolean insured;
    private boolean returned;

    public OrderLine(Chargeable unit, int quantity) {
        if(quantity <= 0) throw new IllegalArgumentException("Quantity can't be negative");
        this.unit = unit;
        this.quantity = quantity;
    }

    public Chargeable unit() {
        return unit;
    }
    public int quantity() {
        return quantity;
    }
    public boolean isInsured() {
        return insured;
    }
    public void setInsured(boolean insured) {
        this.insured = insured;
    }
    public boolean returned() {
        return returned;
    }
    public void markReturned() {
        this.returned = true;
    }
    public long lineCharge() {
        return unit.unitCharge()*quantity;
    }
    public long lineVat() {
        return unit.unitVat() * quantity;
    }




}
