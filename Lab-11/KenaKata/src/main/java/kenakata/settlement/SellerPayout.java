package kenakata.settlement;

import kenakata.catalog.Seller;
public record SellerPayout(
        Seller seller,
        long grossSales,
        long commission,
        long refunds,
        long payout
) {
    public SellerPayout {
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null");
        }

        if (grossSales < 0 || commission < 0 || refunds < 0) {
            throw new IllegalArgumentException(
                    "Settlement components cannot be negative"
            );
        }
    }
}