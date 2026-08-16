package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;
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

    public long commissionOn(int amount) {
        return (long) Math.ceil(amount * 0.08);
    }




}
