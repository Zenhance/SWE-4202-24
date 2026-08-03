package kenakata.settlement;

import kenakata.catalog.Seller;

public final class SellerPayout {

    private final Seller seller;
    private final long grossSales;
    private final long commission;
    private final long refunds;

    SellerPayout(Seller seller, long grossSales, long commission, long refunds) {
        this.seller = seller;
        this.grossSales = grossSales;
        this.commission = commission;
        this.refunds = refunds;
    }


