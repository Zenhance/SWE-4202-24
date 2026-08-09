package kenakata.catalog;

import kenakata.order.Chargeable;
import kenakata.exceptions.OutOfStockException;

public interface CatalogItem extends Chargeable {

    String sku();

    String title();

    long unitPrice();

    Seller seller();

    int remaining();

    void reserve(int quantity) throws OutOfStockException;

    long commissionOn(long amount);
}