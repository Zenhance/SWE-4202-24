package kenakata.catalog;

import kenakata.order.Order;

public class StockedGood extends CatalogItem implements Chargeable {
    int weight;
    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller, int weight) {
        super(sku, title, unitPrice, stock, seller);
        this.weight = weight;
    }

    public long unitCharge() {
        return getUnitPrice();
    }

    public long unitVat() {
        return (long) Math.ceil(getUnitPrice() * 0.075);
    }

    public long commissionOn(int i) {
        return (long) Math.ceil(i * 0.08);
    }

    public void reserve(int i) {
    }

    public int remaining() {
        return 0;
    }
}
