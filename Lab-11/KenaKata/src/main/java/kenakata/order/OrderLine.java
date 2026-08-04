package kenakata.order;
import kenakata.catalog.Chargeable;

public class OrderLine {
    private final Chargeable item;
    private final int quantity;
    private boolean returned;

    public OrderLine(Chargeable item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Line quantity must be positive.");
        }
        this.item = item;
        this.quantity = quantity;
        this.returned = false;
    }

    public Chargeable getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean returned() {
        return returned;
    }

    public void markReturned() {
        this.returned = true;
    }
}
