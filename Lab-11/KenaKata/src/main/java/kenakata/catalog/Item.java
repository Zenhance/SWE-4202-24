package kenakata.catalog;

import kenakata.enums.ItemType;
import kenakata.exceptions.InsufficientStockException;
import kenakata.settlement.Seller;

public interface Item {
    String getSku();
    String getTitle();
    double getUnitPrice();
    int getStockRemaining();
    Seller getSeller();
    ItemType getType();

    void restoreStock(int quantity);
    long getCommission(long lineTotal);
    void reserve(int quantity) throws InsufficientStockException;
    long getPerUnitVat();
}