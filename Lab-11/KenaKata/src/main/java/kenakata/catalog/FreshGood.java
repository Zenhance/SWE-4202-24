package kenakata.catalog;

import kenakata.exceptions.*;

public class FreshGood extends CatalogItem implements Weighable, Insurable, Returnable {
    private int weight;
    private boolean isReturnable;
    private boolean hasReturned = false;

    public FreshGood(String SKU, String title, double unitPrice, int stockCount, Seller seller, int weight) {
        super(SKU, title, unitPrice, stockCount, seller);
        if (weight <= 0.0)
            throw new IllegalArgumentException("Weight cannot be negative or zero");
        this.weight = weight;
    }

    @Override
    public int unitCharge() {
        return (int) Math.ceil(getUnitPrice());
    }

    @Override
    public int unitVat() {
        return (int) Math.ceil(getUnitPrice() * 0.00);
    }

    @Override
    public int commissionOn(int something) {
        return (int) Math.ceil(something * 0.05);
    }

    @Override
    public int weight() {
        return weight;
    }

    @Override
    public int insurance() {
        if (isInsured())
            return (int) Math.ceil(getUnitPrice() * 0.01);
        return 0;
    }

    @Override
    public void insure() throws NotInsurableException {
        super.insure();
    }

    @Override
    public void returnProduct(int dayOfPlacement, int dayOfReturn) throws ReturnNotAllowedException {
        int dayPassed = dayOfReturn - dayOfPlacement;
        isReturnable = dayPassed <= 2; // return window for FreshGood is 2 days
        if (!isReturnable)
            throw new ReturnNotAllowedException("Return window is over");

        hasReturned = true;
    }

    @Override
    public boolean isReturnable() {
        return isReturnable;
    }

    @Override
    public boolean returned() {
        return isReturnable;
    }

    @Override
    public boolean hasReturned() {
        return hasReturned;
    }
}
