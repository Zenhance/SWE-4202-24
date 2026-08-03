package kenakata.settlement;

import kenakata.catalog.Seller;

import java.util.Objects;

public class SellerPayout {
    private Seller seller;
    private long grossSales;
    private long commission;
    private long refunds;
    private long payout;

    public SellerPayout(Seller seller, long grossSales, long commission, long refunds, long payout) {
        this.seller = seller;
        this.grossSales = grossSales;
        this.commission = commission;
        this.refunds = refunds;
        this.payout = payout;
    }

    public Seller seller() {
        return seller;
    }

    public long grossSales() {
        return grossSales;
    }

    public long commission() {
        return commission;
    }

    public long refunds() {
        return refunds;
    }

    public long payout() {
        return payout;
    }
}