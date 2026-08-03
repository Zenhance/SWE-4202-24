package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.Insurable;
import kenakata.catalog.Returnable;
import kenakata.exceptions.NotInsurableException;
import kenakata.exceptions.ReturnNotAllowedException;

public final class OrderLine {

    private final Chargeable content;
    private final int quantity;
    private boolean insured;
    private boolean returned;

    OrderLine(Chargeable content, int quantity) {
        this.content = content;
        this.quantity = quantity;
    }

    public Chargeable content() {
        return content;
    }

    public int quantity() {
        return quantity;
    }

    public boolean isProduct() {
        return content instanceof CatalogItem;
    }

    public CatalogItem asItem() {
        return (CatalogItem) content;
    }

    public long charge() {
        return content.unitCharge() * quantity;
    }

    public long vat() {
        return content.unitVat() * quantity;
    }

    public boolean insured() {
        return insured;
    }

    public boolean returned() {
        return returned;
    }

    void insure() throws NotInsurableException {
        if (!(content instanceof Insurable)) {
            throw new NotInsurableException("This line cannot be insured");
        }
        insured = true;
    }

    void markReturned(long placedDay, long returnDay) throws Throwable {
        if (!(content instanceof Returnable returnable)) {
            throw new Throwable("This line cannot be returned");
        }
        if (returned) {
            throw new ReturnNotAllowedException("This line has already been returned");
        }
        if (returnDay > placedDay + returnable.returnWindowDays()) {
            throw new ReturnNotAllowedException("The return window for this line has passed");
        }
        returned = true;
    }
}
