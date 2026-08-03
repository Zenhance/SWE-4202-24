package kenakata.settlement;

import kenakata.catalog.Seller;

import java.util.List;
import java.util.Map;

public final class SettlementReport {

    private final List<SellerPayout> payouts;
    private final Map<Seller, SellerPayout> bySeller;
    private final long platformRevenue;

    SettlementReport(List<SellerPayout> payouts, Map<Seller, SellerPayout> bySeller, long platformRevenue) {
        this.payouts = payouts;
        this.bySeller = bySeller;
        this.platformRevenue = platformRevenue;
    }
