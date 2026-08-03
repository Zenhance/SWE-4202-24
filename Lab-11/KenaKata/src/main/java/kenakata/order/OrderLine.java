package kenakata.order;

import kenakata.catalog.Chargeable;
import kenakata.catalog.Insurable;
import kenakata.catalog.Returnable;
import kenakata.exceptions.NotInsurableException;
import kenakata.exceptions.ReturnNotAllowedException;

public class OrderLine {
    private final Chargeable item;
    private final int quantity;
    private boolean insured = false;
    private boolean returned = false;

    public OrderLine(Chargeable item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.item = item;
        this.quantity = quantity;
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

    public void insure() throws NotInsurableException {
        if (!(item instanceof Insurable)) {
            throw new NotInsurableException();
        }
        this.insured = true;
    }

    public long getInsuranceFee() {
        if (!insured || !(item instanceof Insurable i))
            return 0;
        long fee = (long) Math.ceil((item.unitCharge() * quantity) * 0.01);
        return Math.max(fee, 20);
    }

    public void processReturn(int placementDay, int currentDay) throws ReturnNotAllowedException {
        if (returned) {
            throw new ReturnNotAllowedException();
        }
        if (!(item instanceof Returnable r)) {
            throw new ReturnNotAllowedException();
        }
        if (currentDay > placementDay + r.returnWindowDays()) {
            throw new ReturnNotAllowedException();
        }
        this.returned = true;
    }
}

