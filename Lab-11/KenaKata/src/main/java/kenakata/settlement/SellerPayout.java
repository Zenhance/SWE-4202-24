package kenakata.settlement;

import kenakata.catalog.Seller;

public record SellerPayout(Seller seller, long grossSales,
                           long commission, long refunds, long payout) {
}