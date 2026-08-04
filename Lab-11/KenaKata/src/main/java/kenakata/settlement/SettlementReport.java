package kenakata.settlement;

import java.util.List;

public record SettlementReport(
        List<SellerPayout>payouts,
        long platformRevenue
) {
    public SellerPayout forSeller(kenakata.catalog.Seller seller){
        return payouts.stream()
                .filter(p ->p.seller().equals(seller))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("Seller not found in settlement report"));
    }
}
