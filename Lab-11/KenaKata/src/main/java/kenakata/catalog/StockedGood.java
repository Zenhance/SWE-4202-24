package kenakata.catalog;

import kenakata.order.Order;

public class StockedGood extends CatalogItem implements Chargeable {
    public StockedGood(String s, String tableLamp, int i, int i1, Seller s1, int i2) {
    }

    public int unitCharge() {
        return 0;
    }

    public int unitVat() {
        return 0;
    }

    public int commissionOn(int i) {
        return 0;
    }

    public void reserve(int i) {
    }

    public int remaining() {
        return 0;
    }
}
