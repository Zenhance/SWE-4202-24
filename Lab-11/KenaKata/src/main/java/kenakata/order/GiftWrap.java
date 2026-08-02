package kenakata.order;

import kenakata.catalog.Chargeable;

public class GiftWrap implements Chargeable {

    @Override
    public long unitCharge() {
        return 0;
    }

    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public String label() {
        return null;
    }
}
