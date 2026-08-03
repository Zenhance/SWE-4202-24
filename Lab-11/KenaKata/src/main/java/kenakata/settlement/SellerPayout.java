package kenakata.settlement;

import kenakata.catalog.Seller;

public class SellerPayout {
    private Seller seller;

    public SellerPayout(Seller seller) {
        if (seller == null)
            throw new IllegalArgumentException("Seller cannot be null");
        this.seller = seller;
    }

    public int grossSales() {
        return 0;
    }

    public int commission() {
        return 0;
    }

    public int payout() {
        return 0;
    }

    public int refunds() {
        return 0;
    }

    public Seller seller() {
        return this.seller;
    }
}
